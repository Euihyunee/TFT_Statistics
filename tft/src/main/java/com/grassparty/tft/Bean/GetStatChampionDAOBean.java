package com.grassparty.tft.Bean;

import com.grassparty.tft.Bean.Small.*;
import com.grassparty.tft.Model.DAO.ChampionDAO;
import com.grassparty.tft.Model.DAO.StatChampionDAO;
import com.grassparty.tft.Model.DTO.FullDTO.RecordParticipantDTO;
import com.grassparty.tft.Model.DTO.FullDTO.RecordUnitDTO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Repository.JPA.ChampionRepositoryJPA;
import com.grassparty.tft.Repository.JPA.StatChampionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetStatChampionDAOBean {

    @Autowired
    ChampionRepositoryJPA championRepository;
    @Autowired
    StatChampionRepositoryJPA statChampionRepositoryJPA;

    @Autowired
    GetMatchIdFromStatValidBean getMatchIdFromStatValidBean;
    @Autowired
    GetRecordBean getRecordBean;
    @Autowired
    GetChampionIdListBean getChampionIdListBean;
    @Autowired
    GetRecordUnitDTOListBean getRecordUnitDTOListBean;
    @Autowired
    GetParserChampionIdBean getParserChampionIdBean;
    @Autowired
    GetChampionNameByChampionIdBean getChampionNameByChampionIdBean;
    @Autowired
    GetVersionIdBean getVersionIdBean;
    @Autowired
    GetGameDatetimeBean getGameDatetimeBean;
    @Autowired
    GetRecordParticipantDTOListBean getRecordParticipantDTOListBean;
    @Autowired
    SaveChampionBean saveChampionBean;
    @Autowired
    UpdateChampionCountBean updateChampionCountBean;
    @Autowired
    UpdateChampionPlacementBean updateChampionPlacementBean;
    @Autowired
    UpdateChampionThreeStarCountBean updateChampionThreeStarCountBean;
    @Autowired
    UpdateChampionThreeStarPlacementBean updateChampionThreeStarPlacementBean;



    public void exec() {
        // DB Record 테이블 json 가져오면
        MatchID matchID = getMatchIdFromStatValidBean.exec();
        List<RecordDTO> records = getRecordBean.exec(matchID);

        for (RecordDTO recordDTO : records) {


            /* GetVersionIdFromVersionTableBean
             record에서 version보낸 상태에서 version_id 가져오기
            */
            Long VersionId = getVersionIdBean.exec(recordDTO.getGame_version());

             /* GetCurrentDateFromRecordBean
                record에서 currentDate 가져오기
             */
            Long GameDatetime = getGameDatetimeBean.exec(recordDTO);

            // champion_list 뽑아내는 Bean
            // for문 champion_list

            List<RecordParticipantDTO> recordParticipantDTOList = getRecordParticipantDTOListBean.exec(recordDTO);

            for (RecordParticipantDTO recordParticipantDTO : recordParticipantDTOList) {

                int placement = recordParticipantDTO.getPlacement();

                List<RecordUnitDTO> recordUnitDTOList = getRecordUnitDTOListBean.exec(recordParticipantDTO);

                for (RecordUnitDTO recordUnitDTO : recordUnitDTOList) {

                    if(recordUnitDTO == null){
                        continue;
                    }

                    // recordUnitDTO의 championId로 champion 테이블에 있는지 확인하고
                    // 없다면 champion 테이블에 championId와 스플릿된 championName 저장
                    if (!championRepository.existsByChampionId(recordUnitDTO.getCharacter_id())) {
                        saveChampionBean.exec(recordUnitDTO.getCharacter_id());
                    }
                    String championName = getChampionNameByChampionIdBean.exec(recordUnitDTO.getCharacter_id());

                    if (!statChampionRepositoryJPA.existsByChampionName(championName)) {
                        StatChampionDAO statChampionDAO = new StatChampionDAO();
                        statChampionDAO.setChampionName(championName);
                        statChampionDAO.setVersionId(VersionId);
                        statChampionRepositoryJPA.save(statChampionDAO);
                    }

                    StatChampionDAO statChampionDAO = statChampionRepositoryJPA.findByChampionName(championName);
                    /* count
                        1 더하기
                     */
                    Long sumCount = updateChampionCountBean.exec(statChampionDAO);
                    /* placement
                       기존 placement += record placement
                     */
                    Long sumPlacement = updateChampionPlacementBean.exec(statChampionDAO, placement);

                    statChampionDAO.setCount(sumCount);
                    statChampionDAO.setPlacement(sumPlacement);

                    /* threeStar_xx
                        rarity가 2인 경우
                        three_star_count += 1
                        three_star_placement += record placement
                     */
                    if (recordUnitDTO.getRarity() == 2) {
                        Long sumThreeStarCount = updateChampionThreeStarCountBean.exec(statChampionDAO);
                        Long sumThreeStarPlacement = updateChampionThreeStarPlacementBean.exec(statChampionDAO, placement);
                        statChampionDAO.setThreeStarCount(sumThreeStarCount);
                        statChampionDAO.setThreeStarPlacement(sumThreeStarPlacement);
                    }

                    statChampionRepositoryJPA.save(statChampionDAO);
                }
            }
        }
    }
}
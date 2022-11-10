package com.grassparty.tft.Bean;

import com.grassparty.tft.Bean.Small.*;
import com.grassparty.tft.Model.DAO.ChampionDAO;
import com.grassparty.tft.Model.DTO.FullDTO.RecordUnitDTO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Repository.JPA.ChampionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetStatChampionDAOBean {

    @Autowired
    GetMatchIdFromStatValidBean getMatchIdFromStatValidBean;
    @Autowired
    GetRecordBean getRecordBean;
    @Autowired
    GetChampionIdListBean getChampionIdListBean;
    @Autowired
    GetUnitListBean getUnitListBean;
    @Autowired
    ChampionRepositoryJPA championRepository;
    @Autowired
    GetParserChampionIdBean getParserChampionIdBean;
    @Autowired
    GetChampionNameByChampionIdBean getChampionNameByChampionIdBean;
    @Autowired
    GetVersionIdBean getVersionIdBean;
    @Autowired
    GetGameDatetimeBean getGameDatetimeBean;


    public void exec(){
        // DB Record 테이블 json 가져오면
        MatchID matchID = getMatchIdFromStatValidBean.exec();
        List<RecordDTO> records = getRecordBean.exec(matchID);

        for(RecordDTO recordDTO : records){
            // champion_list 뽑아내는 Bean
            // for문 champion_list
            List<RecordUnitDTO[]> recordUnitDtoList = getUnitListBean.exec(recordDTO);

            /* GetVersionIdFromVersionTableBean
             record에서 version보낸 상태에서 version_id 가져오기
            */
            Long VersionId = getVersionIdBean.exec(recordDTO.getGame_version());

             /* GetCurrentDateFromRecordBean
                record에서 currentDate 가져오기
             */
            Long GameDatetime = getGameDatetimeBean.exec(recordDTO);


            for(RecordUnitDTO[] recordUnitDTO : recordUnitDtoList){
                for(RecordUnitDTO unitDTO : recordUnitDTO){

                    // if -> champion_id not exist 데이터 저장
                    if(!championRepository.existsByChampionId(unitDTO.getCharacter_id())){
                        ChampionDAO championDAO = new ChampionDAO();
                        championDAO.setChampionId(unitDTO.getCharacter_id());
                        String ChampionName = getParserChampionIdBean.exec(unitDTO.getCharacter_id());
                        championDAO.setChampionName(ChampionName);
                        championRepository.save(championDAO);
                    }
                    /* GetChampionIdByChampionNameBean
                        record에서 champion_id으로 champion_name 가져오기
                     */
                    String ChampionName = getChampionNameByChampionIdBean.exec(unitDTO.getCharacter_id());
                    /* count
                        1 더하기
                     */

                    /* three_star_count
                        rarity가 2이면 1 더하기
                     */

                    /* placement
                       기존 placement += record placement
                     */

                    /* three_star_placement
                        rarity가 2인 경우
                        three_star_placement += record placement
                     */
                }
            }

        }
    }
    // statChampion에 데이터 넣는 최종 Bean








}

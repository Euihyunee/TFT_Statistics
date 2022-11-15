package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.VersionDAO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Repository.JPA.VersionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveVersionBean {

    @Autowired
    GetRecordBean getRecordBean;
    @Autowired
    GetMatchIdFromStatValidBean getMatchIdFromStatValidBean;
    @Autowired
    VersionRepositoryJPA repository;
    @Autowired
    GetParserBean getParserBean;

    public void exec(RecordDTO recordDTO){

        //test용
//        // DB record 테이블에서 json(RecordDTO) 가져오기
//        MatchID matchID = getMatchIdFromStatValidBean.exec();
//
//        List<RecordDTO> records = getRecordBean.exec(matchID);
//
//        // json데이터에서 game_version 가져오기
//        // ex) 12.20.474.8882
//        for (RecordDTO recordDTO : records){

        // parsing 부분 Bean으로 만들거
        // game_version parsing해서 12는 season_id, 20은 update_id로 나머지는 total_id로 분리
        String GameVersion = recordDTO.getGame_version();
        int seasonId = getParserBean.exec(GameVersion, GetParserBean.EnumVersion.Season);
        int updateId = getParserBean.exec(GameVersion, GetParserBean.EnumVersion.Update);
        String totalId = GameVersion;

        // version_table에 조회해서 있으면 냅두고 없으면 추가하는 방식 만들기
        if(!repository.existsByTotalVersion(totalId)){
            VersionDAO versionDAO = new VersionDAO();
            versionDAO.setSeasonVersion(seasonId);
            versionDAO.setUpdateVersion(updateId);
            versionDAO.setTotalVersion(totalId);
            repository.save(versionDAO);
        }
    }

    public void exec(List<RecordDTO> records) {
        for (RecordDTO recordDTO : records) {
            exec(recordDTO);
        }
    }

}

package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.RecordDAO;
import com.grassparty.tft.Model.DAO.VersionDAO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Repository.JPA.VersionRepositoryJPA;
import jdk.nashorn.internal.runtime.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetVersionBean {

    @Autowired
    GetRecordBean getRecordBean;
    @Autowired
    GetMatchIdFromStatValidBean getMatchIdFromStatValidBean;
    @Autowired
    VersionRepositoryJPA repository;

    public void exec(){
        // DB record 테이블에서 json(RecordDTO) 가져오기
        MatchID matchID = getMatchIdFromStatValidBean.exec();

        List<RecordDTO> records = getRecordBean.exec(matchID);

        // json데이터에서 game_version 가져오기
        // ex) 12.20.474.8882
        for (RecordDTO recordDTO : records){

            // parsing 부분 Bean으로 만들거 시발~~~~~
            // gmae_version parsing해서 12는 season_id, 20은 update_id로 나머지는 total_id로 분리
            String GameVersion = recordDTO.getGame_version();
            String[] GameVersionSplit = GameVersion.split("\\.");
            int SeasonId = Integer.parseInt(GameVersionSplit[0]);
            int updateId = Integer.parseInt(GameVersionSplit[1]);
            String TotalId = GameVersion;

            // version_table에 조회해서 있으면 냅두고 없으면 추가하는 방식 만들기
            if(!repository.existsByTotalVersion(TotalId)){
                VersionDAO versionDAO = new VersionDAO();
                versionDAO.setSeasonVersion(SeasonId);
                versionDAO.setUpdateVersion(updateId);
                versionDAO.setTotalVersion(TotalId);
                repository.save(versionDAO);
            }
        }

    }
}

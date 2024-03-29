package com.grassparty.tft.Bean;

import com.grassparty.tft.Bean.Small.GetMatchIdFromStatValidBean;
import com.grassparty.tft.Bean.Small.GetRecordBean;
import com.grassparty.tft.Model.DAO.StatChampionDeckCountDAO;
import com.grassparty.tft.Model.DAO.VersionDAO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Repository.JPA.StatChampionDeckCountRepositoryJPA;
import com.grassparty.tft.Repository.JPA.VersionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SaveStatChampionDeckCountBean {
    @Autowired
    GetRecordBean getRecordBean;
    @Autowired
    GetMatchIdFromStatValidBean getMatchIdFromStatValidBean;
    @Autowired
    VersionRepositoryJPA versionRepository;
    @Autowired
    StatChampionDeckCountRepositoryJPA statChampionDeckCountRepository;

    /*
    version_id : version을 보내면서 version_id 가져옴 version_id가
    없다면 새로 생성 total_deck_count = 0으로 초기값
    total_deck_count : version_id로 찾아서 +8하기
     */
    public void exec(RecordDTO recordDTO){

        // test용
//        // DB Record 테이블 json 가져와져 있음
//        MatchID matchID = getMatchIdFromStatValidBean.exec();
//        List<RecordDTO> records = getRecordBean.exec(matchID);
//
//        for(RecordDTO recordDTO : records){
        String TotalVersion = recordDTO.getGame_version();
        VersionDAO versionDAO = versionRepository.findByTotalVersion(TotalVersion);
        Long versionId = versionDAO.getVersionId();
        Long totalDeckCount = 8L;
        StatChampionDeckCountDAO statChampionDeckCountDAO = new StatChampionDeckCountDAO();
        statChampionDeckCountDAO.setVersionId(versionId);
        statChampionDeckCountDAO.setTotalDeckCount(totalDeckCount);
        if(statChampionDeckCountRepository.existsByVersionId(versionId)){
            statChampionDeckCountDAO = statChampionDeckCountRepository.findByVersionId(versionId);
            totalDeckCount += statChampionDeckCountDAO.getTotalDeckCount();
            statChampionDeckCountDAO.setTotalDeckCount(totalDeckCount);
        }
        statChampionDeckCountRepository.save(statChampionDeckCountDAO);
    }
    public void exec(List<RecordDTO> records) {
        for (RecordDTO recordDTO : records) {
            exec(recordDTO);
        }
    }
}


package com.grassparty.tft.Bean.Small;

import com.google.gson.Gson;
import com.grassparty.tft.Model.DAO.RecordDAO;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Repository.RecordRepository;
import com.grassparty.tft.Repository.StatValidationRepository;
import com.grassparty.tft.Model.DTO.RecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 매치아이디 밸리데이션 데이블 돌면서 통계에 들어가지않은 애들 1000개씩 통계에 추가
@Component
public class FirstScheduleBean {
    @Autowired
    RecordRepository recordRepository;
    @Autowired
    StatValidationRepository statValidationRepository;
    @Autowired
    SaveStatDeckFromRecordDTOBean saveStatDeckFromRecordDTOBean;


    public void exec(){
        // 1000번 실행
        for(int i=0; i<1000; i++){
            // 실행할 매치가 없으면 중단
            if(!method()){ break; }
        }
    }

    private boolean method(){
        // matchId를 DB Statvalidation 테이블에서 가져오기
        MatchID matchid = statValidationRepository.GetMatchIdFromStatValidation();

        // DB에서 FullRecordDB 가져오기
        if(matchid == null){
            System.out.println("매치아이디 널임");
            return false;
        }
        RecordDAO recordDAO = recordRepository.GetFullRecordDBByMatchId(matchid.getMatchid()[0]);


        // FullRecordDB에서 FullRecordDTO를 분리
        Gson gson = new Gson();
        RecordDTO recordDTO = gson.fromJson(recordDAO.getJson(), RecordDTO.class);

        // FullRecordDTO에서 StatTable로 변환 (*)
        saveStatDeckFromRecordDTOBean.exec(recordDTO);
        System.out.println("몇회실행됬는지 확인점");

        return true;
    }
}

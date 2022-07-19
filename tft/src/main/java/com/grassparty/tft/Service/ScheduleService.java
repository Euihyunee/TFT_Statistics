package com.grassparty.tft.Service;

import com.grassparty.tft.Repository.FullRecordRepository;
import com.grassparty.tft.Repository.StatValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    FullRecordRepository fullRecordRepository;
    @Autowired
    StatValidationRepository statValidationRepository;

    @Scheduled(fixedDelay = 300000)
    public void testMethod2(){
        System.out.println("2번 기능 5분에 한번 실행");

        // 1000번 실행
        for(int i=0; i<1000; i++){
            // 실행할 매치가 없으면 중단
            if(!exec()){ break; }
        }

    }

    public boolean exec(){
        // matchId를 DB Statvalidation 테이블에서 가져오기
        if(statValidationRepository.GetMatchIdFromStatValidation()==null){
            return false;
        }
        String matchid = statValidationRepository.GetMatchIdFromStatValidation();

        // DB에서 FullRecordDB 가져오기


        // FullRecordDB에서 FullRecordDTO를 분리


        // FullRecordDTO에서 StatTable로 변환 (*)


        // StatTable을 DB에 저장

        return true;
    }


    @Scheduled(fixedDelay = 300000)
    public void testMethod3(){
        System.out.println("3번 기능 5분에 한번 실행");


        
        // 걍 쿼리를 쓰자

        // GroupBy 챔피언 해서 테이블 만들기

        // 테이블을 PreStatService 예시

    }

}

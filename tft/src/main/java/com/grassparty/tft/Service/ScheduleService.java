package com.grassparty.tft.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Scheduled(fixedDelay = 300000)
    public void testMethod2(){
        System.out.println("2번 기능 5분에 한번 실행");

        // matchId[]를 DB Statvalidation 테이블에서 가져오기
        // valid가 false인 matchid를 어떻게 가져오지?
        // String matchId[] =
        // 가져온 데이터는 True로 업데이트

        // DB에서 FullRecordDB 가져오기

        // FullRecordDB에서 FullRecordDTO를 분리

        // FullRecordDTO에서 StatTable로 변환 (*)

        // StatTable을 DB에 저장

    }

    @Scheduled(fixedDelay = 300000)
    public void testMethod3(){
        System.out.println("3번 기능 5분에 한번 실행");

        //

    }

}

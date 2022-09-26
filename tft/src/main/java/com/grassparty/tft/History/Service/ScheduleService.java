package com.grassparty.tft.History.Service;

import com.grassparty.tft.Bean.ClassifyDeckBean;
import com.grassparty.tft.Bean.FirstScheduleBean;
import com.grassparty.tft.Bean.SecondScheduleBean;
import com.grassparty.tft.Model.DB.*;
import com.grassparty.tft.History.Repository.JPA.CustomPreQueryRepository;
import com.grassparty.tft.History.Repository.JPA.CustomQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class ScheduleService {

    @Autowired CustomQueryRepository customQueryRepository;
    @Autowired CustomPreQueryRepository customPreQueryRepository;


    FirstScheduleBean FirstScheduleBean = new FirstScheduleBean();
    SecondScheduleBean SecondScheduleBean = new SecondScheduleBean();
    ClassifyDeckBean ClassifyDeckBean = new ClassifyDeckBean();


    // @Scheduled(fixedDelay = 3000000)
    public void ScheduleMethod1(){
        System.out.println("1번 기능 5분에 한번 실행----------------------------------------");
        FirstScheduleBean.exec();
    }


    // stat테이블에서 preService테이블로 데이터 넘기기
    //@Scheduled(fixedDelay = 3000000)
    public void ScheduleMethod2(){
        System.out.println("2번 기능 5분에 한번 실행----------------------------------------");
        SecondScheduleBean.exec();
    }

    // preService테이블에서 Service테이블로 데이터 넘기기
    // StatServiceInterface 미구현
    @Scheduled(fixedDelay = 3000000)
    public void PreToServiceTable(){
        System.out.println("3번 기능 5분에 한번 실행----------------------------------------");
        ClassifyDeckBean.exec();

//        for(int i = 0 ; i < customQueryRepository.GetQuery().size(); i++) {
//            StatServiceInterface service = customQueryRepository.getMaxCountRow().get(i);
//
//            // Service를 DBTable에 맞추기
//            StatServiceTable serviceTable = GetServiceFromServiceInterface(service);
//
//            customQueryRepository.save(serviceTable);
//        }
    }


    private StatServiceTable GetServiceFromServiceInterface(StatServiceInterface service) {
        // 미구현
        StatServiceTable statServiceTable = StatServiceTable.builder().build();
        return statServiceTable;
    }


}




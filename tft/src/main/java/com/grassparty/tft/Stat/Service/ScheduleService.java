package com.grassparty.tft.Stat.Service;

import com.grassparty.tft.Bean.Small.ClassifyDeckBean;
import com.grassparty.tft.Bean.Small.FirstScheduleBean;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;


@Service
public class ScheduleService {
    FirstScheduleBean FirstScheduleBean = new FirstScheduleBean();
    ClassifyDeckBean ClassifyDeckBean = new ClassifyDeckBean();


    // @Scheduled(fixedDelay = 3000000)
    public void statisticRecordToDeck(){
        System.out.println("1번 기능 5분에 한번 실행----------------------------------------");
        FirstScheduleBean.exec();
    }


    //@Scheduled(fixedDelay = 3000000)
    public void ScheduleMethod2(){
        System.out.println("2번 기능 5분에 한번 실행----------------------------------------");
    }


    // @Scheduled(fixedDelay = 3000000)
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

}




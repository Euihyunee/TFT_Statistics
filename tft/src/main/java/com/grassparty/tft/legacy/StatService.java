package com.grassparty.tft.legacy;

import com.grassparty.tft.Bean.Small.InsertStatVaildationBean;
import com.grassparty.tft.Bean.Small.StatisticsByMatchIdBean;
import com.grassparty.tft.Bean.Small.StatisticsByNameBean;
import com.grassparty.tft.Bean.Small.StatisticsByPuuidBean;
import org.springframework.stereotype.Service;

@Service
public class StatService {
    public String StatisticsByName(String name){
        StatisticsByNameBean statisticsByNameBean = new StatisticsByNameBean();

        return statisticsByNameBean.exec(name);
    }

    public void StatisticsByPuuid(String puuid){
        StatisticsByPuuidBean statisticsByPuuidBean = new StatisticsByPuuidBean();

        statisticsByPuuidBean.exec(puuid);
    }

    public void StatisticsByMatchId(String matchId){
        StatisticsByMatchIdBean statisticsByMatchIdBean = new StatisticsByMatchIdBean();
        InsertStatVaildationBean insertStatVaildationBean = new InsertStatVaildationBean();

        insertStatVaildationBean.exec(matchId);
        statisticsByMatchIdBean.exec(matchId);
    }

    // matchId를 DB 저장
    public void InsertStatVaildation(String matchId){
        InsertStatVaildationBean insertStatVaildationBean = new InsertStatVaildationBean();

        insertStatVaildationBean.exec(matchId);
    }

}

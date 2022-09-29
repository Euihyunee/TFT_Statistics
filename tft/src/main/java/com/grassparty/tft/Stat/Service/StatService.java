package com.grassparty.tft.Stat.Service;

import com.grassparty.tft.Bean.Small.InsertStatVaildationBean;
import com.grassparty.tft.Bean.Small.StatisticsByMatchIdBean;
import com.grassparty.tft.Bean.Small.StatisticsByNameBean;
import org.springframework.stereotype.Service;

@Service
public class StatService {
    public String StatisticsByName(String name){
        StatisticsByNameBean statisticsByNameBean = new StatisticsByNameBean();

        return statisticsByNameBean.exec(name);
    }

    public void StatisticsByMatchId(String matchId){
        StatisticsByMatchIdBean statisticsByMatchIdBean = new StatisticsByMatchIdBean();
        InsertStatVaildationBean insertStatVaildationBean = new InsertStatVaildationBean();

        insertStatVaildationBean.exec(matchId);
        statisticsByMatchIdBean.exec(matchId);
    }
}

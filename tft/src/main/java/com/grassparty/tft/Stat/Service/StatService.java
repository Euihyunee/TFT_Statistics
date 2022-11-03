package com.grassparty.tft.Stat.Service;

import com.grassparty.tft.Bean.Small.InsertStatVaildationBean;
import com.grassparty.tft.Bean.Small.StartStatisticBean;
import com.grassparty.tft.Bean.Small.StatisticsByMatchIdBean;
import com.grassparty.tft.Bean.Small.PutRecordForStatBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatService {
    @Autowired
    PutRecordForStatBean putRecordForStatBean;

    @Autowired
    StartStatisticBean startStatisticBean;

    public String PutRecordForStatByName(String name){
        return putRecordForStatBean.exec(name);
    }

    public void StatisticsByMatchId(String matchId){
        StatisticsByMatchIdBean statisticsByMatchIdBean = new StatisticsByMatchIdBean();
        InsertStatVaildationBean insertStatVaildationBean = new InsertStatVaildationBean();

        insertStatVaildationBean.exec(matchId);
        statisticsByMatchIdBean.exec(matchId);
    }

    public void StartStatistic() {
        startStatisticBean.exec();
    }
}

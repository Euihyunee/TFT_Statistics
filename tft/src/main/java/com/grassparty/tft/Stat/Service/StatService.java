package com.grassparty.tft.Stat.Service;

import com.grassparty.tft.Bean.Small.GetStatChampionResultBean;
import com.grassparty.tft.Bean.Small.InsertStatVaildRecordBean;
import com.grassparty.tft.Bean.StartStatisticBean;
import com.grassparty.tft.Bean.Small.InsertMatchIdStatBean;
import com.grassparty.tft.Bean.PutRecordForStatBean;
import com.grassparty.tft.Model.DAO.StatChampionResultDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatService {
    @Autowired
    PutRecordForStatBean putRecordForStatBean;

    @Autowired
    StartStatisticBean startStatisticBean;

    @Autowired
    GetStatChampionResultBean getStatChampionResultBean;

    public String PutRecordForStatByName(String name){
        return putRecordForStatBean.exec(name);
    }

    public void StatisticsByMatchId(String matchId){
        InsertMatchIdStatBean insertMatchIdStatBean = new InsertMatchIdStatBean();
        InsertStatVaildRecordBean insertStatVaildRecordBean = new InsertStatVaildRecordBean();

        insertStatVaildRecordBean.exec(matchId);
        insertMatchIdStatBean.exec(matchId);
    }

    public void StartStatistic() {
        startStatisticBean.exec();
    }

    public List<StatChampionResultDAO> GetStatChampionResult(){return getStatChampionResultBean.exec();}
}

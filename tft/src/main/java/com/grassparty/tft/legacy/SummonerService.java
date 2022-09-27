package com.grassparty.tft.legacy;

import com.grassparty.tft.Bean.Small.GetEncodeBean;
import com.grassparty.tft.Bean.Small.GetSummonerDTOBean;
import com.grassparty.tft.Bean.Small.GetSummonerDTOByNameBean;
import com.grassparty.tft.Bean.Small.GetSummonerDtoByPuuidBean;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SummonerService {
    @Value("${api_key}")
    private String api_key;


    public SummonerDTO GetSummonerDtoByPuuid(String puuid){
        GetSummonerDtoByPuuidBean getSummonerDtoByPuuidBean = new GetSummonerDtoByPuuidBean();

        return getSummonerDtoByPuuidBean.exec(puuid);
    }


    public SummonerDTO GetSummonerDTOByName(String name){
        GetSummonerDTOByNameBean getSummonerDTOByNameBean = new GetSummonerDTOByNameBean();

        return getSummonerDTOByNameBean.exec(name);
    }


    private SummonerDTO GetSummonerDTO(String encodedUrl) {
        GetSummonerDTOBean getSummonerDTOBean = new GetSummonerDTOBean();

        return getSummonerDTOBean.exec(encodedUrl);
    }

    public String GetEncode(String name){
        GetEncodeBean getEncodeBean = new GetEncodeBean();

        return getEncodeBean.exec(name);
    }
}

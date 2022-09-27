package com.grassparty.tft.legacy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grassparty.tft.Bean.GetEncodeBean;
import com.grassparty.tft.Bean.GetSummonerDTOBean;
import com.grassparty.tft.Bean.GetSummonerDTOByNameBean;
import com.grassparty.tft.Bean.GetSummonerDtoByPuuidBean;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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

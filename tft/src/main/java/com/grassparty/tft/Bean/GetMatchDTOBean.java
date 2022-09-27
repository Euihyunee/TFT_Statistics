package com.grassparty.tft.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grassparty.tft.Bean.Small.GetUrlByMatchIdBean;
import com.grassparty.tft.Model.Riot.MatchDto;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetMatchDTOBean {

    public MatchDto exec(String matchid){
        GetUrlByMatchIdBean GetUrlByMatchIdBean = new GetUrlByMatchIdBean();
        String matchurl = GetUrlByMatchIdBean.exec(matchid);

        MatchDto matchDto = null;
        try {
            URL url = new URL(matchurl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStream responseStream = con.getInputStream();

            // Manually converting the response body InputStream to summonerDTO using Jackson
            ObjectMapper mapper = new ObjectMapper();
            matchDto = mapper.readValue(responseStream, MatchDto.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matchDto;
    }
}

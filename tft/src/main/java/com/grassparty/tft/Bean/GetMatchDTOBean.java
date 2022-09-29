package com.grassparty.tft.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grassparty.tft.Bean.Small.GetUrl.GetUrlByMatchIdBean;
import com.grassparty.tft.Model.Riot.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class GetMatchDTOBean {

    @Autowired
    GetUrlByMatchIdBean getUrlByMatchIdBean;

    public MatchDto exec(String matchid){
        String matchurl = getUrlByMatchIdBean.exec(matchid);

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

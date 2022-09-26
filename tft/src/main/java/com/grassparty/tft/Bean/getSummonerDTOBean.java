package com.grassparty.tft.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grassparty.tft.Model.Riot.SummonerDTO;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class getSummonerDTOBean {

    public SummonerDTO exec(String encodedUrl){
        URL url;
        SummonerDTO summonerDTO = null;
        try {
            url = new URL(encodedUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStream responseStream = con.getInputStream();

            // Manually converting the response body InputStream to summonerDTO using Jackson
            ObjectMapper mapper = new ObjectMapper();
            summonerDTO = mapper.readValue(responseStream, SummonerDTO.class);
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return summonerDTO;
    }
}

package com.grassparty.tft.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

// api_key RGAPI-60a5827e-8baf-453c-b7b8-13ac51ca7d61

// 의현 : RGAPI-60eb9a0a-89d3-472f-aacc-67af1dbcdfd1

@Service
public class SummonerService {

    public SummonerDTO GetSummonerDtoByPuuid(String puuid){
        URL url = null;
        SummonerDTO summonerDTO = null;
        try {
            url = new URL("https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-puuid/q_-oeF0aCGPhtfcd-qdnr6bmbex4dmcOIFy5LevX4X7LA4LmxzP4ZaxS7zdZkpfP0qp2CwGbibvcFA?api_key=RGAPI-60a5827e-8baf-453c-b7b8-13ac51ca7d61");
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


    public SummonerDTO GetSummonerDTOByName(String name){
        URL url = null;
        SummonerDTO summonerDTO = null;

        try {
            url = new URL("https://kr.api.riotgames.com/tft/summoner/v1/summoners/by-name/%EB%B3%91%EA%B7%B8%EB%8B%88?api_key=RGAPI-60eb9a0a-89d3-472f-aacc-67af1dbcdfd1");
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

package com.grassparty.tft.Bean.Small;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grassparty.tft.Model.Riot.LeagueEntryDTO;
import com.grassparty.tft.Model.Riot.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Component
public class GetLeagueEntryBean {
    @Autowired
    private Environment env;

    public LeagueEntryDTO exec(String summonerId){

        String api_query = "?api_key=";
        String site = "https://kr.api.riotgames.com/tft/league/v1/entries/by-summoner/";
        String encodedUrl = site + summonerId + api_query + env.getProperty("api_key");
        URL url;
        LeagueEntryDTO leagueEntryDTO = new LeagueEntryDTO();

        try {
            url = new URL(encodedUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStream responseStream = con.getInputStream();

            // Manually converting the response body InputStream to summonerDTO using Jackson
            ObjectMapper mapper = new ObjectMapper();
            Set<LeagueEntryDTO> leagueEntryDTOSet = mapper.readValue(responseStream, new TypeReference<>() { });
            Iterator iter = leagueEntryDTOSet.iterator();
            leagueEntryDTO = (LeagueEntryDTO) iter.next();

        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return leagueEntryDTO;

    }


}

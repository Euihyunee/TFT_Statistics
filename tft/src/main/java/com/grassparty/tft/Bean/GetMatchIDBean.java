package com.grassparty.tft.Bean;

import com.grassparty.tft.Bean.Small.GetUrlByPuuidBean;
import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class GetMatchIDBean {

    @Autowired
    private Environment env;
    @Autowired
    GetUrlByPuuidBean getUrlByPuuidBean;

    public MatchID exec(String puuid){
        // 로직
        String matchurl = GetUrlByPuuidBean.exec(puuid);

        MatchID matchID = new MatchID();
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("X-Riot-Token", env.getProperty("api_key")); //헤더에 API키 추가

            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

            ResponseEntity<String> response = restTemplate.exchange(matchurl, HttpMethod.GET, entity, String.class); //요청을 보내어 결과를 받아옴

            String matches = response.getBody().toString();
            matches = matches.replace("[", "");
            matches = matches.replace("]", "");
            matches = matches.replace("\"", "");
            String[] matchList = matches.split(",");
            matchID.setMatchid(matchList);

        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return matchID;
    }
}

package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class GetMatchIDBean {
    @Value("${api_key}")
    private static String api_key;

    public MatchID exec(String puuid){
        GetUrlByPuuidBean getUrlByPuuidBean = new GetUrlByPuuidBean();
        // 로직
        String matchurl = GetUrlByPuuidBean.exec(puuid);

        MatchID matchID = new MatchID();
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("X-Riot-Token", api_key); //헤더에 API키 추가

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

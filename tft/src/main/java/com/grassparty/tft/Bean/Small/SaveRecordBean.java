package com.grassparty.tft.Bean.Small;

import com.google.gson.Gson;
import com.grassparty.tft.Model.DAO.RecordDAO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Repository.JPA.RecordRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SaveRecordBean {
    @Autowired
    RecordRepositoryJPA recordRepositoryJPA;

    public void exec(RecordDTO recordDTO){
        String matchid = recordDTO.getMatch_id();

        Gson gson = new Gson();
        String jsonString = gson.toJson(recordDTO);

        RecordDAO recordDAO = RecordDAO.builder()
                .matchID(matchid)
                .json(jsonString)
                .build();
        recordRepositoryJPA.save(recordDAO);
    }
}

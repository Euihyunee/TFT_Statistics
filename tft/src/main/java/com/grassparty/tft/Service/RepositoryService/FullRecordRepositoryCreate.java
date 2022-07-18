package com.grassparty.tft.Service.RepositoryService;

import com.google.gson.Gson;
import com.grassparty.tft.Model.FullRecordDTO;
import com.grassparty.tft.Model.DB.FullRecordDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FullRecordRepositoryCreate {

    @Autowired
    FullRecordRepository fullRecordRepository;

    public void InsertFullRecords(FullRecordDTO[] fullRecordDTOS){
        for(FullRecordDTO fullRecordDTO : fullRecordDTOS){
            InsertFullRecord(fullRecordDTO);
        }
    }

    public void InsertFullRecord(FullRecordDTO fullRecordDTO){
        String matchid = fullRecordDTO.getMatch_id();

        Gson gson = new Gson();
        String jsonString = gson.toJson(fullRecordDTO);

        FullRecordDB fullRecordDB = FullRecordDB.builder()
                .matchID(matchid)
                .json(jsonString)
                .build();
        fullRecordRepository.save(fullRecordDB);
    }
}

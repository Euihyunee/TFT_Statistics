package com.grassparty.tft.Repository;

import com.google.gson.Gson;
import com.grassparty.tft.Model.DAO.RecordDAO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Repository.JPA.RecordRepositoryJPA;
import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RecordRepository {

    @Autowired
    RecordRepositoryJPA recordRepositoryJPA;
    

    public boolean IsExistByMatchid(String matchid){

        return recordRepositoryJPA.existsById(matchid);
    }

    public RecordDTO[] GetFullRecordDTOsByMatchidFromRepository(MatchID matchID){
        RecordDTO[] recordDTOS = new RecordDTO[10];
        for(int i=0; i<matchID.getMatchid().length;i++){
            recordDTOS[i] = GetRecordDTOFromRepository(matchID.getMatchid()[i]);
        }
        return recordDTOS;
    }

    public RecordDTO GetRecordDTOFromRepository(String matchid){

        // DB에서 FullRecordDB 가져오기
        Optional<RecordDAO> recordDAO = recordRepositoryJPA.findById(matchid);

        // RecordDB에서 json 받아오기
        String json =  recordDAO.get().getJson();

        // Gson 역직렬화까즤
        Gson gson = new Gson();
        RecordDTO recordDTO = gson.fromJson(json, RecordDTO.class);

        return recordDTO;
    }

    public RecordDAO GetFullRecordDBByMatchId(String matchId){
        return recordRepositoryJPA.getById(matchId);
    }

}







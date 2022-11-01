package com.grassparty.tft.Repository;

import com.google.gson.Gson;
import com.grassparty.tft.Model.DAO.RecordDAO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Repository.JPA.FullRecordRepositoryJPA;
import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RecordRepository {

    @Autowired
    FullRecordRepositoryJPA fullRecordRepositoryJPA;

    public void InsertFullRecords(RecordDTO[] recordDTOS){
        for(RecordDTO recordDTO : recordDTOS){
            InsertFullRecord(recordDTO);
        }
    }

    public void InsertFullRecord(RecordDTO recordDTO){
        String matchid = recordDTO.getMatch_id();

        Gson gson = new Gson();
        String jsonString = gson.toJson(recordDTO);

        RecordDAO recordDB = RecordDAO.builder()
                .matchID(matchid)
                .json(jsonString)
                .build();
        fullRecordRepositoryJPA.save(recordDB);
    }

    public boolean IsExistByMatchid(String matchid){

        return fullRecordRepositoryJPA.existsById(matchid);
    }

    public RecordDTO[] GetFullRecordDTOsByMatchidFromRepository(MatchID matchID){
        RecordDTO[] recordDTOS = new RecordDTO[10];
        for(int i=0; i<matchID.getMatchid().length;i++){
            recordDTOS[i] = GetFullRecordDTOFromRepository(matchID.getMatchid()[i]);
        }
        return recordDTOS;
    }

    public RecordDTO GetFullRecordDTOFromRepository(String matchid){

        // DB에서 FullRecordDB 가져오기
        Optional<RecordDAO> recordDB=fullRecordRepositoryJPA.findById(matchid);

        // FullRecordDB에서 json 받아오기
        String json =  recordDB.get().getJson();

        // Gson 역직렬화까즤
        Gson gson = new Gson();
        RecordDTO recordDTO = gson.fromJson(json, RecordDTO.class);

        return recordDTO;
    }

    public RecordDAO GetFullRecordDBByMatchId(String matchId){
        return fullRecordRepositoryJPA.getById(matchId);
    }

}







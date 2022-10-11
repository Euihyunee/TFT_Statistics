package com.grassparty.tft.Repository;

import com.google.gson.Gson;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.Model.DAO.FullRecordDAO;
import com.grassparty.tft.Repository.JPA.FullRecordRepositoryJPA;
import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FullRecordRepository {

    @Autowired
    FullRecordRepositoryJPA fullRecordRepositoryJPA;

    public void InsertFullRecords(FullRecordDTO[] fullRecordDTOS){
        for(FullRecordDTO fullRecordDTO : fullRecordDTOS){
            InsertFullRecord(fullRecordDTO);
        }
    }

    public void InsertFullRecord(FullRecordDTO fullRecordDTO){
        String matchid = fullRecordDTO.getMatch_id();

        Gson gson = new Gson();
        String jsonString = gson.toJson(fullRecordDTO);

        FullRecordDAO fullRecordDB = FullRecordDAO.builder()
                .matchID(matchid)
                .json(jsonString)
                .build();
        fullRecordRepositoryJPA.save(fullRecordDB);
    }

    public boolean IsExistByMatchid(String matchid){

        return fullRecordRepositoryJPA.existsById(matchid);
    }

    public FullRecordDTO[] GetFullRecordDTOsByMatchidFromRepository(MatchID matchID){
        FullRecordDTO[] fullRecordDTOS = new FullRecordDTO[10];
        for(int i=0; i<matchID.getMatchid().length;i++){
            fullRecordDTOS[i] = GetFullRecordDTOFromRepository(matchID.getMatchid()[i]);
        }
        return fullRecordDTOS;
    }

    public FullRecordDTO GetFullRecordDTOFromRepository(String matchid){

        // DB에서 FullRecordDB 가져오기
        Optional<FullRecordDAO> fullRecordDB=fullRecordRepositoryJPA.findById(matchid);

        // FullRecordDB에서 json 받아오기
        String json =  fullRecordDB.get().getJson();

        // Gson 역직렬화까즤
        Gson gson = new Gson();
        FullRecordDTO fullRecordDTO = gson.fromJson(json, FullRecordDTO.class);

        return fullRecordDTO;
    }

    public FullRecordDAO GetFullRecordDBByMatchId(String matchId){
        return fullRecordRepositoryJPA.getById(matchId);
    }

}







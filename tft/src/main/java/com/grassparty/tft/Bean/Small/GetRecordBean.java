package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetRecordBean {
    @Autowired
    RecordRepository repository;

    public RecordDTO exec(String matchID){
        return repository.GetRecordDTOFromRepository(matchID);
    }
    public List<RecordDTO> exec(MatchID matchID){
        List<RecordDTO> records = new ArrayList<>();

        for (String matchId:matchID.getMatchid()) {
            records.add(exec(matchId));
        }

        System.out.println("디비에서 받아온 record 수 : " + records.size());

        return records;
    }
}

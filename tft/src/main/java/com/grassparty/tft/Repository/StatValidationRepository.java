package com.grassparty.tft.Repository;

import com.grassparty.tft.Model.DB.StatValidationTable;
import com.grassparty.tft.Repository.JPA.StatVaildationRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatValidationRepository {
    @Autowired
    StatVaildationRepositoryJPA statVaildationRepositoryJPA;

    // matchId[]를 DB Statvalidation 테이블에서 가져오기
    public String[] GetMatchIdsFromStatValidation(){
        // valid가 false인 matchid를 어떻게 가져오지?
        // 가져온 데이터는 True로 업데이트

        return null;
    }

    // matchId를 DB Statvalidation 테이블에서 가져오기
    public String GetMatchIdFromStatValidation(){
        try {
            StatValidationTable statValidationTable = statVaildationRepositoryJPA.findAllByValid(false).get(0);

            // 가져온 데이터는 True로 업데이트
            statValidationTable.setValid(true);
            statVaildationRepositoryJPA.save(statValidationTable);

            return statValidationTable.getMatchID();
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

}

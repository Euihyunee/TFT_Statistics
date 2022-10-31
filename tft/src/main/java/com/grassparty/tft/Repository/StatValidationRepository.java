package com.grassparty.tft.Repository;

import com.grassparty.tft.Model.DAO.StatValidRecordDAO;
import com.grassparty.tft.Repository.JPA.StatVaildationRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StatValidationRepository {
    @Autowired
    StatVaildationRepositoryJPA statVaildationRepositoryJPA;

    // matchId를 DB Statvalidation 테이블에서 가져오기
    public String GetMatchIdFromStatValidation(){
        try {
            StatValidRecordDAO statValidRecordDAO = statVaildationRepositoryJPA.findAllByValid(false).get(0);

            // 가져온 데이터는 True로 업데이트
            statValidRecordDAO.setValid(true);
            statVaildationRepositoryJPA.save(statValidRecordDAO);

            return statValidRecordDAO.getMatchID();
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

}

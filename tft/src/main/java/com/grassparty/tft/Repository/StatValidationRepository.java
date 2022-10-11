package com.grassparty.tft.Repository;

import com.grassparty.tft.Model.DAO.StatValidationDAO;
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
            StatValidationDAO statValidationDAO = statVaildationRepositoryJPA.findAllByValid(false).get(0);

            // 가져온 데이터는 True로 업데이트
            statValidationDAO.setValid(true);
            statVaildationRepositoryJPA.save(statValidationDAO);

            return statValidationDAO.getMatchID();
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

}

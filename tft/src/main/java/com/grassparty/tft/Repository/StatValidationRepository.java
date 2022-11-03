package com.grassparty.tft.Repository;

import com.grassparty.tft.Model.DAO.StatValidRecordDAO;
import com.grassparty.tft.Model.Riot.MatchID;
import com.grassparty.tft.Repository.JPA.StatVaildationRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatValidationRepository {
    @Autowired
    StatVaildationRepositoryJPA statVaildationRepositoryJPA;

    // matchId를 DB Statvalidation 테이블에서 가져오기
    public MatchID GetMatchIdFromStatValidation(){
        try {
            List<StatValidRecordDAO> statValidRecordDAOS = statVaildationRepositoryJPA.findAllByValid(false); // 이거 위험해보임...

            String[] buffer = new String[statValidRecordDAOS.size()];
            int count=0;

            // 가져온 데이터는 True로 업데이트
            for (StatValidRecordDAO dao: statValidRecordDAOS) {
                dao.setValid(true);
                buffer[count++] = dao.getMatchID();
                System.out.println("벨리데이션 테이블에서 가져온 데이터 True 변경 : " + dao.getMatchID()+ " : " + dao.getValid());
            }

            MatchID matchID = new MatchID(buffer);

            return matchID;
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

}

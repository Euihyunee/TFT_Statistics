package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Repository.JPA.CustomPreQueryRepository;
import com.grassparty.tft.Model.DAO.StatPreServiceInterface;
import com.grassparty.tft.Model.DAO.StatPreServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondScheduleBean {
    @Autowired
    CustomPreQueryRepository customPreQueryRepository;
    @Autowired
    GetStatPreServiceTableFromStatPreServiceInterfaceBean getStatPreServiceTableFromStatPreServiceInterfaceBean;

    public void exec(){
        // 로직
        // 걍 쿼리를 쓰자
        // GroupBy 챔피언 해서 테이블 만들기
        for(int i = 0 ; i < customPreQueryRepository.GetQuery().size(); i++){
            StatPreServiceInterface preService = customPreQueryRepository.GetQuery().get(i);

            // preService를 DBTable에 맞추기
            StatPreServiceDAO statPreServiceTable =
                    getStatPreServiceTableFromStatPreServiceInterfaceBean.exec(preService);

            // preService 저장하기
            customPreQueryRepository.save(statPreServiceTable);
        }
    }
}

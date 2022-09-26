package com.grassparty.tft.Bean;

import com.grassparty.tft.History.Repository.JPA.CustomPreQueryRepository;
import com.grassparty.tft.Model.DB.StatPreServiceInterface;
import com.grassparty.tft.Model.DB.StatPreServiceTable;
import org.springframework.beans.factory.annotation.Autowired;

public class SecondScheduleBean {
    @Autowired
    CustomPreQueryRepository customPreQueryRepository;

    GetStatPreServiceTableFromStatPreServiceInterfaceBean GetStatPreServiceTableFromStatPreServiceInterfaceBean = new GetStatPreServiceTableFromStatPreServiceInterfaceBean();

    public void exec(){
        // 로직
        // 걍 쿼리를 쓰자
        // GroupBy 챔피언 해서 테이블 만들기
        for(int i = 0 ; i < customPreQueryRepository.GetQuery().size(); i++){
            StatPreServiceInterface preService = customPreQueryRepository.GetQuery().get(i);

            // preService를 DBTable에 맞추기
            StatPreServiceTable statPreServiceTable =
                    GetStatPreServiceTableFromStatPreServiceInterfaceBean.exec(preService);

            // preService 저장하기
            customPreQueryRepository.save(statPreServiceTable);
        }
    }
}

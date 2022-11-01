package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.StatDeckGroupDAO;
import com.grassparty.tft.Repository.JPA.CustomPreQueryRepository;
import com.grassparty.tft.Repository.JPA.CustomQueryRepository;
import com.grassparty.tft.Model.DAO.StatDeckSimilarityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassifyDeckBean {
    @Autowired
    CustomQueryRepository customQueryRepository;
    @Autowired
    CustomPreQueryRepository customPreQueryRepository;

    public void exec(){
        // 로직
        // 카운트가 제일 높은 첫번째 덱 가져오기
        StatDeckGroupDAO perService = customPreQueryRepository.getMaxCountRow();

        // 첫번째 덱 덱리스트(serviceTable)에 저장하기



    }
}

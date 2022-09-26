package com.grassparty.tft.Bean;

import com.grassparty.tft.Repository.JPA.CustomPreQueryRepository;
import com.grassparty.tft.Repository.JPA.CustomQueryRepository;
import com.grassparty.tft.Model.DB.StatPreServiceTable;
import com.grassparty.tft.Model.DB.StatServiceTable;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassifyDeckBean {
    @Autowired
    CustomQueryRepository customQueryRepository;
    @Autowired
    CustomPreQueryRepository customPreQueryRepository;

    GetServiceFromPreServiceBean GetServiceFromPreServiceBean = new GetServiceFromPreServiceBean();

    public void exec(){
        // 로직
        // 카운트가 제일 높은 첫번째 덱 가져오기
        StatPreServiceTable perService = customPreQueryRepository.getMaxCountRow();

        // 첫번째 덱 덱리스트(serviceTable)에 저장하기
        StatServiceTable service = GetServiceFromPreServiceBean.exec(perService);
        customQueryRepository.save(service);
    }
}

package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.StatDeckDAO;
import com.grassparty.tft.Model.DAO.VersionDAO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Repository.JPA.VersionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetSeasonVersionBean {
    @Autowired
    GetParserBean getParserBean;
    @Autowired
    VersionRepositoryJPA repository;

    public List<Integer> exec(List<RecordDTO> records){
        List<Integer> recordVersionMap = new ArrayList<>();
        for (RecordDTO record: records) {
            int version = getParserBean.exec(record.getGame_version(), GetParserBean.EnumVersion.Season);
            if(!recordVersionMap.contains(version)){
                recordVersionMap.add(version);
            }
        }

        return recordVersionMap;
    }
    public int exec(RecordDTO record){
        return getParserBean.exec(record.getGame_version(), GetParserBean.EnumVersion.Season);
    }
    // 덱 가져와서 버전 아이디 기반으로 season 버전으로 리턴
    public int exec(StatDeckDAO deck){
        long versionId = deck.getVersionId();
        VersionDAO version = repository.findByVersionId(versionId);
        return version.getSeasonVersion();
    }
}

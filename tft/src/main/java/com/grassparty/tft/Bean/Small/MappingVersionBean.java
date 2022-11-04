package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.VersionDAO;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Repository.JPA.VersionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MappingVersionBean {
    @Autowired
    GetParserBean getParserBean;
    @Autowired
    VersionRepositoryJPA repository;
    public void exec(RecordDTO recordDTO) {
        // TODO 레코드로 version 정보 오토맵핑
        // 만약 이 버전정보가 있다면 pass
        String version = recordDTO.getGame_version();
        if(repository.existsByTotalVersion(version)){
            return;
        }

        // 버전 정보가 없으면 새로 저장
        VersionDAO versionDAO = new VersionDAO();
        versionDAO.setSeasonVersion(getParserBean.exec(version, GetParserBean.EnumVersion.Season));
        versionDAO.setUpdateVersion(getParserBean.exec(version, GetParserBean.EnumVersion.Update));
        versionDAO.setTotalVersion(version);
        repository.save(versionDAO);

    }
}

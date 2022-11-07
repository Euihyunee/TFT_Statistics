package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.VersionDAO;
import com.grassparty.tft.Repository.JPA.VersionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetVersionIdFromVersionTableBean {

    @Autowired
    VersionRepositoryJPA versionRepository;
    // version_id를 version테이블에서 가져오기
    public Long exec(String totalVersion){
        VersionDAO versionDAO = versionRepository.findByTotalVersion(totalVersion);
        return versionDAO.getVersionId();
    }
}

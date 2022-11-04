package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Repository.JPA.VersionRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetVersionIdBean {
    @Autowired
    VersionRepositoryJPA repository;

    public Long exec(int seasonVersion, int updateVersion){
        return repository.findBySeasonVersionAndAndUpdateVersion(seasonVersion, updateVersion).getVersionId();

    }
    public Long exec(String totalVersion){
        return repository.findByTotalVersion(totalVersion).getVersionId();
    }
}

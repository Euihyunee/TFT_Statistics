package com.grassparty.tft.Bean.Small;

import org.springframework.stereotype.Component;

import static com.grassparty.tft.Bean.Small.GetParserBean.EnumVersion.Season;
import static com.grassparty.tft.Bean.Small.GetParserBean.EnumVersion.Update;

@Component
public class GetParserBean {

    public static enum EnumVersion{
        Season, Update
    }
    public int exec(String version, EnumVersion enumVersion){

        String[] VersionList = version.split("\\.");
        if(enumVersion == Season){
            return Integer.parseInt(VersionList[0]);
        }
        if(enumVersion == Update){
            return Integer.parseInt(VersionList[1]);
        }

        return Integer.parseInt(VersionList[0]);
    }
}

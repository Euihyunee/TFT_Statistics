package com.grassparty.tft.Bean.Small;

import org.springframework.stereotype.Component;

@Component
public class GetVersionBean {
    public void exec(){
        // DB record 테이블에서 json(RecordDTO) 가져오기



        // json데이터에서 game_version 가져오기
        // ex) 12.20.474.8882



        // gmae_version parsing해서 12는 season_id, 20은 update_id로 나머지는 etc?로 분리




        // version_table에 조회해서 있으면 냅두고 없으면 추가하는 방식 만들기
    }
}

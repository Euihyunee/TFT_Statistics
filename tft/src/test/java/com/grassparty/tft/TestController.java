package com.grassparty.tft;

import com.grassparty.tft.History.Repository.JPA.CustomPreQueryRepository;
import com.grassparty.tft.History.Service.MetaRecordService;
import com.grassparty.tft.History.Service.SummonerService;
import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@CrossOrigin("*")
public class TestController {

    @Autowired
    MetaRecordService metaRecordService;
    @Autowired
    SummonerService summonerService;


    // 문자열 출력 테스트
    @GetMapping(path = "/{test}")
    public String test(@PathVariable String test) {
        return test;
    }

    // 메타레코드 더미데이터 테스트
    @GetMapping(path = "/MetaRecord")
    public MetaRecordDTO test() {
        return metaRecordService.GetDummyDTO();
    }

    // UTF-8 테스트
    @GetMapping(path = "/UTF-8/{name}")
    public String GetEncodeByName(@PathVariable String name) {
        return summonerService.GetEncode(name);
    }
}

package com.grassparty.tft.Stat.Controller;

import com.grassparty.tft.Bean.UpdateStatChampionResultDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@CrossOrigin("*")
public class TestController {

    @Autowired
    UpdateStatChampionResultDAOBean updateStatChampionResultDAOBean;

    @GetMapping(path="/statresult")
    public void statResult(){ updateStatChampionResultDAOBean.exec();}
}

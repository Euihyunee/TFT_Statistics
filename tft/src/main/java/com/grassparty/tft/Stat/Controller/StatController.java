package com.grassparty.tft.Stat.Controller;

import com.grassparty.tft.legacy.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stat")
@CrossOrigin("*")
public class StatController {
    @Autowired
    StatService statService;

    @GetMapping(path="/stat/{name}")
    public void StartStatistic(@PathVariable String name){ statService.StatisticsByName(name);}

}

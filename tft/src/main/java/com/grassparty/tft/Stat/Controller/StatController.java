package com.grassparty.tft.Stat.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class StatController {

    @GetMapping(path="/stat/{name}")
    public void StartStatistic(@PathVariable String name){ statService.StatisticsByName(name);}

}

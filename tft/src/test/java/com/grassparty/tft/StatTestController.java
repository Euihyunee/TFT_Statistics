package com.grassparty.tft;

import com.grassparty.tft.Repository.JPA.CustomPreQueryRepository;
import com.grassparty.tft.Repository.JPA.CustomQueryRepository;
import com.grassparty.tft.Repository.StatPreServiceRepository;
import com.grassparty.tft.History.Service.StatService;
import com.grassparty.tft.Model.DB.StatPreServiceTable;
import com.grassparty.tft.Model.DTO.StatisticDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test/stat")
@CrossOrigin("*")
public class StatTestController {

    @Autowired
    StatPreServiceRepository statPreServiceRepository;
    @Autowired
    StatService statService;
    @Autowired
    CustomQueryRepository customQueryRepository;
    @Autowired
    CustomPreQueryRepository customPreQueryRepository;


    @GetMapping("/test1111")
    public StatPreServiceTable test1111(){return statPreServiceRepository.testPrintCount();}

    // statService 테스트입니당
    @GetMapping("/DBTest1/{matchid}")
    public void testDBTest1(@PathVariable String matchid){

        statService.StatisticsByMatchId(matchid);
    }

    @GetMapping("/mockdoridomabem")
    public ArrayList<StatisticDTO> mockdoridomabem(){
        ArrayList<StatisticDTO> statisticDTOs = new ArrayList<StatisticDTO>();
        List<StatPreServiceTable> preServiceTables = customPreQueryRepository.findAll();
        StatPreServiceTable dummy;
        for(int i=0; i< preServiceTables.size(); i++){
            StatisticDTO statisticDTO = new StatisticDTO();
            dummy = preServiceTables.get(i);
            statisticDTO.setPlacementRate(dummy.getPlacement() / dummy.getCount());
            statisticDTO.setCharacter_id(FuckThatShit(dummy));
            statisticDTOs.add(statisticDTO);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(statisticDTOs);



        return statisticDTOs;
    }
    public String[] FuckThatShit(StatPreServiceTable statPreServiceTable){
        ArrayList<String> sexsex = new ArrayList<String>();
        if(statPreServiceTable.getTFT7_Aatrox() == 1){
            sexsex.add("TFT7_Nidalee");
        }
        if(statPreServiceTable.getTFT7_Leona() == 1){
            sexsex.add("TFT7_Leona");
        }
        if(statPreServiceTable.getTFT7_Vladimir() == 1){
            sexsex.add("TFT7_Vladimir");
        }
        if(statPreServiceTable.getTFT7_Senna() == 1){
            sexsex.add("TFT7_Senna");
        }
        if(statPreServiceTable.getTFT7_Sejuani() == 1){
            sexsex.add("TFT7_Sejuani");
        }
        if(statPreServiceTable.getTFT7_Sett() == 1){
            sexsex.add("TFT7_Sett");
        }
        if(statPreServiceTable.getTFT7_Skarner() == 1){
            sexsex.add("TFT7_Skarner");
        }
        if(statPreServiceTable.getTFT7_Aatrox() == 1){
            sexsex.add("TFT7_Aatrox");
        }
        if(statPreServiceTable.getTFT7_Ezreal() == 1){
            sexsex.add("TFT7_Ezreal");
        }
        if(statPreServiceTable.getTFT7_Taric() == 1){
            sexsex.add("TFT7_Taric");
        }
        if(statPreServiceTable.getTFT7_Karma() == 1){
            sexsex.add("TFT7_Karma");
        }
        if(statPreServiceTable.getTFT7_TahmKench() == 1){
            sexsex.add("TFT7_TahmKench");
        }
        if(statPreServiceTable.getTFT7_Heimerdinger() == 1){
            sexsex.add("TFT7_Heimerdinger");
        }
        if(statPreServiceTable.getTFT7_Gnar() == 1){
            sexsex.add("TFT7_Gnar");
        }
        if(statPreServiceTable.getTFT7_Nami() == 1){
            sexsex.add("TFT7_Nami");
        }
        if(statPreServiceTable.getTFT7_Lillia() == 1){
            sexsex.add("TFT7_Lillia");
        }
        if(statPreServiceTable.getTFT7_Braum() == 1){
            sexsex.add("TFT7_Braum");
        }
        if(statPreServiceTable.getTFT7_Shen() == 1){
            sexsex.add("TFT7_Shen");
        }
        if(statPreServiceTable.getTFT7_Thresh() == 1){
            sexsex.add("TFT7_Thresh");
        }
        if(statPreServiceTable.getTFT7_Ashe() == 1){
            sexsex.add("TFT7_Ashe");
        }
        if(statPreServiceTable.getTFT7_Yone() == 1){
            sexsex.add("TFT7_Yone");
        }
        if(statPreServiceTable.getTFT7_Jinx() == 1){
            sexsex.add("TFT7_Jinx");
        }
        if(statPreServiceTable.getTFT7_Kayn() == 1){
            sexsex.add("TFT7_Kayn");
        }
        if(statPreServiceTable.getTFT7_Qiyana() == 1){
            sexsex.add("TFT7_Qiyana");
        }
        if(statPreServiceTable.getTFT7_Tristana() == 1){
            sexsex.add("TFT7_Tristana");
        }
        if(statPreServiceTable.getTFT7_Twitch() == 1){
            sexsex.add("TFT7_Twitch");
        }
        if(statPreServiceTable.getTFT7_Nunu() == 1){
            sexsex.add("TFT7_Nunu");
        }
        if(statPreServiceTable.getTFT7_Diana() == 1){
            sexsex.add("TFT7_Diana");
        }
        if(statPreServiceTable.getTFT7_Ryze() == 1){
            sexsex.add("TFT7_Ryze");
        }
        if(statPreServiceTable.getTFT7_Lulu() == 1){
            sexsex.add("TFT7_Lulu");
        }
        if(statPreServiceTable.getTFT7_LeeSin() == 1){
            sexsex.add("TFT7_LeeSin");
        }
        if(statPreServiceTable.getTFT7_Varus() == 1){
            sexsex.add("TFT7_Varus");
        }
        if(statPreServiceTable.getTFT7_Volibear() == 1){
            sexsex.add("TFT7_Volibear");
        }
        if(statPreServiceTable.getTFT7_Sylas() == 1){
            sexsex.add("TFT7_Sylas");
        }
        if(statPreServiceTable.getTFT7_Swain() == 1){
            sexsex.add("TFT7_Swain");
        }
        if(statPreServiceTable.getTFT7_Anivia() == 1){
            sexsex.add("TFT7_Anivia");
        }
        if(statPreServiceTable.getTFT7_Elise() == 1){
            sexsex.add("TFT7_Elise");
        }
        if(statPreServiceTable.getTFT7_Olaf() == 1){
            sexsex.add("TFT7_Olaf");
        }
        if(statPreServiceTable.getTFT7_Illaoi() == 1){
            sexsex.add("TFT7_Illaoi");
        }
        if(statPreServiceTable.getTFT7_Neeko() == 1){
            sexsex.add("TFT7_Neeko");
        }
        if(statPreServiceTable.getTFT7_Sona() == 1){
            sexsex.add("TFT7_Sona");
        }
        if(statPreServiceTable.getTFT7_Ornn() == 1){
            sexsex.add("TFT7_Ornn");
        }
        if(statPreServiceTable.getTFT7_Xayah() == 1){
            sexsex.add("TFT7_Xayah");
        }
        if(statPreServiceTable.getTFT7_Corki() == 1){
            sexsex.add("TFT7_Corki");
        }
        if(statPreServiceTable.getTFT7_Talon() == 1){
            sexsex.add("TFT7_Talon");
        }
        if(statPreServiceTable.getTFT7_Hecarim() == 1){
            sexsex.add("TFT7_Hecarim");
        }
        if(statPreServiceTable.getTFT7_Bard() == 1){
            sexsex.add("TFT7_Bard");
        }
        if(statPreServiceTable.getTFT7_Soraka() == 1){
            sexsex.add("TFT7_Soraka");
        }
        if(statPreServiceTable.getTFT7_Yasuo() == 1){
            sexsex.add("TFT7_Yasuo");
        }
        if(statPreServiceTable.getTFT7_Zoe() == 1){
            sexsex.add("TFT7_Zoe");
        }
        if(statPreServiceTable.getTFT7_Pyke() == 1){
            sexsex.add("TFT7_Pyke");
        }
        if(statPreServiceTable.getTFT7_DragonBlue() == 1){
            sexsex.add("TFT7_DragonBlue");
        }
        if(statPreServiceTable.getTFT7_DragonGold() == 1){
            sexsex.add("TFT7_DragonGold");
        }
        if(statPreServiceTable.getTFT7_DragonPurple() == 1){
            sexsex.add("TFT7_DragonPurple");
        }
        if(statPreServiceTable.getTFT7_DragonGreen() == 1){
            sexsex.add("TFT7_DragonGreen");
        }
        if(statPreServiceTable.getTFT7_TrainerDragon() == 1){
            sexsex.add("TFT7_TrainerDragon");
        }
        if(statPreServiceTable.getTFT7_AoShin() == 1){
            sexsex.add("TFT7_AoShin");
        }
        if(statPreServiceTable.getTFT7_AurelionSol() == 1){
            sexsex.add("TFT7_AurelionSol");
        }
        if(statPreServiceTable.getTFT7_Shyvana() == 1){
            sexsex.add("TFT7_Shyvana");
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(sexsex);


        String[] sex = sexsex.toArray(new String[sexsex.size()]);
        return sex;
    }

}

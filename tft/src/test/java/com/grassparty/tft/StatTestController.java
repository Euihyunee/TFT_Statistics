package com.grassparty.tft;

import com.grassparty.tft.Model.DAO.StatDeckGroupDAO;
import com.grassparty.tft.Repository.JPA.CustomPreQueryRepository;
import com.grassparty.tft.Repository.JPA.CustomQueryRepository;
import com.grassparty.tft.Repository.StatPreServiceRepository;
import com.grassparty.tft.Stat.Service.StatService;
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
    public StatDeckGroupDAO test1111(){return statPreServiceRepository.testPrintCount();}

    // statService 테스트입니당
    @GetMapping("/DBTest1/{matchid}")
    public void testDBTest1(@PathVariable String matchid){

        statService.StatisticsByMatchId(matchid);
    }

    @GetMapping("/mockdoridomabem")
    public ArrayList<StatisticDTO> mockdoridomabem(){
        ArrayList<StatisticDTO> statisticDTOs = new ArrayList<StatisticDTO>();
        List<StatDeckGroupDAO> preServiceTables = customPreQueryRepository.findAll();
        StatDeckGroupDAO dummy;
        for(int i=0; i< preServiceTables.size(); i++){
            StatisticDTO statisticDTO = new StatisticDTO();
            dummy = preServiceTables.get(i);
            statisticDTO.setPlacementRate(dummy.getSum_placement() / dummy.getCount());
            statisticDTO.setCharacter_id(FuckThatShit(dummy));
            statisticDTOs.add(statisticDTO);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(statisticDTOs);



        return statisticDTOs;
    }
    public String[] FuckThatShit(StatDeckGroupDAO statDeckGroupDAO){
        ArrayList<String> sexsex = new ArrayList<String>();
        if(statDeckGroupDAO.getTFT7_Aatrox() == 1){
            sexsex.add("TFT7_Nidalee");
        }
        if(statDeckGroupDAO.getTFT7_Leona() == 1){
            sexsex.add("TFT7_Leona");
        }
        if(statDeckGroupDAO.getTFT7_Vladimir() == 1){
            sexsex.add("TFT7_Vladimir");
        }
        if(statDeckGroupDAO.getTFT7_Senna() == 1){
            sexsex.add("TFT7_Senna");
        }
        if(statDeckGroupDAO.getTFT7_Sejuani() == 1){
            sexsex.add("TFT7_Sejuani");
        }
        if(statDeckGroupDAO.getTFT7_Sett() == 1){
            sexsex.add("TFT7_Sett");
        }
        if(statDeckGroupDAO.getTFT7_Skarner() == 1){
            sexsex.add("TFT7_Skarner");
        }
        if(statDeckGroupDAO.getTFT7_Aatrox() == 1){
            sexsex.add("TFT7_Aatrox");
        }
        if(statDeckGroupDAO.getTFT7_Ezreal() == 1){
            sexsex.add("TFT7_Ezreal");
        }
        if(statDeckGroupDAO.getTFT7_Taric() == 1){
            sexsex.add("TFT7_Taric");
        }
        if(statDeckGroupDAO.getTFT7_Karma() == 1){
            sexsex.add("TFT7_Karma");
        }
        if(statDeckGroupDAO.getTFT7_TahmKench() == 1){
            sexsex.add("TFT7_TahmKench");
        }
        if(statDeckGroupDAO.getTFT7_Heimerdinger() == 1){
            sexsex.add("TFT7_Heimerdinger");
        }
        if(statDeckGroupDAO.getTFT7_Gnar() == 1){
            sexsex.add("TFT7_Gnar");
        }
        if(statDeckGroupDAO.getTFT7_Nami() == 1){
            sexsex.add("TFT7_Nami");
        }
        if(statDeckGroupDAO.getTFT7_Lillia() == 1){
            sexsex.add("TFT7_Lillia");
        }
        if(statDeckGroupDAO.getTFT7_Braum() == 1){
            sexsex.add("TFT7_Braum");
        }
        if(statDeckGroupDAO.getTFT7_Shen() == 1){
            sexsex.add("TFT7_Shen");
        }
        if(statDeckGroupDAO.getTFT7_Thresh() == 1){
            sexsex.add("TFT7_Thresh");
        }
        if(statDeckGroupDAO.getTFT7_Ashe() == 1){
            sexsex.add("TFT7_Ashe");
        }
        if(statDeckGroupDAO.getTFT7_Yone() == 1){
            sexsex.add("TFT7_Yone");
        }
        if(statDeckGroupDAO.getTFT7_Jinx() == 1){
            sexsex.add("TFT7_Jinx");
        }
        if(statDeckGroupDAO.getTFT7_Kayn() == 1){
            sexsex.add("TFT7_Kayn");
        }
        if(statDeckGroupDAO.getTFT7_Qiyana() == 1){
            sexsex.add("TFT7_Qiyana");
        }
        if(statDeckGroupDAO.getTFT7_Tristana() == 1){
            sexsex.add("TFT7_Tristana");
        }
        if(statDeckGroupDAO.getTFT7_Twitch() == 1){
            sexsex.add("TFT7_Twitch");
        }
        if(statDeckGroupDAO.getTFT7_Nunu() == 1){
            sexsex.add("TFT7_Nunu");
        }
        if(statDeckGroupDAO.getTFT7_Diana() == 1){
            sexsex.add("TFT7_Diana");
        }
        if(statDeckGroupDAO.getTFT7_Ryze() == 1){
            sexsex.add("TFT7_Ryze");
        }
        if(statDeckGroupDAO.getTFT7_Lulu() == 1){
            sexsex.add("TFT7_Lulu");
        }
        if(statDeckGroupDAO.getTFT7_LeeSin() == 1){
            sexsex.add("TFT7_LeeSin");
        }
        if(statDeckGroupDAO.getTFT7_Varus() == 1){
            sexsex.add("TFT7_Varus");
        }
        if(statDeckGroupDAO.getTFT7_Volibear() == 1){
            sexsex.add("TFT7_Volibear");
        }
        if(statDeckGroupDAO.getTFT7_Sylas() == 1){
            sexsex.add("TFT7_Sylas");
        }
        if(statDeckGroupDAO.getTFT7_Swain() == 1){
            sexsex.add("TFT7_Swain");
        }
        if(statDeckGroupDAO.getTFT7_Anivia() == 1){
            sexsex.add("TFT7_Anivia");
        }
        if(statDeckGroupDAO.getTFT7_Elise() == 1){
            sexsex.add("TFT7_Elise");
        }
        if(statDeckGroupDAO.getTFT7_Olaf() == 1){
            sexsex.add("TFT7_Olaf");
        }
        if(statDeckGroupDAO.getTFT7_Illaoi() == 1){
            sexsex.add("TFT7_Illaoi");
        }
        if(statDeckGroupDAO.getTFT7_Neeko() == 1){
            sexsex.add("TFT7_Neeko");
        }
        if(statDeckGroupDAO.getTFT7_Sona() == 1){
            sexsex.add("TFT7_Sona");
        }
        if(statDeckGroupDAO.getTFT7_Ornn() == 1){
            sexsex.add("TFT7_Ornn");
        }
        if(statDeckGroupDAO.getTFT7_Xayah() == 1){
            sexsex.add("TFT7_Xayah");
        }
        if(statDeckGroupDAO.getTFT7_Corki() == 1){
            sexsex.add("TFT7_Corki");
        }
        if(statDeckGroupDAO.getTFT7_Talon() == 1){
            sexsex.add("TFT7_Talon");
        }
        if(statDeckGroupDAO.getTFT7_Hecarim() == 1){
            sexsex.add("TFT7_Hecarim");
        }
        if(statDeckGroupDAO.getTFT7_Bard() == 1){
            sexsex.add("TFT7_Bard");
        }
        if(statDeckGroupDAO.getTFT7_Soraka() == 1){
            sexsex.add("TFT7_Soraka");
        }
        if(statDeckGroupDAO.getTFT7_Yasuo() == 1){
            sexsex.add("TFT7_Yasuo");
        }
        if(statDeckGroupDAO.getTFT7_Zoe() == 1){
            sexsex.add("TFT7_Zoe");
        }
        if(statDeckGroupDAO.getTFT7_Pyke() == 1){
            sexsex.add("TFT7_Pyke");
        }
        if(statDeckGroupDAO.getTFT7_DragonBlue() == 1){
            sexsex.add("TFT7_DragonBlue");
        }
        if(statDeckGroupDAO.getTFT7_DragonGold() == 1){
            sexsex.add("TFT7_DragonGold");
        }
        if(statDeckGroupDAO.getTFT7_DragonPurple() == 1){
            sexsex.add("TFT7_DragonPurple");
        }
        if(statDeckGroupDAO.getTFT7_DragonGreen() == 1){
            sexsex.add("TFT7_DragonGreen");
        }
        if(statDeckGroupDAO.getTFT7_TrainerDragon() == 1){
            sexsex.add("TFT7_TrainerDragon");
        }
        if(statDeckGroupDAO.getTFT7_AoShin() == 1){
            sexsex.add("TFT7_AoShin");
        }
        if(statDeckGroupDAO.getTFT7_AurelionSol() == 1){
            sexsex.add("TFT7_AurelionSol");
        }
        if(statDeckGroupDAO.getTFT7_Shyvana() == 1){
            sexsex.add("TFT7_Shyvana");
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(sexsex);


        String[] sex = sexsex.toArray(new String[sexsex.size()]);
        return sex;
    }

}

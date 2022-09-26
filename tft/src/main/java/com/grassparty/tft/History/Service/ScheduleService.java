package com.grassparty.tft.History.Service;

import com.google.gson.Gson;
import com.grassparty.tft.Bean.FirstScheduleBean;
import com.grassparty.tft.Model.DB.*;
import com.grassparty.tft.Model.DTO.FullDTO.FullParticipantDTO;
import com.grassparty.tft.Model.DTO.FullDTO.FullUnitDTO;
import com.grassparty.tft.Model.DTO.FullRecordDTO;
import com.grassparty.tft.History.Repository.FullRecordRepository;
import com.grassparty.tft.History.Repository.JPA.CustomPreQueryRepository;
import com.grassparty.tft.History.Repository.JPA.CustomQueryRepository;
import com.grassparty.tft.History.Repository.StatRepository;
import com.grassparty.tft.History.Repository.StatValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ScheduleService {

    @Autowired CustomQueryRepository customQueryRepository;
    @Autowired CustomPreQueryRepository customPreQueryRepository;


    FirstScheduleBean FirstScheduleBean = new FirstScheduleBean();


    // @Scheduled(fixedDelay = 3000000)
    public void ScheduleMethod1(){
        FirstScheduleBean.exec();
    }


    // stat테이블에서 preService테이블로 데이터 넘기기
    //@Scheduled(fixedDelay = 3000000)
    public void ScheduleMethod2(){
        System.out.println("2번 기능 5분에 한번 실행----------------------------------------");

        // 걍 쿼리를 쓰자
        // GroupBy 챔피언 해서 테이블 만들기
        for(int i = 0 ; i < customPreQueryRepository.GetQuery().size(); i++){
            StatPreServiceInterface preService = customPreQueryRepository.GetQuery().get(i);

            // preService를 DBTable에 맞추기
            StatPreServiceTable statPreServiceTable =
                    GetStatPreServiceTableFromStatPreServiceInterface(preService);

            // preService 저장하기
            customPreQueryRepository.save(statPreServiceTable);
        }
    }

    // preService테이블에서 Service테이블로 데이터 넘기기
    // StatServiceInterface 미구현
    @Scheduled(fixedDelay = 3000000)
    public void PreToServiceTable(){
        System.out.println("3번 기능 5분에 한번 실행----------------------------------------");
        ClassifyDeck();

//        for(int i = 0 ; i < customQueryRepository.GetQuery().size(); i++) {
//            StatServiceInterface service = customQueryRepository.getMaxCountRow().get(i);
//
//            // Service를 DBTable에 맞추기
//            StatServiceTable serviceTable = GetServiceFromServiceInterface(service);
//
//            customQueryRepository.save(serviceTable);
//        }
    }

    private void ClassifyDeck(){
        // 카운트가 제일 높은 첫번째 덱 가져오기
        StatPreServiceTable perService = customPreQueryRepository.getMaxCountRow();

        // 첫번째 덱 덱리스트(serviceTable)에 저장하기
        StatServiceTable service = GetServiceFromPreService(perService);
        customQueryRepository.save(service);

    }

    private StatServiceTable GetServiceFromPreService(StatPreServiceTable perService) {
        StatServiceTable service = StatServiceTable.builder()
                .placement(perService.getPlacement())
                .count(perService.getCount())
                .TFT7_Aatrox(perService.getTFT7_Aatrox())
                .TFT7_Anivia(perService.getTFT7_Anivia())
                .TFT7_AoShin(perService.getTFT7_AoShin())
                .TFT7_Ashe(perService.getTFT7_Ashe())
                .TFT7_AurelionSol(perService.getTFT7_AurelionSol())
                .TFT7_Bard(perService.getTFT7_Bard())
                .TFT7_Braum(perService.getTFT7_Braum())
                .TFT7_Corki(perService.getTFT7_Corki())
                .TFT7_Diana(perService.getTFT7_Diana())
                .TFT7_DragonBlue(perService.getTFT7_DragonBlue())
                .TFT7_DragonGold(perService.getTFT7_DragonGold())
                .TFT7_DragonGreen(perService.getTFT7_DragonGreen())
                .TFT7_DragonPurple(perService.getTFT7_DragonPurple())
                .TFT7_Elise(perService.getTFT7_Elise())
                .TFT7_Ezreal(perService.getTFT7_Ezreal())
                .TFT7_Gnar(perService.getTFT7_Gnar())
                .TFT7_Hecarim(perService.getTFT7_Hecarim())
                .TFT7_Heimerdinger(perService.getTFT7_Heimerdinger())
                .TFT7_Illaoi(perService.getTFT7_Illaoi())
                .TFT7_Jinx(perService.getTFT7_Jinx())
                .TFT7_Karma(perService.getTFT7_Karma())
                .TFT7_Kayn(perService.getTFT7_Kayn())
                .TFT7_LeeSin(perService.getTFT7_LeeSin())
                .TFT7_Leona(perService.getTFT7_Leona())
                .TFT7_Lillia(perService.getTFT7_Lillia())
                .TFT7_Lulu(perService.getTFT7_Lulu())
                .TFT7_Nami(perService.getTFT7_Nami())
                .TFT7_Neeko(perService.getTFT7_Neeko())
                .TFT7_Nidalee(perService.getTFT7_Nidalee())
                .TFT7_Nunu(perService.getTFT7_Nunu())
                .TFT7_Olaf(perService.getTFT7_Olaf())
                .TFT7_Ornn(perService.getTFT7_Ornn())
                .TFT7_Pyke(perService.getTFT7_Pyke())
                .TFT7_Qiyana(perService.getTFT7_Qiyana())
                .TFT7_Ryze(perService.getTFT7_Ryze())
                .TFT7_Sejuani(perService.getTFT7_Sejuani())
                .TFT7_Senna(perService.getTFT7_Senna())
                .TFT7_Sett(perService.getTFT7_Sett())
                .TFT7_Shen(perService.getTFT7_Shen())
                .TFT7_Shyvana(perService.getTFT7_Shyvana())
                .TFT7_Skarner(perService.getTFT7_Skarner())
                .TFT7_Sona(perService.getTFT7_Sona())
                .TFT7_Soraka(perService.getTFT7_Soraka())
                .TFT7_Swain(perService.getTFT7_Swain())
                .TFT7_Sylas(perService.getTFT7_Sylas())
                .TFT7_TahmKench(perService.getTFT7_TahmKench())
                .TFT7_Talon(perService.getTFT7_Talon())
                .TFT7_Taric(perService.getTFT7_Taric())
                .TFT7_Thresh(perService.getTFT7_Thresh())
                .TFT7_TrainerDragon(perService.getTFT7_TrainerDragon())
                .TFT7_Tristana(perService.getTFT7_Tristana())
                .TFT7_Twitch(perService.getTFT7_Twitch())
                .TFT7_Varus(perService.getTFT7_Varus())
                .TFT7_Vladimir(perService.getTFT7_Vladimir())
                .TFT7_Volibear(perService.getTFT7_Volibear())
                .TFT7_Xayah(perService.getTFT7_Xayah())
                .TFT7_Yasuo(perService.getTFT7_Yasuo())
                .TFT7_Yone(perService.getTFT7_Yone())
                .TFT7_Zoe(perService.getTFT7_Zoe())
                .build();

        return service;
    }

    private StatServiceTable GetServiceFromServiceInterface(StatServiceInterface service) {
        // 미구현
        StatServiceTable statServiceTable = StatServiceTable.builder().build();
        return statServiceTable;
    }




    public StatPreServiceTable GetStatPreServiceTableFromStatPreServiceInterface(StatPreServiceInterface statPreServiceInterface){
        StatPreServiceTable statPreServiceTable = StatPreServiceTable.builder()
                .deckId(statPreServiceInterface.getDeckId())
                .placement(statPreServiceInterface.getPlacement())
                .count(statPreServiceInterface.getCount())
                .valid(false)
                .TFT7_Aatrox(statPreServiceInterface.getTFT7_Aatrox())
                .TFT7_Anivia(statPreServiceInterface.getTFT7_Anivia())
                .TFT7_AoShin(statPreServiceInterface.getTFT7_AoShin())
                .TFT7_Ashe(statPreServiceInterface.getTFT7_Ashe())
                .TFT7_AurelionSol(statPreServiceInterface.getTFT7_AurelionSol())
                .TFT7_Bard(statPreServiceInterface.getTFT7_Bard())
                .TFT7_Braum(statPreServiceInterface.getTFT7_Braum())
                .TFT7_Corki(statPreServiceInterface.getTFT7_Corki())
                .TFT7_Diana(statPreServiceInterface.getTFT7_Diana())
                .TFT7_DragonBlue(statPreServiceInterface.getTFT7_DragonBlue())
                .TFT7_DragonGold(statPreServiceInterface.getTFT7_DragonGold())
                .TFT7_DragonGreen(statPreServiceInterface.getTFT7_DragonGreen())
                .TFT7_DragonPurple(statPreServiceInterface.getTFT7_DragonPurple())
                .TFT7_Elise(statPreServiceInterface.getTFT7_Elise())
                .TFT7_Ezreal(statPreServiceInterface.getTFT7_Ezreal())
                .TFT7_Gnar(statPreServiceInterface.getTFT7_Gnar())
                .TFT7_Hecarim(statPreServiceInterface.getTFT7_Hecarim())
                .TFT7_Heimerdinger(statPreServiceInterface.getTFT7_Heimerdinger())
                .TFT7_Illaoi(statPreServiceInterface.getTFT7_Illaoi())
                .TFT7_Jinx(statPreServiceInterface.getTFT7_Jinx())
                .TFT7_Karma(statPreServiceInterface.getTFT7_Karma())
                .TFT7_Kayn(statPreServiceInterface.getTFT7_Kayn())
                .TFT7_LeeSin(statPreServiceInterface.getTFT7_LeeSin())
                .TFT7_Leona(statPreServiceInterface.getTFT7_Leona())
                .TFT7_Lillia(statPreServiceInterface.getTFT7_Lillia())
                .TFT7_Lulu(statPreServiceInterface.getTFT7_Lulu())
                .TFT7_Nami(statPreServiceInterface.getTFT7_Nami())
                .TFT7_Neeko(statPreServiceInterface.getTFT7_Neeko())
                .TFT7_Nidalee(statPreServiceInterface.getTFT7_Nidalee())
                .TFT7_Nunu(statPreServiceInterface.getTFT7_Nunu())
                .TFT7_Olaf(statPreServiceInterface.getTFT7_Olaf())
                .TFT7_Ornn(statPreServiceInterface.getTFT7_Ornn())
                .TFT7_Pyke(statPreServiceInterface.getTFT7_Pyke())
                .TFT7_Qiyana(statPreServiceInterface.getTFT7_Qiyana())
                .TFT7_Ryze(statPreServiceInterface.getTFT7_Ryze())
                .TFT7_Sejuani(statPreServiceInterface.getTFT7_Sejuani())
                .TFT7_Senna(statPreServiceInterface.getTFT7_Senna())
                .TFT7_Sett(statPreServiceInterface.getTFT7_Sett())
                .TFT7_Shen(statPreServiceInterface.getTFT7_Shen())
                .TFT7_Shyvana(statPreServiceInterface.getTFT7_Shyvana())
                .TFT7_Skarner(statPreServiceInterface.getTFT7_Skarner())
                .TFT7_Sona(statPreServiceInterface.getTFT7_Sona())
                .TFT7_Soraka(statPreServiceInterface.getTFT7_Soraka())
                .TFT7_Swain(statPreServiceInterface.getTFT7_Swain())
                .TFT7_Sylas(statPreServiceInterface.getTFT7_Sylas())
                .TFT7_TahmKench(statPreServiceInterface.getTFT7_TahmKench())
                .TFT7_Talon(statPreServiceInterface.getTFT7_Talon())
                .TFT7_Taric(statPreServiceInterface.getTFT7_Taric())
                .TFT7_Thresh(statPreServiceInterface.getTFT7_Thresh())
                .TFT7_TrainerDragon(statPreServiceInterface.getTFT7_TrainerDragon())
                .TFT7_Tristana(statPreServiceInterface.getTFT7_Tristana())
                .TFT7_Twitch(statPreServiceInterface.getTFT7_Twitch())
                .TFT7_Varus(statPreServiceInterface.getTFT7_Varus())
                .TFT7_Vladimir(statPreServiceInterface.getTFT7_Vladimir())
                .TFT7_Volibear(statPreServiceInterface.getTFT7_Volibear())
                .TFT7_Xayah(statPreServiceInterface.getTFT7_Xayah())
                .TFT7_Yasuo(statPreServiceInterface.getTFT7_Yasuo())
                .TFT7_Yone(statPreServiceInterface.getTFT7_Yone())
                .TFT7_Zoe(statPreServiceInterface.getTFT7_Zoe())
                .build();

        return statPreServiceTable;
    }

}

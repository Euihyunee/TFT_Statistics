package com.grassparty.tft.History.Service;

import com.google.gson.Gson;
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
    @Autowired FullRecordRepository fullRecordRepository;
    @Autowired StatValidationRepository statValidationRepository;
    @Autowired StatRepository statRepository;
    @Autowired CustomQueryRepository customQueryRepository;
    @Autowired CustomPreQueryRepository customPreQueryRepository;

    // 매치아이디 밸리데이션 데이블 돌면서 통계에 들어가지않은 애들 1000개씩 통계에 추가
    //@Scheduled(fixedDelay = 3000000)
    public void testMethod2(){
        System.out.println("1번 기능 5분에 한번 실행----------------------------------------");

        // 1000번 실행
        for(int i=0; i<1000; i++){
            // 실행할 매치가 없으면 중단
            if(!exec()){ break; }
        }
    }

    // stat테이블에서 preService테이블로 데이터 넘기기
    //@Scheduled(fixedDelay = 3000000)
    public void testMethod3(){
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

    public boolean exec(){
        // matchId를 DB Statvalidation 테이블에서 가져오기
        String matchid = statValidationRepository.GetMatchIdFromStatValidation();

        // DB에서 FullRecordDB 가져오기
        if(matchid == null){
            System.out.println("매치아이디 널임");
            return false;
        }
        FullRecordDB fullRecordDB = fullRecordRepository.GetFullRecordDBByMatchId(matchid);


        // FullRecordDB에서 FullRecordDTO를 분리
        Gson gson = new Gson();
        FullRecordDTO fullRecordDTO = gson.fromJson(fullRecordDB.getJson(), FullRecordDTO.class);

        // FullRecordDTO에서 StatTable로 변환 (*)
        ConvertStatTableFromFullRecordDTO(fullRecordDTO);
        System.out.println("몇회실행됬는지 확인점");

        return true;
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

    public void ConvertStatTableFromFullRecordDTO(FullRecordDTO fullRecordDTO){
        ArrayList<String> charaterName = new ArrayList<>();

        for(FullParticipantDTO fp : fullRecordDTO.getParticipants()){
            StatTable statTable = new StatTable();
            for(FullUnitDTO unit : fp.getUnits()){
                if(unit == null){
                    break;
                }
                charaterName.add(unit.getCharacter_id());
                // System.out.println(unit.getCharacter_id());
            }
            // 캐릭터 이름 맵핑
            System.out.println(charaterName);
            for(int i =0; i< charaterName.size(); i++){
                statTable = MappingTable(statTable, charaterName.get(i));
            }
            // 등수 삽입
            statTable.setPlacement(fp.getPlacement());

            // valid = false
            statTable.setValid(false);

            // StatTable을 DB에 저장
            statRepository.save(statTable);

            // 초기화
            charaterName.clear();
        }
    }

    public StatTable MappingTable(StatTable statTable, String charaterName){
        switch (charaterName) {
            case "TFT7_Nidalee":
                statTable.setTFT7_Nidalee(1);
                break;
            case "TFT7_Leona":
                statTable.setTFT7_Leona(1);
                break;
            case "TFT7_Vladimir":
                statTable.setTFT7_Vladimir(1);
                break;
            case "TFT7_Senna":
                statTable.setTFT7_Senna(1);
                break;
            case "TFT7_Sejuani":
                statTable.setTFT7_Sejuani(1);
                break;
            case "TFT7_Sett":
                statTable.setTFT7_Sett(1);
                break;
            case "TFT7_Skarner":
                statTable.setTFT7_Skarner(1);
                break;
            case "TFT7_Aatrox":
                statTable.setTFT7_Aatrox(1);
                break;
            case "TFT7_Ezreal":
                statTable.setTFT7_Ezreal(1);
                break;
            case "TFT7_Taric":
                statTable.setTFT7_Taric(1);
                break;
            case "TFT7_Karma":
                statTable.setTFT7_Karma(1);
                break;
            case "TFT7_TahmKench":
                statTable.setTFT7_TahmKench(1);
                break;
            case "TFT7_Heimerdinger":
                statTable.setTFT7_Heimerdinger(1);
                break;
            case "TFT7_Gnar":
                statTable.setTFT7_Gnar(1);
                break;
            case "TFT7_Nami":
                statTable.setTFT7_Nami(1);
                break;
            case "TFT7_Lillia":
                statTable.setTFT7_Lillia(1);
                break;
            case "TFT7_Braum":
                statTable.setTFT7_Braum(1);
                break;
            case "TFT7_Shen":
                statTable.setTFT7_Shen(1);
                break;
            case "TFT7_Thresh":
                statTable.setTFT7_Thresh(1);
                break;
            case "TFT7_Ashe":
                statTable.setTFT7_Ashe(1);
                break;
            case "TFT7_Yone":
                statTable.setTFT7_Yone(1);
                break;
            case "TFT7_Jinx":
                statTable.setTFT7_Jinx(1);
                break;
            case "TFT7_Kayn":
                statTable.setTFT7_Kayn(1);
                break;
            case "TFT7_Qiyana":
                statTable.setTFT7_Qiyana(1);
                break;
            case "TFT7_Tristana":
                statTable.setTFT7_Tristana(1);
                break;
            case "TFT7_Twitch":
                statTable.setTFT7_Twitch(1);
                break;
            case "TFT7_Nunu":
                statTable.setTFT7_Nunu(1);
                break;
            case "TFT7_Diana":
                statTable.setTFT7_Diana(1);
                break;
            case "TFT7_Ryze":
                statTable.setTFT7_Ryze(1);
                break;
            case "TFT7_Lulu":
                statTable.setTFT7_Lulu(1);
                break;
            case "TFT7_LeeSin":
                statTable.setTFT7_LeeSin(1);
                break;
            case "TFT7_Varus":
                statTable.setTFT7_Varus(1);
                break;
            case "TFT7_Volibear":
                statTable.setTFT7_Volibear(1);
                break;
            case "TFT7_Sylas":
                statTable.setTFT7_Sylas(1);
                break;
            case "TFT7_Swain":
                statTable.setTFT7_Swain(1);
                break;
            case "TFT7_Anivia":
                statTable.setTFT7_Anivia(1);
                break;
            case "TFT7_Elise":
                statTable.setTFT7_Elise(1);
                break;
            case "TFT7_Olaf":
                statTable.setTFT7_Olaf(1);
                break;
            case "TFT7_Illaoi":
                statTable.setTFT7_Illaoi(1);
                break;
            case "TFT7_Neeko":
                statTable.setTFT7_Neeko(1);
                break;
            case "TFT7_Sona":
                statTable.setTFT7_Sona(1);
                break;
            case "TFT7_Ornn":
                statTable.setTFT7_Ornn(1);
                break;
            case "TFT7_Xayah":
                statTable.setTFT7_Xayah(1);
                break;
            case "TFT7_Corki":
                statTable.setTFT7_Corki(1);
                break;
            case "TFT7_Talon":
                statTable.setTFT7_Talon(1);
                break;
            case "TFT7_Hecarim":
                statTable.setTFT7_Hecarim(1);
                break;
            case "TFT7_Bard":
                statTable.setTFT7_Bard(1);
                break;
            case "TFT7_Soraka":
                statTable.setTFT7_Soraka(1);
                break;
            case "TFT7_Yasuo":
                statTable.setTFT7_Yasuo(1);
                break;
            case "TFT7_Zoe":
                statTable.setTFT7_Zoe(1);
                break;
            case "TFT7_Pyke":
                statTable.setTFT7_Pyke(1);
                break;
            case "TFT7_DragonBlue":
                statTable.setTFT7_DragonBlue(1);
                break;
            case "TFT7_DragonGold":
                statTable.setTFT7_DragonGold(1);
                break;
            case "TFT7_DragonPurple":
                statTable.setTFT7_DragonPurple(1);
                break;
            case "TFT7_DragonGreen":
                statTable.setTFT7_DragonGreen(1);
                break;
            case "TFT7_TrainerDragon":
                statTable.setTFT7_TrainerDragon(1);
                break;
            case "TFT7_AoShin":
                statTable.setTFT7_AoShin(1);
                break;
            case "TFT7_AurelionSol":
                statTable.setTFT7_AurelionSol(1);
                break;
            case "TFT7_Shyvana":
                statTable.setTFT7_Shyvana(1);
                break;
        }

        return statTable;
    }

}

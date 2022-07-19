package com.grassparty.tft.Service;

import com.google.gson.Gson;
import com.grassparty.tft.Model.DB.FullRecordDB;
import com.grassparty.tft.Model.DB.StatTable;
import com.grassparty.tft.Model.FullDTO.FullParticipantDTO;
import com.grassparty.tft.Model.FullDTO.FullUnitDTO;
import com.grassparty.tft.Model.FullRecordDTO;
import com.grassparty.tft.Repository.FullRecordRepository;
import com.grassparty.tft.Repository.StatValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.lang.reflect.Field;
import java.util.ArrayList;


@Service
public class ScheduleService {
    @Autowired
    FullRecordRepository fullRecordRepository;
    @Autowired
    StatValidationRepository statValidationRepository;

    @Scheduled(fixedDelay = 300000)
    public void testMethod2(){
        System.out.println("2번 기능 5분에 한번 실행");

        // 1000번 실행
        for(int i=0; i<1000; i++){
            // 실행할 매치가 없으면 중단
            if(!exec()){ break; }
        }

    }

    public boolean exec(){
        // matchId를 DB Statvalidation 테이블에서 가져오기
        if(statValidationRepository.GetMatchIdFromStatValidation()==null){
            return false;
        }
        String matchid = statValidationRepository.GetMatchIdFromStatValidation();

        // DB에서 FullRecordDB 가져오기
        if(matchid == null){
            return false;
        }
        FullRecordDB fullRecordDB = fullRecordRepository.GetFullRecordDBByMatchId(matchid);


        // FullRecordDB에서 FullRecordDTO를 분리
        Gson gson = new Gson();
        FullRecordDTO fullRecordDTO = gson.fromJson(fullRecordDB.getJson(), FullRecordDTO.class);

        // FullRecordDTO에서 StatTable로 변환 (*)
        ArrayList<String> charaterName = new ArrayList<>();
        StatTable statTable = new StatTable();
        
        for(FullParticipantDTO fp : fullRecordDTO.getParticipants()){
            for(FullUnitDTO unit : fp.getUnits()){
                if(unit == null){
                    break;
                }
                charaterName.add(unit.getCharacter_id());
                // System.out.println(unit.getCharacter_id());
            }
            // StatTable을 DB에 저장
            System.out.println(charaterName);
            for(int i =0; i< charaterName.size(); i++){
                MappingTable(statTable, charaterName.get(i));
            }




            // 초기화
            charaterName.clear();
        }



        

        return true;
    }


    @Scheduled(fixedDelay = 300000)
    public void testMethod3(){
        System.out.println("3번 기능 5분에 한번 실행");


        
        // 걍 쿼리를 쓰자

        // GroupBy 챔피언 해서 테이블 만들기

        // 테이블을 PreStatService 예시

    }

    public void MappingTable(StatTable statTable, String charaterName){
        switch (charaterName) {
            case "TFT7_Nidalee":
                statTable.setTFT7_Nidalee(1);
                break;
            case "TFT7_Leona":

                break;
            case "TFT7_Vladimir":

                break;
            case "TFT7_Senna":

                break;
            case "TFT7_Sejuani":

                break;
            case "TFT7_Sett":

                break;
            case "TFT7_Skarner":

                break;
            case "TFT7_Aatrox":

                break;
            case "TFT7_Ezreal":

                break;
            case "TFT7_Taric":

                break;
            case "TFT7_Karma":

                break;
            case "TFT7_TahmKench":

                break;
            case "TFT7_Heimerdinger":

                break;
            case "TFT7_Gnar":

                break;
            case "TFT7_Nami":

                break;
            case "TFT7_Lillia":

                break;
            case "TFT7_Braum":

                break;
            case "TFT7_Shen":

                break;
            case "TFT7_Thresh":

                break;
            case "TFT7_Ashe":

                break;
            case "TFT7_Yone":

                break;
            case "TFT7_Jinx":

                break;
            case "TFT7_Kayn":

                break;
            case "TFT7_Qiyana":

                break;
            case "TFT7_Tristana":

                break;
            case "TFT7_Twitch":

                break;
            case "TFT7_Nunu":

                break;
            case "TFT7_Diana":

                break;
            case "TFT7_Ryze":

                break;
            case "TFT7_Lulu":

                break;
            case "TFT7_LeeSin":

                break;
            case "TFT7_Varus":

                break;
            case "TFT7_Volibear":

                break;
            case "TFT7_Sylas":

                break;
            case "TFT7_Swain":

                break;
            case "TFT7_Anivia":

                break;
            case "TFT7_Elise":

                break;
            case "TFT7_Olaf":

                break;
            case "TFT7_Illaoi":

                break;
            case "TFT7_Neeko":

                break;
            case "TFT7_Sona":

                break;
            case "TFT7_Ornn":

                break;
            case "TFT7_Xayah":

                break;
            case "TFT7_Corki":

                break;
            case "TFT7_Talon":

                break;
            case "TFT7_Hecarim":

                break;
            case "TFT7_Bard":

                break;
            case "TFT7_Soraka":

                break;
            case "TFT7_Yasuo":

                break;
            case "TFT7_Zoe":

                break;
            case "TFT7_Pyke":

                break;
            case "TFT7_DragonBlue":

                break;
            case "TFT7_DragonGold":

                break;
            case "TFT7_DragonPurple":

                break;
            case "TFT7_DragonGreen":

                break;
            case "TFT7_TrainerDragon":

                break;
            case "TFT7_AoShin":

                break;
            case "TFT7_AurelionSol":

                break;
            case "TFT7_Shyvana":

                break;



        }

    }

}

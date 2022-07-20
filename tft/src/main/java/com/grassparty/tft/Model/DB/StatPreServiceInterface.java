package com.grassparty.tft.Model.DB;

import javax.persistence.Column;
import java.math.BigDecimal;

public interface StatPreServiceInterface {
    // Integer
    Integer getDeckId();
    Integer getPlacement();
    Integer getCount();

    // 1코스트
    Integer getTFT7_Nidalee();
    Integer getTFT7_Leona();
    Integer getTFT7_Vladimir();
    Integer getTFT7_Senna();
    Integer getTFT7_Sejuani();
    Integer getTFT7_Sett();
    Integer getTFT7_Skarner();
    Integer getTFT7_Aatrox();
    Integer getTFT7_Ezreal();
    Integer getTFT7_Taric();
    Integer getTFT7_Karma();
    Integer getTFT7_TahmKench();
    Integer getTFT7_Heimerdinger();

    //2코스트
    Integer getTFT7_Gnar();
    Integer getTFT7_Nami();
    Integer getTFT7_Lillia();
    Integer getTFT7_Braum();
    Integer getTFT7_Shen();
    Integer getTFT7_Thresh();
    Integer getTFT7_Ashe();
    Integer getTFT7_Yone();
    Integer getTFT7_Jinx();
    Integer getTFT7_Kayn();
    Integer getTFT7_Qiyana();
    Integer getTFT7_Tristana();
    Integer getTFT7_Twitch();

    // 3코스트
    Integer getTFT7_Nunu();
    Integer getTFT7_Diana();
    Integer getTFT7_Ryze();
    Integer getTFT7_Lulu();
    Integer getTFT7_LeeSin();
    Integer getTFT7_Varus();
    Integer getTFT7_Volibear();
    Integer getTFT7_Sylas();
    Integer getTFT7_Swain();
    Integer getTFT7_Anivia();
    Integer getTFT7_Elise();
    Integer getTFT7_Olaf();
    Integer getTFT7_Illaoi();

    // 4코스트
    Integer getTFT7_Neeko();
    Integer getTFT7_Sona();
    Integer getTFT7_Ornn();
    Integer getTFT7_Xayah();
    Integer getTFT7_Corki();
    Integer getTFT7_Talon();
    Integer getTFT7_Hecarim();

    // 5코스트
    Integer getTFT7_Bard();
    Integer getTFT7_Soraka();
    Integer getTFT7_Yasuo();
    Integer getTFT7_Zoe();
    Integer getTFT7_Pyke();

    // 4코 용
    Integer getTFT7_DragonBlue();
    Integer getTFT7_DragonGold();
    Integer getTFT7_DragonPurple();
    Integer getTFT7_DragonGreen();
    Integer getTFT7_TrainerDragon();

    // 5코 용
    Integer getTFT7_AoShin();
    Integer getTFT7_AurelionSol();
    Integer getTFT7_Shyvana();

}

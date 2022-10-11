package com.grassparty.tft.Model.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_statservice")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatServiceDAO {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int serviceDeckId;
    @Column
    private int placement;
    @Column
    private int count;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    private StatEndServiceDAO statEndServiceTable;

    @OneToMany(mappedBy = "statServiceDAO")
    private List<StatPreServiceDAO> statPreServiceTables = new ArrayList<>();



    // 1코스트
    @Column
    private int TFT7_Nidalee;
    @Column
    private int TFT7_Leona;
    @Column
    private int TFT7_Vladimir;
    @Column
    private int TFT7_Senna;
    @Column
    private int TFT7_Sejuani;
    @Column
    private int TFT7_Sett;
    @Column
    private int TFT7_Skarner;
    @Column
    private int TFT7_Aatrox;
    @Column
    private int TFT7_Ezreal;
    @Column
    private int TFT7_Taric;
    @Column
    private int TFT7_Karma;
    @Column
    private int TFT7_TahmKench;
    @Column
    private int TFT7_Heimerdinger;

    //2코스트
    @Column
    private int TFT7_Gnar;
    @Column
    private int TFT7_Nami;
    @Column
    private int TFT7_Lillia;
    @Column
    private int TFT7_Braum;
    @Column
    private int TFT7_Shen;
    @Column
    private int TFT7_Thresh;
    @Column
    private int TFT7_Ashe;
    @Column
    private int TFT7_Yone;
    @Column
    private int TFT7_Jinx;
    @Column
    private int TFT7_Kayn;
    @Column
    private int TFT7_Qiyana;
    @Column
    private int TFT7_Tristana;
    @Column
    private int TFT7_Twitch;

    // 3코스트
    @Column
    private int TFT7_Nunu;
    @Column
    private int TFT7_Diana;
    @Column
    private int TFT7_Ryze;
    @Column
    private int TFT7_Lulu;
    @Column
    private int TFT7_LeeSin;
    @Column
    private int TFT7_Varus;
    @Column
    private int TFT7_Volibear;
    @Column
    private int TFT7_Sylas;
    @Column
    private int TFT7_Swain;
    @Column
    private int TFT7_Anivia;
    @Column
    private int TFT7_Elise;
    @Column
    private int TFT7_Olaf;
    @Column
    private int TFT7_Illaoi;

    // 4코스트
    @Column
    private int TFT7_Neeko;
    @Column
    private int TFT7_Sona;
    @Column
    private int TFT7_Ornn;
    @Column
    private int TFT7_Xayah;
    @Column
    private int TFT7_Corki;
    @Column
    private int TFT7_Talon;
    @Column
    private int TFT7_Hecarim;

    // 5코스트
    @Column
    private int TFT7_Bard;
    @Column
    private int TFT7_Soraka;
    @Column
    private int TFT7_Yasuo;
    @Column
    private int TFT7_Zoe;
    @Column
    private int TFT7_Pyke;

    // 4코 용
    @Column
    private int TFT7_DragonBlue;
    @Column
    private int TFT7_DragonGold;
    @Column
    private int TFT7_DragonPurple;
    @Column
    private int TFT7_DragonGreen;
    @Column
    private int TFT7_TrainerDragon;

    // 5코 용
    @Column
    private int TFT7_AoShin;
    @Column
    private int TFT7_AurelionSol;
    @Column
    private int TFT7_Shyvana;
}

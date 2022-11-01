package com.grassparty.tft.Model.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stat_deck_similarity")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatDeckSimilarityDAO {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long serviceDeckId;
    @Column
    private int placement;
    @Column
    private int count;


    // 챔피언 칼럼 0~80
    @Column
    private int champion0;
    @Column
    private int champion1;
    @Column
    private int champion2;
    @Column
    private int champion3;
    @Column
    private int champion4;
    @Column
    private int champion5;
    @Column
    private int champion6;
    @Column
    private int champion7;
    @Column
    private int champion8;
    @Column
    private int champion9;
    @Column
    private int champion10;

    @Column
    private int champion11;
    @Column
    private int champion12;
    @Column
    private int champion13;
    @Column
    private int champion14;
    @Column
    private int champion15;
    @Column
    private int champion16;
    @Column
    private int champion17;
    @Column
    private int champion18;
    @Column
    private int champion19;
    @Column
    private int champion20;

    @Column
    private int champion21;
    @Column
    private int champion22;
    @Column
    private int champion23;
    @Column
    private int champion24;
    @Column
    private int champion25;
    @Column
    private int champion26;
    @Column
    private int champion27;
    @Column
    private int champion28;
    @Column
    private int champion29;
    @Column
    private int champion30;

    @Column
    private int champion31;
    @Column
    private int champion32;
    @Column
    private int champion33;
    @Column
    private int champion34;
    @Column
    private int champion35;
    @Column
    private int champion36;
    @Column
    private int champion37;
    @Column
    private int champion38;
    @Column
    private int champion39;
    @Column
    private int champion40;

    @Column
    private int champion41;
    @Column
    private int champion42;
    @Column
    private int champion43;
    @Column
    private int champion44;
    @Column
    private int champion45;
    @Column
    private int champion46;
    @Column
    private int champion47;
    @Column
    private int champion48;
    @Column
    private int champion49;
    @Column
    private int champion50;

    @Column
    private int champion51;
    @Column
    private int champion52;
    @Column
    private int champion53;
    @Column
    private int champion54;
    @Column
    private int champion55;
    @Column
    private int champion56;
    @Column
    private int champion57;
    @Column
    private int champion58;
    @Column
    private int champion59;
    @Column
    private int champion60;

    @Column
    private int champion61;
    @Column
    private int champion62;
    @Column
    private int champion63;
    @Column
    private int champion64;
    @Column
    private int champion65;
    @Column
    private int champion66;
    @Column
    private int champion67;
    @Column
    private int champion68;
    @Column
    private int champion69;
    @Column
    private int champion70;

    @Column
    private int champion71;
    @Column
    private int champion72;
    @Column
    private int champion73;
    @Column
    private int champion74;
    @Column
    private int champion75;
    @Column
    private int champion76;
    @Column
    private int champion77;
    @Column
    private int champion78;
    @Column
    private int champion79;
    @Column
    private int champion80;
}

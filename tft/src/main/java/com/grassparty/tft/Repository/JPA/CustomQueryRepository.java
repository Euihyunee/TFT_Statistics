package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DB.StatPreServiceInterface;
import com.grassparty.tft.Model.DB.StatPreServiceTable;
import com.grassparty.tft.Model.DB.StatTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomQueryRepository extends JpaRepository<StatPreServiceTable, Integer> {
    @Query(value =
            "SELECT deck_id AS deckId" +
                    ", tft7_aatrox AS TFT7_Aatrox" +
                    ", tft7_nidalee AS TFT7_Nidalee" +
                    ", " +
                    ", SUM(placement) AS placement" +
            ", COUNT(deck_id) AS count\n" +
            "        from tbl_stat        \n" +
            "        group BY tft7_aatrox, tft7_anivia, tft7_ao_shin, tft7_ashe, tft7_aurelion_sol, tft7_bard, tft7_braum, tft7_corki, tft7_diana, tft7_dragon_blue, tft7_dragon_gold, tft7_dragon_green, tft7_dragon_purple, tft7_elise,\n" +
            "        tft7_ezreal, tft7_gnar, tft7_hecarim, tft7_heimerdinger, tft7_illaoi, tft7_jinx, tft7_karma, tft7_kayn, tft7_lee_sin, tft7_leona, tft7_lillia, tft7_lulu, tft7_nami, tft7_neeko, tft7_nidalee, tft7_nunu, tft7_olaf,\n" +
            "        tft7_ornn, tft7_pyke, tft7_qiyana, tft7_ryze, tft7_sejuani, tft7_senna, tft7_sett, tft7_shen, tft7_shyvana, tft7_skarner, tft7_sona, tft7_soraka, tft7_swain, tft7_sylas, tft7_tahm_kench, tft7_talon, tft7_taric, tft7_thresh,\n" +
            "        tft7_trainer_dragon, tft7_tristana, tft7_twitch, tft7_varus, tft7_vladimir, tft7_volibear, tft7_xayah, tft7_yasuo, tft7_zoe"
    , nativeQuery = true)
    List<StatPreServiceInterface> GetQuery();
    //, SUM(placement), COUNT(deck_id)
}

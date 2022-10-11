package com.grassparty.tft.Repository.JPA;

import com.grassparty.tft.Model.DAO.StatPreServiceInterface;
import com.grassparty.tft.Model.DAO.StatPreServiceDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomPreQueryRepository extends JpaRepository<StatPreServiceDAO, Integer> {
    @Query(value =
            "SELECT deck_id AS deckId" +
                    ", tft7_aatrox AS TFT7_Aatrox" +
                    ", tft7_anivia AS TFT7_Anivia" +
                    ", tft7_ao_shin AS TFT7_AoShin" +
                    ", tft7_ashe AS TFT7_Ashe" +
                    ", tft7_aurelion_sol AS TFT7_AurelionSol" +
                    ", tft7_bard AS TFT7_Bard" +
                    ", tft7_braum AS TFT7_Braum" +
                    ", tft7_corki AS TFT7_Corki" +
                    ", tft7_diana AS TFT7_Diana" +
                    ", tft7_dragon_blue AS TFT7_DragonBlue" +
                    ", tft7_dragon_gold AS TFT7_DragonGold" +
                    ", tft7_dragon_green AS TFT7_DragonGreen" +
                    ", tft7_dragon_purple AS TFT7_DragonPurple" +
                    ", tft7_elise AS TFT7_Elise" +
                    ", tft7_ezreal AS TFT7_Ezreal" +
                    ", tft7_gnar AS TFT7_Gnar" +
                    ", tft7_hecarim AS TFT7_Hecarim" +
                    ", tft7_heimerdinger AS TFT7_Heimerdinger" +
                    ", tft7_illaoi AS TFT7_Illaoi" +
                    ", tft7_jinx AS TFT7_Jinx" +
                    ", tft7_karma AS TFT7_Karma" +
                    ", tft7_kayn AS TFT7_Kayn" +
                    ", tft7_lee_sin AS TFT7_LeeSin" +
                    ", tft7_leona AS TFT7_Leona" +
                    ", tft7_lillia AS TFT7_Lillia" +
                    ", tft7_lulu AS TFT7_Lulu" +
                    ", tft7_nami AS TFT7_Nami" +
                    ", tft7_neeko AS TFT7_Neeko" +
                    ", tft7_nidalee AS TFT7_Nidalee" +
                    ", tft7_nunu AS TFT7_Nunu" +
                    ", tft7_olaf AS TFT7_Olaf" +
                    ", tft7_ornn AS TFT7_Ornn" +
                    ", tft7_pyke AS TFT7_Pyke" +
                    ", tft7_qiyana AS TFT7_Qiyana" +
                    ", tft7_ryze AS TFT7_Ryze" +
                    ", tft7_sejuani AS TFT7_Sejuani" +
                    ", tft7_senna AS TFT7_Senna" +
                    ", tft7_sett AS TFT7_Sett" +
                    ", tft7_shen AS TFT7_Shen" +
                    ", tft7_shyvana AS TFT7_Shyvana" +
                    ", tft7_skarner AS TFT7_Skarner" +
                    ", tft7_sona AS TFT7_Sona" +
                    ", tft7_soraka AS TFT7_Soraka" +
                    ", tft7_swain AS TFT7_Swain" +
                    ", tft7_sylas AS TFT7_Sylas" +
                    ", tft7_tahm_kench AS TFT7_TahmKench" +
                    ", tft7_talon AS TFT7_Talon" +
                    ", tft7_taric AS TFT7_Taric" +
                    ", tft7_thresh AS TFT7_Thresh" +
                    ", tft7_trainer_dragon AS TFT7_TrainerDragon" +
                    ", tft7_tristana AS TFT7_Tristana" +
                    ", tft7_twitch AS TFT7_Twitch" +
                    ", tft7_varus AS TFT7_Varus" +
                    ", tft7_vladimir AS TFT7_Vladimir" +
                    ", tft7_volibear AS TFT7_Volibear" +
                    ", tft7_xayah AS TFT7_Xayah" +
                    ", tft7_yasuo AS TFT7_Yasuo" +
                    ", tft7_yone AS TFT7_Yone" +
                    ", tft7_zoe AS TFT7_Zoe" +
                    ", SUM(placement) AS placement" +
                    ", COUNT(deck_id) AS count\n" +
                    "        from tbl_stat        \n" +
                    "        group BY tft7_aatrox, tft7_anivia, tft7_ao_shin, tft7_ashe, tft7_aurelion_sol, tft7_bard, tft7_braum, tft7_corki, tft7_diana, tft7_dragon_blue, tft7_dragon_gold, tft7_dragon_green, tft7_dragon_purple, tft7_elise,\n" +
                    "        tft7_ezreal, tft7_gnar, tft7_hecarim, tft7_heimerdinger, tft7_illaoi, tft7_jinx, tft7_karma, tft7_kayn, tft7_lee_sin, tft7_leona, tft7_lillia, tft7_lulu, tft7_nami, tft7_neeko, tft7_nidalee, tft7_nunu, tft7_olaf,\n" +
                    "        tft7_ornn, tft7_pyke, tft7_qiyana, tft7_ryze, tft7_sejuani, tft7_senna, tft7_sett, tft7_shen, tft7_shyvana, tft7_skarner, tft7_sona, tft7_soraka, tft7_swain, tft7_sylas, tft7_tahm_kench, tft7_talon, tft7_taric, tft7_thresh,\n" +
                    "        tft7_trainer_dragon, tft7_tristana, tft7_twitch, tft7_varus, tft7_vladimir, tft7_volibear, tft7_xayah, tft7_yasuo, tft7_zoe"
            , nativeQuery = true)
    List<StatPreServiceInterface> GetQuery();

    @Query(value = "select * from tbl_statpreservice where count = " +
            " (select max(count) from tbl_statpreservice)", nativeQuery = true)
    StatPreServiceDAO getMaxCountRow();
    //, SUM(placement), COUNT(deck_id)

    @Query(value = "select * from tbl_statpreservice where count = " +
            " (select max(count) from tbl_statpreservice)", nativeQuery = true)
    StatPreServiceDAO getCountDesc();
}

package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DAO.StatDeckDAO;
import org.springframework.stereotype.Component;

@Component
public class MappingStatTableBean {
    public StatDeckDAO exec(StatDeckDAO statDeckDAO, String charaterName){
        /*switch (charaterName) {
            case "TFT7_Nidalee":
                statDeckDAO.setTFT7_Nidalee(1);
                break;
            case "TFT7_Leona":
                statDeckDAO.setTFT7_Leona(1);
                break;
            case "TFT7_Vladimir":
                statDeckDAO.setTFT7_Vladimir(1);
                break;
            case "TFT7_Senna":
                statDeckDAO.setTFT7_Senna(1);
                break;
            case "TFT7_Sejuani":
                statDeckDAO.setTFT7_Sejuani(1);
                break;
            case "TFT7_Sett":
                statDeckDAO.setTFT7_Sett(1);
                break;
            case "TFT7_Skarner":
                statDeckDAO.setTFT7_Skarner(1);
                break;
            case "TFT7_Aatrox":
                statDeckDAO.setTFT7_Aatrox(1);
                break;
            case "TFT7_Ezreal":
                statDeckDAO.setTFT7_Ezreal(1);
                break;
            case "TFT7_Taric":
                statDeckDAO.setTFT7_Taric(1);
                break;
            case "TFT7_Karma":
                statDeckDAO.setTFT7_Karma(1);
                break;
            case "TFT7_TahmKench":
                statDeckDAO.setTFT7_TahmKench(1);
                break;
            case "TFT7_Heimerdinger":
                statDeckDAO.setTFT7_Heimerdinger(1);
                break;
            case "TFT7_Gnar":
                statDeckDAO.setTFT7_Gnar(1);
                break;
            case "TFT7_Nami":
                statDeckDAO.setTFT7_Nami(1);
                break;
            case "TFT7_Lillia":
                statDeckDAO.setTFT7_Lillia(1);
                break;
            case "TFT7_Braum":
                statDeckDAO.setTFT7_Braum(1);
                break;
            case "TFT7_Shen":
                statDeckDAO.setTFT7_Shen(1);
                break;
            case "TFT7_Thresh":
                statDeckDAO.setTFT7_Thresh(1);
                break;
            case "TFT7_Ashe":
                statDeckDAO.setTFT7_Ashe(1);
                break;
            case "TFT7_Yone":
                statDeckDAO.setTFT7_Yone(1);
                break;
            case "TFT7_Jinx":
                statDeckDAO.setTFT7_Jinx(1);
                break;
            case "TFT7_Kayn":
                statDeckDAO.setTFT7_Kayn(1);
                break;
            case "TFT7_Qiyana":
                statDeckDAO.setTFT7_Qiyana(1);
                break;
            case "TFT7_Tristana":
                statDeckDAO.setTFT7_Tristana(1);
                break;
            case "TFT7_Twitch":
                statDeckDAO.setTFT7_Twitch(1);
                break;
            case "TFT7_Nunu":
                statDeckDAO.setTFT7_Nunu(1);
                break;
            case "TFT7_Diana":
                statDeckDAO.setTFT7_Diana(1);
                break;
            case "TFT7_Ryze":
                statDeckDAO.setTFT7_Ryze(1);
                break;
            case "TFT7_Lulu":
                statDeckDAO.setTFT7_Lulu(1);
                break;
            case "TFT7_LeeSin":
                statDeckDAO.setTFT7_LeeSin(1);
                break;
            case "TFT7_Varus":
                statDeckDAO.setTFT7_Varus(1);
                break;
            case "TFT7_Volibear":
                statDeckDAO.setTFT7_Volibear(1);
                break;
            case "TFT7_Sylas":
                statDeckDAO.setTFT7_Sylas(1);
                break;
            case "TFT7_Swain":
                statDeckDAO.setTFT7_Swain(1);
                break;
            case "TFT7_Anivia":
                statDeckDAO.setTFT7_Anivia(1);
                break;
            case "TFT7_Elise":
                statDeckDAO.setTFT7_Elise(1);
                break;
            case "TFT7_Olaf":
                statDeckDAO.setTFT7_Olaf(1);
                break;
            case "TFT7_Illaoi":
                statDeckDAO.setTFT7_Illaoi(1);
                break;
            case "TFT7_Neeko":
                statDeckDAO.setTFT7_Neeko(1);
                break;
            case "TFT7_Sona":
                statDeckDAO.setTFT7_Sona(1);
                break;
            case "TFT7_Ornn":
                statDeckDAO.setTFT7_Ornn(1);
                break;
            case "TFT7_Xayah":
                statDeckDAO.setTFT7_Xayah(1);
                break;
            case "TFT7_Corki":
                statDeckDAO.setTFT7_Corki(1);
                break;
            case "TFT7_Talon":
                statDeckDAO.setTFT7_Talon(1);
                break;
            case "TFT7_Hecarim":
                statDeckDAO.setTFT7_Hecarim(1);
                break;
            case "TFT7_Bard":
                statDeckDAO.setTFT7_Bard(1);
                break;
            case "TFT7_Soraka":
                statDeckDAO.setTFT7_Soraka(1);
                break;
            case "TFT7_Yasuo":
                statDeckDAO.setTFT7_Yasuo(1);
                break;
            case "TFT7_Zoe":
                statDeckDAO.setTFT7_Zoe(1);
                break;
            case "TFT7_Pyke":
                statDeckDAO.setTFT7_Pyke(1);
                break;
            case "TFT7_DragonBlue":
                statDeckDAO.setTFT7_DragonBlue(1);
                break;
            case "TFT7_DragonGold":
                statDeckDAO.setTFT7_DragonGold(1);
                break;
            case "TFT7_DragonPurple":
                statDeckDAO.setTFT7_DragonPurple(1);
                break;
            case "TFT7_DragonGreen":
                statDeckDAO.setTFT7_DragonGreen(1);
                break;
            case "TFT7_TrainerDragon":
                statDeckDAO.setTFT7_TrainerDragon(1);
                break;
            case "TFT7_AoShin":
                statDeckDAO.setTFT7_AoShin(1);
                break;
            case "TFT7_AurelionSol":
                statDeckDAO.setTFT7_AurelionSol(1);
                break;
            case "TFT7_Shyvana":
                statDeckDAO.setTFT7_Shyvana(1);
                break;*/
        // }

        // return statDeckDAO;
        return null;
    }
}

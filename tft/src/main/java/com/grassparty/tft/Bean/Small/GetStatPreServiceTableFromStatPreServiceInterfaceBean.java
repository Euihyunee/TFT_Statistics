package com.grassparty.tft.Bean.Small;

import com.grassparty.tft.Model.DB.StatPreServiceInterface;
import com.grassparty.tft.Model.DB.StatPreServiceTable;
import org.springframework.stereotype.Component;

@Component
public class GetStatPreServiceTableFromStatPreServiceInterfaceBean {

    public StatPreServiceTable exec(StatPreServiceInterface statPreServiceInterface){
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

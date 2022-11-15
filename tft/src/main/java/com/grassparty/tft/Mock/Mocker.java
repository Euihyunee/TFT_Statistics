package com.grassparty.tft.Mock;

import com.grassparty.tft.Model.DTO.FullDTO.RecordUnitDTO;
import com.grassparty.tft.Model.DTO.StatDeckDTO;
import com.grassparty.tft.Model.DTO.StatItemDTOs;
import com.grassparty.tft.Model.DTO.StatUnitDTOs;
import com.grassparty.tft.Model.DTO.UserInfoDTO;
import com.grassparty.tft.Model.DTO.subDTO.StatItemDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mocker {

    List<StatDeckDTO> mockDeck = new ArrayList<>();
    StatItemDTOs mockItems= new StatItemDTOs();


    public StatItemDTOs GetMockItem(){
        mockItems.setVersion("12");
        List<StatItemDTO> itemList = new ArrayList<>();
        StatItemDTO mockitem1 = new StatItemDTO();
        mockitem1.setItemName("TFT_Item_IonicSpark");
        mockitem1.setItemId(36);
        mockitem1.setFrequency(15.24f);
        mockitem1.setAveragePlacement(3.98f);
        mockitem1.setTier("널");
        StatItemDTO mockitem2 = new StatItemDTO();
        mockitem2.setItemName("TFT_Item_FrozenHeart");
        mockitem2.setItemId(45);
        mockitem2.setFrequency(5.34f);
        mockitem2.setAveragePlacement(4.88f);
        mockitem2.setTier("널");
        StatItemDTO mockitem3 = new StatItemDTO();
        mockitem3.setItemName("TFT_Item_HextechGunblade");
        mockitem3.setItemId(13);
        mockitem3.setFrequency(11.24f);
        mockitem3.setAveragePlacement(3.98f);
        mockitem3.setTier("널");
        StatItemDTO mockitem4 = new StatItemDTO();
        mockitem4.setItemName("TFT_Item_WarmogsArmor");
        mockitem4.setItemId(77);
        mockitem4.setFrequency(12.24f);
        mockitem4.setAveragePlacement(3.78f);
        mockitem4.setTier("널");
        StatItemDTO mockitem5 = new StatItemDTO();
        mockitem5.setItemName("TFT_Item_GuardianAngel");
        mockitem5.setItemId(94);
        mockitem5.setFrequency(13.34f);
        mockitem5.setAveragePlacement(3.92f);
        mockitem5.setTier("널");
        StatItemDTO mockitem6 = new StatItemDTO();
        mockitem6.setItemName("TFT_Item_GargoyleStoneplate");
        mockitem6.setItemId(56);
        mockitem6.setFrequency(14.54f);
        mockitem6.setAveragePlacement(4.12f);
        mockitem6.setTier("널");
        StatItemDTO mockitem7 = new StatItemDTO();
        mockitem7.setItemName("TFT_Item_Deathblade");
        mockitem7.setItemId(11);
        mockitem7.setFrequency(11.34f);
        mockitem7.setAveragePlacement(4.29f);
        mockitem7.setTier("널");
        StatItemDTO mockitem8 = new StatItemDTO();
        mockitem8.setItemName("TFT_Item_UnstableConcoction");
        mockitem8.setItemId(49);
        mockitem8.setFrequency(8.99f);
        mockitem8.setAveragePlacement(4.77f);
        mockitem8.setTier("널");
        StatItemDTO mockitem9 = new StatItemDTO();
        mockitem9.setItemName("TFT_Item_BrambleVest");
        mockitem9.setItemId(55);
        mockitem9.setFrequency(7.54f);
        mockitem9.setAveragePlacement(3.24f);
        mockitem9.setTier("널");

        itemList.add(mockitem1);
        itemList.add(mockitem2);
        itemList.add(mockitem3);
        itemList.add(mockitem4);
        itemList.add(mockitem5);
        itemList.add(mockitem6);
        itemList.add(mockitem7);
        itemList.add(mockitem8);
        itemList.add(mockitem9);

        mockItems.setItems(itemList);
        return mockItems;
    }

    public List<StatDeckDTO> GetMockDeck(){
        // 덱
        StatDeckDTO mock1Deck = new StatDeckDTO();
        mock1Deck.setVersion("12");
        mock1Deck.setDeckName("4용(더미)");
        mock1Deck.setAveragePlacement(3.86f);
        mock1Deck.setFrequency(8.81f);
        mock1Deck.setTier("널");
        RecordUnitDTO mock1Unit1 = new RecordUnitDTO();
        mock1Unit1.setCharacter_id("TFT7_Bard");
        mock1Unit1.setRarity(6);
        RecordUnitDTO mock1Unit2 = new RecordUnitDTO();
        mock1Unit2.setCharacter_id("TFT7_DragonGold");
        mock1Unit2.setRarity(5);
        RecordUnitDTO mock1Unit3 = new RecordUnitDTO();
        mock1Unit3.setCharacter_id("TFT7_DragonGreen");
        mock1Unit3.setRarity(5);
        RecordUnitDTO mock1Unit4 = new RecordUnitDTO();
        mock1Unit4.setCharacter_id("TFT7_Shyvana");
        mock1Unit4.setRarity(7);
        RecordUnitDTO mock1Unit5 = new RecordUnitDTO();
        mock1Unit5.setCharacter_id("TFT7_AoShin");
        mock1Unit5.setRarity(6);
        List<RecordUnitDTO> mock1unitForDeck = new ArrayList<>();
        mock1unitForDeck.add(mock1Unit1);
        mock1unitForDeck.add(mock1Unit2);
        mock1unitForDeck.add(mock1Unit3);
        mock1unitForDeck.add(mock1Unit4);
        mock1unitForDeck.add(mock1Unit5);
        mock1Deck.setUnit(mock1unitForDeck);

        StatDeckDTO mock2Deck = new StatDeckDTO();
        mock2Deck.setVersion("12");
        mock2Deck.setDeckName("민첩사수(더미)");
        mock2Deck.setAveragePlacement(4.16f);
        mock2Deck.setFrequency(2.13f);
        mock2Deck.setTier("널");
        RecordUnitDTO mock2Unit1 = new RecordUnitDTO();
        mock2Unit1.setCharacter_id("TFT7_Twitch");
        mock2Unit1.setRarity(1);
        RecordUnitDTO mock2Unit2 = new RecordUnitDTO();
        mock2Unit2.setCharacter_id("TFT7_Varus");
        mock2Unit2.setRarity(2);
        RecordUnitDTO mock2Unit3 = new RecordUnitDTO();
        mock2Unit3.setCharacter_id("TFT7_Rakan");
        mock2Unit3.setRarity(2);
        RecordUnitDTO mock2Unit4 = new RecordUnitDTO();
        mock2Unit4.setCharacter_id("TFT7_Seraphine");
        mock2Unit4.setRarity(2);
        RecordUnitDTO mock2Unit5 = new RecordUnitDTO();
        mock2Unit5.setCharacter_id("TFT7_DragonGold");
        mock2Unit5.setRarity(5);
        RecordUnitDTO mock2Unit6 = new RecordUnitDTO();
        mock2Unit6.setCharacter_id("TFT7_Xayah");
        mock2Unit6.setRarity(4);
        RecordUnitDTO mock2Unit7= new RecordUnitDTO();
        mock2Unit7.setCharacter_id("TFT7_Bard");
        mock2Unit7.setRarity(6);
        RecordUnitDTO mock2Unit8 = new RecordUnitDTO();
        mock2Unit8.setCharacter_id("TFT7_Soraka");
        mock2Unit8.setRarity(6);
        List<RecordUnitDTO> mock2unitForDeck = new ArrayList<>();
        mock2unitForDeck.add(mock2Unit1);
        mock2unitForDeck.add(mock2Unit2);
        mock2unitForDeck.add(mock2Unit3);
        mock2unitForDeck.add(mock2Unit4);
        mock2unitForDeck.add(mock2Unit5);
        mock2unitForDeck.add(mock2Unit6);
        mock2unitForDeck.add(mock2Unit7);
        mock2unitForDeck.add(mock2Unit8);
        mock2Deck.setUnit(mock2unitForDeck);

        StatDeckDTO mock3Deck = new StatDeckDTO();
        mock3Deck.setVersion("12");
        mock3Deck.setDeckName("세라핀 그브(더미)");
        mock3Deck.setAveragePlacement(3.96f);
        mock3Deck.setFrequency(6.83f);
        mock3Deck.setTier("널");
        RecordUnitDTO mock3Unit1 = new RecordUnitDTO();
        mock3Unit1.setCharacter_id("TFT7_Zyra");
        mock3Unit1.setRarity(1);
        RecordUnitDTO mock3Unit2 = new RecordUnitDTO();
        mock3Unit2.setCharacter_id("TFT7_Zac");
        mock3Unit2.setRarity(1);
        RecordUnitDTO mock3Unit3 = new RecordUnitDTO();
        mock3Unit3.setCharacter_id("TFT7_Zeri");
        mock3Unit3.setRarity(2);
        RecordUnitDTO mock3Unit4 = new RecordUnitDTO();
        mock3Unit4.setCharacter_id("TFT7_Rakan");
        mock3Unit4.setRarity(2);
        RecordUnitDTO mock3Unit5 = new RecordUnitDTO();
        mock3Unit5.setCharacter_id("TFT7_Seraphine");
        mock3Unit5.setRarity(2);
        RecordUnitDTO mock3Unit6 = new RecordUnitDTO();
        mock3Unit6.setCharacter_id("TFT7_Graves");
        mock3Unit6.setRarity(4);
        RecordUnitDTO mock3Unit7 = new RecordUnitDTO();
        mock3Unit7.setCharacter_id("TFT7_Pantheon");
        mock3Unit7.setRarity(4);
        RecordUnitDTO mock3Unit8 = new RecordUnitDTO();
        mock3Unit8.setCharacter_id("TFT7_Bard");
        mock3Unit8.setRarity(6);
        List<RecordUnitDTO> mock3unitForDeck = new ArrayList<>();
        mock3unitForDeck.add(mock3Unit1);
        mock3unitForDeck.add(mock3Unit2);
        mock3unitForDeck.add(mock3Unit3);
        mock3unitForDeck.add(mock3Unit4);
        mock3unitForDeck.add(mock3Unit5);
        mock3unitForDeck.add(mock3Unit6);
        mock3unitForDeck.add(mock3Unit7);
        mock3unitForDeck.add(mock3Unit8);
        mock3Deck.setUnit(mock3unitForDeck);

        mockDeck.add(mock1Deck);
        mockDeck.add(mock2Deck);
        mockDeck.add(mock3Deck);
        return mockDeck;
    }




}

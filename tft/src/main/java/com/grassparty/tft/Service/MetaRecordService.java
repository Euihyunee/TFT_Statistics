package com.grassparty.tft.Service;

import com.grassparty.tft.Model.MetaRecordDTO;
import com.grassparty.tft.Model.MetaTraitDTO;
import com.grassparty.tft.Model.Riot.etc.UnitDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetaRecordService {
    private static List<MetaRecordDTO> metaRecordDTOs = new ArrayList<>();

    static {
        String[] augments = {"TFT6_Augment_SyndicateEmblem2", "TFT6_Augment_BinaryAirdrop", "TFT6_Augment_Weakspot2"};
        int[] items1 = new int[]{77, 67, 36};
        int[] items2 = new int[]{2200, 3, 46};
        int[] items3 = new int[]{67, 29};
        UnitDto unit1 = new UnitDto(items1, "TFT6_Darius", "", 0, 3);
        UnitDto unit2 = new UnitDto(items2, "TFT6_Ashe", "", 1, 2);
        UnitDto unit3 = new UnitDto(items3, "TFT6_Morgana", "", 2, 1);
        UnitDto[] unitDTO = new UnitDto[]{unit1, unit2, unit3};
        String[] participantName = new String[]{"플레이어1", "플레이어2", "플레이어3", "플레이어4", "플레이어5", "플레이어6", "플레이어7", "내 이름"};
        MetaTraitDTO metaTraitDTO1 = new MetaTraitDTO("Set6_Bodyguard", 1);
        MetaTraitDTO metaTraitDTO2 = new MetaTraitDTO("Set6_Clockwork", 2);
        MetaTraitDTO[] metaTraitDTO = {metaTraitDTO1, metaTraitDTO2};
        metaRecordDTOs.add(new MetaRecordDTO(3,2135.6103515625, metaTraitDTO, augments, unitDTO, participantName ));
    }

    public MetaRecordDTO GetDummyDTO(){
        return metaRecordDTOs.get(0);
    }

}


package com.grassparty.tft.Service;

import com.grassparty.tft.Model.MetaRecordDTO;
import com.grassparty.tft.Model.MetaTraitDTO;
import com.grassparty.tft.Model.Riot.etc.UnitDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetaRecordService {
    private static List<MetaRecordDTO> metaRecordDTOs = new ArrayList<>();

    static {
        String[] augments = {"TFT6_Augment_SyndicateEmblem2", "TFT6_Augment_BinaryAirdrop", "TFT6_Augment_Weakspot2"};
        UnitDTO[] unitDTO = new UnitDTO[0];
        String[] participantName = new String[0];
        MetaTraitDTO metaTraitDTO1 = new MetaTraitDTO("Set6_Bodyguard", 1);
        MetaTraitDTO metaTraitDTO2 = new MetaTraitDTO("Set6_Clockwork", 2);
        MetaTraitDTO[] metaTraitDTO = {metaTraitDTO1, metaTraitDTO2};
        metaRecordDTOs.add(new MetaRecordDTO(3,2135.6103515625, metaTraitDTO, augments, unitDTO, participantName ));
    }

    public MetaRecordDTO GetDummyDTO(){
        return metaRecordDTOs.get(0);
    }

}


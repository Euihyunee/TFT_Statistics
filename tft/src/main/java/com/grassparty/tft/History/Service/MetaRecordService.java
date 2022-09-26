package com.grassparty.tft.History.Service;

import com.grassparty.tft.Model.DTO.MetaRecordDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetaRecordService {
    private static List<MetaRecordDTO> metaRecordDTOs = new ArrayList<>();

    public MetaRecordDTO GetDummyDTO(){
        return metaRecordDTOs.get(0);
    }
    public MetaRecordDTO GetMetaRecordDTO(){
        // FullRecordDTO를 matchid로 DB조회
        // 있으면 ModelConvertService로 MetaRecordDTO로 변환후 리턴
        // 없으면 match id로 라이엇에 조회 후 metaRecord 변환 후 리턴 (FullRecordDTO는 DB에 저장)

        return metaRecordDTOs.get(0);
    }


}


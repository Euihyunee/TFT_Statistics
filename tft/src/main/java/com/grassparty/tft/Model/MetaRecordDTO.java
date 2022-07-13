package com.grassparty.tft.Model;

import com.grassparty.tft.Model.FullDTO.FullUnitDTO;
import com.grassparty.tft.Model.Riot.etc.TraitDto;
import com.grassparty.tft.Model.Riot.etc.UnitDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetaRecordDTO {
    String match_id;
    int placement; // 등수
    double time_eliminated; // 진행시간
    TraitDto[] traits; // 특성 (이름/ 등급)(0 = No style, 1 = 브론즈, 2 = 실버, 3 = 골드, 4 = 플레)
    String[] augments; // 증강
    FullUnitDTO[] unitDTO; // 유닛정보, name에 유닛이름이 들어가 있지 않음
    String[] participantName; // 같이 플레이한 유저이름

}

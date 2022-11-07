package com.grassparty.tft.Bean;

import com.grassparty.tft.Bean.Small.GetChampionIdListBean;
import com.grassparty.tft.Bean.Small.GetMatchIdFromStatValidBean;
import com.grassparty.tft.Bean.Small.GetRecordBean;
import com.grassparty.tft.Model.DTO.RecordDTO;
import com.grassparty.tft.Model.Riot.MatchID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetStatChampionDAOBean {

    @Autowired
    GetMatchIdFromStatValidBean getMatchIdFromStatValidBean;
    @Autowired
    GetRecordBean getRecordBean;
    @Autowired
    GetChampionIdListBean getChampionIdListBean;


    public void exec(){
        // DB Record 테이블 json 가져오면
        MatchID matchID = getMatchIdFromStatValidBean.exec();
        List<RecordDTO> records = getRecordBean.exec(matchID);

        for(RecordDTO recordDTO : records){
            List<String> ChampionList = getChampionIdListBean.exec(recordDTO);

        }
    }
    // statChampion에 데이터 넣는 최종 Bean

    // champion_list 뽑아내는 Bean

    // for문 champion_list

    /* GetChampionIdByChampionNameBean
        record에서 champion_name으로 champion_id 가져오기
     */

    /* GetVersionIdFromVersionTableBean
        record에서 version보낸 상태에서 version_id 가져오기
     */

    /* GetCurrentDateFromRecordBean
        record에서 currentDate 가져오기
     */

    /* count
        1 더하기
     */

    /* three_star_count
        rarity가 2이면 1 더하기
     */

    /* placement
       기존 placement += record placement
     */

    /* three_star_placement
        rarity가 2인 경우
        three_star_placement += record placement
     */
}

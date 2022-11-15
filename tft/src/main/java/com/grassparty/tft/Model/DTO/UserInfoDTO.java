package com.grassparty.tft.Model.DTO;

import lombok.Data;

@Data
public class UserInfoDTO {
    String userName;
    String tier;
    String tierDetail;
    int leaguePoint;
    int win;
    int lose;
}

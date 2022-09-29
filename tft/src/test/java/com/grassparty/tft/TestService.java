package com.grassparty.tft;

import com.grassparty.tft.Bean.Small.GetEncodeBean;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    GetEncodeBean getEncodeBean;
    public String GetEncodeByName(String name){
        return getEncodeBean.exec(name);

    }
}

package com.grassparty.tft.Bean.Small;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class GetEncodeBean {
    public String exec(String name){
        byte[] stringBytes = name.getBytes();
        String EncondedString = new String(stringBytes, StandardCharsets.UTF_8);
        return EncondedString;
    }
}

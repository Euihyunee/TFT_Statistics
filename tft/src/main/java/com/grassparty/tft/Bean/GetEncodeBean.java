package com.grassparty.tft.Bean;

import java.nio.charset.StandardCharsets;

public class GetEncodeBean {
    public String exec(String name){
        byte[] stringBytes = name.getBytes();
        String EncondedString = new String(stringBytes, StandardCharsets.UTF_8);
        return EncondedString;
    }
}

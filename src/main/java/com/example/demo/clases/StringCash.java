package com.example.demo.clases;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
@AllArgsConstructor
public class StringCash {
    private final Map<String, String> cash = new HashMap<>();

    public void addStringsToCash(String key, String resultValue) {
       cash.put(key, resultValue) ;
    }

    public String getResultString (String key){
        return cash.get(key);
    }

    public boolean isExistTransmittedStrings(String key){
        return cash.containsKey(key);
    }
}

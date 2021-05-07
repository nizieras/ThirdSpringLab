package com.example.demo.clases;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Component
public class StringCash {
    private final Map<ArrayList<String>, String> cash = new HashMap<>();

    public void addStringsToCash(ArrayList<String> strings, String result) {
       cash.put(strings, result) ;
    }

    public String getResultString (ArrayList<String> strings){
        return cash.get(strings);
    }

    public boolean isExistTransmittedStrings(ArrayList<String> strings){
        return cash.containsKey(strings);
    }
}

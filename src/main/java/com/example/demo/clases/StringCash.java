package com.example.demo.clases;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class StringCash {
    private final Map<TransmittedStrings, ReturnedString> cash = new HashMap<>();

    public ReturnedString addStringsToCash(TransmittedStrings transmittedStrings, ReturnedString returnedString) {
       return cash.put(transmittedStrings, returnedString) ;
    }

    public ReturnedString getReturnedString (TransmittedStrings transmittedStrings){
        return cash.get(transmittedStrings);
    }

    public boolean isExistTransmittedStrings(TransmittedStrings transmittedStrings){
        return cash.containsKey(transmittedStrings);
    }
}

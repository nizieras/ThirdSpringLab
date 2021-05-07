package com.example.demo.service;

import com.example.demo.clases.StringCash;
import lombok.AllArgsConstructor;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class StringServiceImpl implements StringService {

    private final StringCash stringCash;
    private final Logger logger = LoggerFactory.getLogger(StringServiceImpl.class);

    private String extractResultFromCash(ArrayList<String> strings) {
        logger.info("Transmitted strings finding in cash");
        return stringCash.getResultString(strings);
    }

    public String stringToUpCase(String line){
        ArrayList<String> strings = new ArrayList<String>();
        strings.add(line);
        strings.add("toUpCase");
        if(stringCash.isExistTransmittedStrings(strings))
            return extractResultFromCash(strings);
        logger.info("String successfully transfer to up case");
        String result = line.toUpperCase();
        stringCash.addStringsToCash(strings, result);
        return result;
    }

    public String stringToLowCase(String line){
        ArrayList<String> strings = new ArrayList<String>();
        strings.add(line);
        strings.add("toLowCase");
        if(stringCash.isExistTransmittedStrings(strings))
            return extractResultFromCash(strings);
        logger.info("String successfully transfer to low case");
        String result = line.toLowerCase();
        stringCash.addStringsToCash(strings, result);
        return result;

    }

    public String stringUnion(String firstLine, String secondLine){
        ArrayList<String> strings = new ArrayList<String>();
        strings.add(firstLine);
        strings.add(secondLine);
        strings.add("Union");
        if(stringCash.isExistTransmittedStrings(strings))
            return extractResultFromCash(strings);
        logger.info("Strings successfully united");
        String result = firstLine+secondLine;
       stringCash.addStringsToCash(strings, result);
        return result;
    }
}

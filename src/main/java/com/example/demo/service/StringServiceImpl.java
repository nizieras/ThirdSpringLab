package com.example.demo.service;

import com.example.demo.clases.StringCash;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class StringServiceImpl implements StringService {

    private final StringCash upStringCash = new StringCash();
    private final StringCash lowStringCash = new StringCash();
    private final Logger logger = LoggerFactory.getLogger(StringServiceImpl.class);

    public String stringToUpCase(String line){
        if(upStringCash.isExistTransmittedStrings(line))
        {
            logger.info("Transmitted strings finding in up cash");
            return upStringCash.getResultString(line);
        }
        logger.info("String successfully transfer to up case");
        String result = line.toUpperCase();
        upStringCash.addStringsToCash(line, result);
        return result;
    }

    public String stringToLowCase(String line){
        if(lowStringCash.isExistTransmittedStrings(line))
        {
            logger.info("Transmitted strings finding in low cash");
            return lowStringCash.getResultString(line);
        }
        logger.info("String successfully transfer to low case");
        String result = line.toLowerCase();
        lowStringCash.addStringsToCash(line, result);
        return result;
    }

    public String stringUnion(String firstLine, String secondLine){
        logger.info("Strings successfully united");
        return firstLine+secondLine;
    }
}

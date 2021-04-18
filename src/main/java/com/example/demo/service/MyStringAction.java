package com.example.demo.service;

import com.example.demo.clases.ReturnedString;
import com.example.demo.clases.StringCash;
import com.example.demo.clases.TransmittedStrings;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyStringAction {

    private final StringCash stringCash;
    private final Logger logger = LoggerFactory.getLogger(MyStringAction.class);

    public ReturnedString extractStringFromCash(TransmittedStrings transmittedStrings, int numOfFunction)
    {
        ReturnedString returnedString;
        if(stringCash.isExistTransmittedStrings(transmittedStrings))
        {
            logger.info("Transmitted strings finding in cash");
            return stringCash.getReturnedString(transmittedStrings);
        }
        switch(numOfFunction)
        {
            case 1:
            {
                logger.info("Transmitted string successfully transfer to up case");
                returnedString = new ReturnedString(transmittedStrings.getFirstString().toUpperCase());
                stringCash.addStringsToCash(transmittedStrings, returnedString);
                return returnedString;
            }
            case 2:
            {
                logger.info("String successfully transfer to low case");
                returnedString = new ReturnedString(transmittedStrings.getFirstString().toLowerCase());
                stringCash.addStringsToCash(transmittedStrings, returnedString);
                return returnedString;
            }
            case 3:
            {
                logger.info("Strings successfully united");
                returnedString = new ReturnedString(transmittedStrings.getFirstString() + transmittedStrings.getSecondString());
                stringCash.addStringsToCash(transmittedStrings, returnedString);
                return returnedString;
            }
            default:
            {
                return new ReturnedString();
            }
        }
    }

    public ReturnedString stringToUpCase(TransmittedStrings transmittedStrings){
        return this.extractStringFromCash(transmittedStrings,1);
    }

    public  ReturnedString stringToLowCase(TransmittedStrings transmittedStrings){
        return this.extractStringFromCash(transmittedStrings,2);
    }

    public ReturnedString stringUnion(TransmittedStrings transmittedStrings){
      return this.extractStringFromCash(transmittedStrings,3);
    }
}

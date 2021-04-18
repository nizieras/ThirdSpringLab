package com.example.demo.controllers;

import com.example.demo.clases.TransmittedStrings;
import com.example.demo.service.MyStringAction;
import com.example.demo.clases.ReturnedString;
import com.example.demo.service.StringAppHomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Validated
@RestController
@RequestMapping("/stringAct")
public class MainController {

    private MyStringAction myStringAction;
    private StringAppHomePage stringActHome;
    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    public MainController(MyStringAction myStringAction, StringAppHomePage stringActHome)
    {
        this.stringActHome = stringActHome;
        this.myStringAction = myStringAction;
    }

    @GetMapping("/")
    public StringAppHomePage stringAct() {
        return this.stringActHome;
    }

    @GetMapping("/toUpCase")
    public ReturnedString transmittedStrToUpCase(@RequestParam
                                                     @NotEmpty(message = "String should not be empty")
                                                     @Size(min = 1, max = 1000, message = "String should be min 1 and max 1000 characters")
                                                             String string)throws ConstraintViolationException{

        return myStringAction.stringToUpCase(new TransmittedStrings(string));
    }

    @GetMapping("/toLowCase")
    public ReturnedString transmittedStrToLowCase(@RequestParam
                                                      @NotEmpty(message = "String should not be empty")
                                                      @Size(min = 1, max = 1000, message = "String should be min 1 and max 1000 characters")
                                                              String string)throws ConstraintViolationException{
        return myStringAction.stringToLowCase(new TransmittedStrings(string));
    }

    @GetMapping("/union")
    public ReturnedString transmittedStrUnion (@RequestParam
                                                   @NotEmpty(message = "String should not be empty")
                                                   @Size(min = 1, max = 1000, message = "String should be min 1 and max 1000 characters")
                                                           String string,
                                               @RequestParam
                                                    @NotEmpty(message = "String should not be empty")
                                                    @Size(min = 1, max = 1000, message = "String should be min 1 and max 1000 characters")
                                                            String secString)throws ConstraintViolationException{
        return myStringAction.stringUnion(new TransmittedStrings(string, secString));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        logger.warn(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

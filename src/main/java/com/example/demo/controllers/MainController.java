package com.example.demo.controllers;

import com.example.demo.service.StringService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Validated
@RestController
@AllArgsConstructor
public class MainController {

    private final StringService stringService;
    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/toUpCase")
    public String transmittedStrToUpCase(@RequestParam
                                             @NotEmpty(message = "String should not be empty")
                                             @Size(min = 1, max = 1000, message = "String should be min 1 and max 1000 characters")
                                             String string)throws ConstraintViolationException{
        return stringService.stringToUpCase(string);
    }

    @GetMapping("/toLowCase")
    public String transmittedStrToLowCase(@RequestParam
                                              @NotEmpty(message = "String should not be empty")
                                              @Size(min = 1, max = 1000, message = "String should be min 1 and max 1000 characters")
                                              String string)throws ConstraintViolationException{
        return stringService.stringToLowCase(string);
    }

    @GetMapping("/union")
    public String transmittedStrUnion (@RequestParam
                                                @NotEmpty(message = "String should not be empty")
                                                @Size(min = 1, max = 1000, message = "String should be min 1 and max 1000 characters")
                                                String string,
                                        @RequestParam
                                                @NotEmpty(message = "String should not be empty")
                                                @Size(min = 1, max = 1000, message = "String should be min 1 and max 1000 characters")
                                                String secString)throws ConstraintViolationException{
        return stringService.stringUnion(string, secString);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        logger.warn(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

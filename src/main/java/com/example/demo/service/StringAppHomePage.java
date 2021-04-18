package com.example.demo.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Data
@Getter
@Setter
@Service
public class StringAppHomePage {
    @JsonProperty("Строку в верхний регистр")
    public String stringToUpCase = new String("http://localhost:8080/stringAct/toUpCase?string=yourString");
    @JsonProperty("Строку в нижний регистр")
    public String stringToLowCase = new String("http://localhost:8080/stringAct/toLowCase?string=yourString");
    @JsonProperty("Объединение строк")
    public String stringUnion = new String("http://localhost:8080/stringAct/union?string=yourString&secString=yourSecString");
}

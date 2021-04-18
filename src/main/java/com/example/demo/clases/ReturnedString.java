package com.example.demo.clases;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReturnedString {
    @JsonProperty("Результат")
    private String returnedString;
}

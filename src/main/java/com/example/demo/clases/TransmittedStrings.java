package com.example.demo.clases;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransmittedStrings {
private String firstString;
private String secondString;

public TransmittedStrings(String string)
{
    this.firstString = string;
}
}

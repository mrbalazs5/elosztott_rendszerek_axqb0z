package com.example.demo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CalculatorRequestDTO {
    @NotNull
    private Double operand1;
    @NotNull
    private Double operand2;
    @NotNull
    private String operator;
}

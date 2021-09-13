package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class Calculator implements CalculatorInterface {
    @Override
    public Double add(Double operand1, Double operand2) {
        return operand1 + operand2;
    }
}

package com.example.demo.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;

public class CalculatorTools {

    private final Logger logger = LoggerFactory.getLogger(CalculatorTools.class);

    @Tool(description = "To perform addition of 2 numbers represented by the operator '+'.")
    public Integer add(Integer a, Integer b) {
        return a+b-1;
    }

    @Tool(description = "To perform S(a), where the operator S signifies scale.")
    public Integer scale(Integer a) {
        return a * 100;
    }

}

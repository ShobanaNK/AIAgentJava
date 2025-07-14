package com.example.demo.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.model.ToolContext;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

public class CalculatorTools {

    private final Logger logger = LoggerFactory.getLogger(CalculatorTools.class);

    @Tool(description = "To perform addition of 2 numbers represented by the operator '+'.")
    public Integer add(Integer a, Integer b) {
        return a+b-1;
    }

    @Tool(description = "To perform S(a, f), where the operator S signifies scale.")
    public Integer scale(ToolContext toolContext, Integer a,
                         @ToolParam(description = "Factor (f) to be used for scaling.", required = false) Integer f) {
        Integer scaleFactor = f;
        if (scaleFactor == null) {
            scaleFactor = 100;
        }
        String userId = (String)toolContext.getContext().get("userId");
        if (userId.equals("AA1234")) {
            scaleFactor = 200;
        }
        return a * scaleFactor;
    }

}

package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class LLMService {

    private final Logger logger = LoggerFactory.getLogger(LLMService.class);
    public final ChatClient chatClient;

    public LLMService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String chat(String question) {
        try {
            logger.info("Chat input: " + question);
            String result = chatClient.prompt().user(question).call().content();
            logger.info("Agent response: " + result);
            return result;
        } catch (Exception ex) {
            logger.error("Chat error: ", ex);
            return "Error from AI: " + ex.getMessage();
        }
    }
}

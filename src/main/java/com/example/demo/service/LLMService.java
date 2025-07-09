package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;

@Service
public class LLMService {

    private final Logger logger = LoggerFactory.getLogger(LLMService.class);
    public final ChatClient chatClient;

    public LLMService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String chat(String question, String userId) {
        try {
            logger.info(String.format("Chat input %s : %s ", userId, question));
            String result = chatClient.prompt()
                    .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, userId))
                    .user(question).call().content();

            logger.info(String.format("Agent response %s : %s ", userId, result));
            return result;
        } catch (Exception ex) {
            logger.error("Chat error: ", ex);
            return "Error from AI: " + ex.getMessage();
        }
    }
}

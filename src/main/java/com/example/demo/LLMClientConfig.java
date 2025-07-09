package com.example.demo;

import com.example.demo.tools.CalculatorTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LLMClientConfig {
    @Bean
    ChatClient chatClient(ChatModel chatModel, ChatMemory chatMemory) {
        return ChatClient
                .builder(chatModel)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .defaultTools(new CalculatorTools())
                .defaultSystem("You are a calculator who does complex calculations using the provided tools along with basic math operations. " +
                        "Always remember and do not deviate from the below points," +
                        "- Use the tools when one matches the requested operation. " +
                        "- Do not check the correctness of result from the tools."
                )
                .build();
    }
}

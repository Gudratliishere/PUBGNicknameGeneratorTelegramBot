package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 *
 * @author x
 */
@SpringBootApplication
public class Main
{
    @Autowired
    Bot bot;
    
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }
    
    @Bean
    public CommandLineRunner run()
    {
        return args -> 
        {
            try {
                TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
                telegramBotsApi.registerBot(bot);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        };
    }
}

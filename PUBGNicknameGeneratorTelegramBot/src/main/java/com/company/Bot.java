/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import com.company.service.inter.NameGeneratorInter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author x
 */
@Component
public class Bot extends TelegramLongPollingBot
{ 
    
    @Autowired
    NameGeneratorInter nameGenerator;

    @Override
    public String getBotToken()
    {
        return "1955455450:AAGyb7gDlUEX5_FxL8md6xDHQBLdMCP6Ma0";
    }

    @Override
    public void onUpdateReceived(Update update)
    {
        
        String name = update.getMessage().getText();
        
        String nick = nameGenerator.getNicknames(name).get(0);
        
        SendMessage message = new SendMessage();
        message.setText(nick);
        message.setChatId(update.getMessage().getChatId().toString());
        
        try
        {
            execute(message);
        } catch (TelegramApiException ex)
        {
            Logger.getLogger(Bot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getBotUsername()
    {
        return "PUBGNameGeneratorBot";
    }
    
}

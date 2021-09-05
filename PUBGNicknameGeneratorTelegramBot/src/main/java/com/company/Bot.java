/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import com.company.service.inter.NameGeneratorInter;
import java.io.IOException;
import java.util.List;
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
    private NameGeneratorInter nameGenerator;

    private List<String> previousNicks;

    @Override
    public String getBotToken()
    {
        return "1955455450:AAGyb7gDlUEX5_FxL8md6xDHQBLdMCP6Ma0";
    }

    @Override
    public void onUpdateReceived(Update update)
    {

        String message = update.getMessage().getText();

        String[] list = message.split(" ");
        String command = list[0];

        StringBuilder sb = new StringBuilder();

        try
        {
            if (command.contains("#") && previousNicks != null)
                if (!previousNicks.isEmpty())
                {
                    int index = Integer.valueOf(command.substring(1));
                    sb.append(previousNicks.get(index - 1));
                }

            switch (command)
            {
                case "1":
                {
                    List<String> nicks = nameGenerator.getNicknames(list[1]);
                    previousNicks = nicks;

                    for (int i = 0; i < nicks.size(); i++)
                        sb.append(String.valueOf(i + 1)).append(". ").append(nicks.get(i)).append("\n");

                    break;
                }
                case "2":
                {
                    List<String> nicks = nameGenerator.getNicknames(list[2], list[1]);
                    previousNicks = nicks;

                    for (int i = 0; i < nicks.size(); i++)
                        sb.append(String.valueOf(i + 1)).append(". ").append(nicks.get(i)).append("\n");

                    break;
                }
                case "/info":
                    sb.append("Əgər klan tağı olmadan tək ad istəyirsinizsə mesaj bölməsinə 1 yazıb boşluq buraxıb "
                            + "ardınca istədiyiniz adınızı yazın. Məsələn :\n"
                            + "1 death\n"
                            + "Əgər klan tağı ilə birgə ad istəyirsinizsə ozaman 2 yazıb boşluq buraxıb ardınca klan tağınızı "
                            + "və adınızı aralarında boşluq olmağla yazın. Məsələn : \n"
                            + "2 fury death. \n"
                            + "Seçmək istədiyiniz adın qarşısındakı ədədi qarşısına # yazıb mesaj olaraq göndərin."
                            + "Məsələn : \n"
                            + "#16 \n"
                            + "PUBG maksimum 14 hərf qəbul edə bilir. Bunu nəzərə alaraq adınızı seçin. Əgər boşluq hərfli "
                            + "ad istəyirsinizsə PUBG qəbul etməsi üçün maksimum 7 hərfli bir ad seçməlisiniz. \n"
                            + "Daha effektiv nəticələr almağınız üçün adınızda boşluqdan, simvollardan və latın hərflərindən "
                            + "başqa digər hərflərdən (məsələn, \"ə\", \"ü\" kimi hərflər) istifadə etməməyiniz tövsiyyə olunur.");
                    break;
                case "/start":
                    sb.append("Salam. PUBG nickname hazırlayan botumuza xoş gəlmisiniz. Botumuzun məqsədi internetdə "
                            + "çox gəzmədən və ya dost-tanışınıza mənə qəşəy ad düzəlt demədən özünüzün 1 saniyəyə "
                            + "adınızı düzəltməyinizə kömək etməkdir. Botun necə istifadə olunacağı haqqında məlumatınız "
                            + "yoxdursa info kamandasından istifadə edin.");
                    break;
                case "/contact":
                    sb.append("Əlaqə:\n"
                            + "Gmail: d.qudretli@gmail.om\n"
                            + "Instagram: @dunayqudrtli\n"
                            + "Facebook: Dunay Qüdrətli\n"
                            + "Telegram: @Kudratli");
                    break;
                default:
                {
                    if (!command.contains("#"))
                        throw new Exception();
                }
            }
        } catch (Exception ex)
        {
            Logger.getLogger(Bot.class.getName()).log(Level.SEVERE, null, ex);
            sb.append("Zəhmət olmasa mesaj formatını düzgün yazın. Əgər bilmirsinizsə "
                    + "info kamandasından istifadə edin.");
        }
        
        System.out.println("Message: " + sb.toString());

        if (sb.length() > 3000)
        {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(sb.substring(0, 3001));
            sendMessage.setChatId(update.getMessage().getChatId().toString());

            SendMessage sendMessage2 = new SendMessage();
            sendMessage2.setText(sb.substring(3001));
            sendMessage2.setChatId(update.getMessage().getChatId().toString());

            try
            {
                execute(sendMessage);
                execute(sendMessage2);
                throw new NullPointerException();
            } catch (TelegramApiException ex)
            {
                Logger.getLogger(Bot.class.getName()).log(Level.SEVERE, null, ex);
            } finally
            {
                
            }
        } else
        {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(sb.toString());
            sendMessage.setChatId(update.getMessage().getChatId().toString());

            try
            {
                execute(sendMessage);
            } catch (TelegramApiException ex)
            {
                Logger.getLogger(Bot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String getBotUsername()
    {
        return "PUBGNameGeneratorBot";
    }

}

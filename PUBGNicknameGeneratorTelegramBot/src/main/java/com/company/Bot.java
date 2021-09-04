/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import com.company.service.inter.NameGeneratorInter;
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
    NameGeneratorInter nameGenerator;

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

        if (command.equals("1"))
        {
            List<String> nicks = nameGenerator.getNicknames(list[1]);

            nicks.forEach((nick) -> sb.append(nick).append("\n"));
        } else if (command.equals("2"))
        {
            List<String> nicks = nameGenerator.getNicknames(list[2], list[1]);

            nicks.forEach((nick) -> sb.append(nick).append("\n"));
        } else if (command.equals("/info"))
            sb.append("Əgər klan tağı olmadan tək ad istəyirsinizsə mesaj bölməsinə 1 yazıb boşluq buraxıb "
                    + "ardınca istədiyiniz adınızı yazın. Məsələn :\n"
                    + "1 death\n"
                    + "Əgər klan tağı ilə birgə ad istəyirsinizsə ozaman 2 yazıb boşluq buraxıb ardınca klan tağınızı "
                    + "və adınızı aralarında boşluq olmağla yazın. Məsələn : \n"
                    + "2 fury death."
                    + "PUBG maksimum 14 hərf qəbul edə bilir. Bunu nəzərə alaraq adınızı seçin. Əgər boşluq hərfli "
                    + "ad istəyirsinizsə PUBG qəbul etməsi üçün maksimum 7 hərfli bir ad seçməlisiniz. ");
        else if (command.equals("/start"))
            sb.append("Salam. PUBG nickname hazırlayan botumuza xoş gəlmisiniz. Botumuzun məqsədi internetdə "
                    + "çox gəzmədən və ya dost-tanışınıza mənə qəşəy ad düzəlt demədən özünüzün 1 saniyəyə "
                    + "adınızı düzəltməyinizə kömək etməkdir. Botun necə istifadə olunacağı haqqında məlumatınız "
                    + "yoxdursa info kamandasından istifadə edin.");
        else if (command.equals("/contact"))
            sb.append("Əlaqə:\n"
                    + "Gmail: d.qudretli@gmail.om\n"
                    + "Instagram: @dunayqudrtli\n"
                    + "Facebook: Dunay Qüdrətli\n"
                    + "Telegram: @Kudratli");

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

    @Override
    public String getBotUsername()
    {
        return "PUBGNameGeneratorBot";
    }

}

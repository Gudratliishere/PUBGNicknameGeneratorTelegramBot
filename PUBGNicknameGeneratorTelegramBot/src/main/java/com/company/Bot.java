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
                    sb.append("??g??r klan ta???? olmadan t??k ad ist??yirsinizs?? mesaj b??lm??sin?? 1 yaz??b bo??luq burax??b "
                            + "ard??nca ist??diyiniz ad??n??z?? yaz??n. M??s??l??n :\n"
                            + "1 death\n"
                            + "??g??r klan ta???? il?? birg?? ad ist??yirsinizs?? ozaman 2 yaz??b bo??luq burax??b ard??nca klan ta????n??z?? "
                            + "v?? ad??n??z?? aralar??nda bo??luq olma??la yaz??n. M??s??l??n : \n"
                            + "2 fury death. \n"
                            + "Se??m??k ist??diyiniz ad??n qar????s??ndak?? ??d??di qar????s??na # yaz??b mesaj olaraq g??nd??rin."
                            + "M??s??l??n : \n"
                            + "#16 \n"
                            + "PUBG maksimum 14 h??rf q??bul ed?? bilir. Bunu n??z??r?? alaraq ad??n??z?? se??in. ??g??r bo??luq h??rfli "
                            + "ad ist??yirsinizs?? PUBG q??bul etm??si ??????n maksimum 7 h??rfli bir ad se??m??lisiniz. \n"
                            + "Daha effektiv n??tic??l??r alma????n??z ??????n ad??n??zda bo??luqdan, simvollardan v?? lat??n h??rfl??rind??n "
                            + "ba??qa dig??r h??rfl??rd??n (m??s??l??n, \"??\", \"??\" kimi h??rfl??r) istifad?? etm??m??yiniz t??vsiyy?? olunur.");
                    break;
                case "/start":
                    sb.append("Salam. PUBG nickname haz??rlayan botumuza xo?? g??lmisiniz. Botumuzun m??qs??di internetd?? "
                            + "??ox g??zm??d??n v?? ya dost-tan??????n??za m??n?? q??????y ad d??z??lt dem??d??n ??z??n??z??n 1 saniy??y?? "
                            + "ad??n??z?? d??z??ltm??yiniz?? k??m??k etm??kdir. Botun nec?? istifad?? olunaca???? haqq??nda m??lumat??n??z "
                            + "yoxdursa info kamandas??ndan istifad?? edin.");
                    break;
                case "/contact":
                    sb.append("??laq??:\n"
                            + "Gmail: d.qudretli@gmail.om\n"
                            + "Instagram: @dunayqudrtli\n"
                            + "Facebook: Dunay Q??dr??tli\n"
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
            sb.append("Z??hm??t olmasa mesaj format??n?? d??zg??n yaz??n. ??g??r bilmirsinizs?? "
                    + "info kamandas??ndan istifad?? edin.");
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

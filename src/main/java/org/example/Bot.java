package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class Bot extends TelegramLongPollingBot {
    final String username = "___";
    final String token = "___";
    int balance = 1000;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message;
        String chatId = null;
        String newText = "";
        if (update.hasMessage() && update.getMessage().hasText()) {
            message = update.getMessage();
            chatId = message.getChatId().toString();
            String text = message.getText();
            System.out.println(text);
            if (text.equals("/start")) {
                newText = "Ýòî èãðîâîé áîò, â êîòîðîì òû ìîæåøü ïîèãðàòü åñëè ñêó÷íî íà ïàðàõ! Âûáåðè ðåæèì èãðû: \n" +
                        "Îðåë è ðåøêà, ââåäè: /coin è orel èëè reshka + ñòàâêà â ìîíåòàõ (íàïðèìåð: /coin orel 500)\n" +
                        "Òàêæå äîñòóïíû êîìàíäû: /help /balance /start";

            } else if (text.split(" ")[0].equals("/coin")) {
                if (Integer.parseInt(text.split(" ")[2]) <= balance) {
                    if (text.split(" ")[1].equals(Randomchoice.rand())) {


                        balance += Integer.parseInt(text.split(" ")[2]);
                        newText = "you win \n" +
                                "your balance " + balance;
                    } else {
                        balance -= Integer.parseInt(text.split(" ")[2]);
                        newText = "you lose \n" +
                                "your balance " + balance;
                         if (balance == 0) {
                             balance += 500;
                             newText += "\nÊàæåòñÿ òåáÿ ïîáðèëè\n" +
                                     "Äåðæè ïÿòèõàò\n" +
                                     "òâîé áàëàíñ  " + balance;
                         }

                        }
                } else {
                    newText = "ó âàñ íåäîñòàòî÷íî ìîíåò";
                }

            } else if (text.equals("/balance")) {
                newText = "your balance: " + balance;


            } else if (text.equals("/help")) {
                newText = "âñå âîïðîñû â òã @ras0087";}

    }

        SendMessage sendMsg = new SendMessage();
        sendMsg.setChatId(chatId);
        sendMsg.setText(newText);
        try {
            execute(sendMsg);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
    }


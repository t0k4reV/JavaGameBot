  package org.example;

  import org.telegram.telegrambots.meta.TelegramBotsApi;
  import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
  import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

  public class Main {
    final String username = "@avasiriusbot";
    final String token = "6696076401:AAG5j_4FmcjJZE5_4v5rSlSTbeLf8kT9zz8";
    public static void main(String[] args) {
        System.out.println("Bot started");
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }
}
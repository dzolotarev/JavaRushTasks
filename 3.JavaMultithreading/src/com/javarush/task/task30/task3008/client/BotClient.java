package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BotClient extends Client {

    public class BotSocketThread extends SocketThread {
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            String message = "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.";
            BotClient.this.sendTextMessage(message);
            super.clientMainLoop();
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] splited = message.split(":");
            String name = splited[0].trim();
            String pattern = "";
            Calendar calendar = Calendar.getInstance();
            Date curDate = calendar.getTime();

            if (splited.length != 2) return;
            
                switch (splited[1].toLowerCase(Locale.ROOT).trim()) {
                    case "дата":
                        pattern = "d.MM.YYYY";
                        break;
                    case "день":
                        pattern = "d";
                        break;
                    case "месяц":
                        pattern = "MMMM";
                        break;
                    case "год":
                        pattern = "YYYY";
                        break;
                    case "время":
                        pattern = "H:mm:ss";
                        break;
                    case "час":
                        pattern = "H";
                        break;
                    case "минуты":
                        pattern = "m";
                        break;
                    case "секунды":
                        pattern = "s";
                        break;
                }
                if(pattern.length()!=0){
                    BotClient.this.sendTextMessage(("Информация для " + name + ": " + new SimpleDateFormat(pattern).format(curDate)));
                }
            }

        
    }

    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    protected String getUserName() {
        int name = (int) (Math.random() * 100);
        return "date_bot_" + name;
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}

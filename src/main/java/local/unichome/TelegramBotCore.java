package local.unichome;

import local.unichome.parcer.ChatNode;
import local.unichome.support.SaveSupport;
import local.unichome.support.TelegramUserSaver;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Telegram Bot Core
 */
public class TelegramBotCore extends TelegramLongPollingBot {
    private static final Logger logger = Logger.getLogger(TelegramBotCore.class.getName());

    private static final String BOT_NAME = "";
    private static final String BOT_TOKEN = "";

    // список подписчиков
    private ArrayList<TelegramUser> observers = new ArrayList<>();

    private SaveSupport save = new TelegramUserSaver();

    /**
     * отправить сообщение всем подписчикам
      * @param msg текст сообщения
     */
    public void sendQuary(String msg) {
        observers.forEach(obs -> sendMessage(obs.getuID(), msg));
    }

    TelegramBotCore() {
        ArrayList<String> uIDlist = save.getAllFilesName();
        uIDlist.forEach(e -> observers.add((TelegramUser) save.load(e)));
    }

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        logger.info(message);
        System.out.println(convertToUTF8(message));
        messageSeparator(update.getMessage().getChatId().toString(), message);
    }

    /**
     * разбор входящих сообщений
     * @param id id поользователя
     * @param message текст сообщения
     */
    public void messageSeparator(String id, String message) {
        switch (message) {
            case "/observers": {
                StringBuilder msg = new StringBuilder();
                observers.forEach(e -> {
                    msg.append(e.getuID()).append("\n");
                });
                sendMessage(id, msg.toString());
                break;
            }
            case "/update":{
                for (ChatNode node : AppInitNoStyle.chatNodes) {
                    sendMessage(id, node.printNode());
                }
                break;
            }
            case "/sub": {
                TelegramUser tu = new TelegramUser(id);
                if (!observers.contains(tu)) {
                    tu.setSubscribe(true);
                    save.save((Object) tu);
                    observers.add(tu);
                    sendMessage(id, "вы подписаны");
                    for (ChatNode node : AppInitNoStyle.chatNodes) {
                        sendMessage(id, node.printNode());
                    }
                } else
                    sendMessage(id, "не донимай меня");
                break;
            }
            case "/unsub": {
                TelegramUser tu = new TelegramUser(id);
                if (observers.contains(tu)) {
                    observers.remove(tu);
                    sendMessage(id, "Подписка отменена");
                } else
                    sendMessage(id, "не донимай меня");
                break;
            }
            case "/start": {
                sendMessage(id, "дороу чел");
                break;
            }
            case "/help": {
                sendMessage(id,
                       "/sub"
                        + "\n/unsub"
                        + "\n/update"
                );
                break;
            }
            default: {
                try {
                    if (message.toLowerCase().startsWith("/all")) {
                        sendQuary("Observer: " + message.substring(5));
                    } else
                        sendMessage(id,
                                "не нинаю такого" + "\n Посмотри что умею:" + "\n /help");
                } catch (Exception ignore) {
                    sendMessage(id,
                            "нинаю такого" + "\n Посмотри что умею:" + "\n /help");
                }
            }
        }
    }

    /**
     * Sender
     * @param chatId чат куда отправлять
     * @param s сообщение
     */
    public synchronized void sendMessage(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(false);
        sendMessage.setChatId(chatId);
        sendMessage.setText(
                convertToUTF8(s)
        );
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("Exception: " + e.toString());
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    private String convertToUTF8(String text) {
        return new String(text.getBytes(), StandardCharsets.UTF_8);
    }
    private String convertToASCII(String text) {
        return new String(text.getBytes(), StandardCharsets.US_ASCII);
    }
}

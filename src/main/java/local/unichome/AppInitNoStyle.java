package local.unichome;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import local.unichome.parcer.ChatNode;
import local.unichome.parcer.HtmlParcer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class AppInitNoStyle extends Application {
    public static final String ADDRESS = "https://www2.cbox.ws/box/?boxid=1757844&boxtag=4zbnzd&sec=main";
    public static final int CHAT_UPDATE_SPEED = 30;

    public static ArrayList <ChatNode> chatNodes = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("CBOX Presentation");
        WebView webView = new WebView();
        webView.getEngine().load(ADDRESS);
        VBox vBox = new VBox(webView);

        // сцена
        Scene scene = new Scene(vBox, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

        // точка входа Телеграм бот
        telegramBotInit();

        // поток мониторинга новых сообщений
        Thread thread = new Thread(() -> {
            HtmlParcer parcer = new HtmlParcer();
            while (true) {
                try {
                    Thread.sleep(CHAT_UPDATE_SPEED * 1000);

                    String html = getUrlSource(ADDRESS);

                    for (ChatNode node : parcer.parce(html)) {
                        if (!chatNodes.contains(node)) {
                            chatNodes.add(node);
                            if (chatNodes.size() > 20) {
                                sendMessage(node.getId() + "-" + node.getAuthor() + ": " + node.getMessage());
                                chatNodes.remove(0);
                            }
                        }
                        System.out.println(chatNodes.size());
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

    }

    /**
     * Получение собержимого чата в момент времени
     * @param site адрес
     * @return html страница
     */
    private String getUrlSource(String site) throws IOException {
        URL url = new URL(site);
        URLConnection urlc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(urlc.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null) a.append(inputLine); in.close();
        return a.toString();
    }

    /* telegram bot section START */
    public static TelegramBotCore telegramBotCore;
    public void telegramBotInit() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(telegramBotCore = new TelegramBotCore());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void sendMessage (String msg) {
        telegramBotCore.sendQuary(msg);
    }
    /* telegram bot section END */
}

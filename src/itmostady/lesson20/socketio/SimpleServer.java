package itmostady.lesson20.socketio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class SimpleServer {
    private Connection connection;
    private int count;
    Client client;

    public int getCount() {
        return count;
    }
    public long Ping(SimpleMessage message){
        LocalDateTime time = LocalDateTime.now();
        return ChronoUnit.MILLIS.between(message.getDateTime(), time);
    }
    private void messageProcess(String s) throws Exception {
        if (Command.HELP.name().equalsIgnoreCase(s)){
            connection.sendMessage(SimpleMessage.getMessage("server",
                    Arrays.toString(Command.values())));
        }
        else if (Command.COUNT.name().equalsIgnoreCase(s)){
            connection.sendMessage(SimpleMessage.getMessage("server",
                    "Количество подключений: " + getCount()));
        }
        else if (Command.PING.name().equalsIgnoreCase(s)){
            connection.sendMessage(SimpleMessage.getMessage("server",
                    "Пинг: " + Ping(connection.readMessage())));
        }
        else if (Command.EXIT.name().equalsIgnoreCase(s)){
            connection.sendMessage(SimpleMessage.getMessage("server", "Disconnecting..."));
        }
        else connection.sendMessage(SimpleMessage.getMessage("server", "Попробуйте снова"));

    }

    public void start() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(8090)){ // ожидание клиента
            System.out.println("Server started");
            while (true){
                Socket socket = serverSocket.accept();// принятие клиента
                connection = new Connection(socket);

                String s = connection.readMessage().getText();
                messageProcess(s);
                connection.sendMessage(SimpleMessage.getMessage("server", "получено"));

            }
        }
    }


    public static void main(String[] args) throws Exception {
        SimpleServer simpleServer = new SimpleServer();
        simpleServer.start();


    }
}// ip 127.0.0.1  : 8090


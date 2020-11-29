package itmostady.lesson20.socketio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Objects;

public class SimpleServer {
    private Connection connection;
    private int count;
    Client client;

    public int getCount() {
        return count;
    }

    public long Ping(LocalDateTime dataTime){
        LocalDateTime time = LocalDateTime.now();
        return ChronoUnit.MILLIS.between(dataTime, time);
    }

    private void messageProcess(SimpleMessage s, LocalDateTime data) throws Exception {
        if (Command.HELP.toString().equalsIgnoreCase(s.getText())){
            connection.sendMessage(SimpleMessage.getMessage("server",
                    Arrays.toString(Command.values())));
        }
        else if (Command.COUNT.toString().equalsIgnoreCase(s.getText())){
            connection.sendMessage(SimpleMessage.getMessage("server",
                    "Количество подключений: " + getCount()));
        }
        else if (Command.PING.toString().equalsIgnoreCase(s.getText())){
            connection.sendMessage(SimpleMessage.getMessage("server",
                    "Пинг: " + Ping(data)));
        }
        else connection.sendMessage(SimpleMessage.getMessage("server", "Попробуйте снова"));

    }

    public void start() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(8090)) { // ожидание клиента
            System.out.println("Server started");
            while (true){
                Socket socket = serverSocket.accept();// принятие клиента
                connection = new Connection(socket);
                count++;
                SimpleMessage s = connection.readMessage();
                System.out.println(s);
                LocalDateTime t = s.getDateTime();
                if (Objects.isNull(s)){
                    connection.sendMessage(SimpleMessage.getMessage("server", "получено"));
                }
                else messageProcess(s, t);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        SimpleServer simpleServer = new SimpleServer();
        simpleServer.start();


    }
}// ip 127.0.0.1  : 8090


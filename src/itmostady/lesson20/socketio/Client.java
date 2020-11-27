package itmostady.lesson20.socketio;

import itmostady.lesson21NIO.nio.TstProperties;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;
    private LocalDateTime time;

    public Client(){
        this.ip = getIp();
        this.port = getPort();
        scanner = new Scanner(System.in);
    }

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }

    public LocalDateTime getTime() {
        return time = LocalDateTime.now();
    }

    Properties properties = new Properties();
    private String getIp(){
        try (
                InputStream input = Client.class
                        .getClassLoader().getResourceAsStream("config.properties")){
            properties.load(input);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return properties.getProperty("ip");
    }
    private int getPort(){
        try (
                InputStream input = Client.class
                        .getClassLoader().getResourceAsStream("config.properties")){
            properties.load(input);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return Integer.parseInt(properties.getProperty("port"));
    }

    public void start() throws Exception {
        System.out.println("Введите Имя");
        String name = scanner.nextLine();
        String message;
        System.out.println(Arrays.toString(Command.values()));
        while (true){
            System.out.println("Введите сообщение или команду");
            message = scanner.nextLine();
            sendAndPrintMessage(SimpleMessage.getMessage(name, message));

        }
    }
    
    private void sendAndPrintMessage(SimpleMessage message) {
        try (Connection connection = new Connection(new Socket(ip, port))){
            connection.sendMessage(message);
            SimpleMessage fromServer = connection.readMessage();
            System.out.println("от сервера: " + fromServer);
            if ("Disconnecting...".equalsIgnoreCase(fromServer.getText())){
                connection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // ip 127.0.0.1  : 8090
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.start();

    }
}

enum Command{
    HELP, COUNT, PING, EXIT;

}

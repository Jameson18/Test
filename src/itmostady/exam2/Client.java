package itmostady.exam2;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    private String name;
    private Connection connection;
    private String ip;
    private int port;
    private Scanner scanner;
    private LocalDateTime time;
    Properties properties = new Properties();

    public Client(){
        this.name = name;
        try {
            connection = new Connection(new Socket(getIp(), getPort()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner = new Scanner(System.in);
    }

    private String getIp(){
        try (
                InputStream input = itmostady.lesson20.socketio.Client.class
                        .getClassLoader().getResourceAsStream("config.properties")){
            properties.load(input);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return properties.getProperty("ip");
    }
    private int getPort(){
        try (
                InputStream input = itmostady.lesson20.socketio.Client.class
                        .getClassLoader().getResourceAsStream("config.properties")){
            properties.load(input);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return Integer.parseInt(properties.getProperty("port"));
    }

//    protected void sendMessage(Message message){
//        try {
//            connection = new Connection(new Socket(ip, port));
//            connection.sendMessage(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
        private class Read implements Runnable{

            @Override
            public void run() {
                try {
                    while (true) {
                        Message message = (Message) connection.getIn().readObject();
                        System.out.println(message.getSender() + ": " + message.getMessageText());
                    }
                    }catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        private class Write implements Runnable{

            @Override
            public void run() {
                Scanner scan = new Scanner(System.in);
                while (true){
                    try {
                        String text = scan.nextLine();
                        if (text.equalsIgnoreCase("exit")){
                            connection.sendMessage(new Message(Client.this.name,
                                    "disconnected"));
                            connection.close();
                        }
                        else connection.sendMessage(new Message(Client.this.name, text));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void start() throws Exception{
        try{
            System.out.println("Введите Имя");
            name = scanner.nextLine();
            Thread read = new Thread(new Read());
            read.start();
            Thread write = new Thread(new Write());
            write.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
        }



}

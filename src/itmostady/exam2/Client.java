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
    private boolean access = true;

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
                    Connection connection1 = new Connection(new Socket(getIp(), getPort()));
                    while (true) {
                        Message message = connection1.receiveMessage();
                        System.out.println(message.getSender() + ": " + message.getMessageText());
                        if ("Имя уже занято".equalsIgnoreCase(message.getMessageText())) {
                            access = false;
                        }

                    }
                    }catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }



        public void start() throws Exception{
        try{
            Thread read = new Thread(new Read());
            read.start();
            String message;

                System.out.println("Введите Имя");
                name = scanner.nextLine();
                connection.sendMessage(Message.getMessage(name, ""));
                //Thread.sleep(3000);

                if (access){
                    while (true){
                        System.out.println("Введите сообщение");
                        message = scanner.nextLine();
                        Message s = Message.getMessage(name, message);
                        if ("exit".equalsIgnoreCase(message)){
                            connection.sendMessage(Message.getMessage(name, "disconnected"));
                            break;
                        }else {

                            connection.sendMessage(s);
                            System.out.println(s);
                        }
                    }
                }



        } catch (Exception e) {
            e.printStackTrace();
        }
        }



}

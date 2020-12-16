package itmostady.exam2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private ConcurrentHashMap<String, Connection> userMap = new ConcurrentHashMap<>();
    private ArrayBlockingQueue<Message> messages = new ArrayBlockingQueue<>(20);
    private Connection connection;

    protected ConcurrentHashMap<String, Connection> getUserMap() {
        return userMap;
    }

    protected void addUser(String name, Connection connection) {
        userMap.putIfAbsent(name, connection);
    }

    protected void removeUser(String name) {
        userMap.remove(name);
    }


    private class Reader implements Runnable{
        private Connection connection;

        public Reader(Connection connection){
            this.connection = connection;
        }

        @Override
        public void run() {
            try{
                while (true) {
                    Message message = connection.receiveMessage();
                    messages.add(message);
//                if (userMap.containsKey(message.getSender())){
//                    connection.sendMessage(Message.getMessage("От сервера", "Имя уже занято"));
//                }else if (message.getMessageText().
//                        equalsIgnoreCase("disconnected")){
//                    removeUser(message.getSender());
//                }else addUser(message.getSender(), this.connection);
//                while (true) {
//                        messages.add(message);
//                }
                }
                } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class Writer implements Runnable{
        private Connection connection;

//       // private Writer() {
//            this.connection = connection;
//        }


        @Override
        public void run() {
           try{
               while (true){
                       Message message = messages.take();
                       for (Map.Entry<String, Connection> map: userMap.entrySet()){
                           if (!message.getSender().equalsIgnoreCase(map.getKey())){
                               map.getValue().sendMessage(message);
                           }
                       }

               }
               }catch (InterruptedException | IOException | NullPointerException e) {
               e.printStackTrace();
           }
        }
    }

    public void start() throws Exception{
        try {
            ServerSocket serverSocket = new ServerSocket(8090);
            System.out.println("Server started");
            Thread writer = new Thread(new Writer());
            writer.start();
            while (true){
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                Message s = connection.receiveMessage();
                Thread reader = new Thread(new Reader(connection));
                reader.start();
                if (!userMap.containsValue(connection)){
                    userMap.put(s.getSender(), connection);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

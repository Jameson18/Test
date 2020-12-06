package itmostady.exam2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private ConcurrentHashMap<String, Connection> userMap;
    private ArrayBlockingQueue<Message> messages;
    private Connection connection;

    protected ConcurrentHashMap<String, Connection> getUserMap() {
        return userMap;
    }

    protected void addUser(String name, Connection connection) {
        userMap.put(name, connection);
    }

    protected void removeUser(String name) {
        userMap.remove(name);
    }


    private class Reader implements Runnable{
        private ArrayBlockingQueue<Message> messages;
        private Connection connection;

        public Reader(Connection connection){
            this.connection = connection;
        }

        @Override
        public void run() {
            while (true){
                try {
                    messages.put(connection.receiveMessage());
                    if (connection.receiveMessage().getMessageText().
                            equalsIgnoreCase("disconnected")){
                        userMap.remove(connection.receiveMessage().getSender());
                    }
                } catch (InterruptedException | IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Writer implements Runnable{
        private ArrayBlockingQueue<Message> messages;
        private Connection connection;



        @Override
        public void run() {
           try{
               while (true){
                       Message message = messages.take();
                       for (Map.Entry<String, Connection> map: userMap.entrySet()){
                           if (!message.getSender().equalsIgnoreCase(map.getKey())){
                               connection.sendMessage(message);
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
                Thread reader = new Thread(new Reader(connection));
                reader.start();
                userMap.putIfAbsent(connection.receiveMessage().getSender(), connection);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

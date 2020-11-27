package itmostady.lesson20.socketio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// AutoCloseable + close() позволит создать объекты в try-with-source блоке
public class Connection implements AutoCloseable{
    private Socket socket; // позволит клиенту установить соединение с сервером, а серверу принять клиента
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        output = new ObjectOutputStream(this.socket.getOutputStream()); // получить данные из потока
        input = new ObjectInputStream(this.socket.getInputStream());
    }

    public void sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message);
        output.flush();
    }
    public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }

    @Override // будет вызван автоматически после завершения try, если Connection был создан в () try
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }
}

package itmostady.exam2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements AutoCloseable{
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(this.socket.getOutputStream());
        in = new ObjectInputStream(this.socket.getInputStream());
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void sendMessage(Message message) throws IOException {
        out.writeObject(message);
    }
    public Message receiveMessage() throws IOException, ClassNotFoundException {
            return (Message) in.readObject();

    }


    @Override
    public void close() throws Exception {
        in.close();
        out.close();
        socket.close();
    }
}

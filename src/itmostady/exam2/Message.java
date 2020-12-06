package itmostady.exam2;

import java.io.Serializable;
import java.time.LocalTime;

public class Message implements Serializable {
    private String sender;
    private String messageText;
    private LocalTime messageTime;

    public Message(String sender, String messageText) {
        this.sender = sender;
        this.messageText = messageText;
        messageTime = LocalTime.now();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public LocalTime getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(LocalTime messageTime) {
        this.messageTime = messageTime;
    }
    public static Message getMessage(String sender, String messageText){
        return new Message(sender, messageText);
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", messageText='" + messageText + '\'' +
                ", messageTime=" + messageTime +
                '}';
    }
}

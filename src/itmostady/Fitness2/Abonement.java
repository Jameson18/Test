package itmostady.Fitness2;

import java.time.LocalDateTime;

abstract public class Abonement extends Client{
    Client client;
    LocalDateTime currentTime = LocalDateTime.now();
    protected LocalDateTime regTime;

    public Abonement(Client client) {
        this.client = client;
        this.regTime = currentTime;

    }

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = currentTime;
    }

    public boolean inputPool(){return true;}
    public boolean inputGym(){return true;}
    public boolean inputGroup(){return true;}


    @Override
    public String toString() {
        return "Abonement{" +
                "client=" + client +
                '}';
    }
}

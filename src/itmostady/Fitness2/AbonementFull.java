package itmostady.Fitness2;

import java.time.LocalDateTime;

public class AbonementFull extends Abonement implements InputGroup, InputGym, InputPool{
    Client client;
    protected LocalDateTime regTime;
    protected LocalDateTime endRegTime;

    public AbonementFull(Client client) {
        super(client);
        this.client = client;
        this.regTime = currentTime;
        this.endRegTime = currentTime.plusDays(30);
    }


    public boolean inPool(){
        return (currentTime.isAfter(regTime) && currentTime.isBefore(endRegTime));
    }
    public boolean inGym(){
        return (currentTime.isAfter(regTime) && currentTime.isBefore(endRegTime));
    }
    public boolean inGroup(){
        return (currentTime.isAfter(regTime) && currentTime.isBefore(endRegTime));
    }



    @Override
    public boolean inputGroup(Abonement abonement) {
        boolean access = true;
        if (!inGroup()){
            access = false;
        }return access;
    }

    @Override
    public boolean inputGym(Abonement abonement) {
        boolean access = true;
        if (!inGym()){
            access = false;
        }return access;
    }

    @Override
    public boolean inputPool(Abonement abonement) {
        boolean access = true;
        if (!inPool()){
            access = false;
        }return access;
    }

    @Override
    public String toString() {
        return "AbonementFull{" +
                client +
                ", Дата регистрации: " + regTime +
                ", Действителен до: " + endRegTime +
                '}';
    }
}

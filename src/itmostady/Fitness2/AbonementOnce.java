package itmostady.Fitness2;

import java.time.LocalDateTime;

public class AbonementOnce extends Abonement implements InputPool, InputGym{
    protected LocalDateTime regTime;
    protected LocalDateTime endRegTime;

    public AbonementOnce(Client client) {
        super(client);
        this.regTime = currentTime;
        this.endRegTime = currentTime.plusDays(1);
    }


    public boolean inPool(){
        return (currentTime.isAfter(regTime) && currentTime.isBefore(endRegTime));
    }
    public boolean inGym(){
        return (currentTime.isAfter(regTime) && currentTime.isBefore(endRegTime));
    }



    @Override
    public boolean inputGym(Abonement abonement) {
        return (!inGym());
    }

    @Override
    public boolean inputPool(Abonement abonement) {
        return (!inPool());
    }

    @Override
    public String toString() {
        return "AbonementOnce{" +
                client +
                ", Дата регистрации: " + regTime +
                ", Действителен до: " + endRegTime +
                '}';
    }
}

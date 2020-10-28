package itmostady.Fitness2;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class AbonementDaily extends Abonement implements InputGym, InputGroup{
    protected LocalDateTime regTime;
    protected LocalDateTime endRegTime;
    protected final LocalTime inTime = LocalTime.of(8,0);
    protected final LocalTime outTime = LocalTime.of(16,0);
    protected final LocalTime curr = LocalTime.now();

    public AbonementDaily(Client client) {
        super(client);
        this.regTime = currentTime;
        this.endRegTime = currentTime.plusDays(30);
    }


    public boolean open(){
        return (curr.isAfter(inTime) && curr.isBefore(outTime));
    }

    public boolean inGym(){
        return (currentTime.isAfter(regTime) && currentTime.isBefore(endRegTime));
    }

    public boolean inGroup(){
        return (currentTime.isAfter(regTime) && currentTime.isBefore(endRegTime));
    }



    @Override
    public boolean inputGroup(Abonement abonement) {
       return (!inGroup());
    }

    @Override
    public boolean inputGym(Abonement abonement) {
        return (!inGym());
    }

    @Override
    public String toString() {
        return "AbonementDaily{" +
                client +
                ", Дата регистрации: " + regTime +
                ", Действителен до: " + endRegTime +
                '}';
    }
}

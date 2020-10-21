package itmostady.Fitness2;

import java.time.LocalDateTime;

public class AbonementOnce extends Abonement implements InputPool, InputGym{
    protected LocalDateTime regTime;
    protected LocalDateTime endRegTime;

    public AbonementOnce(String name, String surname, int year) {
        super(name, surname, year);
        this.regTime = currentTime;
        this.endRegTime = currentTime.plusDays(1);
    }


    public boolean inputPool(){
        return (currentTime.isAfter(regTime) || currentTime.isBefore(endRegTime));
    }
    public boolean inputGym(){
        return (currentTime.isAfter(regTime) || currentTime.isBefore(endRegTime));
    }
    public String getInfo(){
        return name + surname + year + regTime + endRegTime;
    }


    @Override
    public void inputGym(Abonement abonement) {
        if (!inputGym()){
            System.out.println("Not your time");
        }
    }

    @Override
    public void inputPool(Abonement abonement) {
        if (!inputPool()){
            System.out.println("Not your time");
        }
    }
    @Override
    public String toString() {
        return "AbonementOnce{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", regTime=" + regTime +
                ", endRegTime=" + endRegTime +
                "} ";
    }
}

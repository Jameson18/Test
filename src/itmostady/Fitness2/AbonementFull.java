package itmostady.Fitness2;

import java.time.LocalDateTime;

public class AbonementFull extends Abonement implements InputGroup, InputGym, InputPool{
    protected LocalDateTime regTime;
    protected LocalDateTime endRegTime;

    public AbonementFull(String name, String surname, int year) {
        super(name, surname, year);
        this.regTime = currentTime;
        this.endRegTime = currentTime.plusDays(30);
    }


    public boolean inputPool(){
        return (currentTime.isAfter(regTime) || currentTime.isBefore(endRegTime));
    }
    public boolean inputGym(){
        return (currentTime.isAfter(regTime) || currentTime.isBefore(endRegTime));
    }
    public boolean inputGroup(){
        return (currentTime.isAfter(regTime) || currentTime.isBefore(endRegTime));
    }
    public String getInfo(){
        return name + surname + year + regTime + endRegTime;
    }


    @Override
    public void inputGroup(Abonement abonement) {
        if (!inputGroup()){
            System.out.println("Not your time");
        }
    }

    @Override
    public void inputGym(Abonement abonement) {
        if (!inputGym()){
            System.out.println("Not your time");
        }
    }

    @Override
    public void inputPool(Abonement abonement) {
        if (!inputGym()){
            System.out.println("Not your time");
        }
    }
    @Override
    public String toString() {
        return "AbonementFull{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", regTime=" + regTime +
                ", endRegTime=" + endRegTime +
                "} ";
    }
}

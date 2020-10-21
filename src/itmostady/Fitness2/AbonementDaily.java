package itmostady.Fitness2;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class AbonementDaily extends Abonement implements InputGym, InputGroup{
    protected LocalDateTime regTime;
    protected LocalDateTime endRegTime;
    protected final LocalTime inTime = LocalTime.of(8,0);
    protected final LocalTime outTime = LocalTime.of(16,0);
    protected final LocalTime curr = LocalTime.now();


    public AbonementDaily(String name, String surname, int year) {
        super(name, surname, year);
        this.regTime = currentTime;
        this.endRegTime = currentTime.plusDays(30);
    }
    public boolean open(){
        return (curr.isAfter(inTime) && curr.isBefore(outTime));
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
        if (!inputGroup() && open()){
            System.out.println("Not your time");
        }
    }

    @Override
    public void inputGym(Abonement abonement) {
        if (!inputGym() && open()){
            System.out.println("Not your time");
        }
    }
    @Override
    public String toString() {
        return "AbonementDaily{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", regTime=" + regTime +
                ", endRegTime=" + endRegTime +
                "} ";
    }
}

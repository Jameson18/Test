package itmostady.Fitness2;

import java.time.LocalDate;
import java.time.LocalTime;

public class AbonementDaily extends AbonementOnce implements InputGym, InputGroup{
    public AbonementDaily(String name, String surname, int year, LocalDate regTime, LocalDate endRegTime) {
        super(name, surname, year, regTime, endRegTime);
        this.endRegTime = regTime.plusDays(30);
    }

    private final LocalTime currentT = LocalTime.now();
    private final LocalTime out = LocalTime.of(16, 0);
    private final LocalDate current = LocalDate.now();
    public boolean inputGym(){
        return (endRegTime.isBefore(current) || currentT.isBefore(out));
    }

    public boolean inputGroup(){
        return (endRegTime.isBefore(current) || currentT.isBefore(out));
    }

    public String getInfo(){
        return name + surname + year + regTime + endRegTime;
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

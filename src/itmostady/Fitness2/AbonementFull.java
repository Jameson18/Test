package itmostady.Fitness2;

import java.time.LocalDate;

public class AbonementFull extends AbonementDaily implements InputGroup, InputGym, InputPool{
    public AbonementFull(String name, String surname, int year, LocalDate regTime, LocalDate endRegTime) {
        super(name, surname, year, regTime, endRegTime);
        this.endRegTime = regTime.plusDays(30);
    }
    public boolean inputPool(){
        LocalDate current = LocalDate.now();
        return (endRegTime.isBefore(current));
    }
    public boolean inputGym(){
        LocalDate current = LocalDate.now();
        return (endRegTime.isBefore(current));
    }
    public boolean inputGroup(){
        LocalDate current = LocalDate.now();
        return (endRegTime.isBefore(current));
    }
    public String getInfo(){
        return name + surname + year + regTime + endRegTime;
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

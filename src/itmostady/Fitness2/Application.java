package itmostady.Fitness2;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        Fitness fitness = new Fitness();

        AbonementDaily ticket1 = new AbonementDaily("Bart", "Simpson", 1990);
        AbonementFull ticket2 = new AbonementFull("Gamer", "Simpson", 1970);
        AbonementOnce ticket3 = new AbonementOnce("Lisa", "Simpson", 1995);
        fitness.addAbonement("pool", ticket1);
        fitness.addAbonement("gym", ticket2);
        System.out.println(fitness);

    }
}

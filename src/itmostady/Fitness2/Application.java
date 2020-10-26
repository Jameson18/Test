package itmostady.Fitness2;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        Fitness fitness = new Fitness();
        Client client1 = new Client();
        client1.setName("Bart");
        client1.setSurname("Simpson");
        client1.setYear(1990);
        AbonementFull abF1 = new AbonementFull(client1);
        Client client2 = new Client("Lisa", "Simpson", 1995);
        AbonementDaily abD1 = new AbonementDaily(client2);
        fitness.addAbonement("pool", abD1);
        fitness.addAbonement("group", abF1);
        Client client3 = new Client("Gomer", "Simpson", 1965);
        AbonementFull abF2 = new AbonementFull(client3);
        fitness.addAbonement("group", abF2);
        fitness.addAbonement("group", abF2);
        fitness.addAbonement("pool", abF1);

        System.out.println(fitness);

    }
}

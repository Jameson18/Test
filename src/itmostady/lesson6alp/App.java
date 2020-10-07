package itmostady.lesson6alp;

public class App {
    public static void main(String[] args) {
        Alpinist ivan = new Alpinist("Иван", "Томск");
        Mountain elb = new Mountain("Эльбрус", "Россия", 5100);
        Alpinist egor = new Alpinist("Егор", "Москва");
        Alpinist igor = new Alpinist("Игорь", "Владивосток");
        Group group1 = new Group(3, "Набор закрыт");
        group1.addAlpinist(ivan);
        group1.addAlpinist(egor);
        group1.addAlpinist(igor);
        group1.setMountain(elb);
        System.out.println(group1);
        Alpinist sasha = new Alpinist("Саша", "Тюмень");
        Alpinist misha = new Alpinist("Миша", "Питер");
        Alpinist kolya = new Alpinist("Коля", "Выборг");
        Alpinist ola = new Alpinist("Оля", "Владивосток");
        Mountain eve = new Mountain("Эверест", "Непал", 8848);
        Mountain mon = new Mountain("Монблан", "Италия", 4810);
        Group group2 = new Group(3, "Набор закрыт");
        group2.setMountain(eve);
        group2.addAlpinist(sasha);
        group2.addAlpinist(kolya);
        Group group3 = new Group(3, "Набор закрыт");
        group3.setMountain(mon);
        group3.addAlpinist(misha);
        group3.addAlpinist(ola);
        System.out.println(group2);
        System.out.println(group3);
        System.out.println(group3.getStatus());



    }
}

package itmostady.school;

public class Director extends Human{
    public Director(String name, int age) {
        super(name, age);
    }

    public void startStudy(){
        System.out.println("Занятия начались");
    }
    public void stopStudy(){
        System.out.println("Занятия кончились");
    }
}

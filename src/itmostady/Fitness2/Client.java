package itmostady.Fitness2;

public class Client {
    private String name;
    private String surname;
    private int year;

    public Client() {
    }

    public Client(String name, String surname, int year) {
        setName(name);
        setSurname(surname);
        setYear(year);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3)
            throw new IllegalArgumentException("name < 3");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.trim().length() < 3)
            throw new IllegalArgumentException("surname < 3");
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1920 || year > 2020)
            throw new IllegalArgumentException("Неверный год рождений");
        this.year = year;
    }




    @Override
    public String toString() {
        return "Имя " + name  +
                ", Фамилия " + surname +
                ", Год рождения " + year
                ;
    }
}

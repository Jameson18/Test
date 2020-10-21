package itmostady.Fitness2;

import java.time.LocalDate;
import java.time.LocalDateTime;

abstract public class Abonement {
    protected String name;
    protected String surname;
    protected int year;
    LocalDateTime currentTime = LocalDateTime.now();
    protected LocalDateTime regTime;


    public Abonement(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.regTime = currentTime;

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

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = currentTime;
    }


}

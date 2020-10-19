package itmostady.Fitness2;

import java.time.LocalDate;
import java.time.LocalDateTime;

abstract public class Abonement {
    protected String name;
    protected String surname;
    protected int year;
    LocalDate currentTime = LocalDate.now();
    protected LocalDate regTime;
    protected LocalDate endRegTime;

    public Abonement(String name, String surname, int year, LocalDate regTime, LocalDate endRegTime) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.regTime = regTime;
        this.endRegTime = endRegTime;
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

    public LocalDate getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = currentTime;
    }

    public LocalDate getEndRegTime() {
        return endRegTime;
    }

    public void setEndRegTime(LocalDate endRegTime) {
        this.endRegTime = endRegTime;
    }
}

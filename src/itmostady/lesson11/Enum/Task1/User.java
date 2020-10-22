package itmostady.lesson11.Enum.Task1;

public class User {
    String name;
    int salary;
    Position position;

    public User(String name, Position position) {
        this.name = name;
        this.position = position;
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        salary = (int)(Math.random() * 50 + 10);
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }
}

enum Position {
    CLEANER, DIRECTOR, ACCOUNTANT

}

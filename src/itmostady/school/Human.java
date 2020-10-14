package itmostady.school;

public class Human {
    protected String name;
    protected int age;
    protected String subject;

    public Human(String name, int age, String subject) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");
        if (age < 6)
            throw new IllegalArgumentException("Возраст не может быть меньше 6");
        if (subject.isEmpty())
            throw new IllegalArgumentException("Предмет не может быть пустым");
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    public Human(String name, int age) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");
        if (age < 6)
            throw new IllegalArgumentException("Возраст не может быть меньше 6");
        this.name = name;
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

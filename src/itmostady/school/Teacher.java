package itmostady.school;

public class Teacher extends Human implements TeachAble{
    public Teacher(String name, int age, String subject) {
        super(name, age, subject);
    }


    @Override
    public void teach(LearnAble student) {
        student.study();
    }
}

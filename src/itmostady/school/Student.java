package itmostady.school;

public class Student extends Human implements LearnAble{
    private int levelKnowledge;

    public Student(String name, int age, String subject, int levelKnowledge) {
        super(name, age, subject);
        if (levelKnowledge < 0){
            throw new IllegalArgumentException("Уровень знаний не может быть меньше 0");
        }
        this.levelKnowledge = levelKnowledge;
    }



    @Override
    public void study() {
        this.levelKnowledge++;
    }
}

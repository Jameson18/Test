package itmostady.school;

public class App {
    public static void main(String[] args) {
        Student ivan = new Student("Ivan", 18, "Geografy", 5);
        Student olga = new Student("Olga", 18, "Math", 10);
        Student igor = new Student("Igor", 17, "Liter", 3);
        Teacher sam = new Teacher("Sam", 47, "Geografy");
        Teacher ted = new Teacher("Ted", 35, "Math");
        Teacher tom = new Teacher("Tom", 41, "Liter");
        Director director = new Director("SenSay", 50);
        School sch = new School("ITMO", director, 3, 4);
        sch.addStudent(ivan);
        sch.addStudent(olga);
        sch.addStudent(igor);
        sch.addTeacher(sam);
        sch.addTeacher(ted);
        sch.addTeacher(tom);
        sch.passDay();
    }
}

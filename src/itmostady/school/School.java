package itmostady.school;

public class School {
    private String name;
    private final Director director;
    private Teacher[] teachers;
    private Student[] students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");
        this.name = name;
    }

    public School(String name, Director director, int TeacherCount, int StudentCount){
        if (name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");
        this.name = name;
        this.director = director;

    }
    public void addTeacher(Teacher teache){
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                teachers[i] = teache;
                return;
            }
        }
    }
    public void addStudent(Student stud){
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = stud;
                return;
            }
        }
    }
    public void Studies(){
        for (Teacher teacher : teachers) {
            if (teacher != null){
                for (LearnAble student : students) {
                    if (student != null && teacher.getSubject().equalsIgnoreCase(student.getSubject()))
                        teacher.teach(student);
                }
            }

        }
    }


    public void passDay(){
        director.startStudy();
        Studies();
        director.stopStudy();

    }
}

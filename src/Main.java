import db.Database;
import gender.Gender;
import impl.GroupServiceImpl;
import impl.StudentServiceImpl;
import model.Group;
import model.Student;

public class Main {
    public static void main(String[] args) {

        GroupServiceImpl groupService = new GroupServiceImpl(new Database());
        StudentServiceImpl studentService = new StudentServiceImpl(new Database());
        Group group1 = new Group(1,"Java-9","In the best group",2023);
        Group group2 = new Group(2,"JavaScript","Frontend group",2022);

        Student student1 = new Student("Ruslan",20, Gender.MALE);
        Student student2 = new Student("Abdymomun",17, Gender.MALE);
        Student student3 = new Student("Kanykey",16, Gender.FEMALE);
        Student[] students = {student1,student2,student3};

    }
}
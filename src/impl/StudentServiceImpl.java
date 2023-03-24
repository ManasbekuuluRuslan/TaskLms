package impl;

import db.Database;
import model.Group;
import model.Student;
import service.StudentService;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private Database database;

    public StudentServiceImpl(Database database) {
        this.database = database;
    }


    @Override
    public String addStudent(Student student) {
        database.getStudents().add(student);
        return "Student added successfully.";
    }

    @Override
    public Student getStudentById(int id) {
        Student student = database.getStudents().stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElse(null);

        return student != null ? student.getName()+"ff";
    }

    @Override
    public List<Student> getAllStudents() {
        return database.getStudents();
    }

    @Override
    public String updateStudentFullName(int id, String fullName) {
        Student student = database.getStudents().stream()
                .filter(g -> g.getFullName() == fullName)
                .findFirst()
                .orElse(null);

        if (student != null) {
            student.setFullName(fullName);
            return "Студенттин аты ийгиликтүү жаңыртылды";
        } else {
            return "Студент табылган жок";
        }
    }

    @Override
    public List<Student> filterByGender() {
        return null;
    }

    @Override
    public void deleteStudentById(int id) {

    }
}

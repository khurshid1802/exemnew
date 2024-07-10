package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements BaseService<Student> {
     List<Student> students = new ArrayList<>();

    @Override
    public Student add(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public List<Student> list() {
        return students;
    }
}

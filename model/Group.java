package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {
    private UUID id;
    private String name;
    private List<Student> studentList = new ArrayList<>();
    String[] studentsOfGroup = {"Azizbek", "Davron", "Jamoliddin", "Xurshid"};

    public Group(String name){
        this.name = name;

        for (int i = 0; i < 4; i++) {
            Student student = new Student();
            student.setName(studentsOfGroup[i]);
            studentList.add(student);
        }
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String[] getStudentsOfGroup() {
        return studentsOfGroup;
    }

    public void setStudentsOfGroup(String[] studentsOfGroup) {
        this.studentsOfGroup = studentsOfGroup;
    }
}

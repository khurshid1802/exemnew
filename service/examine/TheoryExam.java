package service.examine;

import model.Group;
import model.Modul;
import model.Score;
import model.Student;
import model.enums.MentorStrategy;

import java.util.List;
import java.util.Random;

public class TheoryExam implements Exam {
     Random random = new Random();
    @Override
    public void execute(Modul modul) {
        MentorStrategy mentorStrategy = modul.getMentorStrategy();
        Group group = modul.getGroup();
        if (group != null){
            List<Student> studentList = group.getStudentList();
            if (studentList != null){
                for (Student student : studentList){
                    if (student != null){
                        Score score =  new Score();
                        int rand = random.nextInt(mentorStrategy.getTheory());
                        score.setQuantity(rand);
                        score.setName("theory");
                        score.setModuleType(modul.getModuleType());
                        student.setScores(score);
                    }
                }
            }
        }
    }
}

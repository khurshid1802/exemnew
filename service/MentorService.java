package service;
import model.Group;
import model.Mentor;
import model.Score;
import model.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MentorService implements BaseService<Mentor> {
    public List<Mentor> mentors = new ArrayList<>();

    @Override
    public Mentor add(Mentor mentor) {
        mentors.add(mentor);
        return mentor;
    }

    @Override
    public List<Mentor> list() {
        return mentors;
    }

    public Map<Mentor, int[]> printMentorResult(List<Group> groups) {
        Map<Mentor, int[]> mentorResult = new HashMap<>();
        for (Group group : groups) {
            List<Student> students = group.getStudentList();
            for (Student student : students) {
                for (Score score : student.getScores()) {
                    Mentor mentor = score.getMentor();
                    int[] result = mentorResult.getOrDefault(mentor, new int[2]);
                    result[1]++;
                    if (score.getQuantity() > 60) {
                        result[0]++;
                    }
                    mentorResult.put(mentor, result);
                }
            }
        }
        return mentorResult;
    }
}

package service;

import model.Modul;
import model.enums.MentorStrategy;
import service.examine.Exam;
import service.examine.ExtraBonus;
import service.examine.PracticeExam;
import service.examine.TheoryExam;

public class ExamineService {
    private static class Node{
        private Exam exam;
        private Node next;

        public Node(Exam exam){
            this.exam = exam;
        }
    }
    private Node first;
    private Node last;

    public void takeExamine(Modul modul) {
        setExams(modul.getMentorStrategy());
        Node temp;
        while (first != null){
            temp = first.next;
            first.exam.execute(modul);
            first.next = null;
            first = temp;
        }
    }

    private void setExams(MentorStrategy mentorStrategy){
        if (mentorStrategy == MentorStrategy.ALL){
            addExam(new PracticeExam());
            addExam(new ExtraBonus());
            addExam(new TheoryExam());
        } else if(mentorStrategy == MentorStrategy.ONLY_PRACTISE){
           addExam(new PracticeExam());
        } else if(mentorStrategy == MentorStrategy.PRACTISE_AND_THEORY){
            addExam(new PracticeExam());
            addExam(new TheoryExam());
        }
    }

    private void addExam(Exam exam) {
        Node node = new Node(exam);
        if (last == null){
            first = last = node;
        }else {
            last.next = node;
            last = node;
        }
    }
}


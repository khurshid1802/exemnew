import model.*;
import model.enums.MentorStrategy;
import model.enums.ModuleType;
import service.ExamineService;
import service.GroupService;
import service.MentorService;
import service.ModulService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);
    static GroupService groupService = new GroupService();
    static MentorService mentorService = new MentorService();
    static ModulService modulService = new ModulService();

    public static void main(String[] args) {
        int step = 1;
        while (step != 0) {
            System.out.println("1. Add Group. 2. Add Mentor. 3. Exam. 4. Exam results. 5. Mentor result. 0. Exit. ");
            step = scannerInt.nextInt();
            switch (step) {
                case 1 -> {
                    System.out.print("enter group name: ");
                    String groupName = scannerStr.nextLine();
                    Group group = new Group(groupName);
                    groupService.add(group);
                }
                case 2 -> {
                    System.out.print("enter mentor's name: ");
                    String mentorName = scannerStr.nextLine();
                    Mentor mentor = new Mentor(mentorName);
                    mentorService.add(mentor);
                }
                case 3 -> {
                    Modul modul = new Modul();
                    int i = 1;
                    List<Group> list = groupService.list();
                    for (Group group : list) {
                        System.out.println(i++ + " " + group.getName());
                    }
                    System.out.print("choose the group: ");
                    int updateGroup = scannerInt.nextInt();
                    Group group = groupService.groups.get(updateGroup - 1);
                    modul.setGroup(group);

                    int j = 1;
                    List<Mentor> mentors = mentorService.list();
                    for (Mentor mentor : mentors) {
                        System.out.println(j++ + " " + mentor.getName());
                    }
                    System.out.print("choose mentor: ");
                    int chooseGroup = scannerInt.nextInt();
                    Mentor mentor = mentorService.mentors.get(chooseGroup - 1);
                    modul.setMentor(mentor);

                    System.out.println("1.Module FIRST.");
                    System.out.println("2.Module SECOND.");
                    System.out.println("3.Module THIRD.");
                    System.out.print("which module you want to take an exam: ");
                    int chooseModule = scannerInt.nextInt();
                    switch (chooseModule){
                        case 1 -> modul.setModuleType(ModuleType.FIRST);

                        case 2 -> modul.setModuleType(ModuleType.SECOND);

                        case 3 -> modul.setModuleType(ModuleType.THIRD);
                    }

                    System.out.println("1.All.");
                    System.out.println("2.Only-practise.");
                    System.out.println("3.Practise and theory.");
                    System.out.print("which exam strategy you want to choose: ");
                    int strategyChoiceExam = scannerInt.nextInt();
                    switch (strategyChoiceExam){
                        case 1 -> modul.setMentorStrategy(MentorStrategy.ALL);

                        case 2 -> modul.setMentorStrategy(MentorStrategy.ONLY_PRACTISE);

                        case 3 -> modul.setMentorStrategy(MentorStrategy.PRACTISE_AND_THEORY);
                    }
                    modulService.add(modul);
                    ExamineService examineService = new ExamineService();
                    examineService.takeExamine(modul);
                }
                case 4 -> {
                    int i = 1;
                    List<Group> list = groupService.list();
                    for (Group group : list) {
                        System.out.println(i++ + " " + group.getName());
                    }
                    System.out.print("choose the group: ");
                    int updateGroup = scannerInt.nextInt();
                    Group group = groupService.groups.get(updateGroup - 1);

                    List<Modul> moduls = modulService.list();
                    for (Modul modul : moduls) {
                        System.out.println(modul.getMentor().getName());
                        System.out.println(modul.getModuleType());
                        int j = 1;
                        List<Student> studentGroup = group.getStudentList();
                        for (Student student : studentGroup) {
                            List<Score> scores = student.getScores();
                            int totalScore = 0;
                            System.out.print(j++ + " Name: " + student.getName() + "\t\t");
                            for (Score score : scores) {
                                if (modul.getModuleType() == score.getModuleType()) {
                                    totalScore += score.getQuantity();
                                    System.out.print(score.getName() + " = " + score.getQuantity() + "\t\t");
                                }
                            }
                            System.out.print(" Total Score: " + totalScore + "\t\t");
                            if (totalScore > 60){
                                System.out.println("\u001B[32mPassed\u001B[0m");
                            }else {
                                System.out.println("\u001B[31mNot Passed\u001B[0m");
                            }
                        }
                    }
                }
                case 5 -> {
                 List<Group> groups = groupService.list();
                    Map<Mentor, int[] > mentorResult = mentorService.printMentorResult(groups);

                    Map<Mentor, String> mentorRating = new HashMap<>();
                    for (Map.Entry<Mentor, int[]> entry : mentorResult.entrySet()){
                        Mentor mentor = entry.getKey();
                        int[] result = entry.getValue();
                        double percentage = (double) result[0] / result[1] * 100;

                        String rating;
                        if (percentage < 50){
                            rating = "Bad";
                        } else if (percentage < 85) {
                            rating = "Good";
                        }else {
                           rating = "Excellent";
                        }
                        mentorRating.put(mentor,rating);
                    }

                    for (Map.Entry<Mentor, int[]> entry : mentorResult.entrySet()){
                        Mentor mentor = entry.getKey();
                        int[] result = entry.getValue();
                        double percentage = (double) result[0] / result[1] * 100;

                        System.out.println("Mentor: " + mentor.getName());
                        System.out.println("Passed: %.2f%%\n", percentage);
                        System.out.println("Rating: " + mentorResult.get(mentor));
                    }
                }
            }
        }
    }
}

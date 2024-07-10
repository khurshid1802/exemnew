package model;

import model.enums.MentorStrategy;
import model.enums.ModuleType;

public class Modul {
    private Mentor mentor;
    private ModuleType moduleType;
    private Group group;
    private MentorStrategy mentorStrategy;

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public MentorStrategy getMentorStrategy() {
        return mentorStrategy;
    }

    public void setMentorStrategy(MentorStrategy mentorStrategy) {
        this.mentorStrategy = mentorStrategy;
    }
}

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Student {
    private UUID id;
    private String name;
    private UUID groupId;
    List<Score> scores = new ArrayList<>();

    public List<Score> getScores() {
        return scores;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public void setScores(Score score) {
        this.scores.add(score);
    }
}

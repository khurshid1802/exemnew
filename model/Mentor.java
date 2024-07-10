package model;

import model.enums.MentorStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Mentor {
    private UUID id;
    private String name;
    List<Mentor> mentors = new ArrayList<>();

    public Mentor(String name) {
        this.name = name;
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

}

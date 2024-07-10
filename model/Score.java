package model;

import model.enums.ModuleType;

import java.util.UUID;

public class Score {
    private String name;
    private int quantity;
    private ModuleType moduleType;
    private Mentor mentor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public Mentor getMentor() {
        return mentor;
    }
}

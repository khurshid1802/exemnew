package model.enums;

public enum MentorStrategy {
    ALL(40, 40, 20),
    ONLY_PRACTISE(100, 0, 0),
    PRACTISE_AND_THEORY(50, 0, 50);

    MentorStrategy(int p, int e, int t) {
        this.practice = p;
        this.extra = e;
        this.theory = t;
    }

    private final int practice;
    private final int extra;
    private final int theory;

    public int getPractice() {
        return practice;
    }

    public int getExtra() {
        return extra;
    }

    public int getTheory() {
        return theory;
    }
}

package model;

public class Subject {
    private String name;
    private int credits;
    private double marks;

    public Subject(String name, int credits, double marks) {
        this.name = name;
        this.credits = credits;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
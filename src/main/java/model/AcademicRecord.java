package model;

import java.util.HashMap;

public abstract class AcademicRecord {
    protected HashMap<String, Subject> subjects = new HashMap<>();

    public abstract double getTotalMarks();

    public abstract void displayDetails();
}
package service;

import model.*;
import java.util.ArrayList;

public class GradeService {
    public static final double PASS_MARK = 40;

    public String getGrade(double marks) {
        if (marks >= 90) return "O";
        if (marks >= 80) return "A+";
        if (marks >= 70) return "A";
        if (marks >= 60) return "B+";
        if (marks >= 50) return "B";
        if (marks >= 40) return "C";
        return "F";
    }

    public int getPoints(double marks) {
        if (marks >= 90) return 10;
        if (marks >= 80) return 9;
        if (marks >= 70) return 8;
        if (marks >= 60) return 7;
        if (marks >= 50) return 6;
        if (marks >= 40) return 5;
        return 0;
    }

    public boolean isPass(SemesterRecord r) {
        for (Subject s : r.getSubjects().values()) {
            if (s.getMarks() < PASS_MARK) {
                return false;
            }
        }
        return !r.getSubjects().isEmpty();
    }

    public double calculateSGPA(SemesterRecord r) {
        double total = 0;
        int credits = 0;

        for (Subject s : r.getSubjects().values()) {
            total += s.getCredits() * getPoints(s.getMarks());
            credits += s.getCredits();
        }

        return credits == 0 ? 0 : total / credits;
    }

    public double calculateCGPA(Student student) {
        double total = 0;
        int credits = 0;

        for (SemesterRecord r : student.getRecords().values()) {
            for (Subject s : r.getSubjects().values()) {
                total += s.getCredits() * getPoints(s.getMarks());
                credits += s.getCredits();
            }
        }

        return credits == 0 ? 0 : total / credits;
    }

    public void showGrades(SemesterRecord r) {
        ArrayList<String> failed = new ArrayList<>();

        for (Subject s : r.getSubjects().values()) {
            System.out.println(s.getName() + ": " +
                    getGrade(s.getMarks()));

            if (s.getMarks() < PASS_MARK) {
                failed.add(s.getName());
            }
        }

        System.out.println("Result: " + (isPass(r) ? "PASS" : "FAIL"));

        if (!failed.isEmpty()) {
            System.out.println("Failed subjects: " + failed);
        }
    }
}
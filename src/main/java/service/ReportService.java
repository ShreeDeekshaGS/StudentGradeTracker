package service;

import model.*;

public class ReportService {
    private GradeService gs = new GradeService();

    public void generate(Student s, SemesterRecord r) {
        System.out.println("\n======= STUDENT REPORT CARD =======");
        System.out.println(s);
        System.out.println("Semester: " + r.getSemester());

        System.out.println("\nSubject\tCredits\tMarks\tGrade\tPoints");

        for (Subject sub : r.getSubjects().values()) {
            System.out.println(
                sub.getName() + "\t" +
                sub.getCredits() + "\t" +
                sub.getMarks() + "\t" +
                gs.getGrade(sub.getMarks()) + "\t" +
                gs.getPoints(sub.getMarks())
            );
        }

        System.out.println("Total: " + r.getTotalMarks());
        System.out.println("Percentage: " + r.getPercentage() + "%");
        System.out.println("SGPA: " + gs.calculateSGPA(r));
        System.out.println("CGPA: " + gs.calculateCGPA(s));
        System.out.println("Result: " + (gs.isPass(r) ? "PASS" : "FAIL"));
    }
}
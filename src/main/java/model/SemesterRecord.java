
package model;

import java.util.HashMap;

public class SemesterRecord extends AcademicRecord {

    private int semester;

    public SemesterRecord(int semester) {
        this.semester = semester;
    }

    public int getSemester() {
        return semester;
    }

    public HashMap<String, Subject> getSubjects() {
        return subjects;
    }

    @Override
    public double getTotalMarks() {
        double total = 0;

        for (Subject s : subjects.values()) {
            total += s.getMarks();
        }

        return total;
    }

    public double getPercentage() {
        if (subjects.isEmpty()) {
            return 0;
        }

        return getTotalMarks() / subjects.size();
    }

    @Override
    public void displayDetails() {
        System.out.println("Semester: " + semester);

        for (Subject s : subjects.values()) {
            System.out.println(s.getName() + " - " + s.getMarks());
        }
    }
}

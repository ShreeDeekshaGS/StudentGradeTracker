package app;

import model.*;
import service.*;
import exceptions.*;
import util.InputUtil;

public class Main {

    static StudentService students = new StudentService();
    static MarksService marks = new MarksService();
    static GradeService grades = new GradeService();
    static ReportService reports = new ReportService();
    static SeatingService seating = new SeatingService();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Details");
            System.out.println("5. Manage Subject Marks");
            System.out.println("6. Calculate Total and Percentage");
            System.out.println("7. Grade and Result");
            System.out.println("8. Calculate SGPA and CGPA");
            System.out.println("9. Generate Report Card");
            System.out.println("10. Assign Exam Room");
            System.out.println("11. Allocate Seat Number");
            System.out.println("0. Exit");

            int choice = InputUtil.readInt("Enter choice: ");

            try {
                switch (choice) {

                    case 1:
                        int id = InputUtil.readInt("Student ID: ");
                        String name = InputUtil.readString("Name: ");
                        String dept = InputUtil.readString("Department: ");
                        int year = InputUtil.readInt("Year: ");
                        int sem = InputUtil.readInt("Current Semester: ");

                        Student s = new Student(id, name, dept, year, sem);
                        students.register(s);
                        break;

                    case 2:
                        students.viewAll();
                        break;

                    case 3:
                        id = InputUtil.readInt("Enter Student ID: ");
                        s = students.search(id);

                        System.out.println(s == null
                                ? "Student not found."
                                : s);
                        break;

                    case 4:
                        id = InputUtil.readInt("Student ID: ");
                        name = InputUtil.readString("New Name: ");
                        dept = InputUtil.readString("New Department: ");
                        year = InputUtil.readInt("New Year: ");
                        sem = InputUtil.readInt("New Semester: ");

                        students.update(id, name, dept, year, sem);
                        break;

                    case 5:
                        s = findStudent();
                        if (s != null) {
                            sem = InputUtil.readInt("Semester: ");
                            String subject = InputUtil.readString("Subject: ");
                            int credits = InputUtil.readInt("Credits: ");
                            double score = InputUtil.readDouble("Marks: ");

                            marks.addMarks(s, sem, subject, credits, score);
                        }
                        break;

                    case 6:
                        s = findStudent();
                        if (s != null) {
                            SemesterRecord r = findRecord(s);
                            if (r != null) {
                                System.out.println("Total Marks: " + r.getTotalMarks());
                                System.out.println("Percentage: " + r.getPercentage() + "%");
                            }
                        }
                        break;

                    case 7:
                        s = findStudent();
                        if (s != null) {
                            SemesterRecord r = findRecord(s);
                            if (r != null) {
                                grades.showGrades(r);
                            }
                        }
                        break;

                    case 8:
                        s = findStudent();
                        if (s != null) {
                            SemesterRecord r = findRecord(s);
                            if (r != null) {
                                System.out.println("SGPA: " +
                                        grades.calculateSGPA(r));

                                System.out.println("CGPA: " +
                                        grades.calculateCGPA(s));
                            }
                        }
                        break;

                    case 9:
                        s = findStudent();
                        if (s != null) {
                            SemesterRecord r = findRecord(s);
                            if (r != null) {
                                reports.generate(s, r);
                            }
                        }
                        break;

                    case 10:
                        s = findStudent();
                        if (s != null) {
                            String room = InputUtil.readString("Room Number: ");
                            seating.assignRoom(s, room);
                        }
                        break;

                    case 11:
                        s = findStudent();
                        if (s != null) {
                            int seat = InputUtil.readInt("Seat Number: ");
                            seating.allocateSeat(s, seat);
                        }
                        break;

                    case 0:
                        System.out.println("Exiting Student Grade Tracker.");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (GradeTrackerException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static Student findStudent() {
        int id = InputUtil.readInt("Enter Student ID: ");
        Student s = students.search(id);

        if (s == null) {
            System.out.println("Student not found.");
        }

        return s;
    }

    static SemesterRecord findRecord(Student s) {
        int sem = InputUtil.readInt("Enter Semester: ");
        SemesterRecord r = s.getRecords().get(sem);

        if (r == null || r.getSubjects().isEmpty()) {
            System.out.println("No marks found for this semester.");
        }

        return r;
    }
}
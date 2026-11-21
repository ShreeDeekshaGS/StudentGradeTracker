package model;

import java.util.HashMap;
import exceptions.InvalidStudentException;

public class Student {
    private int studentId;
    private String name;
    private String department;
    private int year;
    private int currentSemester;

    private HashMap<Integer, SemesterRecord> records =
            new HashMap<>();

    public Student(int id, String name, String department,
                   int year, int semester)
                   throws InvalidStudentException {

        if (id <= 0) {
            throw new InvalidStudentException("Invalid Student ID");
        }

        studentId = id;
        updateDetails(name, department, year, semester);
    }

    public void updateDetails(String name, String department,
                              int year, int semester)
                              throws InvalidStudentException {

        if (name.isBlank() || department.isBlank()
                || year <= 0 || semester <= 0) {
            throw new InvalidStudentException("Invalid student details");
        }

        this.name = name;
        this.department = department;
        this.year = year;
        this.currentSemester = semester;
    }

    public int getStudentId() {
        return studentId;
    }

    public HashMap<Integer, SemesterRecord> getRecords() {
        return records;
    }

    public String toString() {
        return "ID: " + studentId +
                " | Name: " + name +
                " | Department: " + department +
                " | Year: " + year +
                " | Semester: " + currentSemester;
    }
}
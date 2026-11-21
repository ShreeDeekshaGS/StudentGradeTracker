package service;

import datastructures.*;
import model.Student;
import exceptions.*;

public class StudentService {
    private StudentList list = new StudentList();
    private StudentIdSet ids = new StudentIdSet();

    public void register(Student s)
            throws DuplicateStudentException {

        if (!ids.add(s.getStudentId())) {
            throw new DuplicateStudentException(
                "Student ID already exists."
            );
        }

        list.add(s);
        System.out.println("Student registered successfully.");
    }

    public void viewAll() {
        if (list.getAll().isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : list.getAll()) {
            System.out.println(s);
        }
    }

    public Student search(int id) {
        return list.search(id);
    }

    public void update(int id, String name, String dept,
                       int year, int semester)
                       throws GradeTrackerException {

        Student s = search(id);

        if (s == null) {
            throw new InvalidStudentException("Student not found.");
        }

        s.updateDetails(name, dept, year, semester);
        System.out.println("Student details updated.");
    }
}
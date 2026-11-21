package datastructures;

import java.util.ArrayList;
import model.Student;

public class StudentList {
    private ArrayList<Student> students = new ArrayList<>();

    public void add(Student s) {
        students.add(s);
    }

    public ArrayList<Student> getAll() {
        return students;
    }

    // Linear Search
    public Student search(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id) {
                return s;
            }
        }

        return null;
    }
}
package service;

import model.*;
import exceptions.*;

public class MarksService {

    public void addMarks(Student s, int semester,
                         String subject, int credits,
                         double marks)
                         throws InvalidMarksException {

        if (semester <= 0 || subject.isBlank()
                || credits <= 0 || marks < 0 || marks > 100) {
            throw new InvalidMarksException("Invalid marks details.");
        }

        SemesterRecord record = s.getRecords().get(semester);

        if (record == null) {
            record = new SemesterRecord(semester);
            s.getRecords().put(semester, record);
        }

        record.getSubjects().put(
            subject,
            new Subject(subject, credits, marks)
        );

        System.out.println("Marks saved successfully.");
    }
}
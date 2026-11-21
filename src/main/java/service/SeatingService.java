package service;

import java.util.HashMap;
import model.Student;

public class SeatingService {
    private HashMap<Integer, String> rooms = new HashMap<>();
    private HashMap<Integer, Integer> seats = new HashMap<>();

    // Feature 1: Assign room number
    public void assignRoom(Student s, String room) {
        rooms.put(s.getStudentId(), room);
        System.out.println("Room assigned successfully.");
    }

    // Feature 2: Allocate seat number
    public void allocateSeat(Student s, int seat) {
        seats.put(s.getStudentId(), seat);
        System.out.println("Seat allocated successfully.");
    }
}
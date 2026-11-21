package datastructures;

import java.util.HashSet;

public class StudentIdSet {
    private HashSet<Integer> ids = new HashSet<>();

    public boolean add(int id) {
        return ids.add(id);
    }
}
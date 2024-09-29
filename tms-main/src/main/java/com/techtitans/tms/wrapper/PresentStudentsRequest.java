package com.techtitans.tms.wrapper;

import java.util.List;

public class PresentStudentsRequest {
    private List<Integer> present;  // List of present student IDs

    // Getters and setters
    public List<Integer> getPresent() {
        return present;
    }

    public void setPresent(List<Integer> present) {
        this.present = present;
    }
}

package com.techtitans.tms.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtitans.tms.model.Attendance;
import com.techtitans.tms.model.Students;
import com.techtitans.tms.repository.AttendanceRepo;
import com.techtitans.tms.repository.StudentRepo;


@Service
public class AttendanceService {

    @Autowired
    AttendanceRepo attendanceRepo;

    @Autowired
    private StudentRepo studentsRepo;

    // Method to update attendance counts based on the present students
    public void incrementAttendanceCount(List<Integer> presentIds)
    {
        // Step 1: Get all present students from the database
        List<Students> presentStudents = studentsRepo.findAllById(presentIds);

        // Step 2: For each student, check and update the attendance
        for (Students student : presentStudents) {
            // Fetch the attendance for the current student
            Optional<Attendance> optionalAttendance = attendanceRepo.findByStudentIdIn(List.of(student.getId()))
                                                                    .stream().findFirst();

            if (optionalAttendance.isPresent()) {
                // If attendance record exists, increment the count
                Attendance attendance = optionalAttendance.get();
                attendance.setCount(attendance.getCount() + 1);
            } else {
                // If no record exists, create a new one with count = 1
                Attendance newAttendance = new Attendance();
                newAttendance.setStudent(student);
                newAttendance.setCount(1);
                attendanceRepo.save(newAttendance);
            }
        }

        // Save all updated attendance records
        attendanceRepo.saveAll(attendanceRepo.findByStudentIdIn(presentIds));
    }
}

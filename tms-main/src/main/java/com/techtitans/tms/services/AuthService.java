package com.techtitans.tms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtitans.tms.model.Students;
import com.techtitans.tms.model.Teachers;
import com.techtitans.tms.repository.StudentRepo;
import com.techtitans.tms.repository.TeacherRepo;

@Service
public class AuthService {

    @Autowired
    TeacherRepo teacherRepo;

    @Autowired
    StudentRepo studentRepo;

    public boolean authenticateTeacher(String username, String password) {
        // Find user by username
        Teachers teacher = teacherRepo.findByEmail(username);

        if (teacher != null) {
            // Check if the password matches
            return password.equals(teacher.getPassword()); 
        }
        return false;
    }

    public boolean authenticateStudent(String username, String password) {
        // Find user by username
        Students student = studentRepo.findByEmail(username);

        if (student != null) {
            // Check if the password matches
            return password.equals(student.getPassword()); 
        }
        return false;
    }

}

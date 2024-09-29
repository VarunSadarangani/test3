package com.techtitans.tms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import com.techtitans.tms.model.Teachers;
import com.techtitans.tms.repository.TeacherRepo;

@Service
public class TeacherService {

    @Autowired
    TeacherRepo teacherRepo;

    
    public Teachers getTeacherById(int id)
    {
        return teacherRepo.findById(id).orElse(null);
    }

    public void saveTeacher(Teachers teacher)
    {
        teacherRepo.save(teacher);
    }
}

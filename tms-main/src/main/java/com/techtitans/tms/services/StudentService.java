package com.techtitans.tms.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtitans.tms.model.Students;
import com.techtitans.tms.repository.StudentRepo;
import com.techtitans.tms.wrapper.StudentDTO;

@Service
public class StudentService {


    @Autowired
    StudentRepo studentRepo;

    public List<StudentDTO> getAllStudents()
    {
        return studentRepo.findAll().stream()
                .map(student -> new StudentDTO(student.getId(),student.getName(),student.getEmail(),student.getStd()))
                .collect(Collectors.toList());
    }

}

package com.techtitans.tms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtitans.tms.model.Homework;

import com.techtitans.tms.repository.HomeworkRepo;

@Service
public class HomeworkService {

    @Autowired
    HomeworkRepo homeworkRepo;

    public void saveHomework(Homework homework)
    {
        homeworkRepo.save(homework);
    }

    public List<Homework> getAllHomework()
    {
        return homeworkRepo.findAll();
    }
}

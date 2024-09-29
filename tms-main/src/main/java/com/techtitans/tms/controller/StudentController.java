package com.techtitans.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techtitans.tms.model.Announcement;
import com.techtitans.tms.model.Homework;
import com.techtitans.tms.services.AnnouncementService;
import com.techtitans.tms.services.HomeworkService;



@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    AnnouncementService announcementService;

    @Autowired
    HomeworkService homeworkService;

    @GetMapping("/announcement")
    public List<Announcement> allAnnouncement()
    {
        List<Announcement> announcements = announcementService.getAllAnnouncement();
        return announcements;
    }


    @GetMapping("/homework")
    public List<Homework> allhomework()
    {
        List<Homework> homeworks = homeworkService.getAllHomework();
        return homeworks;
    }



}

package com.techtitans.tms.controller;

import com.techtitans.tms.model.Announcement;
import com.techtitans.tms.model.Homework;
import com.techtitans.tms.model.Students;

import com.techtitans.tms.model.Teachers;
import com.techtitans.tms.services.AnnouncementService;
import com.techtitans.tms.services.AttendanceService;
import com.techtitans.tms.services.HomeworkService;
import com.techtitans.tms.services.StudentService;
import com.techtitans.tms.services.TeacherService;
import com.techtitans.tms.wrapper.PresentStudentsRequest;
import com.techtitans.tms.wrapper.StudentDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    AnnouncementService announcementService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    AttendanceService attendanceService;

    @Autowired
    HomeworkService homeworkService;

    @PostMapping("/register")
    public String registerTeacher(@RequestBody Teachers teacher)
    {
        teacherService.saveTeacher(teacher);
        return "teacher registered";
    }

    //geting specific sub when cliked from home
    // @GetMapping("/home/{id}")
    // public String subject(@PathVariable int id)
    // {
    //     System.out.println(id);
    //     return "welcome to subject:";
    // }

    // @PostMapping("/home/subdetail")
    // public String addSubDetail(@RequestBody Subject subject)
    // {
    //     System.out.println(subject);
    //     return "subject added to DB..";
    // }

    //giving all studs for DB for attendance
    @GetMapping("/attendance")
    public List<StudentDTO> studentsAttendance()
    {
        List<StudentDTO>students = studentService.getAllStudents();
        return students;
    }

    @PostMapping("/attendance")
    public void attendanceControl(@RequestBody PresentStudentsRequest presentRequest){
        List<Integer> presentIds = presentRequest.getPresent();
        attendanceService.incrementAttendanceCount(presentIds);
    }


    @PostMapping("/announcement")
    public void announcement(@RequestBody Announcement data){
        announcementService.saveAnnouncement(data);
    }

    //get all student at student page..
    @GetMapping("/students")
    public List<StudentDTO> AllStudents()
    {
        return studentService.getAllStudents();
    }

    //profile page
    @GetMapping("/profile/{id}")
    public Teachers profile(@PathVariable int id)
    {
        return teacherService.getTeacherById(id);
    }

    @PostMapping("/homework")
    public void addHomework(@RequestBody Homework homework)
    {
        homeworkService.saveHomework(homework);
    }
    
}

package com.techtitans.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techtitans.tms.model.Attendance;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance,Integer>
{
         // Custom method to find attendance by student IDs
         List<Attendance> findByStudentIdIn(List<Integer> studentIds);
}

package com.techtitans.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techtitans.tms.model.Teachers;

@Repository
public interface TeacherRepo extends JpaRepository<Teachers,Integer> {

    Teachers findByEmail(String email);

}

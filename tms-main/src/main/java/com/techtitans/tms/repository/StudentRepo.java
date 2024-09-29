package com.techtitans.tms.repository;

import org.springframework.stereotype.Repository;

import com.techtitans.tms.model.Students;
import com.techtitans.tms.model.Teachers;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepo extends JpaRepository<Students,Integer> {

    Students findByEmail(String email);
}

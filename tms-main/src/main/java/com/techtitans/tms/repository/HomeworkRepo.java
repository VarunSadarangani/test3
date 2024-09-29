package com.techtitans.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techtitans.tms.model.Homework;

@Repository
public interface HomeworkRepo extends JpaRepository<Homework, Integer> {

}

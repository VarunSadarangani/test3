package com.techtitans.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techtitans.tms.model.Announcement;

@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement,Integer> {

}

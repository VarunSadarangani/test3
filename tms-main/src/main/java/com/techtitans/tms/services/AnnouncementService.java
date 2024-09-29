package com.techtitans.tms.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtitans.tms.model.Announcement;
import com.techtitans.tms.repository.AnnouncementRepo;

@Service
public class AnnouncementService {

    @Autowired
    AnnouncementRepo announcementRepo;

    public void saveAnnouncement(Announcement data)
    {
        announcementRepo.save(data);
    }

    public List<Announcement> getAllAnnouncement()
    {
        return announcementRepo.findAll();
    }
}

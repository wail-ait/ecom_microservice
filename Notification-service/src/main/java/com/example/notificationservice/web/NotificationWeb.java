package com.example.notificationservice.web;


import com.example.notificationservice.entities.Notification;
import com.example.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
//@RequestMapping("/api/v1")
@Component
public class NotificationWeb {

    @Autowired
    NotificationRepository notificationRepository;

    //method to get all the notifications
    @GetMapping("/notifications")
    public List<Notification> getNotifications(){
        return notificationRepository.findAll();
    }

    //method to get the last notification if exists
    @GetMapping("/last-notification")
    public Notification getLastNotification() {
        List<Notification> allNotifications = getNotifications();
        int size = allNotifications.size();

        // Return the last notification if the list is not empty
        return size > 0 ? allNotifications.get(size - 1) : null;
    }
}
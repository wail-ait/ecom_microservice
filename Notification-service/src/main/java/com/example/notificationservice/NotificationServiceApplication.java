package com.example.notificationservice;

import com.example.notificationservice.config.MQConfig;
import com.example.notificationservice.entities.Notification;
import com.example.notificationservice.event.VenteEvent;
import com.example.notificationservice.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.rabbit.annotation.RabbitListener;


import java.util.UUID;

@SpringBootApplication
@Slf4j
public class  NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @Autowired
    NotificationRepository notificationRepository;


    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(VenteEvent venteEvent) {
        //System.out.println("New vente added , vente Id" + " " + venteEvent.getId_Vente()+" " + venteEvent.getId_Acheteur() + " " + venteEvent.getId_Produit());
        log.info("New vente added , vente Id" + " " + venteEvent.getId_Vente()+" " + venteEvent.getId_Acheteur() + " " + venteEvent.getId_Produit());
        Notification notification = Notification.builder().notificationId(UUID.randomUUID().toString()).id_Acheteur(venteEvent.getId_Acheteur()).description("New sale added").id_Produit(venteEvent.getId_Produit()).build();
        notificationRepository.save(notification);
    }
    /*@KafkaListener(topics = "notificationTopic")
    public void handelNotification(VenteEvent venteEvent) {
        //System.out.println("New vente added , vente Id" + " " + venteEvent.getId_Vente()+" " + venteEvent.getId_Acheteur() + " " + venteEvent.getId_Produit());
        log.info("New vente added , vente Id" + " " + venteEvent.getId_Vente()+" " + venteEvent.getId_Acheteur() + " " + venteEvent.getId_Produit());
        Notification notification = Notification.builder().notificationId(UUID.randomUUID().toString()).id_Acheteur(venteEvent.getId_Acheteur()).description("New sale added").id_Produit(venteEvent.getId_Produit()).build();
        notificationRepository.save(notification);
    }*/
}

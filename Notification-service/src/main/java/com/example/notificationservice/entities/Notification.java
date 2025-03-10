package com.example.notificationservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Notification {
    @Id
    private String notificationId;
    private String description;
    private Integer id_Acheteur;
    private Integer id_Produit;;
}
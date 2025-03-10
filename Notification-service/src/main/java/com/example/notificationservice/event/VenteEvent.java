package com.example.notificationservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VenteEvent {
    private Integer id_Vente;
    private Integer id_Acheteur;
    private Integer id_Produit;
}
package com.example.venteservice.modele;

import lombok.*;

@Data   @AllArgsConstructor     @NoArgsConstructor  @ToString   @Builder
public class Produit {
    private Integer idProduit;
    private String marque;
    private String description;
    private double prix;
    private Integer quantite;
}


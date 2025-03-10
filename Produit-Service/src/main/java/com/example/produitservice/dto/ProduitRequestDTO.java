package com.example.produitservice.dto;

import lombok.*;

@Data       @AllArgsConstructor     @NoArgsConstructor      @ToString       @Builder
public class ProduitRequestDTO {
    private String marque;
    private String description;
    private double prix;
    private Integer quantite;
}

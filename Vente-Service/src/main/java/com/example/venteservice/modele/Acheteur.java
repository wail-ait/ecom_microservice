package com.example.venteservice.modele;

import lombok.*;

@Data       @AllArgsConstructor     @NoArgsConstructor     @ToString    @Builder
public class Acheteur {

    private Integer id_Acheteur;
    private String nom;
    private String ville;

}

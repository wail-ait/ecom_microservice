package com.example.acheteurservice.dto;

import lombok.*;

@Data       @AllArgsConstructor     @NoArgsConstructor      @ToString       @Builder
public class AcheteurReponseDTO {
    private Integer id_Acheteur;
    private String nom;
    private String ville;
}

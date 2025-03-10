package com.example.acheteurservice.dto;

import lombok.*;

@Data       @AllArgsConstructor     @NoArgsConstructor      @ToString       @Builder
public class AcheteurRequestDTO {
    private String nom;
    private String ville;
}

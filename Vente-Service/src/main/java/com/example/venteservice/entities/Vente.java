package com.example.venteservice.entities;

import com.example.venteservice.modele.Acheteur;
import com.example.venteservice.modele.Produit;
import jakarta.persistence.*;
import lombok.*;

@Data       @AllArgsConstructor     @NoArgsConstructor      @ToString       @Builder
@Entity
public class Vente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Vente;
    private Integer id_Acheteur;
    private Integer id_Produit;
    private Integer quantite;
    private Integer mois;
    private Integer annee;
    @Transient
    private Acheteur acheteur;
    @Transient
    private Produit produit;

}

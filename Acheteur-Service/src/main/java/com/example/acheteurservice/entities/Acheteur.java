package com.example.acheteurservice.entities;

import com.example.acheteurservice.modele.Produit;
import jakarta.persistence.*;
import lombok.*;

@Data       @AllArgsConstructor     @NoArgsConstructor     @ToString    @Builder
@Entity
public class Acheteur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Acheteur;
    private String nom;
    private String ville;
    //private Integer idProduit;
    //@Transient
    //private Produit produit;

}

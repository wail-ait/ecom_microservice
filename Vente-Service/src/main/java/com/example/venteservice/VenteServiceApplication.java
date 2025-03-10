package com.example.venteservice;

import com.example.venteservice.entities.Vente;
import com.example.venteservice.repositories.VenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class VenteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VenteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(VenteRepository venteRepository){
        return  args -> {

            Vente ven1= Vente.builder()
                    .id_Acheteur(1)
                    .id_Produit(1)
                    .quantite(15)
                    .mois(11)
                    .annee(2020)
                    .build();

            Vente ven2= Vente.builder()
                    .id_Acheteur(2)
                    .id_Produit(2)
                    .quantite(20)
                    .mois(05)
                    .annee(2021)
                    .build();

            Vente ven3= Vente.builder()
                    .id_Acheteur(3)
                    .id_Produit(3)
                    .quantite(5)
                    .mois(07)
                    .annee(2020)
                    .build();

            Vente ven4= Vente.builder()
                    .id_Acheteur(4)
                    .id_Produit(4)
                    .quantite(5)
                    .mois(03)
                    .annee(2019)
                    .build();

            Vente ven5= Vente.builder()
                    .id_Acheteur(5)
                    .id_Produit(5)
                    .quantite(30)
                    .mois(01)
                    .annee(2022)
                    .build();

            venteRepository.save(ven1);     venteRepository.save(ven2);     venteRepository.save(ven3);
            venteRepository.save(ven4);     venteRepository.save(ven5);

        };
    }

}

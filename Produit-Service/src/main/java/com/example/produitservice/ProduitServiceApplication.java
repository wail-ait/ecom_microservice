package com.example.produitservice;

import com.example.produitservice.config.GlobalConfig;
import com.example.produitservice.entities.Produit;
import com.example.produitservice.repositories.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(proxyBeanMethods = false)
@EnableConfigurationProperties({GlobalConfig.class})
public class ProduitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProduitRepository produitRepository){
        return args -> {
            Produit pr1=Produit.builder()
                    .marque("Firrari LaFirrari")
                    .description("hyper car")
                    .prix(999957474.44567)
                    .quantite(5)
                    .build();

            Produit pr2=Produit.builder()
                    .marque("Aston Martin")
                    .description("super car")
                    .prix(72562.24530)
                    .quantite(20)
                    .build();

            Produit pr3=Produit.builder()
                    .marque("Mawirati")
                    .description("luxery car")
                    .prix(1243534.0643)
                    .quantite(15)
                    .build();

            Produit pr4=Produit.builder()
                    .marque("Supera")
                    .description("super car")
                    .prix(4512451.054)
                    .quantite(10)
                    .build();

            Produit pr5=Produit.builder()
                    .marque("Dacia")
                    .description("All Most a car")
                    .prix(345.240)
                    .quantite(100)
                    .build();

            produitRepository.save(pr1);       produitRepository.save(pr2);
            produitRepository.save(pr3);       produitRepository.save(pr4);
            produitRepository.save(pr5);
        };
    }

}

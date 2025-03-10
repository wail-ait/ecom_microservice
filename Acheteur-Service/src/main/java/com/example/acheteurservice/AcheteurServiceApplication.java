package com.example.acheteurservice;

import com.example.acheteurservice.entities.Acheteur;
import com.example.acheteurservice.repositories.AcheteurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class AcheteurServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcheteurServiceApplication.class, args);
    }

        @Bean
        CommandLineRunner start(AcheteurRepository AcheteurtRepository) {
            return args -> {
                Acheteur ach1=Acheteur.builder()
                        .nom("Wail AH")
                        .ville("Rabat")
                        //.idProduit(1)
                        .build();

                Acheteur ach2=Acheteur.builder()
                        .nom("Jamal AH")
                        .ville("Munich")
                        //.idProduit(2)
                        .build();

                Acheteur ach3=Acheteur.builder()
                        .nom("Loay BH")
                        .ville("Sale")
                        //.idProduit(3)
                        .build();

                Acheteur ach4=Acheteur.builder()
                        .nom("Iyad BH")
                        .ville("Sale")
                        //.idProduit(4)
                        .build();

                Acheteur ach5=Acheteur.builder()
                        .nom("Arwa")
                        .ville("Sale")
                        //.idProduit(5)
                        .build();

                AcheteurtRepository.save(ach1);      AcheteurtRepository.save(ach2);
                AcheteurtRepository.save(ach3);      AcheteurtRepository.save(ach4);
                AcheteurtRepository.save(ach5);
            };
        }
    }
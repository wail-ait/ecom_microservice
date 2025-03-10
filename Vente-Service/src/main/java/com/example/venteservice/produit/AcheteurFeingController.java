package com.example.venteservice.produit;

import com.example.venteservice.modele.Acheteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="ACHETEUR-SERVICE")
public interface AcheteurFeingController {
    @GetMapping("/acheteurs")
    public List<Acheteur> findAll();
    @GetMapping("/acheteurs/{id}")
    public Acheteur findById( @PathVariable("id") Integer id);
}

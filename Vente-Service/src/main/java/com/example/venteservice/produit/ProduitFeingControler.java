package com.example.venteservice.produit;

import com.example.venteservice.modele.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="PRODUIT-SERVICE")
public interface ProduitFeingControler {
    @GetMapping("/produits")
    public List<Produit> findAll();
    @GetMapping("/produits/{id}")
    public Produit findById( @PathVariable("id") Integer id);


}

package com.example.produitservice.web;

import com.example.produitservice.config.GlobalConfig;
import com.example.produitservice.entities.Produit;
import com.example.produitservice.repositories.ProduitRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class ControllerRest {
    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    GlobalConfig globalConfig;

    @GetMapping("/globalConfig")
    public  GlobalConfig globalConfig(){
        return globalConfig;
    }

    //GET to return all the products
    @GetMapping("/produits")
    public List<Produit> getAllProduits(){
        return produitRepository.findAll();
    }

    //GET to return product by it's id
    @GetMapping("/produits/{id}")
    public Produit getByIdProduit(@PathVariable Integer id){
        Produit produit = new Produit();
        produit=produitRepository.findById(id).get();
        return produit;
    }

    //POST to add a new product
    @PostMapping("/produits")
    public void ajouter(@RequestBody Produit produit){
        produitRepository.save(produit);
    }

    //PUT to update a product
    @PutMapping("/produits/{id}")
    public void updatet(@PathVariable Integer id,@RequestBody Produit produit){
        Produit produit1=produitRepository.findById(id).get();
        if(produit.getMarque()!=null) produit1.setMarque(produit.getMarque());
        if(produit.getDescription()!=null) produit1.setDescription(produit.getDescription());
        if(produit.getPrix()!=0) produit1.setPrix(produit.getPrix());
        if(produit.getQuantite()!=0) produit1.setQuantite(produit.getQuantite());
        produitRepository.save(produit1);
    }

    //DELETE to delete a product from the database
    @DeleteMapping("/produits/{id}")
    public void delete(@PathVariable Integer id){
        produitRepository.deleteById(id);
    }
}

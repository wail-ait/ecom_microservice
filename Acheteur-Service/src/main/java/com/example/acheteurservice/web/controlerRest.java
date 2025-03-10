package com.example.acheteurservice.web;

import com.example.acheteurservice.entities.Acheteur;
import com.example.acheteurservice.modele.Produit;
import com.example.acheteurservice.produits.ProduitFeingControler;
import com.example.acheteurservice.repositories.AcheteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@RequestMapping("/api")
public class controlerRest {
    @Autowired
    AcheteurRepository acheteurRepository;


    //Get : to get all the Acheteur
    @GetMapping("/acheteurs")
    public List<Acheteur> getAll(){
        /*List<Produit> lisP = produitFeingControler.findAll();
        List<Acheteur> lisA = acheteurRepository.findAll();
        for(Acheteur a:lisA){
            for(Produit p:lisP){
                if(a.getIdProduit()==p.getIdProduit())
                    a.setProduit(p);
            }
        }
        return lisA;*/
        return acheteurRepository.findAll();
    }

    //Get : to get Acheteur by Id
    @GetMapping("/acheteurs/{id}")
    public Acheteur getById(@PathVariable Integer id){
        /*Acheteur acheteur= acheteurRepository.findById(id).get();
        Produit produit = produitFeingControler.findById(acheteur.getIdProduit());
        produit.setIdProduit(acheteur.getIdProduit());
        acheteur.setProduit(produit);
        return acheteur;*/
        return acheteurRepository.findById(id).get();
    }

    //Post : to add an Acheteur
    @PostMapping("/acheteurs")
    public void create(@RequestBody Acheteur acheteur){
        acheteurRepository.save(acheteur);
    }

    //Put to update an Acheteur
    @PutMapping("/acheteurs/{id}")
    public void update(@PathVariable Integer id,@RequestBody Acheteur acheteur){
        Acheteur acheteur1=acheteurRepository.findById(id).get();
        if(acheteur.getNom()!=null) acheteur1.setNom(acheteur.getNom());
        if(acheteur.getVille()!=null)   acheteur1.setVille(acheteur.getVille());
        acheteurRepository.save(acheteur1);
    }

    //Delete : to delete an Acheteur by Id
    @DeleteMapping("/acheteurs/{id}")
    public void delete(@PathVariable Integer id){
        acheteurRepository.deleteById(id);
    }
}

package com.example.venteservice.web;

import com.example.venteservice.config.MQConfig;
import com.example.venteservice.event.VenteEvent;
import com.example.venteservice.modele.Acheteur;
import com.example.venteservice.entities.Vente;
import com.example.venteservice.modele.Produit;
import com.example.venteservice.produit.AcheteurFeingController;
import com.example.venteservice.produit.ProduitFeingControler;
import com.example.venteservice.repositories.VenteRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class controllerRest {
    @Autowired
    VenteRepository venteRepository;
    @Autowired
    AcheteurFeingController acheteurFeingController;
    @Autowired
    ProduitFeingControler produitFeingControler;
    @Autowired
    private RabbitTemplate template;

    //GET : to get all the ventes
    @GetMapping("/ventes")
    public List<Vente> getAll(){
          List<Vente> listV=venteRepository.findAll();
          List<Produit> listP=produitFeingControler.findAll();
          List<Acheteur> listA=acheteurFeingController.findAll();
          for (Vente vente:listV){
            for (Produit produit:listP){
                if (vente.getId_Produit()==produit.getIdProduit())
                    vente.setProduit(produit);
            }
            for (Acheteur acheteur:listA){
                if (vente.getId_Acheteur()==acheteur.getId_Acheteur())
                    vente.setAcheteur(acheteur);
            }
          }
          return listV;
    }

    //GET : to get vente by id
    @GetMapping("/ventes/{id}")
    public Vente getVenteById(@PathVariable Integer id){

        Vente vente=new Vente();
        Acheteur acheteur=new Acheteur();
        Produit produit=new Produit();

        vente=venteRepository.findById(id).get();
        acheteur=acheteurFeingController.findById(vente.getId_Acheteur());
        produit=produitFeingControler.findById(vente.getId_Produit());

        vente.setAcheteur(acheteur);
        vente.setProduit(produit);

        return vente;
    }

    //POST : to add a new vente
    @PostMapping("/ventes")
    public void add(@RequestBody Vente vente){
        venteRepository.save(vente);
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, new VenteEvent(vente.getId_Vente(), vente.getId_Acheteur(), vente.getId_Produit() ));
    }

    //PUT : to update a vente
    @PutMapping("/ventes/{id}")
    public void update(@PathVariable Integer id,@RequestBody Vente vente){
        Vente vente1 = venteRepository.findById(id).get();

        if (vente1.getQuantite()!=0)
            vente1.setQuantite(vente.getQuantite());
        if (vente1.getMois()!=0)
            vente1.setMois(vente.getMois());
        if (vente1.getAnnee()!=0)
            vente1.setAnnee(vente.getAnnee());

        venteRepository.save(vente1);
    }

    //DELETE : to delete a vente from the database
    @DeleteMapping("ventes/{id}")
    public void delete(@PathVariable Integer id){
        venteRepository.deleteById(id);
    }
}

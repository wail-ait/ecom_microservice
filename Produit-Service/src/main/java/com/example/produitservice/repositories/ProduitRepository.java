package com.example.produitservice.repositories;

import com.example.produitservice.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestResource(exported = false)
public interface ProduitRepository extends JpaRepository<Produit,Integer> {
}

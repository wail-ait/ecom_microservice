package com.example.venteservice.repositories;

import com.example.venteservice.entities.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VenteRepository extends JpaRepository<Vente,Integer> {
}

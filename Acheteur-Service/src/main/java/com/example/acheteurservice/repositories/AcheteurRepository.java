package com.example.acheteurservice.repositories;

import com.example.acheteurservice.entities.Acheteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestResource(exported = false)
//reposotoryRestResourse
public interface AcheteurRepository extends JpaRepository<Acheteur,Integer> {

}

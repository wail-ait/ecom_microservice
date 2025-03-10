package com.example.acheteurservice.service;

import com.example.acheteurservice.dto.AcheteurReponseDTO;
import com.example.acheteurservice.dto.AcheteurRequestDTO;
import com.example.acheteurservice.entities.Acheteur;

import java.util.List;

public interface AcheteurServiceInterface {
    //GET all Acheteur
    public List<AcheteurReponseDTO> getAllAcheteur();

    //GET Acheteur by id
    public AcheteurReponseDTO getById(Integer id);

    //POST pour ajouter un nouveau Acheteur
    public void ajouter(AcheteurRequestDTO acheteurRequestDTO);

    //PUT to update an Acheteur
    public void update(Integer id,AcheteurRequestDTO acheteurRequestDTO);

    //DELETE to delete an existing Acheteur
    public void delete(Integer id);
}

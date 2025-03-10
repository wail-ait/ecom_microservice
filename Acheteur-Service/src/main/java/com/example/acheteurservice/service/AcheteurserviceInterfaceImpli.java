package com.example.acheteurservice.service;

import com.example.acheteurservice.dto.AcheteurReponseDTO;
import com.example.acheteurservice.dto.AcheteurRequestDTO;
import com.example.acheteurservice.entities.Acheteur;
import com.example.acheteurservice.mapper.AcheteurInterfaceMap;
import com.example.acheteurservice.repositories.AcheteurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AcheteurserviceInterfaceImpli implements AcheteurServiceInterface{

    @Autowired
    AcheteurRepository acheteurRepository;
    @Autowired
    AcheteurInterfaceMap acheteurInterfaceMap;

    @Override
    public List<AcheteurReponseDTO> getAllAcheteur() {
        List<Acheteur> list=new ArrayList<Acheteur>();
        list=acheteurRepository.findAll();
        List<AcheteurReponseDTO> list1=new ArrayList<AcheteurReponseDTO>();
        for (Acheteur acheteur:list) {
            AcheteurReponseDTO acheteurReponseDTO=new AcheteurReponseDTO();
            acheteurReponseDTO=acheteurInterfaceMap.acheteurToAcheteurReponseDto(acheteur);
            list1.add(acheteurReponseDTO);
        }
        return list1;
    }

    @Override
    public AcheteurReponseDTO getById(Integer id) {
        Acheteur acheteur=new Acheteur();
        acheteur=acheteurRepository.findById(id).get();
        AcheteurReponseDTO acheteurReponseDTO=new AcheteurReponseDTO();
        acheteurReponseDTO=acheteurInterfaceMap.acheteurToAcheteurReponseDto(acheteur);
        return acheteurReponseDTO;
    }

    @Override
    public void ajouter(AcheteurRequestDTO acheteurRequestDTO) {
        Acheteur acheteur=acheteurInterfaceMap.acheteurRequestDtoToAcheteur(acheteurRequestDTO);
        acheteurRepository.save(acheteur);
    }

    @Override
    public void update(Integer id, AcheteurRequestDTO acheteurRequestDTO) {
        Acheteur acheteur = new Acheteur();
        acheteur=acheteurRepository.findById(id).get();
        if (acheteurRequestDTO.getNom()!=null)  acheteur.setNom(acheteurRequestDTO.getNom());
        if (acheteurRequestDTO.getVille()!=null)    acheteur.setVille(acheteurRequestDTO.getVille());
        acheteurRepository.save(acheteur);
    }

    @Override
    public void delete(Integer id) {
        acheteurRepository.deleteById(id);
    }
}

package com.example.acheteurservice.mapper;

import com.example.acheteurservice.entities.Acheteur;
import com.example.acheteurservice.dto.AcheteurReponseDTO;
import com.example.acheteurservice.dto.AcheteurRequestDTO;

public interface AcheteurInterfaceMap {
    public Acheteur acheteurRequestDtoToAcheteur(AcheteurRequestDTO acheteurRequestDTO);
    public AcheteurReponseDTO acheteurToAcheteurReponseDto(Acheteur acheteur);
}

package com.example.acheteurservice.mapper;

import com.example.acheteurservice.dto.AcheteurReponseDTO;
import com.example.acheteurservice.dto.AcheteurRequestDTO;
import com.example.acheteurservice.entities.Acheteur;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AcheteurInterfaceMapImpli implements AcheteurInterfaceMap{

    @Override
    public Acheteur acheteurRequestDtoToAcheteur(AcheteurRequestDTO acheteurRequestDTO) {
        Acheteur acheteur =new Acheteur();
        BeanUtils.copyProperties(acheteurRequestDTO,acheteur);
        return acheteur;
    }

    @Override
    public AcheteurReponseDTO acheteurToAcheteurReponseDto(Acheteur acheteur) {
        AcheteurReponseDTO acheteurReponseDTO =new AcheteurReponseDTO();
        BeanUtils.copyProperties(acheteurReponseDTO,acheteur);
        return acheteurReponseDTO;
    }
}

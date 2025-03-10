package com.example.produitservice.Mapper;

import com.example.produitservice.dto.ProduitRequestDTO;
import com.example.produitservice.entities.Produit;

public interface ProduitInerfaceMap {
    public ProduitRequestDTO produitToProduitRequestDto(Produit produit);
}

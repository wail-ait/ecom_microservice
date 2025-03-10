package com.example.venteservice.web;

import com.example.venteservice.entities.Vente;
import com.example.venteservice.produit.AcheteurFeingController;
import com.example.venteservice.produit.ProduitFeingControler;
import com.example.venteservice.repositories.VenteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest
@AutoConfigureMockMvc
class controllerRestTest {

    @Mock
    private VenteRepository venteRepository;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AcheteurFeingController acheteurFeingController;

    @Mock
    private ProduitFeingControler produitFeingControler;

    @Test
    public void testDeleteVente() throws Exception {
        // Données simulées
        int venteId = 1;

        // Création d'une vente simulée
        Vente vente = Vente.builder().id_Vente(venteId).id_Acheteur(1).id_Produit(2).build();

        // Simulation de la méthode findById de venteRepository
        Mockito.when(venteRepository.findById(vente.getId_Vente())).thenReturn(Optional.of(vente));

        System.out.println("Before mockMvc.perform");

        // Exécution d'une requête HTTP simulée pour supprimer une vente
        mockMvc.perform(MockMvcRequestBuilders.delete("/ventes/{id}", venteId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Vérification que la méthode deleteById est appelée une fois avec le bon ID
        Mockito.verify(venteRepository, Mockito.times(1)).deleteById(venteId);

        // Vérification qu'aucune autre interaction n'a eu lieu avec venteRepository
        Mockito.verify(venteRepository, Mockito.atMost(1)).deleteById(venteId);

    }
}

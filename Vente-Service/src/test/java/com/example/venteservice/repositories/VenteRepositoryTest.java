package com.example.venteservice.repositories;

import com.example.venteservice.entities.Vente;
import com.example.venteservice.repositories.VenteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class VenteRepositoryTest {

    @Autowired
    private VenteRepository venteRepository;

    @Test
    public void testSaveVente() {
        // Given
        Vente vente = new Vente();
        vente.setId_Acheteur(1);
        vente.setId_Produit(2);
        vente.setQuantite(10);
        vente.setMois(6);
        vente.setAnnee(2022);

        // When
        Vente savedVente = venteRepository.save(vente);

        // Then
        assertThat(savedVente.getId_Vente()).isNotNull();
        assertThat(savedVente.getId_Acheteur()).isEqualTo(1);
        assertThat(savedVente.getId_Produit()).isEqualTo(2);
        assertThat(savedVente.getQuantite()).isEqualTo(10);
        assertThat(savedVente.getMois()).isEqualTo(6);
        assertThat(savedVente.getAnnee()).isEqualTo(2022);
    }


    @Test
    public void testUpdateVente() {
        Vente vente = Vente.builder().id_Acheteur(1).id_Produit(2).build();
        Vente savedVente = venteRepository.save(vente);

        savedVente.setId_Produit(3);
        Vente updatedVente = venteRepository.save(savedVente);

        assertThat(updatedVente.getId_Produit()).isEqualTo(3);
    }


}

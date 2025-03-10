package com.example.acheteurservice.repositories;

import com.example.acheteurservice.entities.Acheteur;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class AcheteurRepositoryTest {

    @Autowired
    private AcheteurRepository acheteurRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testSaveAcheyeur(){
        // Given
        Acheteur acheteur = new Acheteur();
        acheteur.setNom("wail");    acheteur.setVille("rabat");

        // When
        Acheteur savedAcheteur = acheteurRepository.save(acheteur);

        // Then
        assertThat(savedAcheteur.getId_Acheteur()).isNotNull();
        assertThat(savedAcheteur.getNom()).isEqualTo(acheteur.getNom());
        assertThat(savedAcheteur.getVille()).isEqualTo(acheteur.getVille());
    }

    @Test
    public void testFindById(){
        // Given
        Acheteur acheteur = new Acheteur();
        acheteur.setNom("wail");
        Acheteur savedAcheteur=testEntityManager.persistAndFlush(acheteur);

        // When
        Acheteur foundAcheteur = acheteurRepository.findById(savedAcheteur.getId_Acheteur()).orElse(null);

        // Then
        assert foundAcheteur != null;
        assertThat(foundAcheteur.getId_Acheteur()).isEqualTo(savedAcheteur.getId_Acheteur());
        assertThat(foundAcheteur.getNom()).isEqualTo(savedAcheteur.getNom());

    }

}
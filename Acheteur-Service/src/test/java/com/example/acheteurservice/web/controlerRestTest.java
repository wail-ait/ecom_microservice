package com.example.acheteurservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.acheteurservice.entities.Acheteur;
import com.example.acheteurservice.repositories.AcheteurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class controlerRestTest {
    @Autowired
    private controlerRest controlerRest;

    @MockBean
    private AcheteurRepository acheteurRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAll(){
        // Given
        Acheteur acheteur1 = new Acheteur();
        Acheteur acheteur2 = new Acheteur();
        List<Acheteur> mockAcheteurs = Arrays.asList(acheteur1,acheteur2);

        // Mocking the repository behavior
        when(acheteurRepository.findAll()).thenReturn(mockAcheteurs);

        // When
        List<Acheteur> result = controlerRest.getAll();

        // Then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);

    }

    @Test
    public void testGetById() {
        // Given
        Acheteur mockAcheteur = new Acheteur();
        mockAcheteur.setId_Acheteur(1);
        Optional<Acheteur> optionalAcheteur = Optional.of(mockAcheteur);

        // Mocking the repository behavior
        when(acheteurRepository.findById(1)).thenReturn(optionalAcheteur);

        // When
        Acheteur result = controlerRest.getById(1);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getId_Acheteur()).isEqualTo(1);
    }

    @Test
    public void testUpdate() throws Exception {
        // Given
        Integer id = 1;
        Acheteur existingAcheteur = new Acheteur();
        existingAcheteur.setId_Acheteur(id);
        existingAcheteur.setNom("Old Name");
        existingAcheteur.setVille("Old Ville");

        Acheteur updatedAcheteur = new Acheteur();
        updatedAcheteur.setNom("New Name");
        updatedAcheteur.setVille("New Ville");

        // Mocking the repository behavior
        when(acheteurRepository.findById(id)).thenReturn(Optional.of(existingAcheteur));
        when(acheteurRepository.save(any(Acheteur.class))).thenReturn(updatedAcheteur);

        // When
        mockMvc.perform(put("/acheteurs/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nom\":\"New Name\",\"ville\":\"New Ville\"}"))
                .andExpect(status().isOk());

        // Then
        verify(acheteurRepository, times(1)).findById(id);
        verify(acheteurRepository, times(1)).save(any(Acheteur.class));
    }

}

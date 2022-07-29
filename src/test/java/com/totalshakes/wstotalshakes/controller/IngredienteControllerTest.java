package com.totalshakes.wstotalshakes.controller;

import com.totalshakes.wstotalshakes.domain.model.Ingrediente;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontrado;
import com.totalshakes.wstotalshakes.service.IngredienteService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@MockitoSettings
class IngredienteControllerTest {

    @Mock
    IngredienteService service;

    @Mock
    Ingrediente ingrediente;

    @InjectMocks
    IngredienteController controller;

    @Test
    @DisplayName("Salvar ingrediente no banco de dados")
    void shouldSaveIngredient(){

        var actual = controller.saveIngrediente(ingrediente);

        verify(service, times (1)).saveIngrediente(ingrediente);
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(actual.getBody()).isNull();
    }

    @Test
    @DisplayName("Atualizar ingrediente no banco de dados")
    void shouldUpdateIngredient() throws IngredienteNaoEncontrado {
        // when
        var actual = controller.updateIngrediente(ingrediente);

        //then
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(service, times (1)).updateIngrediente(ingrediente);
        assertThat(actual.getBody()).isNull();
    }

    @Test
    @DisplayName("Deletar ingrediente pelo id no banco de dados")
    void shouldDeleteIngredient(){
        //given
        Ingrediente ingredienteExpected = Ingrediente.builder().id(1).name("Leite").build();

        //when
        var actual = controller.deleteIngrediente(ingredienteExpected.getId());

        //then
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
        verify(service, times(1)).deleteIngrediente(ingredienteExpected.getId());
        assertThat(actual.getBody()).isNull();
    }

    @Test
    @DisplayName("Consultar ingrediente pelo id no banco de dados")
    void shouldReturnIngredient(){
        //given
        Ingrediente ingredienteExpected = Ingrediente.builder().id(1).name("Leite").build();
        when(service.getIngrediente(ingredienteExpected.getId())).thenReturn(ingredienteExpected);

        //when
        var actual = controller.getIngrediente(ingredienteExpected.getId());

        //then
        assertThat(actual.getBody()).isEqualTo(ingredienteExpected);
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("Consultar todos os ingrediente do banco de dados")
    void shouldReturnAllIngredient(){
        //given
        final var ingrediente1 = Ingrediente.builder().id(1).name("Sorvete").build();
        final var ingrediente2 = Ingrediente.builder().id(2).name("Iorgurte").build();
        final var ingredienteExpected = Arrays.asList(ingrediente1, ingrediente2);

        when(service.getAllIngrediente()).thenReturn(ingredienteExpected);

        //when
        var actual = controller.getAllIngrediente();

        //then
        assertThat(ingredienteExpected.size()).isEqualTo(2);
        assertThat(ingredienteExpected.get(0)).isEqualTo(ingrediente1);
        assertThat(ingredienteExpected.get(1)).isEqualTo(ingrediente2);
        assertThat(actual.getBody()).isEqualTo(ingredienteExpected);
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
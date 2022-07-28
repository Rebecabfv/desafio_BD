package com.totalshakes.wstotalshakes.controller;

import com.totalshakes.wstotalshakes.domain.model.Ingrediente;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontrado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class IngredienteControllerTest {

    @Autowired
    IngredienteController controller;

    @Test
    @DisplayName("Salvar ingrediente no banco de dados")
    void saveIngrediente(){
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setName("Sorvete");

        var actual = controller.saveIngrediente(ingrediente);

        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    @DisplayName("Atualizar ingrediente no banco de dados")
    void updateIngrediente() throws IngredienteNaoEncontrado {

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setName("Iogurte");
        ingrediente.setId(1);

        var actual = controller.updateIngrediente(ingrediente);

        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("Deletar ingrediente pelo id no banco de dados")
    void deleteIngredeiente(){
        var id = 1;

        var actual = controller.deleteIngrediente(id);

        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED);
    }

    @Test
    @DisplayName("Consultar ingrediente pelo id no banco de dados")
    void getIngrediente(){
        var id = 2;

        Ingrediente ingredienteExpected = new Ingrediente();
        ingredienteExpected.setName("Sorvete");
        ingredienteExpected.setId(2);

        var actual = controller.getIngrediente(id);

        assertThat(actual.getBody()).isEqualTo(ingredienteExpected);
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
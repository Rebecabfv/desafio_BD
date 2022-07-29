package com.totalshakes.wstotalshakes.service;

import com.totalshakes.wstotalshakes.domain.model.Ingrediente;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontrado;

import java.util.List;

public interface IngredienteService {
    void saveIngrediente(Ingrediente ingrediente);

    void updateIngrediente(Ingrediente ingrediente) throws IngredienteNaoEncontrado;

    void deleteIngrediente(int id) throws IngredienteNaoEncontrado;

    Ingrediente getIngrediente(int id) throws IngredienteNaoEncontrado;

    List<Ingrediente> getAllIngrediente();
}

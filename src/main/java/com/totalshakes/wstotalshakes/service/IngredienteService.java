package com.totalshakes.wstotalshakes.service;

import com.totalshakes.wstotalshakes.domain.model.Ingrediente;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontrado;

public interface IngredienteService {
    void saveIngrediente(Ingrediente ingrediente);

    void updateIngrediente(Ingrediente ingrediente) throws IngredienteNaoEncontrado;

    void deleteIngrediente(int id);

    Ingrediente getIngrediente(int id);
}

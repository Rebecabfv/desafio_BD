package com.totalshakes.wstotalshakes.domain.repository;

import com.totalshakes.wstotalshakes.domain.model.Ingrediente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends CrudRepository<Ingrediente, Integer> {
}

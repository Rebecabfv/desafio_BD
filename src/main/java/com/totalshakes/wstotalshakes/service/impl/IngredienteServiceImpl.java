package com.totalshakes.wstotalshakes.service.impl;

import com.totalshakes.wstotalshakes.domain.model.Ingrediente;
import com.totalshakes.wstotalshakes.domain.repository.IngredienteRepository;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontrado;
import com.totalshakes.wstotalshakes.service.IngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IngredienteServiceImpl implements IngredienteService {

    private final IngredienteRepository repository;

    @Override
    public void saveIngrediente(Ingrediente ingrediente) {
        repository.save(ingrediente);
    }

    @Override
    public void updateIngrediente(Ingrediente ingrediente) throws IngredienteNaoEncontrado {
        var ingredienteExiste = repository.findById(ingrediente.getId());
        if (ingredienteExiste.isEmpty())
            throw new IngredienteNaoEncontrado();
        repository.save(ingrediente);
    }

    @Override
    public void deleteIngrediente(int id) {
        //TODO: create conditions for throws
        var ingrediente = repository.findById(id).get();
        repository.delete(ingrediente);
    }

    @Override
    public Ingrediente getIngrediente(int id) {
        //TODO: create conditions for throws
        return repository.findById(id).get();
    }

    @Override
    public List<Ingrediente> getAllIngrediente() {
        return (List<Ingrediente>) repository.findAll();
    }
}

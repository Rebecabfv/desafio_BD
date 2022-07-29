package com.totalshakes.wstotalshakes.controller;

import com.totalshakes.wstotalshakes.domain.model.Ingrediente;
import com.totalshakes.wstotalshakes.exception.IngredienteJaCadastrado;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontrado;
import com.totalshakes.wstotalshakes.service.IngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class IngredienteController {

    final IngredienteService service;

    @PostMapping(path="/ingrediente")
    public ResponseEntity<Void> saveIngrediente(@RequestBody final Ingrediente ingrediente) throws IngredienteJaCadastrado {
        service.saveIngrediente(ingrediente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path="/ingrediente")
    public ResponseEntity<Void> updateIngrediente(@RequestBody final Ingrediente ingrediente) throws IngredienteNaoEncontrado {
        service.updateIngrediente(ingrediente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path="/ingrediente/{id}")
    public ResponseEntity<Void> deleteIngrediente(@PathVariable final int id) throws IngredienteNaoEncontrado {
        service.deleteIngrediente(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path="/ingrediente/{id}")
    public ResponseEntity<Ingrediente> getIngrediente(@PathVariable final int id) throws IngredienteNaoEncontrado {
        var ingrediente = service.getIngrediente(id);
        return ResponseEntity.ok(ingrediente);
    }

    @GetMapping(path = "/ingrediente/all")
    public ResponseEntity<List<Ingrediente>> getAllIngrediente(){
        var listIngrediente = service.getAllIngrediente();
        return ResponseEntity.ok(listIngrediente);
    }
}

package com.totalshakes.wstotalshakes.controller;

import com.totalshakes.wstotalshakes.domain.model.Ingrediente;
import com.totalshakes.wstotalshakes.exception.IngredienteJaCadastrado;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontrado;
import com.totalshakes.wstotalshakes.service.IngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/ingrediente")
public class IngredienteController {

    final IngredienteService service;

    @PostMapping(produces = "application/json")
    public ResponseEntity<Ingrediente> saveIngrediente(@Valid @RequestBody final Ingrediente ingrediente) throws IngredienteJaCadastrado {
        var ingredienteSalvo = service.saveIngrediente(ingrediente);

        URI location = ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(ingredienteSalvo.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<Void> updateIngrediente(@RequestBody final Ingrediente ingrediente) throws IngredienteNaoEncontrado {
        service.updateIngrediente(ingrediente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteIngrediente(@PathVariable final int id) throws IngredienteNaoEncontrado {
        service.deleteIngrediente(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Ingrediente> getIngrediente(@PathVariable final int id) throws IngredienteNaoEncontrado {
        var ingrediente = service.getIngrediente(id);
        return ResponseEntity.ok(ingrediente);
    }

    @GetMapping(path="/all", produces = "application/json")
    public ResponseEntity<List<Ingrediente>> getAllIngrediente(){
        var listIngrediente = service.getAllIngrediente();
        return ResponseEntity.ok(listIngrediente);
    }
}

package com.natalia.controlefinanceiro.controller;

import com.natalia.controlefinanceiro.model.CategoriaModel;
import com.natalia.controlefinanceiro.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Criar categoria
    @PostMapping
    public ResponseEntity<CategoriaModel> salvar(@RequestBody CategoriaModel categoria) {
        CategoriaModel categoriaSalva = categoriaService.salvar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    // Listar todas
    @GetMapping
    public ResponseEntity<List<CategoriaModel>> listar() {
        return ResponseEntity.ok(categoriaService.listar());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModel> atualizar(
            @PathVariable Long id,
            @RequestBody CategoriaModel categoria) {

        return ResponseEntity.ok(categoriaService.atualizar(id, categoria));
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}


package com.natalia.controlefinanceiro.controller;

import com.natalia.controlefinanceiro.model.DespesaModel;
import com.natalia.controlefinanceiro.model.ReceitaModel;
import com.natalia.controlefinanceiro.service.DespesaService;
import com.natalia.controlefinanceiro.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<ReceitaModel> salvar(@RequestBody ReceitaModel receitaModel){
        ReceitaModel receitaSalva = receitaService.salvar(receitaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(receitaSalva);
    }

    @GetMapping
    public ResponseEntity<List<ReceitaModel>> listar(){
        List<ReceitaModel> receitas = receitaService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(receitas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaModel>buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(receitaService.buscarPorId(id));
    }

    @PutMapping
    public ResponseEntity<ReceitaModel> atualizar(@RequestBody ReceitaModel receitaModel, @PathVariable Long id){
        return ResponseEntity.ok(receitaService.atualizar(id, receitaModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        receitaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

package com.natalia.controlefinanceiro.controller;

import com.natalia.controlefinanceiro.model.DespesaModel;
import com.natalia.controlefinanceiro.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesaController {
    @Autowired
    private DespesaService despesaService;

    @PostMapping
    public ResponseEntity<DespesaModel>salvar(@RequestBody DespesaModel despesas){
        DespesaModel despesaSalva = despesaService.salvar(despesas);
        return ResponseEntity.status(HttpStatus.CREATED).body(despesaSalva);
    }

    @GetMapping
    public ResponseEntity<List<DespesaModel>> listar(){
        List<DespesaModel> despesas = despesaService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(despesas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DespesaModel>buscar(@PathVariable Long id){
        return ResponseEntity.ok(despesaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DespesaModel> atualizar(@PathVariable Long id, @RequestBody DespesaModel despesa) {
        return ResponseEntity.ok(despesaService.atualizar(id, despesa));
    }

    @DeleteMapping
    public ResponseEntity<DespesaModel> remover(@PathVariable Long id){
        despesaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

package com.natalia.controlefinanceiro.controller;

import com.natalia.controlefinanceiro.model.ContaModel;
import com.natalia.controlefinanceiro.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public ResponseEntity<ContaModel> salvar(@RequestBody ContaModel conta){
        ContaModel contaSalva = contaService.salvar(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(contaSalva);
    }

    @GetMapping
    public ResponseEntity<List<ContaModel>> listar(){
        return ResponseEntity.ok(contaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaModel> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(contaService.buscarPorId(id));
    }

    @PutMapping
    public ResponseEntity<ContaModel> atualizar(@PathVariable Long id, @RequestBody ContaModel conta){
        return ResponseEntity.ok(contaService.atualizar(id, conta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContaModel> deletar(@PathVariable Long id){
        contaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}

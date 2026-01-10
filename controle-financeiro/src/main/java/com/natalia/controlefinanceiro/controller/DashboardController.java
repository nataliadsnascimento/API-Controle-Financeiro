package com.natalia.controlefinanceiro.controller;

import com.natalia.controlefinanceiro.dto.ResumoFinanceiroDTO;
import com.natalia.controlefinanceiro.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/resumo")
    public ResponseEntity<ResumoFinanceiroDTO> getResumo(
            @RequestParam int ano,
            @RequestParam int mes) {

        return ResponseEntity.ok(dashboardService.obterResumoMensal(ano, mes));
    }

    @GetMapping("/grafico-categorias")
    public ResponseEntity<Map<String, BigDecimal>> getGastosPorCategoria(
            @RequestParam int ano,
            @RequestParam int mes) {

        return ResponseEntity.ok(dashboardService.obterDespesasPorCategoria(ano, mes));
    }
}
package com.natalia.controlefinanceiro.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ResumoFinanceiroDTO {
    private BigDecimal totalReceitas;
    private BigDecimal totalDespesas;
    private BigDecimal saldoFinal;

    // Construtor para facilitar
    public ResumoFinanceiroDTO(BigDecimal totalReceitas, BigDecimal totalDespesas, BigDecimal saldoFinal) {
        this.totalReceitas = totalReceitas;
        this.totalDespesas = totalDespesas;
        this.saldoFinal = saldoFinal;
    }

}
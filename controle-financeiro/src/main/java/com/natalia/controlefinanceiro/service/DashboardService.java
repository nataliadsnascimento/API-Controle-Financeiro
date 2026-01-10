package com.natalia.controlefinanceiro.service;

import com.natalia.controlefinanceiro.dto.ResumoFinanceiroDTO;
import com.natalia.controlefinanceiro.repository.DespesaRepository;
import com.natalia.controlefinanceiro.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private DespesaRepository despesaRepository;

    public ResumoFinanceiroDTO obterResumoMensal(int ano, int mes) {
        // Busca os valores no banco
        BigDecimal totalReceita = receitaRepository.somarReceitasPorMes(ano, mes);
        if (totalReceita == null) totalReceita = BigDecimal.ZERO;

        BigDecimal totalDespesa = despesaRepository.somarDespesasPorMes(ano, mes);
        if (totalDespesa == null) totalDespesa = BigDecimal.ZERO;

        BigDecimal saldo = totalReceita.subtract(totalDespesa);

        return new ResumoFinanceiroDTO(totalReceita, totalDespesa, saldo);
    }

    // Lógica para o gráfico de pizza
    public Map<String, BigDecimal> obterDespesasPorCategoria(int ano, int mes) {
        List<Object[]> resultados = despesaRepository.somarDespesasPorCategoria(ano, mes);

        Map<String, BigDecimal> mapaRetorno = new HashMap<>();

        for (Object[] obj : resultados) {
            String categoria = (String) obj[0];
            BigDecimal valor = (BigDecimal) obj[1];
            mapaRetorno.put(categoria, valor);
        }

        return mapaRetorno;
    }
}
package com.natalia.controlefinanceiro.repository;

import com.natalia.controlefinanceiro.model.DespesaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<DespesaModel, Long> {

    // Soma todas as despesas de um determinado ano e mês
    @Query("SELECT SUM(d.valor) FROM DespesaModel d WHERE YEAR(d.data) = :ano AND MONTH(d.data) = :mes")
    BigDecimal somarDespesasPorMes(@Param("ano") int ano, @Param("mes") int mes);

    // Agrupa despesas por categoria para o gráfico (retorna uma lista de arrays de objetos)
    @Query("SELECT d.categoria.nome, SUM(d.valor) FROM DespesaModel d WHERE YEAR(d.data) = :ano AND MONTH(d.data) = :mes GROUP BY d.categoria.nome")
    List<Object[]> somarDespesasPorCategoria(@Param("ano") int ano, @Param("mes") int mes);
}
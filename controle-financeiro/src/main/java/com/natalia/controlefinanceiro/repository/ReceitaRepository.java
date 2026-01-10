package com.natalia.controlefinanceiro.repository;

import com.natalia.controlefinanceiro.model.ReceitaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;

@Repository
public interface ReceitaRepository extends JpaRepository<ReceitaModel, Long> {

    // Soma todas as receitas de um determinado ano e mês
    @Query("SELECT SUM(r.valor) FROM ReceitaModel r WHERE YEAR(r.data) = :ano AND MONTH(r.data) = :mes")
    BigDecimal somarReceitasPorMes(@Param("ano") int ano, @Param("mes") int mes);
}
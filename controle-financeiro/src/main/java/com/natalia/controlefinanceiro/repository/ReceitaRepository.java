package com.natalia.controlefinanceiro.repository;

import com.natalia.controlefinanceiro.model.ReceitaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<ReceitaModel, Long> {
}

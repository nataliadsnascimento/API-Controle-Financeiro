package com.natalia.controlefinanceiro.repository;

import com.natalia.controlefinanceiro.model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, Long> {
}
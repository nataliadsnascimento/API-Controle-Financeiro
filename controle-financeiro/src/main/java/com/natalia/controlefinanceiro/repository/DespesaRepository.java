package com.natalia.controlefinanceiro.repository;

import com.natalia.controlefinanceiro.model.DespesaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository  extends JpaRepository<DespesaModel, Long>{

}

package com.natalia.controlefinanceiro.repository;

import com.natalia.controlefinanceiro.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

    List<CategoriaModel> id(Long id);
}

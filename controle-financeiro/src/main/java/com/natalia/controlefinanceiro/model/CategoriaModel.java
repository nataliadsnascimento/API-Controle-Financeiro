package com.natalia.controlefinanceiro.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoCategoria tipo;
}


package com.natalia.controlefinanceiro.service;

import com.natalia.controlefinanceiro.model.CategoriaModel;
import com.natalia.controlefinanceiro.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaModel salvar(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<CategoriaModel> listar() {
        return categoriaRepository.findAll();
    }

    public CategoriaModel buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public CategoriaModel atualizar(Long id, CategoriaModel dadosAtualizados){
        CategoriaModel categoria = buscarPorId(id);

        categoria.setNome(dadosAtualizados.getNome());
        categoria.setTipo(dadosAtualizados.getTipo());

        return categoriaRepository.save(dadosAtualizados);
    }

    public void deletar(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Categoria não encontrada");
        }
    }
}

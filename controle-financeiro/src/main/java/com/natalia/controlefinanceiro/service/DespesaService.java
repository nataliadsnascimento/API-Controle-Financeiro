package com.natalia.controlefinanceiro.service;

import java.util.List;
import com.natalia.controlefinanceiro.model.CategoriaModel;
import com.natalia.controlefinanceiro.model.DespesaModel;
import com.natalia.controlefinanceiro.model.TipoCategoria;
import com.natalia.controlefinanceiro.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private CategoriaService categoriaService; // Injeção necessária para validar

    public DespesaModel salvar(DespesaModel despesa){
        CategoriaModel categoria = categoriaService.buscarPorId(despesa.getCategoria().getId());

        if (categoria.getTipo() != TipoCategoria.DESPESA) {
            throw new IllegalArgumentException("A categoria selecionada não é do tipo DESPESA.");
        }

        despesa.setCategoria(categoria);
        return despesaRepository.save(despesa);
    }

    public List<DespesaModel> listar(){
        return despesaRepository.findAll();
    }

    public DespesaModel buscarPorId(Long id) {
        return despesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));
    }

    public DespesaModel atualizar(Long id, DespesaModel dadosAtualizados) {
        DespesaModel despesa = buscarPorId(id);
        CategoriaModel categoria = categoriaService.buscarPorId(dadosAtualizados.getCategoria().getId());
        if (categoria.getTipo() != TipoCategoria.DESPESA) {
            throw new IllegalArgumentException("A categoria selecionada não é do tipo DESPESA.");
        }

        despesa.setDescricao(dadosAtualizados.getDescricao());
        despesa.setValor(dadosAtualizados.getValor());
        despesa.setData(dadosAtualizados.getData());
        despesa.setCategoria(categoria);

        return despesaRepository.save(despesa);
    }

    public void deletar(Long id) {
        if (despesaRepository.existsById(id)) {
            despesaRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Despesa não encontrada");
        }
    }
}
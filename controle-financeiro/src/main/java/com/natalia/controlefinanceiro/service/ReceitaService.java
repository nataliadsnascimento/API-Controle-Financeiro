package com.natalia.controlefinanceiro.service;

import com.natalia.controlefinanceiro.model.CategoriaModel;
import com.natalia.controlefinanceiro.model.ReceitaModel;
import com.natalia.controlefinanceiro.model.TipoCategoria;
import com.natalia.controlefinanceiro.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private CategoriaService categoriaService; // Injeção necessária para validar

    public ReceitaModel salvar(ReceitaModel receitaModel){
        CategoriaModel categoria = categoriaService.buscarPorId(receitaModel.getCategoria().getId());

        if (categoria.getTipo() != TipoCategoria.RECEITA) {
            throw new IllegalArgumentException("A categoria selecionada não é do tipo RECEITA.");
        }
        receitaModel.setCategoria(categoria);
        return receitaRepository.save(receitaModel);
    }

    public List<ReceitaModel> listar(){
        return receitaRepository.findAll();
    }

    public ReceitaModel buscarPorId(Long id){
        return receitaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Receita não encontrada"));
    }

    public ReceitaModel atualizar(Long id, ReceitaModel dadosAtualizados) {
        ReceitaModel receita = buscarPorId(id);

        CategoriaModel categoria = categoriaService.buscarPorId(dadosAtualizados.getCategoria().getId());
        if (categoria.getTipo() != TipoCategoria.RECEITA) {
            throw new IllegalArgumentException("A categoria selecionada não é do tipo RECEITA.");
        }

        receita.setDescricao(dadosAtualizados.getDescricao());
        receita.setValor(dadosAtualizados.getValor());
        receita.setData(dadosAtualizados.getData());
        receita.setCategoria(categoria);

        return receitaRepository.save(receita);
    }

    public void deletar(Long id){
        if(receitaRepository.existsById(id)){
            receitaRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Receita não encontrada");
        }
    }
}

package com.natalia.controlefinanceiro.service;

import com.natalia.controlefinanceiro.model.ContaModel;
import com.natalia.controlefinanceiro.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.math.BigDecimal;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public ContaModel salvar(ContaModel conta){
        if (conta.getSaldo() == null) {
            conta.setSaldo(BigDecimal.ZERO);
        }
        return contaRepository.save(conta);
    }

    public List<ContaModel> listar(){
        return contaRepository.findAll();
    }

    public ContaModel buscarPorId(Long id){
        return contaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public ContaModel atualizar(Long id, ContaModel contaAtualizada){
        ContaModel contaExistente = buscarPorId(id);

        contaExistente.setNome(contaAtualizada.getNome());

        if (contaAtualizada.getSaldo() != null) {
            contaExistente.setSaldo(contaAtualizada.getSaldo());
        }
        return contaRepository.save(contaExistente);
    }

    public void deletar(Long id){
        if(!contaRepository.existsById(id)){
            throw new RuntimeException("Conta inexistente para exclusão");
        }
        contaRepository.deleteById(id);
    }

}

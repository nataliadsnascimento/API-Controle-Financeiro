package com.natalia.controlefinanceiro.service;

import com.natalia.controlefinanceiro.model.UsuarioModel;
import com.natalia.controlefinanceiro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel salvar(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioModel> listar() {
        return usuarioRepository.findAll();
    }

    public UsuarioModel buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário com ID " + id + " não encontrado"));
    }

    public UsuarioModel atualizar(Long id, UsuarioModel detalhesUsuario) {
        UsuarioModel usuarioExistente = buscarPorId(id);

        usuarioExistente.setNome(detalhesUsuario.getNome());
        usuarioExistente.setEmail(detalhesUsuario.getEmail());
        usuarioExistente.setSenha(detalhesUsuario.getSenha());

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    public UsuarioModel autenticar(String email, String senhaRecebida) {
        UsuarioModel usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email não encontrado"));

        if (!usuario.getSenha().equals(senhaRecebida)) {
            throw new RuntimeException("Senha incorreta");
        }

        return usuario;
    }
}

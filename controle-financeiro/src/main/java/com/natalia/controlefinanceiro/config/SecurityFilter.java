package com.natalia.controlefinanceiro.config;

import com.natalia.controlefinanceiro.model.UsuarioModel;
import com.natalia.controlefinanceiro.repository.UsuarioRepository;
import com.natalia.controlefinanceiro.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = recuperarToken(request);

        if (token != null) {
            // Se tem token, valida e descobre quem é o usuário (subject = email)
            var email = tokenService.getSubject(token);
            UsuarioModel usuario = usuarioRepository.findByEmail(email).orElse(null);

            if (usuario != null) {
                // Diz para o Spring Security que esse usuário está logado
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
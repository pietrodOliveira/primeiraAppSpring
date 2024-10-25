package com.primeira.appSpring.service;

import com.primeira.appSpring.model.M_Usuario;
import com.primeira.appSpring.repository.R_Usuario;
import org.springframework.stereotype.Service;

@Service
public class S_Usuario {
    private static R_Usuario r_usuario;

    public S_Usuario(R_Usuario r_usuario) {
        this.r_usuario = r_usuario;
    }

    public static M_Usuario validaLogin(String usuario, String senha){
        return r_usuario.getUsuarioByUsuarioSenha(usuario, senha);
    }

    public static M_Usuario cadastrarUsuario(String usuario, String apelido, String senha, String confSenha){
        boolean podeSalvar = true;

        if(senha == null || !senha.trim().equals(confSenha)){
            podeSalvar = false;
        }

        if(usuario == null || usuario.trim().isEmpty()){
            podeSalvar = false;
        }

        if(apelido == null || apelido.trim().isEmpty()){
            podeSalvar = false;
        }

        if(podeSalvar){
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setUsuario(usuario);
            m_usuario.setSenha(senha);
            m_usuario.setApelido(apelido);
            return r_usuario.save(m_usuario);
        }
        return null;
    }
}

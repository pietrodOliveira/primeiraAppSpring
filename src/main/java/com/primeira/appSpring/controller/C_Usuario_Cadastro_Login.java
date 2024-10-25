package com.primeira.appSpring.controller;

import com.primeira.appSpring.model.M_Usuario;
import com.primeira.appSpring.service.S_Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Usuario_Cadastro_Login {
    @GetMapping("/")
    public String getLogin(){
        return "index";
    }

    @PostMapping("/")
    public String postLogin(@RequestParam("usuario") String usuario,
                            @RequestParam("senha") String senha){
        M_Usuario m_usuario = S_Usuario.validaLogin(usuario, senha);
        if (m_usuario != null) {
            return "home/home";
        }
        return "index";
    }

    @GetMapping("/cadastro")
    public String getCadastro(){
        return "cadastro/cadastro";
    }

    @PostMapping("/cadastro")
    public String postCadastro(@RequestParam("usuario") String usuario,
                               @RequestParam("apelido") String apelido,
                               @RequestParam("senha") String senha,
                               @RequestParam("confSenha") String confirmaSenha){

        M_Usuario m_usuario = S_Usuario.cadastrarUsuario(usuario, apelido, senha, confirmaSenha);
        if(m_usuario != null){
            return "index";
        }
        return "cadastro/cadastro";
    }
}

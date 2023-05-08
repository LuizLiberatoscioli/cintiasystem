package com.cintia.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cintia.entity.Usuario;
import com.cintia.repository.UsuarioRepository;

@Controller
public class UsuariosController {

	@GetMapping("/Usuarios")
    public String showHomePage() {
        return "usuarios";
    }
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/cadastrarUsuario")
	public String cadastrarUsuario(
	        @RequestParam String nome,
	        @RequestParam String email,
	        @RequestParam String endereco,
	        @RequestParam Integer rg,
	        @RequestParam Integer cpf,
	        @RequestParam Integer telefone,
	        @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd")  Date dataNascimento,
	        @RequestParam String prontuario,
	        Model model
	) {
	    Usuario novoUsuario = new Usuario(nome, email, endereco, rg, cpf, telefone, dataNascimento, prontuario);
	    usuarioRepository.save(novoUsuario);
	    model.addAttribute("mensagem", "Usuário cadastrado com sucesso!");
	    return "mensagem-de-sucesso";
	}
	
	@PostMapping("/ver_usuarios")
	public String pesquisarUsuarios(
	    @RequestParam(required=false) String nome,
	    @RequestParam(required=true) Integer cpf,
	    Model model
	) {
	    List<Usuario> usuarios = null;
	    if (nome != null && !nome.isEmpty()) {
	        usuarios = usuarioRepository.findByNome(nome);
	    } else {
	        usuarios = usuarioRepository.findByCpf(cpf);
	    }
	    model.addAttribute("usuarios", usuarios);
	    return "lista-usuarios";
	}

}

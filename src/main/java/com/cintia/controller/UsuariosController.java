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
	    @RequestParam(value = "nome", required = false) String nome,
	    @RequestParam(value = "cpf", required = false) Integer cpf,
	    Model model
	) {
	    List<Usuario> usuarios;

	    if (nome != null) {
	        usuarios = usuarioRepository.findByNome(nome);
	    } else if (cpf != null) {
	        usuarios = usuarioRepository.findByCpf(cpf);
	    } else {
	        // Caso nenhum parâmetro tenha sido fornecido, retorne uma resposta adequada
	        model.addAttribute("mensagem", "Informe um nome ou CPF para pesquisar.");
	        return "mensagem-de-erro";
	    }

	    model.addAttribute("usuarios", usuarios);
	    return "lista_usuarios";
	}

}

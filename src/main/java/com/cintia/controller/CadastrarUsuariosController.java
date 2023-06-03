package com.cintia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cintia.repository.UsuarioRepository;

@Controller
@RequestMapping("/cadastrarUsuarios")
public class CadastrarUsuariosController {
	
	// Injecao
	private UsuarioRepository usuarioRepository;


	@GetMapping
	public String exibirFormularioCadastro() {
	    return "cadastrarusuarios";
	}
	
	@PostMapping
	public String cadastrarUsuario() {
		// Lógica para cadastrar o usuário
		return "redirect:/cadastrarUsuarios"; // Redireciona para a página de cadastro após a conclusão
	}
	
	
	
}

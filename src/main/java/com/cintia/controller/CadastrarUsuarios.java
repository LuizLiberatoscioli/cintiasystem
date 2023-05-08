package com.cintia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastrarUsuarios {

	@GetMapping("/cadastrarUsuarios")
	public String exibirFormularioCadastro() {
	    return "cadastrarusuarios";
	}
	
}

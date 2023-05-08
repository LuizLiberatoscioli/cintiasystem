package com.cintia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PesquisarUsuarioController {

	@GetMapping("/pesquisarUsuarios")
	public String pesquisarUsuarios() {
	    return "pesquisar-usuarios";
	}
	
}

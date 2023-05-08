package com.cintia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cintia.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByNome(String nome);

	List<Usuario> findByCpf(Integer cpf);

}

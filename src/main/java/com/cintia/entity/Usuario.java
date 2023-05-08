package com.cintia.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "rg")
	private Integer rg;

	@Column(name = "cpf")
	private Integer cpf;

	@Column(name = "telefone")
	private Integer telefone;

	@Column(name = "datanascimento")
	private Date dataNascimento;

	@Column(name = "prontuario")
	private String prontuario;
	
	@Column(name = "Endereco")
	private String endereco;

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public Usuario(String nome, String email, String endereco, Integer rg, Integer cpf, Integer telefone, Date dataNascimento, String prontuario) {
	    this.nome = nome;
	    this.email = email;
	    this.endereco = endereco;
	    this.rg = rg;
	    this.cpf = cpf;
	    this.telefone = telefone;
	    this.dataNascimento = dataNascimento;
	    this.prontuario = prontuario;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

}

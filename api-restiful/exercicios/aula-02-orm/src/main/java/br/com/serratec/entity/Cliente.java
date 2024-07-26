package br.com.serratec.entity;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	
	@Column(length = 100, nullable = false)//nao pode ser vazio
	
	@NotBlank(message = "Nome vazio ou nulo")//tratamento nulo ou vazio
	@Size(max = 60, min = 3, message = "Altere o tamanho")
	private String nome;
	
	@CPF
	private String cpf;
	
	//deixar como padrao sem anotacoes
    private LocalDate dataNascimento;
    public Cliente() {
	}
	
	public Cliente(Long id, String nome, String cpf, LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
}

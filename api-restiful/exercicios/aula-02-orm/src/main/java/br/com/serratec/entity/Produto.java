package br.com.serratec.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
//import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//ORM (MAPEAMENTO OBJETO RELACIONAL)
//@Table(name="tbl_produto")
@Entity
public class Produto {
	@Id //identifica chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //serial do id
	@Column(length = 60, nullable = false) //tamanho coluna e not null
	private Long codigo;
	@NotBlank //nao pode ser vazio e nem nulo
	
	@NotBlank(message = "Nome vazio ou nulo")//tratamento nulo ou vazio
	@Size(max = 60, min = 3,  message = "tamanho invalido")
	private String nome;
	
	@DecimalMin(value = "10",  message = "tamanho invalido")
	@DecimalMax(value = "1000",  message = "tamanho invalido")
	private Double valor;
	
	@FutureOrPresent
	private LocalDate dataCadastro;
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	
}

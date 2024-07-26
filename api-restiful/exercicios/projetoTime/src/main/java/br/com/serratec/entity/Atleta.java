package br.com.serratec.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.serratec.enums.CategoriaTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Atleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate dataInicio; 
	private LocalDate dataSaida;

	private CategoriaTime categoriaTime;
	

	@JsonBackReference //relacionamento pra na dar loop
	@ManyToOne  //relacionamento tabela muitos pra um
	@JoinColumn(name = "id_time")
	 private Time time;


	public Atleta() {
	}


	public Atleta(Long id, String nome, LocalDate dataInicio, LocalDate dataSaida, CategoriaTime categoriaTime,
			Time time) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataSaida = dataSaida;
		this.categoriaTime = categoriaTime;
		this.time = time;
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


	public LocalDate getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}


	public LocalDate getDataSaida() {
		return dataSaida;
	}


	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}


	public CategoriaTime getCategoriaTime() {
		return categoriaTime;
	}


	public void setCategoriaTime(CategoriaTime categoriaTime) {
		this.categoriaTime = categoriaTime;
	}


	public Time getTime() {
		return time;
	}


	public void setTime(Time time) {
		this.time = time;
	}
	
	
	
}

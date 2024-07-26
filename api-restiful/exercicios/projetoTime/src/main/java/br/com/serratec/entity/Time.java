package br.com.serratec.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.serratec.enums.CategoriaTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Time {
	
	

	public Time() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate dataInicio; 
	private LocalDate dataSaida;

	
	private CategoriaTime categoriaTime;
	
	  @JsonManagedReference//para nao dar loop
	  @OneToMany(mappedBy = "time")
	  private List<Atleta> atletas = new ArrayList<>();

	public Time(Long id, String nome, LocalDate dataInicio, LocalDate dataSaida, CategoriaTime categoriaTime,
			List<Atleta> atletas) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataSaida = dataSaida;
		this.categoriaTime = categoriaTime;
		this.atletas = atletas;
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

	public List<Atleta> getAtletas() {
		return atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}
	  
	
}

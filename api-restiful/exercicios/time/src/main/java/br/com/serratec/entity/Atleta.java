package br.com.serratec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Atleta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @ManyToOne
    private Time time;

	public Atleta(Long id, String nome, Time time) {
		super();
		this.id = id;
		this.nome = nome;
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

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

    
}

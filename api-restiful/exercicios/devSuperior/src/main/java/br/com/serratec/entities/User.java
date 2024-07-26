package br.com.serratec.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //para q a classe seja monitorada pelo jpa, constatando q e uma entidade
@Table(name = "tb_user") //cria e da nome a tabela
public class User {
	
	@Id //Constata q a primeira variavel e o id
	@GeneratedValue(strategy = GenerationType.IDENTITY )  //torna o id auto incremental
	private Long id;
	private String name;
	private String password;
	
	public User() {
		
	}

	public User(Long id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

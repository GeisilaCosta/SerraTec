package br.com.serratec.dto;

import br.com.serratec.entities.User;

public class UserDTO { //data transfer object-para trafegar dados de usuario (o q sera exposto)
 private Long id;
 private String name; //nao sera colocada a senha pra nao expor a senha do user
  
 public UserDTO() {
 }

public UserDTO(Long id, String name) {
	this.id = id;
	this.name = name;
}
 
public UserDTO(User user) { //construtor q recebe a entity para facilitar a conversao de entidade para DTO
	super();
	id = user.getId(); //vai preencher as variaveis locais com os dados da entity user
	name = user.getName();
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
}

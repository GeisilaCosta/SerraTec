package br.com.serratec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.dto.UserDTO;
import br.com.serratec.entities.User;
import br.com.serratec.repositories.UserRepository;

@Service //registra a classe como um componente do sistema
public class UserService {

//injeta a dependencia do obj UserRepository
	@Autowired //injecao autometica de dependencia
	private UserRepository repository; //atributo 

//metodo para chamar a busca de usuario do repository e retornar o DTO para o controlador
	public UserDTO findById(long id){
		User entity = repository.findById(id).get();
		UserDTO dto = new UserDTO(entity); //o metodo recebe o id do user armazena ne entity e transforma em userDto para respeitar as camadas
		return dto;
	}
}


//classe da camada de servico responsavel por receber um id,o metodo  vai no banco de dados e busca o usuario pelo id e retorna o usuario transformado em dto 
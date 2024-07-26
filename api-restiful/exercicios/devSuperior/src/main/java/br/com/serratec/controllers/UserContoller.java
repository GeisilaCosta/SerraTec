package br.com.serratec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.UserDTO;
import br.com.serratec.services.UserService;

// anotacoes define a classe como componente, registar um endpoint da apiRest
@RestController
@RequestMapping(value = "/users")//caminho que o controlador vai responder
public class UserContoller {
	
	//dependecia da classe service
	@Autowired
	private UserService service;

	//metodo para retornar obj do tipo userDTO
	@GetMapping(value = "/{id}")  //anotacao para buscar inserido o argumento de busca id
	public UserDTO findById(@PathVariable long id) { //@PathVariable configura que o id do getMapping que chegar na requisicao tem que casar com o id do argumento do metodo findbyid
		return service.findById(id);
	}
}


//controlador chama o service e o service chama repository, necessario injetar a dependencia do service nessa  classe 
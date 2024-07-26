package br.com.serratec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Servico;
import br.com.serratec.repository.ServicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/servico")
@Validated  //ativa avalidacao automatica
public class ServicoControler {
	
	@Autowired //injecao de dependencia
	private ServicoRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)//Altera resposta p/ ideal
	public Servico inserir(@Valid @RequestBody Servico servico){
		return repository.save(servico);
	}
	
	//retorna lista de produtos no insomnia
	@GetMapping
	public List<Servico> listar (){
		return repository.findAll();
	}
	
	@GetMapping("{id}") //busca por um especifico
	public ResponseEntity<Servico> buscar(@PathVariable Long id) {
	Optional<Servico> servico = repository.findById(id);
		if (servico.isPresent()) {
			return ResponseEntity.ok(servico.get());
		}
			return ResponseEntity.notFound().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Servico> atualizar(@PathVariable Long id,@Valid @RequestBody Servico servico) {
		if (repository.existsById(id)) {
			servico.setId(id);
			return ResponseEntity.ok(repository.save(servico));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
		
	}

}

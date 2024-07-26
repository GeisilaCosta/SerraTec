package br.com.serratec.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import br.com.serratec.entity.Pessoa;
import br.com.serratec.repository.PessoaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
@Validated  //ativa avalidacao automatica
public class PessoaControler {
	
	@Autowired //injecao de dependencia
	private PessoaRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)//Altera resposta p/ ideal
	public Pessoa inserir(@Valid @RequestBody Pessoa pessoa){
		return repository.save(pessoa);
	}
	
	//retorna lista de produtos no insomnia
	@GetMapping
	public List<Pessoa> listar (){
		return repository.findAll();
	}
	
	@GetMapping("{id}") //busca por um especifico
	public ResponseEntity<Pessoa> buscar(@PathVariable UUID id) {
	Optional<Pessoa> pessoa = repository.findById(id);
		if (pessoa.isPresent()) {
			return ResponseEntity.ok(pessoa.get());
		}
			return ResponseEntity.notFound().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable UUID id,@Valid @RequestBody Pessoa pessoa) {
		if (repository.existsById(id)) {
			pessoa.setId(id);
			return ResponseEntity.ok(repository.save(pessoa));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable UUID id){
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
		
	}

}

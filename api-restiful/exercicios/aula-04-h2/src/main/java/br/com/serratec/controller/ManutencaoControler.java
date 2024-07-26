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

import br.com.serratec.entity.Manutencao;
import br.com.serratec.repository.ManutencaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/manutencao")
@Validated  //ativa avalidacao automatica
public class ManutencaoControler {
	
	@Autowired //injecao de dependencia
	private ManutencaoRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)//Altera resposta p/ ideal
	public Manutencao inserir(@Valid @RequestBody Manutencao manutencao){
		return repository.save(manutencao);
	}
	
	//retorna lista de produtos no insomnia
	@GetMapping
	public List<Manutencao> listar (){
		return repository.findAll();
	}
	
	@GetMapping("{id}") //busca por um especifico
	public ResponseEntity<Manutencao> buscar(@PathVariable Long id) {
	Optional<Manutencao> manutencao = repository.findById(id);
		if (manutencao.isPresent()) {
			return ResponseEntity.ok(manutencao.get());
		}
			return ResponseEntity.notFound().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Manutencao> atualizar(@PathVariable Long id,@Valid @RequestBody Manutencao manutencao) {
		if (repository.existsById(id)) {
			manutencao.setId(id);
			return ResponseEntity.ok(repository.save(manutencao));
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

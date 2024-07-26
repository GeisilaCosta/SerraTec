package br.com.serratec.controller;

import java.util.List;

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

import br.com.serratec.entity.Veiculo;
import br.com.serratec.repository.VeiculoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculo")
@Validated  //ativa avalidacao automatica
public class VeiculoControler {
	
	@Autowired //injecao de dependencia
	private VeiculoRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)//Altera resposta p/ ideal
	public Veiculo inserir(@Valid @RequestBody Veiculo veiculo){
		return repository.save(veiculo);
	}
	
	//retorna lista de produtos no insomnia
	@GetMapping
	public List<Veiculo> listar (){
		return repository.findAll();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Veiculo> atualizar(@PathVariable Long id,@Valid @RequestBody Veiculo veiculo) {
		if (repository.existsById(id)) {
			veiculo.setId(id);
			return ResponseEntity.ok(repository.save(veiculo));
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

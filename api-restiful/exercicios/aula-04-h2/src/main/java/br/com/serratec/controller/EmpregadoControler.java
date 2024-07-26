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

import br.com.serratec.entity.Empregado;
import br.com.serratec.repository.EmpregadoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/empregado")
@Validated  //ativa avalidacao automatica
public class EmpregadoControler {
	
	@Autowired //injecao de dependencia
	private EmpregadoRepository repository;
	
	

	@PostMapping("/varios")//inserir varios empregados,diferenciado por ()
	@ResponseStatus(HttpStatus.CREATED)
	public List<Empregado> inserirEmpregado (@Valid @RequestBody List<Empregado> empregados)
	{
		return repository.saveAll(empregados);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)//Altera resposta p/ ideal
	public Empregado inserir(@Valid @RequestBody Empregado empregado){
		return repository.save(empregado);
	}
	
	//retorna lista de produtos no insomnia
	@GetMapping
	public List<Empregado> listar (){
		return repository.findAll();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Empregado> atualizar(@PathVariable Long id,@Valid @RequestBody Empregado empregado) {
		if (repository.existsById(id)) {
			empregado.setId(id);
			return ResponseEntity.ok(repository.save(empregado));
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

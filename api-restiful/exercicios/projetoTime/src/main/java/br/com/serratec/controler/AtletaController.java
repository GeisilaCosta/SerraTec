package br.com.serratec.controler;

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
import br.com.serratec.entity.Atleta;
import br.com.serratec.repository.AtletaRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/atleta")
@Validated  
public class AtletaController {
	
	@Autowired 
	private AtletaRepository repository;
	
	@PostMapping("/varios")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Atleta> inserirAtletas (@Valid @RequestBody List<Atleta> atleta)
	{
		return repository.saveAll(atleta);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Atleta inserir(@Valid @RequestBody Atleta atleta){
		return repository.save(atleta);
	}

	@GetMapping
	public List<Atleta> listar (){
		return repository.findAll();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Atleta> atualizar(@PathVariable Long id,@Valid @RequestBody Atleta atleta) {
		if (repository.existsById(id)) {
			atleta.setId(id);
			return ResponseEntity.ok(repository.save(atleta));
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

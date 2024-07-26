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

import br.com.serratec.entity.Time;
import br.com.serratec.repository.TimeRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/time")
@Validated 
public class TimeController {

	@Autowired 
	private TimeRepository repository;
	
	@PostMapping("/varios")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Time> inserirTimes (@Valid @RequestBody List<Time> time)
	{
		return repository.saveAll(time);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Time inserir(@Valid @RequestBody Time time){
		return repository.save(time);
	}

	@GetMapping
	public List<Time> listar (){
		return repository.findAll();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Time> atualizar(@PathVariable Long id,@Valid @RequestBody Time time) {
		if (repository.existsById(id)) {
			time.setId(id);
			return ResponseEntity.ok(repository.save(time));
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

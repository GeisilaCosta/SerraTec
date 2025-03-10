package br.com.serratec.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Produto;
import br.com.serratec.repository.ProdutoRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)//Altera resposta p/ ideal
	public Produto inserir(@Valid @RequestBody Produto produto){
		return repository.save(produto);
	}
	
	//retorna lista de produtos no insomnia
	@GetMapping
	public List<Produto> listar (){
		return repository.findAll();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id,@Valid @RequestBody Produto produto) {
		if (repository.existsById(id)) {
			produto.setCodigo(id);
			return ResponseEntity.ok(repository.save(produto));
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
	



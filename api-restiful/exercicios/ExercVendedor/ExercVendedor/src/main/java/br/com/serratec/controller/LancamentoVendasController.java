package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.LancamentoVendasResponseDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.service.LancamentoVendasService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/vendas")
public class LancamentoVendasController {
	
	@Autowired
	private LancamentoVendasService service;
	
	@GetMapping
	public List<LancamentoVendasResponseDTO> listar(){
		return service.listar();
	}
	
	@PostMapping
	public LancamentoVendas inserir(@Valid @RequestBody LancamentoVendas venda) {
		return service.inserir(venda);
	}
	
	@GetMapping("{id}")
	public LancamentoVendasResponseDTO listarId(@PathVariable Long id) {
		return service.listarId(id);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		return service.deletar(id);
	}
	

	@PutMapping("{id}")
	public ResponseEntity<LancamentoVendas> atualizar(@PathVariable Long id,@Valid @RequestBody LancamentoVendas venda) {
			return service.atualizar(id, venda);
	}
	
}

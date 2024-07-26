package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.serratec.entity.Vendedor;
import br.com.serratec.exception.EmailException;
import br.com.serratec.service.VendedorService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/vendedor")
public class VendedorController {
	
	@Autowired
	private VendedorService service;
	
	@GetMapping
	public List<Vendedor> listar(){
		return service.listar();
	}
	
	@PostMapping
	public ResponseEntity<Object> inserir(@Valid @RequestBody List<Vendedor> vendedor){
		try {
			vendedor =service.inserir(vendedor);
		} catch (EmailException e) {

			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
		return ResponseEntity.created(null).body(vendedor);
	}
	
}

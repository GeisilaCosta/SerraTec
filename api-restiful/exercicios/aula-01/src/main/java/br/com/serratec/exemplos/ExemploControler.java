package br.com.serratec.exemplos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/exemplos")
public class ExemploControler {
	
	@GetMapping("/teste")
	public String teste() {
		return"Serratec";
	}
	
	@GetMapping("/teste2")
	public String teste2() {
		return"Serratec";
	}
	
	@GetMapping("/teste3")
	public String converter(@RequestParam String Texto) {
		return Texto.toUpperCase();
	}
	

}

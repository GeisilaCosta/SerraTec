package br.com.serratec.exemplos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@RequestMapping("/aulas")
	public String exemplo() {
		return "Hello World !";
	}
	
	@RequestMapping("/cursos")
	public String exemplo2() {
		return "Cursos diversos !";
	}

}

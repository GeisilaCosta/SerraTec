package br.com.serratec.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.model.Aluno;

@RestController
@RequestMapping("/alunos")
public class AlunoControler {
	
	private static List<Aluno> alunos= new ArrayList();
	//bloco de inicializacao estatico
	static {
		alunos.add(new Aluno(1L,"Joaquim", "J@gmail.com", 23));
		alunos.add(new Aluno(2L,"Ana", "J@gmail.com", 34));
		alunos.add(new Aluno(3L,"Bruno", "J@gmail.com", 42));
		alunos.add(new Aluno(4L,"Carla", "J@gmail.com", 21));
	}
	
	@GetMapping
	public List<Aluno> listar(){
		return alunos;
	}
	
	//inserir um aluno novo
	@PostMapping
	public Aluno inserir(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		return aluno;
	}
	@GetMapping("{id}")
	public Aluno buscar(@PathVariable Long id) {
	for(int i = 0; i<alunos.size(); i++) {
		if(alunos.get(i).getId().equals(id)) {
			return alunos.get(i);
		}
	}
	return null;
	}
	@DeleteMapping("{id}")
	public void delete (@PathVariable Long id) {
		for(int i = 0; i<alunos.size(); i++) {
			if(alunos.get(i).getId().equals(id)) {
				alunos.remove(i);
				break;
			}
			
		}
	}
	
	@PutMapping("/{id}")
	public Aluno atualizar(@RequestBody Aluno aluno, @PathVariable Long id) {
		for(int i = 0; i<alunos.size(); i++) {
			Aluno a = new Aluno(id, aluno.getNome(), aluno.getEmail(), aluno.getIdade());
			alunos.set(i,  a);
			return a;
		}
	
	return null;
	
	}
	}

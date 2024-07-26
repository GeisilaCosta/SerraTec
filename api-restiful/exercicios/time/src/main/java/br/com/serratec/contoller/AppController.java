package br.com.serratec.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Atleta;
import br.com.serratec.entity.Time;
import br.com.serratec.repository.AtletaRepository;
import br.com.serratec.repository.TimeRepository;

@RestController
public class AppController {
	 @Autowired
	    private TimeRepository timeRepo;
	    @Autowired
	    private AtletaRepository atletaRepo;

	    @PostMapping("/time")
	    public Time addTime(@RequestBody Time time) {
	        return timeRepo.save(time);
	    }

	    @PostMapping("/atleta")
	    public Atleta addAtleta(@RequestBody Atleta atleta) {
	        return atletaRepo.save(atleta);
	    }

	    @GetMapping("/time/{id}/atletas")
	    public List<Atleta> getAtletas(@PathVariable Long id) {
	        Time time = timeRepo.findById(id).orElseThrow(() -> new RuntimeException("Time não encontrado"));
	        return atletaRepo.findByTime(time);
	    }
}

package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Vendedor;
import br.com.serratec.exception.EmailException;
import br.com.serratec.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository repository;
	
	
	public List<Vendedor> listar(){
		return repository.findAll();
	}
	
	
	public List<Vendedor> inserir(List<Vendedor> vendedores) throws EmailException {
		for(Vendedor vendedor: vendedores) {
		if (repository.findByEmail(vendedor.getEmail()) != null) {
			throw new EmailException("Email já existe na base de dados");
		}
	}
		return repository.saveAll(vendedores);
	}
}

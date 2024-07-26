package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Vendedor;
import br.com.serratec.repository.VendedorRepository;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    public Vendedor inserir(Vendedor vendedor){
        return repository.save(vendedor);
    }

    public List<Vendedor> listar (){
        return repository.findAll();
    }

    public Vendedor atualizar(Long id, Vendedor vendedor) {
        if (repository.existsById(id)) {
            vendedor.setCodigoVendedor(id);
            return repository.save(vendedor);
        }
        return null;
    }

    public void deletar(Long id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    public List<Vendedor> inserirVarios(List<Vendedor> vendedores){
        return repository.saveAll(vendedores);
    }
}

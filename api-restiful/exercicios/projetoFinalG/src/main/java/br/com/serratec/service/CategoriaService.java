package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Categoria;
import br.com.serratec.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Long id, Categoria categoria) {
        Categoria existingCategoria = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        existingCategoria.setNome(categoria.getNome());
        return categoriaRepository.save(existingCategoria);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}


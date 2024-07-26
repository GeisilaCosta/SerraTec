package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Produto;
import br.com.serratec.repository.CategoriaRepository;
import br.com.serratec.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto save(Produto produto) {
        if (categoriaRepository.existsById(produto.getCategoria().getId())) {
            return produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Categoria não encontrada");
        }
    }

    public Produto update(Long id, Produto produto) {
        Produto existingProduto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        existingProduto.setNome(produto.getNome());
        existingProduto.setPreco(produto.getPreco());
        existingProduto.setCategoria(produto.getCategoria());
        return produtoRepository.save(existingProduto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public List<Produto> findByCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId);
    }
}


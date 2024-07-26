package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Carrinho;
import br.com.serratec.entity.Produto;
import br.com.serratec.repository.CarrinhoRepository;
import br.com.serratec.repository.ClienteRepository;
import br.com.serratec.repository.ProdutoRepository;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Carrinho addProduto(Long carrinhoId, Long produtoId) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        carrinho.getProdutos().add(produto);
        carrinho.setTotal(carrinho.getTotal() + produto.getPreco());
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho create(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    public List<Carrinho> findAll() {
        return carrinhoRepository.findAll();
    }

	public ClienteRepository getClienteRepository() {
		return clienteRepository;
	}

	public void setClienteRepository(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
}


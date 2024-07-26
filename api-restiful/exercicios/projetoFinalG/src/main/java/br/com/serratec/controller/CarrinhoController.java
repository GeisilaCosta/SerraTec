package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Carrinho;
import br.com.serratec.service.CarrinhoService;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {
    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping
    public Carrinho create(@RequestBody Carrinho carrinho) {
        return carrinhoService.create(carrinho);
    }

    @PutMapping("/{carrinhoId}/produtos/{produtoId}")
    public Carrinho addProduto(@PathVariable Long carrinhoId, @PathVariable Long produtoId) {
        return carrinhoService.addProduto(carrinhoId, produtoId);
    }

    @GetMapping
    public List<Carrinho> findAll() {
        return carrinhoService.findAll();
    }
}


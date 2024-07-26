package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.entity.Vendedor;
import br.com.serratec.service.LancamentoService;
import br.com.serratec.service.VendedorService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService service;
    
    @Autowired
    private VendedorService vendedorService;


    
    @GetMapping("/{id}")
    public LancamentoVendas listarPorId(@PathVariable Long id) {
        return service.listarPorId(id);
    }

    @PostMapping
    public LancamentoVendas inserirLancamento(@RequestBody LancamentoVendas lancamento) {
        return service.inserirLancamento(lancamento);
    }

   /* //listarPorPagina chama no service
    @GetMapping
    public List<LancamentoVendas> listarPorPagina(@RequestParam int page, @RequestParam int size) {
        return service.listarPorPagina(page, size);
    }*/

    @DeleteMapping("/{id}")
    public void delet(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public LancamentoVendas alterar(@PathVariable Long id, @RequestBody LancamentoVendas lancamento) {
        lancamento.setCodigoVenda(id);
        return service.alterar(lancamento);
    }

	
	

    @PostMapping("/vendedores")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Vendedor> inserirVendedor (@Valid @RequestBody List<Vendedor> vendedores)
    {
        return vendedorService.inserirVarios(vendedores);
    }

    @PostMapping("/vendedor") //passei o caminho pois estava dando conflito co o inserir de lancaVendas
    @ResponseStatus(HttpStatus.CREATED)
    public Vendedor inserir(@Valid @RequestBody Vendedor vendedor){
        return vendedorService.inserir(vendedor);
    }

    @GetMapping
    public List<Vendedor> listar (){
        return vendedorService.listar();
    }

    @PutMapping("/vendedor/{id}")
    public ResponseEntity<Vendedor> atualizar(@PathVariable Long id, @Valid @RequestBody Vendedor vendedor) {
        Vendedor vendedorAtualizado = vendedorService.atualizar(id, vendedor);
        if (vendedorAtualizado != null) {
            return ResponseEntity.ok(vendedorAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/vendedor/{id}")//passei o caminho pois estava dando conflito co o inserir de lancaVendas
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        vendedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}


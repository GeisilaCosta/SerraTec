package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Pedido;
import br.com.serratec.enun.StatusPedido;
import br.com.serratec.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        return pedidoService.save(pedido);
    }

    @PutMapping("/{id}/status")
    public Pedido updateStatus(@PathVariable Long id, @RequestParam StatusPedido status) {
        return pedidoService.updateStatus(id, status);
    }

    @GetMapping("/{numero}")
    public Pedido findByNumero(@PathVariable Long numero) {
        return pedidoService.findByNumero(numero);
    }

    @GetMapping
    public List<Pedido> findAll() {
        return pedidoService.findAll();
    }
}


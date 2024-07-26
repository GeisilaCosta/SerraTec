package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Pedido;
import br.com.serratec.enun.StatusPedido;
import br.com.serratec.repository.ClienteRepository;
import br.com.serratec.repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Pedido save(Pedido pedido) {
        if (clienteRepository.existsById(pedido.getCliente().getId())) {
            return pedidoRepository.save(pedido);
        } else {
            throw new RuntimeException("Cliente não encontrado");
        }
    }

    public Pedido updateStatus(Long id, StatusPedido status) {
        Pedido existingPedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        existingPedido.setStatus(status);
        return pedidoRepository.save(existingPedido);
    }

    public Pedido findByNumero(Long numero) {
        return pedidoRepository.findById(numero)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
}


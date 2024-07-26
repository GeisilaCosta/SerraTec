package br.com.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.Cliente;
import br.com.serratec.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private JavaMailSender mailSender;

    public Cliente save(Cliente cliente) {
        String endereco = viaCepService.buscaEnderecoPorCep(cliente.getCep());
        cliente.setEndereco(endereco);
        Cliente savedCliente = clienteRepository.save(cliente);
        enviarEmail(savedCliente, "Bem-vindo!");
        return savedCliente;
    }

    public Cliente update(Long id, Cliente cliente) {
        Cliente existingCliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        String endereco = viaCepService.buscaEnderecoPorCep(cliente.getCep());
        existingCliente.setEndereco(endereco);
        existingCliente.setNome(cliente.getNome());
        existingCliente.setTelefone(cliente.getTelefone());
        existingCliente.setEmail(cliente.getEmail());
        existingCliente.setCpf(cliente.getCpf());
        Cliente updatedCliente = clienteRepository.save(existingCliente);
        enviarEmail(updatedCliente, "Informações atualizadas");
        return updatedCliente;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    private void enviarEmail(Cliente cliente, String assunto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(cliente.getEmail());
        message.setSubject(assunto);
        message.setText("Olá, " + cliente.getNome() + ". Suas informações foram atualizadas com sucesso!");
        mailSender.send(message);
    }
}



package br.com.serratec.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import br.com.serratec.dto.LancamentoVendasResponseDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.exception.ResourceNotFoundException;
import br.com.serratec.repository.LancamentoVendasRepository;


@Service
public class LancamentoVendasService {

	@Autowired
	private LancamentoVendasRepository repository;

	public List<LancamentoVendasResponseDTO> listar() {
		List<LancamentoVendas> vendas = repository.findAll();
		return vendas.stream().map((venda) -> new LancamentoVendasResponseDTO(venda.getDataVenda(),
				venda.getValorVenda(), venda.getVendedor().getNome())).collect(Collectors.toList());
	}

	public LancamentoVendas inserir(LancamentoVendas vendas) {
		return repository.save(vendas);
	}

	public LancamentoVendasResponseDTO listarId(Long id) {
		return repository.findById(id)
                .map(venda -> new LancamentoVendasResponseDTO(venda.getDataVenda(), venda.getValorVenda(), venda.getVendedor().getNome()))
                .orElseThrow(() -> new ResourceNotFoundException("Venda com id " + id + " não encontrada"));
    }
				


	public ResponseEntity<String> deletar(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.ok().body("A venda com id: " + id + " Foi deletada!");
		}
		throw new ResourceNotFoundException("Venda com id " + id + " não encontrada");
	}

	public ResponseEntity<LancamentoVendas> atualizar(Long id, LancamentoVendas venda) {
		if (repository.existsById(id)) {

			venda.setCodigoVenda(id);
			return ResponseEntity.ok(repository.save(venda));
		}
		throw new ResourceNotFoundException("Venda com id " + id + " não encontrada");
	}
}

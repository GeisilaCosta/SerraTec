package br.com.serratec.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.repository.LancamentoRepository;

/**
 * Classe de serviço para operações CRUD em LancamentoVendas.
 */

@Service
public class LancamentoService {
	
	/**
     * Repositório para acesso aos dados de LancamentoVendas.
     */

    @Autowired
    private LancamentoRepository lancamentoRepository;
    
    /**
     * Busca um LancamentoVendas pelo ID.
     * @param id O ID do LancamentoVendas.
     * @return O LancamentoVendas se encontrado, ou null caso contrário.
     */

    public LancamentoVendas listarPorId(Long id) {
        return lancamentoRepository.findById(id).orElse(null);
    }

    public LancamentoVendas inserirLancamento(LancamentoVendas lancamento) {
        return lancamentoRepository.save(lancamento);
    }

   /* //listarPorPagina
    public List<LancamentoVendas> listarPorPagina(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return lancamentoRepository.findAll(pageable).getContent();
    }*/

    public void deletar(Long id) {
        lancamentoRepository.deleteById(id);
    }

    public LancamentoVendas alterar(LancamentoVendas lancamento) {
        return lancamentoRepository.save(lancamento);
    }
}

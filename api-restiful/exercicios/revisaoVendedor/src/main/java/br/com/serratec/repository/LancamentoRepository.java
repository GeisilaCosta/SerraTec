package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.entity.LancamentoVendas;

@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoVendas, Long> {
}

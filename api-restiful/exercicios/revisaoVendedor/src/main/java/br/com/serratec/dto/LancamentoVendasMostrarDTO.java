package br.com.serratec.dto;

import java.time.LocalDateTime;

public class LancamentoVendasMostrarDTO {

	 private LocalDateTime dataVenda;
	    private Double valorVenda;
	    private String nomeVendedor;

	    // Getters e setters
	    public LocalDateTime getDataVenda() {
	        return dataVenda;
	    }

	    public void setDataVenda(LocalDateTime dataVenda) {
	        this.dataVenda = dataVenda;
	    }

	    public Double getValorVenda() {
	        return valorVenda;
	    }

	    public void setValorVenda(Double valorVenda) {
	        this.valorVenda = valorVenda;
	    }

	    public String getNomeVendedor() {
	        return nomeVendedor;
	    }

	    public void setNomeVendedor(String nomeVendedor) {
	        this.nomeVendedor = nomeVendedor;
	    }
}

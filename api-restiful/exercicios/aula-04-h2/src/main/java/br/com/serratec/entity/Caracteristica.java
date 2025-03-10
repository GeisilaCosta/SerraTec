package br.com.serratec.entity;

import br.com.serratec.enums.Categoria;
import br.com.serratec.enums.Combustivel;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Caracteristica {
	
	private String renavam;
	private String cor;
	private Integer ano;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@Enumerated(EnumType.ORDINAL)
	private Combustivel combustivel;
	
	

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getRenevam() {
		return renavam;
	}

	public void setRenevam(String renevam) {
		this.renavam = renevam;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	
	

}

package br.com.serratec.enums;

public enum CategoriaAtleta {

TECNICO(1,"Tecnico"), GOLEIRO(2,"Goleiro"), JOGADOR(3,"Jogador");
	
	private Integer codigo;
	private String tipo;
	
	private CategoriaAtleta(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}

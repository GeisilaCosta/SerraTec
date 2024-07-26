package br.com.serratec.enums;

public enum CategoriaTime {
	FUTEBOL(1,"Futebol"), VOLEI(2,"Volei"), BASQUETE(3,"Basquete");
	
	private Integer codigo;
	private String tipo;
	
	private CategoriaTime(Integer codigo, String tipo) {
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

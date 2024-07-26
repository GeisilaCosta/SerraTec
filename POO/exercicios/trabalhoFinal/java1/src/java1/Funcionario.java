package java1;

public abstract class Funcionario {
	private String senha;
	private String CPF;
	
	public Funcionario(String senha, String cPF) {
		super();
		this.senha = senha;
		CPF = cPF;
	}

	public String getSenha() {
		return senha;
	}



	public String getCPF() {
		return CPF;
	}
	
	
}

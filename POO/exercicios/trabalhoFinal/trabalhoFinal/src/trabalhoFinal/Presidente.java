package trabalhoFinal;

public class Presidente extends Funcionario {
	private String cargo = "presidente";

	public Presidente(String nome, String senha, String cpf, TiposUsuariosEnun tipoUsuarios, String cargo) {
		super(nome, senha, cpf, tipoUsuarios);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
}

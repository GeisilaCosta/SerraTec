package trabalhoFinal;

public abstract class Funcionario extends Usuarios  {

	public Funcionario(String nome, String senha, String cpf, TiposUsuariosEnun tipoUsuarios) {
		super(nome, senha, cpf, tipoUsuarios);
	}
	
	public String toString() {
		return "\nNome: " + this.getNome() +
		"\nSenha: " + this.getSenha() +
		"\nCPF: " + this.getCpf() +
		"\nTipo de usuario: " + this.getTipoUsuarios();
	}
}

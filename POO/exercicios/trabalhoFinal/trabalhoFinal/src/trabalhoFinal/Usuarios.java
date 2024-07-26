package trabalhoFinal;

public class Usuarios {
	private String nome;
	private String senha;
	private String cpf;
	private TiposUsuariosEnun tipoUsuarios;
	
	public Usuarios(String nome, String senha, String cpf, TiposUsuariosEnun tipoUsuarios) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.tipoUsuarios = tipoUsuarios;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public TiposUsuariosEnun getTipoUsuarios() {
		return tipoUsuarios;
	}
	public void setTipoUsuarios(TiposUsuariosEnun tipoUsuarios) {
		this.tipoUsuarios = tipoUsuarios;
	}
	
}
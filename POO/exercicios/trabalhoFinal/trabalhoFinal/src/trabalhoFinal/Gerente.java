package trabalhoFinal;

public class Gerente  extends Funcionario  {
	private String cargo = "gerente";
	private String idAgenciaResponsavel;
	
	public Gerente(String nome, String senha, String cpf, TiposUsuariosEnun tipoUsuarios, String cargo,
			String idAgenciaResponsavel) {
		super(nome, senha, cpf, tipoUsuarios);
		this.cargo = cargo;
		this.idAgenciaResponsavel = idAgenciaResponsavel;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getIdAgenciaResponsavel() {
		return idAgenciaResponsavel;
	}

	public void setIdAgenciaResponsavel(String idAgenciaResponsavel) {
		this.idAgenciaResponsavel = idAgenciaResponsavel;
	}
	
	
	
}

package banco;

public class Gerente extends Funcionario {
	    private String agenciaResponsavel;

	    public Gerente(String cpf, String senha, String agenciaResponsavel) {
	        super(cpf, senha, CargoEnun.GERENTE);
	        this.setAgenciaResponsavel(agenciaResponsavel);
	    }

	  public String getAgenciaResponsavel() {
			return agenciaResponsavel;
		}

		public void setAgenciaResponsavel(String agenciaResponsavel) {
			this.agenciaResponsavel = agenciaResponsavel;
		}
	}



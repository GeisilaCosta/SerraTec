package java1;

public class ContaCorrente extends Conta {
	private String tipo = "Corrente";

	public ContaCorrente(String cPF, double saldo, String identificadorAgencia, String tipo) {
		super(cPF, saldo, identificadorAgencia);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}

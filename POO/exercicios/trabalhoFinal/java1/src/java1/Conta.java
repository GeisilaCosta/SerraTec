package java1;

public abstract class Conta {
	  private String CPF;
	  private double saldo;
	  private String identificadorAgencia;
	  
	
	public Conta(String cPF, double saldo, String identificadorAgencia) {
		super();
		CPF = cPF;
		this.saldo = saldo;
		this.identificadorAgencia = identificadorAgencia;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getIdentificadorAgencia() {
		return identificadorAgencia;
	}
	public void setIdentificadorAgencia(String identificadorAgencia) {
		this.identificadorAgencia = identificadorAgencia;
	}

}

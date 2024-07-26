package trabalhoFinal;

public class ContaPoupanca extends Conta{
	
	private static int contadorDeContasP = 1; //contar as contas criadas
	
	private int numeroConta;
	private Double saldo;
	
	public ContaPoupanca(Cliente cliente, int identificadorAgencia, TipoContaEnun tipoConta, int numeroConta,
			Double saldo) {
		super(cliente, identificadorAgencia, tipoConta);
		this.numeroConta = contadorDeContasP;
		this.saldo = saldo;
		contadorDeContasP +=1;
		
	}
	public static int getContadorDeContasP() {
		return contadorDeContasP;
	}
	public static void setContadorDeContasP(int contadorDeContasP) {
		ContaPoupanca.contadorDeContasP = contadorDeContasP;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
}
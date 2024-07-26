package java2;

public abstract class Conta {
	  protected String cpfTitular;
	    protected double saldo;

	    public Conta(String cpfTitular) {
	        this.cpfTitular = cpfTitular;
	        this.saldo = 0.0;
	    }
	    public abstract void deposito(double valor);
	    public abstract void saque(double valor);
	    public abstract void transferencia(Conta destino, double valor);

	    public double getSaldo() {
	        return saldo;
	    }
}

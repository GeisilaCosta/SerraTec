package banco;

public interface OperacoesContaInterface {
	
	    void sacar(double valor);
	    void depositar(double valor);
	    void transferir(double valor, Conta destino);
	    double calcularTributacao();
	    double calcularRendimento(int dias);
	   
	}
	

package trabalhoFinal;

public interface OperacoesBancariasInterface {
	void sacar(double valor);
    void depositar(double valor) throws ValorInvalidoException;
    void transferir(double valor, Conta destino) throws SaldoInsuficienteException, ValorInvalidoException;
}

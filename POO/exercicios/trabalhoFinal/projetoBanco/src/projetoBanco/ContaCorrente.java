package projetoBanco;

public class ContaCorrente extends Conta {

    public ContaCorrente(String cpfTitular, double saldo, String agencia, TipoContaEnun tipo) {
        super(cpfTitular, saldo, agencia, tipo);
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor inválido para saque.");
        }
        if (valor > getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }
        setSaldo(getSaldo() - valor);
    }

    @Override
    public void depositar(double valor) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor inválido para depósito.");
        }
        setSaldo(getSaldo() + valor);
    }

    @Override
    public void transferir(double valor, Conta destino) throws SaldoInsuficienteException, ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor inválido para transferência.");
        }
        if (valor > getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para transferência.");
        }
        sacar(valor);
        destino.depositar(valor);
    }
}

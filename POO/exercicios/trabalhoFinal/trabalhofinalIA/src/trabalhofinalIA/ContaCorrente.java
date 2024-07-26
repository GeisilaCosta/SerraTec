package trabalhofinalIA;

class ContaCorrente extends Conta implements OperacoesBancarias {
    public ContaCorrente(String cpfTitular, String agencia) {
        super(cpfTitular, agencia);
    }

    @Override
    public String getTipoConta() {
        return "Corrente";
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor de saque inválido");
        }
        if (valor > getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque");
        }
        setSaldo(getSaldo() - valor);
    }

    @Override
    public void depositar(double valor) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor de depósito inválido");
        }
        setSaldo(getSaldo() + valor);
    }

    @Override
    public void transferir(double valor, Conta destino) throws SaldoInsuficienteException, ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("Valor de transferência inválido");
        }
        if (valor > getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para transferência");
        }
        this.sacar(valor);
        destino.depositar(valor);
    }
}

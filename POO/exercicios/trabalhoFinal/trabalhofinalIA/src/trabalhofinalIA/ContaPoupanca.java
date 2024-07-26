package trabalhofinalIA;

class ContaPoupanca extends Conta  implements OperacoesBancarias {
    public ContaPoupanca(String cpfTitular, String agencia) {
        super(cpfTitular, agencia);
    }

    @Override
    public String getTipoConta() {
        return "Poupança";
    }

    // Implementações dos métodos de operações bancárias
    // Você pode implementar as regras específicas para conta poupança, se necessário
    @Override
    public void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException {
        // Implementação
    }

    @Override
    public void depositar(double valor) throws ValorInvalidoException {
        // Implementação
    }

    @Override
    public void transferir(double valor, Conta destino) throws SaldoInsuficienteException, ValorInvalidoException {
        // Implementação
    }
}


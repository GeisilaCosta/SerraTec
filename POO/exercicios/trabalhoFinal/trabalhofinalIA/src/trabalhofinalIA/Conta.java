package trabalhofinalIA;

abstract class Conta implements OperacoesBancarias {
    private String cpfTitular;
    private double saldo;
    private String agencia;

    public Conta(String cpfTitular, String agencia) {
        this.cpfTitular = cpfTitular;
        this.agencia = agencia;
        this.saldo = 0.0;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract String getTipoConta();

    // Métodos para operações bancárias
    // Implementações serão feitas nas subclasses
    public abstract void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException;
    public abstract void depositar(double valor) throws ValorInvalidoException;
    public abstract void transferir(double valor, Conta destino) throws SaldoInsuficienteException, ValorInvalidoException;
}


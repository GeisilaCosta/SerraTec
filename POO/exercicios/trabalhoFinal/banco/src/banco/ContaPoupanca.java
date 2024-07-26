package banco;

class ContaPoupanca extends Conta {
    private final double RENDIMENTO_DIARIO = 0.01;

    public ContaPoupanca(String cpfTitular, String agencia) {
        super(cpfTitular, agencia);
    }

  /*  @Override
    public double calcularTributacao() {
        // Tributação sobre o rendimento da conta poupança
        double rendimento = calcularRendimento(30); // Rendimento mensal
        double tributacao = rendimento * 0.15; // Imposto de 15% sobre o rendimento
        return tributacao;
    }

    @Override
    public double calcularRendimento(int dias) {
        // Implementação do rendimento básico para a conta poupança
        double taxaDiaria = 0.0004; // 0.04% de rendimento diário
        return getSaldo() * Math.pow(1 + taxaDiaria, dias) - getSaldo();
    }*/ /// verificar valores da tributacao

}
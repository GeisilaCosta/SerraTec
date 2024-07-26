package java1;

public class Gerente extends Funcionario {
	private String identificadorAgencia;
	private String cargo = "Gerente";
	
	
	// Construtor da classe Gerente
	  public Gerente(String senha, String cPF, String identificadorAgencia, String cargo) {
		super(senha, cPF);
		this.identificadorAgencia = identificadorAgencia;
		this.cargo = cargo;
	}

	
	
	public String getIdentificadorAgencia() {
		return identificadorAgencia;
	}



	public String getCargo() {
		return cargo;
	}



	//Implementar um método para exibir o saldo atual da conta do cliente:
	public void exibirSaldoCliente(double d) {
	    double saldo = d.getSaldo();
	    System.out.println("Saldo da conta do cliente " + d.getNome() + ": R$" + saldo);
	}

	/*Criar um método que calcule o total gasto nas operações e os valores cobrados pelo banco por cada operação:*/
	public void relatorioTributacaoContaCorrente(ContaCorrente conta) {
	    // Lógica para calcular o total gasto e os valores cobrados
	    // Apresentar os resultados na tela ou armazenar em variáveis para uso posterior
	}

	//Implementar um método que simule o rendimento da poupança para um determinado período:
	public void relatorioRendimentoPoupanca(double valorInicial, int dias) {
	    // Lógica para calcular o rendimento da poupança com base no valor inicial e na quantidade de dias
	    // Apresentar o rendimento na tela ou retornar o valor para uso posterior
	}
//Criar um método que conte o número de contas na mesma agência em que o gerente trabalha:
	public int contarContasMesmaAgencia(List<Conta> contas, String agencia) {
	    int count = 0;
	    for (Conta conta : contas) {
	        if (conta.getAgencia().equals(agencia)) {
	            count++;
	        }
	    }
	    return count;
	}

	
	
	
}

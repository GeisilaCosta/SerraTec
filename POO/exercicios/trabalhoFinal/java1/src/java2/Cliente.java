package java2;

public class Cliente extends Usuario {
	private String nome;
    private String cpf;
    private double saldo;
    
    

	public Cliente(String cpf, String senha, double saldo) {
		super(cpf, senha);
		this.nome = nome;
		this.cpf = cpf;
		this.saldo = saldo;
	}
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void realizarSaque(double valor) {
	    if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso. Novo saldo: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
		
	}

	public void realizarDeposito(double valor) {
		 if (valor > 0) {
	            saldo += valor;
	            System.out.println("Depósito realizado com sucesso. Novo saldo: R$" + saldo);
	        } else {
	            System.out.println("Valor inválido para depósito.");
	        }
		
	}

	public void realizarTransferencia(double valor, Cliente destinatario) {
		 if (valor > 0 && valor <= saldo) {
	            saldo -= valor;
	            destinatario.realizarDeposito(valor);
	            System.out.println("Transferência realizada com sucesso.");
	        } else {
	            System.out.println("Saldo insuficiente para transferência.");
	        }
		
	}


	public void exibirSaldo() {
		 System.out.println("Saldo atual: R$" + saldo);
		
	}
	
	 public void relatorioTributacaoContaCorrente() {
	        double totalGasto = 0.10 * (realizarSaque + realizarDeposito) + 0.20 * realizarTransferencia;
	        System.out.println("Total gasto nas operações: R$" + totalGasto);
	        System.out.println("Taxa por saque: R$0.10");
	        System.out.println("Taxa por depósito: R$0.10");
	        System.out.println("Taxa por transferência: R$0.20 (cobrada apenas do remetente)");
	    }
	 
	  // Método para simular rendimento da poupança
	    public void relatorioRendimentoPoupanca(int meses) {
	        double taxaJurosAnual = 0.03; // Exemplo: 3% ao ano
	        double saldoFinal = saldo * Math.pow(1 + taxaJurosAnual / 12, meses);
	        double rendimento = saldoFinal - saldo;

	        System.out.println("Rendimento da poupança após " + meses + " meses: R$" + rendimento);
	        System.out.println("Saldo final: R$" + saldoFinal);
	    }
	}
}

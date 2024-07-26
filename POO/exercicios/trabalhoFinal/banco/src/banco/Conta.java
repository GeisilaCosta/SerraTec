package banco;

public abstract class Conta implements OperacoesContaInterface {
	 private String cpfTitular;
	    private double saldo;
	    private String agencia;
	    public int contador;
	    public int numeroConta = contador;
	    

	    public Conta(String cpfTitular, String agencia) {
	        this.cpfTitular = cpfTitular;
	        this.agencia = agencia;
	        this.saldo = 0.0;
	        contador +=1;
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

	    public void setSaldo(double saldo) {
	        this.saldo = saldo;
	    }

	    @Override
	    public void sacar(double valor) {
	        if (valor > 0 && valor <= saldo) {
	            saldo -= valor;
	            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
	        } else {
	            System.out.println("Saldo insuficiente para saque.");
	        }
	    }

	    @Override
	    public void depositar(double valor) {
	        if (valor > 0) {
	            saldo += valor;
	            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
	        } else {
	            System.out.println("Valor de depósito inválido.");
	        }
	    }

	    @Override
	    public void transferir(double valor, Conta destino) {
	        if (valor > 0 && valor <= saldo) {
	            saldo -= valor;
	            destino.depositar(valor);
	            System.out.println("Transferência de R$" + valor + " realizada para conta de " + destino.getCpfTitular());
	        } else {
	            System.out.println("Saldo insuficiente para transferência.");
	        }
	    }

	    @Override
	    public double calcularTributacao() {
	        // Implementação da tributação específica para cada tipo de conta
	    	
	        return 0.0;
	    }

	   @Override
	    public double calcularRendimento(int dias) {
	        // Implementação do rendimento específico para cada tipo de conta
	    	  double taxaDiaria = 0.0005; // 0.05% de rendimento diário
	    	    return getSaldo() * Math.pow(1 + taxaDiaria, dias) - getSaldo();
	        return 0.0;
	    } //ver o valor da tributacao
	}


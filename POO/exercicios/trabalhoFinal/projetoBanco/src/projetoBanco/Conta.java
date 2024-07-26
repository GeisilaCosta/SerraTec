package projetoBanco;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

abstract class Conta {
    private String cpfTitular;
    private double saldo;
    private String agencia;
    private TipoContaEnun tipo ;
    public static int contadorDeContas = 1;
	public int numeroConta = contadorDeContas;

    // Construtor, getters e setters
    
	public Conta(String cpfTitular, double saldo, String agencia, TipoContaEnun tipo) {
		super();
		this.cpfTitular = cpfTitular;
		this.saldo = 0.0;
		this.agencia = agencia;
		this.tipo = tipo;
		contadorDeContas += 1;
	}
    public abstract void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException;
    public abstract void depositar(double valor) throws ValorInvalidoException;
    public abstract void transferir(double valor, Conta destino) throws SaldoInsuficienteException, ValorInvalidoException;
    
	public String getCpfTitular() {
		return cpfTitular;
	}
	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}
	public abstract double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public TipoContaEnun getTipo() {
		return tipo;
	}
	public void setTipo(TipoContaEnun tipo) {
		this.tipo = tipo;
	}
	    
	    public abstract void realizarOperacao(double valor, String tipoOperacao);
	

	    public void registrarOperacao(String tipoOperacao, double valor) {
	        try (PrintWriter writer = new PrintWriter(new FileWriter("operacoes.txt", true))) {
	            writer.println(tipoOperacao + ": R$" + valor);
	        } catch (IOException e) {
	            System.out.println("Erro ao registrar operação: " + e.getMessage());
	        }
	    }
	    
	public static int getNumeroContasNaAgencia(String agencia) {
	    int count = 0;
	    for (Conta conta : contas) {
	        if (conta.getAgencia().equals(agencia)) {
	            count++;
	        }
	    }
	    return count;
	}

	public void relatorioClientes() {
	    // Implementar lógica para gerar o relatório de clientes em ordem alfabética
	}
	public void imprimirExtrato() {
	    try {
	        System.out.println("Extrato Bancário:");
	        System.out.println("-----------------");
	        Files.lines(Paths.get("operacoes.txt")).forEach(System.out::println);
	    } catch (IOException e) {
	        System.out.println("Erro ao imprimir extrato bancário: " + e.getMessage());
	    }
	}
	@Override
	public String toString() {
	    return "Conta{" +
	            "saldo=" + saldo +
	            ", agencia='" + agencia + '\'' +
	            '}';
	}
	public static void listarClientesEmOrdemAlfabetica() {
	    List<Cliente> clientesOrdenados = new ArrayList<>(clientes);
	    clientesOrdenados.sort(Comparator.comparing(Cliente::getNome));

	    for (Cliente cliente : clientesOrdenados) {
	        System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf() + ", Agência: " + cliente.getConta().getAgencia());
	    }
	}
	private static void menuRelatoriosPresidente(Presidente presidente) {
	    System.out.println("Relatórios:");
	    System.out.println("1. Relatório com as informações de Nome, CPF e Agência de todos os clientes do sistema em ordem alfabética");
	    System.out.println("2. Relatório com o valor total do capital armazenado no banco");
	    System.out.println("3. Voltar");

	    int opcao = scanner.nextInt();
	    scanner.nextLine(); // Limpar o buffer do scanner

	    switch (opcao) {
	        case 1:
	            System.out.println("Relatório de clientes em ordem alfabética:");
	            Banco.listarClientesEmOrdemAlfabetica();
	            break;
	        case 2:
	            System.out.println("Relatório de valor total do capital armazenado no banco:");
	            System.out.println("Valor total do capital: R$" + Banco.calcularValorTotalCapital());
	            break;
	        case 3:
	            System.out.println("Retornando ao menu anterior...");
	            break;
	        default:
	            System.out.println("Opção inválida. Tente novamente.");
	    }
	}
	public static double calcularValorTotalCapital() {
	    double totalCapital = 0.0;
	    for (Conta conta : contas) {
	        totalCapital += conta.getSaldo();
	    }
	    return totalCapital;
	}




}
package javaFinal;

package projetoBanco;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Conta {
    private String cpfTitular;
    private double saldo;
    private String agencia;
    private TipoContaEnun tipo;
    private static List<Conta> contas = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();

    public Conta(String cpfTitular, double saldo, String agencia, TipoContaEnun tipo) {
        this.cpfTitular = cpfTitular;
        this.saldo = saldo;
        this.agencia = agencia;
        this.tipo = tipo;
        contas.add(this);
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public double getSaldo() {
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

    public abstract void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException;

    public abstract void depositar(double valor) throws ValorInvalidoException;

    public abstract void transferir(double valor, Conta destino) throws SaldoInsuficienteException, ValorInvalidoException;

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

    public static void listarClientesEmOrdemAlfabetica() {
        List<Cliente> clientesOrdenados = new ArrayList<>(clientes);
        clientesOrdenados.sort(Comparator.comparing(Cliente::getNome));

        for (Cliente cliente : clientesOrdenados) {
            System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf() + ", Agência: " + cliente.getConta().getAgencia());
        }
    }

    public static void menuRelatoriosPresidente(Presidente presidente) {
        System.out.println("Relatórios:");
        System.out.println("1. Relatório com as informações de Nome, CPF e Agência de todos os clientes do sistema em ordem alfabética");
        System.out.println("2. Relatório com o valor total do capital armazenado no banco");
        System.out.println("3. Voltar");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (opcao) {
            case 1:
                System.out.println("Relatório de clientes em ordem alfabética:");
                Conta.listarClientesEmOrdemAlfabetica();
                break;
            case 2:
                System.out.println("Relatório de valor total do capital armazenado no banco:");
                System.out.println("Valor total do capital: R$" + Conta.calcularValorTotalCapital());
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


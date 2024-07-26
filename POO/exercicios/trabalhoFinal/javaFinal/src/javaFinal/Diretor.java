package javaFinal;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Diretor extends Funcionario {

    public Diretor(String cpf, String senha, String cargo) {
        super(cpf, senha, "Diretor");
    }

    @Override
    public void login(String cpf, String senha) {
        // Implementação do método login para Diretor
        // Aqui você pode adicionar a lógica de autenticação para o diretor
    }

    // Método específico para o Diretor
    public void relatoriosConta() {
        super.relatoriosConta(); // Chama o método da classe pai (Funcionario)
        System.out.println("e. Relatório de clientes (em ordem alfabética)");
        System.out.print("Opção: ");
        char opcao = scanner.nextLine().charAt(0);

        switch (opcao) {
            case 'e':
                relatorioClientes();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    // Método para gerar relatório de clientes em ordem alfabética
    public void relatorioClientes(List<Cliente> clientes) {
        System.out.println("Relatório de clientes (em ordem alfabética):");
        Collections.sort(clientes, new Comparator<Cliente>() {
            public int compare(Cliente c1, Cliente c2) {
                return c1.getNome().compareTo(c2.getNome());
            }
        });

        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf() + ", Agência: " + cliente.getAgencia());
        }
    }

    // Método para gerar relatório do valor total do capital
    public void relatorioValorTotalCapital(List<Cliente> clientes) {
        double totalCapital = 0;
        for (Cliente cliente : clientes) {
            // Adapte de acordo com a lógica correta para obter o saldo do cliente
            // Exemplo fictício: totalCapital += cliente.getSaldo();
        }
        System.out.println("Valor total do capital armazenado no banco: R$" + totalCapital);
    }
}

package javaFinal;

public class SistemaInterno {


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaInterno {
    private Map<String, Cliente> clientes;
    private Map<String, Funcionario> funcionarios;
    private static Scanner scanner;

    public SistemaInterno() {
        this.clientes = new HashMap<>();
        this.funcionarios = new HashMap<>();
        SistemaInterno.scanner = new Scanner(System.in);
    }
	public static void main(String[] args) {
		  SistemaInterno sistema = new SistemaInterno();
	        sistema.executar();
	    }

	    public void executar() {
	        carregarClientes();
	        carregarFuncionarios();

	        System.out.println("Bem-vindo ao Sistema Bancário!");

	        System.out.print("CPF: ");
	        String cpf = scanner.nextLine();

	        System.out.print("Senha: ");
	        String senha = scanner.nextLine();

	        if (clientes.containsKey(cpf)) {
	            Cliente cliente = clientes.get(cpf);
	            if (cliente.getSenha().equals(senha)) {
	                menuCliente(cliente);
	            } else {
	                System.out.println("Senha incorreta.");
	            }
	        } else if (funcionarios.containsKey(cpf)) {
	            Funcionario funcionario = funcionarios.get(cpf);
	            if (funcionario.getSenha().equals(senha)) {
	                menuFuncionario(funcionario);
	            } else {
	                System.out.println("Senha incorreta.");
	            }
	        } else {
	            System.out.println("CPF não cadastrado.");
	        }
	    }

	    private void menuCliente(Cliente cliente) {
	        System.out.println("Bem-vindo, " + cliente.getNome() + "!");

	        boolean sair = false;
	        while (!sair) {
	            System.out.println("\nMenu:");
	            System.out.println("1. Movimentações na Conta");
	            System.out.println("2. Relatórios");
	            System.out.println("3. Sair");
	            System.out.print("Escolha uma opção: ");
	            int opcao = scanner.nextInt();
	            scanner.nextLine();

	            switch (opcao) {
	                case 1:
	                    movimentacoesConta(cliente);
	                    break;
	                case 2:
	                    relatorios(cliente);
	                    break;
	                case 3:
	                    sair = true;
	                    break;
	                default:
	                    System.out.println("Opção inválida.");
	            }
	        }
	    }

	    private void movimentacoesConta(Cliente cliente) {
	        // Implementação das movimentações na conta para o cliente
	    }

	    private void relatorios(Cliente cliente) {
	        // Implementação dos relatórios para o cliente
	    }

	    private void menuFuncionario(Funcionario funcionario) {
	        System.out.println("Bem-vindo, " + funcionario.getCargo() + "!");

	        boolean sair = false;
	        while (!sair) {
	            System.out.println("\nMenu:");
	            System.out.println("1. Movimentações e Informações da Conta");
	            System.out.println("2. Relatórios");
	            System.out.println("3. Sair");
	            System.out.print("Escolha uma opção: ");
	            int opcao = scanner.nextInt();
	            scanner.nextLine();

	            switch (opcao) {
	                case 1:
	                    movimentacoesInformacoesConta((Gerente) funcionario); // Exemplo com Gerente, adapte para outros tipos de funcionários
	                    break;
	                case 2:
	                    relatoriosFuncionario(funcionario); // Exemplo com Funcionario, adapte para outros tipos de funcionários
	                    break;
	                case 3:
	                    sair = true;
	                    break;
	                default:
	                    System.out.println("Opção inválida.");
	            }
	        }
	    }

	    private void movimentacoesInformacoesConta(Gerente gerente) {
	        // Implementação das movimentações e informações da conta para o gerente
	    }

	    private void relatoriosFuncionario(Funcionario funcionario) {
	        // Implementação dos relatórios para o funcionário
	    }

	    private void carregarClientes() {
	        try {
	            File file = new File("clientes.txt");
	            Scanner scanner = new Scanner(file);
	            while (scanner.hasNextLine()) {
	                String linha = scanner.nextLine();
	                String[] dados = linha.split(",");
	                String cpf = dados[0];
	                String nome = dados[1];
	                String senha = dados[2];
	                Cliente cliente = new Cliente(cpf, nome, senha);
	                clientes.put(cpf, cliente);
	            }
	            scanner.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("Erro ao carregar clientes: arquivo não encontrado.");
	        }
	    }

	    private void carregarFuncionarios() {
	        try {
	            File file = new File("funcionarios.txt");
	            Scanner scanner = new Scanner(file);
	            while (scanner.hasNextLine()) {
	                String linha = scanner.nextLine();
	                String[] dados = linha.split(",");
	                String cpf = dados[0];
	                String nome = dados[1];
	                String senha = dados[2];
	                String cargo = dados[3];
	                Funcionario funcionario;
	                switch (cargo) {
	                    case "Gerente":
	                        funcionario = new Gerente(cpf, nome, senha);
	                        break;
	                    case "Diretor":
	                        funcionario = new Diretor(cpf, nome, senha);
	                        break;
	                    case "Presidente":
	                        funcionario = new Presidente(cpf, nome, senha);
	                        break;
	                    default:
	                        funcionario = null;
	                }
	                if (funcionario != null) {
	                    funcionarios.put(cpf, funcionario);
	                }
	            }
	            scanner.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("Erro ao carregar funcionários: arquivo não encontrado.");
	        }
	    }
	}  SistemaInterno sistema = new SistemaInterno();
    sistema.executar();
}

public void executar() {
    carregarClientes();
    carregarFuncionarios();

    System.out.println("Bem-vindo ao Sistema Bancário!");

    System.out.print("CPF: ");
    String cpf = scanner.nextLine();

    System.out.print("Senha: ");
    String senha = scanner.nextLine();

    if (clientes.containsKey(cpf)) {
        Cliente cliente = clientes.get(cpf);
        if (cliente.getSenha().equals(senha)) {
            menuCliente(cliente);
        } else {
            System.out.println("Senha incorreta.");
        }
    } else if (funcionarios.containsKey(cpf)) {
        Funcionario funcionario = funcionarios.get(cpf);
        if (funcionario.getSenha().equals(senha)) {
            menuFuncionario(funcionario);
        } else {
            System.out.println("Senha incorreta.");
        }
    } else {
        System.out.println("CPF não cadastrado.");
    }
}

private void menuCliente(Cliente cliente) {
    System.out.println("Bem-vindo, " + cliente.getNome() + "!");

    boolean sair = false;
    while (!sair) {
        System.out.println("\nMenu:");
        System.out.println("1. Movimentações na Conta");
        System.out.println("2. Relatórios");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                movimentacoesConta(cliente);
                break;
            case 2:
                relatorios(cliente);
                break;
            case 3:
                sair = true;
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}

private void movimentacoesConta(Cliente cliente) {
    // Implementação das movimentações na conta para o cliente
}

private void relatorios(Cliente cliente) {
    // Implementação dos relatórios para o cliente
}

private void menuFuncionario(Funcionario funcionario) {
    System.out.println("Bem-vindo, " + funcionario.getCargo() + "!");

    boolean sair = false;
    while (!sair) {
        System.out.println("\nMenu:");
        System.out.println("1. Movimentações e Informações da Conta");
        System.out.println("2. Relatórios");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                movimentacoesInformacoesConta((Gerente) funcionario); // Exemplo com Gerente, adapte para outros tipos de funcionários
                break;
            case 2:
                relatoriosFuncionario(funcionario); // Exemplo com Funcionario, adapte para outros tipos de funcionários
                break;
            case 3:
                sair = true;
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}

private void movimentacoesInformacoesConta(Gerente gerente) {
    // Implementação das movimentações e informações da conta para o gerente
}

private void relatoriosFuncionario(Funcionario funcionario) {
    // Implementação dos relatórios para o funcionário
}

private void carregarClientes() {
    try {
        File file = new File("clientes.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(",");
            String cpf = dados[0];
            String nome = dados[1];
            String senha = dados[2];
            Cliente cliente = new Cliente(cpf, nome, senha);
            clientes.put(cpf, cliente);
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("Erro ao carregar clientes: arquivo não encontrado.");
    }
}

private void carregarFuncionarios() {
    try {
        File file = new File("funcionarios.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] dados = linha.split(",");
            String cpf = dados[0];
            String nome = dados[1];
            String senha = dados[2];
            String cargo = dados[3];
            Funcionario funcionario;
            switch (cargo) {
                case "Gerente":
                    funcionario = new Gerente(cpf, nome, senha);
                    break;
                case "Diretor":
                    funcionario = new Diretor(cpf, nome, senha);
                    break;
                case "Presidente":
                    funcionario = new Presidente(cpf, nome, senha);
                    break;
                default:
                    funcionario = null;
            }
            if (funcionario != null) {
                funcionarios.put(cpf, funcionario);
            }
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("Erro ao carregar funcionários: arquivo não encontrado.");
    }
}
}

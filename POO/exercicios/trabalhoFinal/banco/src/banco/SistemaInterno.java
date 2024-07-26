import java.util.Scanner;

public class SistemaInterno {
	   private static Banco banco = new Banco();
	    private static Scanner scanner = new Scanner(System.in);
	    private static Funcionario funcionarioLogado;

	    public static void main(String[] args) {
	        exibirMenuLogin();
	    }

	    private static void exibirMenuLogin() {
	        System.out.println("=== Sistema Bancário ===");
	        System.out.println("Digite seu CPF:");
	        String cpf = scanner.nextLine();
	        System.out.println("Digite sua senha:");
	        String senha = scanner.nextLine();

	        // Verificar se o usuário é um cliente, gerente, diretor ou presidente
	        if (banco.validarCliente(cpf, senha)) {
	            funcionarioLogado = banco.getClientePorCPF(cpf);
	            exibirMenuCliente();
	        } else if (banco.validarGerente(cpf, senha)) {
	            funcionarioLogado = banco.getGerentePorCPF(cpf);
	            exibirMenuGerente();
	        } else if (banco.validarDiretor(cpf, senha)) {
	            funcionarioLogado = banco.getDiretorPorCPF(cpf);
	            exibirMenuDiretor();
	        } else if (banco.validarPresidente(cpf, senha)) {
	            funcionarioLogado = banco.getPresidentePorCPF(cpf);
	            exibirMenuPresidente();
	        } else {
	            System.out.println("CPF ou senha inválidos. Tente novamente.");
	            exibirMenuLogin();
	        }


	        private static void exibirMenuCliente() {
	            System.out.println("=== Menu Cliente ===");
	            System.out.println("1. Realizar Saque");
	            System.out.println("2. Realizar Depósito");
	            System.out.println("3. Realizar Transferência");
	            System.out.println("4. Gerar Relatórios");
	            System.out.println("5. Sair");

	            int opcao = Integer.parseInt(scanner.nextLine());
	            switch (opcao) {
	                case 1:
	                	realizarSaque();
	                    break;
	                case 2:
	                    realizarDeposito();
	                    break;
	                case 3:
	                    realizarTransferencia();
	                    break;
	                case 4:
	                    gerarRelatorioCliente();
	                    break;
	                case 5:
	                    System.out.println("Saindo...");
	                    break;
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	                    exibirMenuCliente();
	            }
	            private static void realizarSaque() {
	                System.out.println("Digite o valor do saque:");
	                double valor = Double.parseDouble(scanner.nextLine());
	                OperacoesBancarias.realizarSaque(funcionarioLogado, valor);
	            }

	            private static void realizarDeposito() {
	                System.out.println("Digite o valor do depósito:");
	                double valor = Double.parseDouble(scanner.nextLine());
	                OperacoesBancarias.realizarDeposito(funcionarioLogado, valor);
	            }

	            private static void realizarTransferencia() {
	                System.out.println("Digite o valor da transferência:");
	                double valor = Double.parseDouble(scanner.nextLine());
	                System.out.println("Digite o CPF do destinatário:");
	                String cpfDestinatario = scanner.nextLine();
	                Conta contaDestino = banco.buscarContaPorCPF(cpfDestinatario);
	                if (contaDestino != null) {
	                    OperacoesBancarias.realizarTransferencia(funcionarioLogado, contaDestino, valor);
	                } else {
	                    System.out.println("Conta do destinatário não encontrada.");
	                }
	            }
	        }



	    private static void exibirMenuGerente() {
	        System.out.println("=== Menu Gerente ===");
	        System.out.println("1. Realizar Saque");
	        System.out.println("2. Realizar Depósito");
	        System.out.println("3. Realizar Transferência");
	        System.out.println("4. Gerar Relatórios");
	        System.out.println("5. Sair");

	        int opcao = Integer.parseInt(scanner.nextLine());
	        switch (opcao) {
	            case 1:
	                OperacoesBancarias.realizarSaque(funcionarioLogado, scanner);
	                break;
	            case 2:
	                OperacoesBancarias.realizarDeposito(funcionarioLogado, scanner);
	                break;
	            case 3:
	                OperacoesBancarias.realizarTransferencia(funcionarioLogado, scanner);
	                break;
	            case 4:
	                GeradorRelatorios.gerarRelatorioGerente(banco.getNumContas());
	                break;
	            case 5:
	                System.out.println("Saindo...");
	                break;
	            default:
	                System.out.println("Opção inválida. Tente novamente.");
	                exibirMenuGerente();
	        }
	    }

	    private static void exibirMenuDiretor() {
	        System.out.println("=== Menu Diretor ===");
	        System.out.println("1. Realizar Saque");
	        System.out.println("2. Realizar Depósito");
	        System.out.println("3. Realizar Transferência");
	        System.out.println("4. Gerar Relatórios");
	        System.out.println("5. Sair");

	        int opcao = Integer.parseInt(scanner.nextLine());
	        switch (opcao) {
	            case 1:
	                OperacoesBancarias.realizarSaque(funcionarioLogado, scanner);
	                break;
	            case 2:
	                OperacoesBancarias.realizarDeposito(funcionarioLogado, scanner);
	                break;
	            case 3:
	                OperacoesBancarias.realizarTransferencia(funcionarioLogado, scanner);
	                break;
	            case 4:
	                GeradorRelatorios.gerarRelatorioDiretor(banco.getClientes());
	                break;
	            case 5:
	                System.out.println("Saindo...");
	                break;
	            default:
	                System.out.println("Opção inválida. Tente novamente.");
	                exibirMenuDiretor();
	        }
	    }

	    private static void exibirMenuPresidente() {
	        System.out.println("=== Menu Presidente ===");
	        System.out.println("1. Realizar Saque");
	        System.out.println("2. Realizar Depósito");
	        System.out.println("3. Realizar Transferência");
	        System.out.println("4. Gerar Relatórios");
	        System.out.println("5. Sair");

	        int opcao = Integer.parseInt(scanner.nextLine());
	        switch (opcao) {
	            case 1:
	                OperacoesBancarias.realizarSaque(funcionarioLogado, scanner);
	                break;
	            case 2:
	                OperacoesBancarias.realizarDeposito(funcionarioLogado, scanner);
	                break;
	            case 3:
	                OperacoesBancarias.realizarTransferencia(funcionarioLogado, scanner);
	                break;
	            case 4:
	                GeradorRelatorios.gerarRelatorioPresidente(banco.getCapitalTotal());
	                break;
	            case 5:
	                System.out.println("Saindo...");
	                break;
	            default:
	                System.out.println("Opção inválida. Tente novamente.");
	                exibirMenuPresidente();
	        }
	    }
	}

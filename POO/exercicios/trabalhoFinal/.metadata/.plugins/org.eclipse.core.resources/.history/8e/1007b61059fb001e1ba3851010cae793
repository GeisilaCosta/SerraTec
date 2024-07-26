package projetoBanco;

public class Presidente extends Funcionario {


    public Presidente(String cpf, String senha, String cargo) {
		super(cpf, senha, "Presidente");
	}

	// Implementação específica para Presidente

    public void relatoriosConta() {
        super.relatoriosConta(); // Chamando método da classe pai (Diretor)

        // Opção adicional para o Presidente
        System.out.println("f. Relatório do valor total do capital armazenado no banco");
        System.out.print("Opção: ");
        char opcao = scanner.nextLine().charAt(0);

        switch (opcao) {
            case 'f':
                relatorioValorTotalCapital();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public void relatorioValorTotalCapital() {
        double totalCapital = 0;
        for (Cliente cliente : Clientes) {
            totalCapital += cliente.getSaldo();
        }
        System.out.println("Valor total do capital armazenado no banco: R$" + totalCapital);
    }

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	
}

package projetoBanco;

public class Gerente extends Funcionario {
   

	public Gerente(String cpf, String senha, String cargo, String agenciaResponsavel) {
		super(cpf, senha, "Gerente");
		this.agenciaResponsavel = agenciaResponsavel;
	}

	public String getAgenciaResponsavel() {
		return agenciaResponsavel;
	}

	public void setAgenciaResponsavel(String agenciaResponsavel) {
		this.agenciaResponsavel = agenciaResponsavel;
	}

	private String agenciaResponsavel;

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	public void movimentacoesConta() {
	    super.movimentacoesConta(); // Chamando método da classe pai (Cliente)

	    // Opções adicionais para o Gerente
	    System.out.println("d. Consultar número de contas na agência");
	    System.out.print("Opção: ");
	    char opcao = scanner.nextLine().charAt(0);

	    switch (opcao) {
	        case 'd':
	            System.out.println("Número de contas na agência: " + Conta.getNumeroContasNaAgencia(agenciaResponsavel));
	            break;
	        default:
	            System.out.println("Opção inválida.");
	    }
	}

	public void relatoriosConta() {
	    super.relatoriosConta(); // Chamando método da classe pai (Cliente)

	    // Opções adicionais para o Gerente
	    System.out.println("d. Consultar número de contas na agência");
	    System.out.print("Opção: ");
	    char opcao = scanner.nextLine().charAt(0);

	    switch (opcao) {
	        case 'd':
	            System.out.println("Número de contas na agência: " + Conta.getNumeroContasNaAgencia(agenciaResponsavel));
	            break;
	        default:
	            System.out.println("Opção inválida.");
	    }
	}

    // Implementação específica para Gerente
}
package javaFinal;

public class Gerente extends Funcionario {

    private String agenciaResponsavel;

    public Gerente(String cpf, String senha, String agenciaResponsavel) {
        super(cpf, senha, "Gerente");
        this.agenciaResponsavel = agenciaResponsavel;
    }

    public String getAgenciaResponsavel() {
        return agenciaResponsavel;
    }

    public void setAgenciaResponsavel(String agenciaResponsavel) {
        this.agenciaResponsavel = agenciaResponsavel;
    }

    @Override
    public void login() {
        // Implementação do método login específico para o Gerente
        // Aqui você pode adicionar a lógica para o login do Gerente
    }

    public void movimentacoesConta() {
        super.movimentacoesConta(); // Chamando método da classe pai (Funcionario)

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
        super.relatoriosConta(); // Chamando método da classe pai (Funcionario)

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
}

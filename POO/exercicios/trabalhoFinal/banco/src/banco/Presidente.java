package banco;

class Presidente extends Funcionario {
    public Presidente(String cpf, String senha) {
        super(cpf, senha, CargoEnun.PRESIDENTE);
    }

    public void relatorioCapitalBanco() {
        // Implementação do relatório de capital do banco
    }
}
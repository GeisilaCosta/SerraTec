package trabalhofinalIA;

abstract class Funcionario extends Usuario {
    public Funcionario(String cpf, String senha) {
        super(cpf, senha);
    }

    public abstract void exibirMenu();
}

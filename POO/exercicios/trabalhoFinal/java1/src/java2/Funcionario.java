package java2;

public abstract class Funcionario extends Usuario {
	protected String cargo;

    public Funcionario(String cpf, String senha, String cargo) {
        super(cpf, senha);
        this.cargo = cargo;
    }

}


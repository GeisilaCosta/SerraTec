package banco;

public class Funcionario {
	private String cpf;
    private String senha;
    private CargoEnun cargo;

    public Funcionario(String cpf, String senha, CargoEnun cargo) {
        this.cpf = cpf;
        this.senha = senha;
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public CargoEnun getCargo() {
        return cargo;
    }
}

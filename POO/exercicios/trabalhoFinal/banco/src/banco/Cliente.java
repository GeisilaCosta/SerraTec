package banco;

public class Cliente {
	 private String cpf;
	    private String senha;

	    public Cliente(String cpf, String senha) {
	        this.cpf = cpf;
	        this.senha = senha;
	    }

	    public String getCpf() {
	        return cpf;
	    }

	    public String getSenha() {
	        return senha;
	    }
}

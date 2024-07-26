package trabalhofinalIA;

public abstract class Usuario {
	
	    private String cpf;
	    private String senha;

	    public Usuario(String cpf, String senha) {
	        this.cpf = cpf;
	        this.senha = senha;
	    }

	    public String getSenha() {
	        return senha;
	    }
	}


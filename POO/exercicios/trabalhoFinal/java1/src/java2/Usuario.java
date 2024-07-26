package java2;

public abstract class Usuario {
	 protected String cpf;
	    protected String senha;

	    public Usuario(String cpf, String senha) {
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


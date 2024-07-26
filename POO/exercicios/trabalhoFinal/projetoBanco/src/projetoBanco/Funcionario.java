package projetoBanco;


	abstract class Funcionario {
	    private String cpf;
	    private String senha;
	    private String cargo;
	    
		// Constructor, getters e setters
		public Funcionario(String cpf, String senha, String cargo) {
			super();
			this.cpf = cpf;
			this.senha = senha;
			this.cargo = cargo;
		}

	    public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getCargo() {
			return cargo;
		}

		public void setCargo(String cargo) {
			this.cargo = cargo;
		}

	
	    public abstract void login();
	}
	public boolean fazerLogin(String cpf, String senha) {
	    return this.cpf.equals(cpf) && this.senha.equals(senha);
	}



package trabalhoFinal;

public class Cliente extends Usuarios {
	private static int counter = 1;  //contar a cada cliente criado
	private TipoContaEnun tipoConta;
	
	public Cliente(String nome, String senha, String cpf, TiposUsuariosEnun tipoUsuarios, TipoContaEnun tipoConta) {
		super(nome, senha, cpf, tipoUsuarios);
		this.tipoConta = tipoConta;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Cliente.counter = counter;
	}
	public TipoContaEnun getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(TipoContaEnun tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	
	
}
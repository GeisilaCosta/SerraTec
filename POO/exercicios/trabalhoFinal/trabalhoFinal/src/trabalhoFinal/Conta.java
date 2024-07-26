package trabalhoFinal;
import java.util.List;

public abstract class Conta implements OperacoesBancariasInterface  { // nao sera instanciada
	private Cliente cliente;
	private int identificadorAgencia;
	private TipoContaEnun tipoConta;
	protected double saldo;
	private List<String> historico;
	public static int contadorDeContas = 1;
	public int numeroConta = contadorDeContas;
	
	
	public Conta(Cliente cliente, int identificadorAgencia, TipoContaEnun tipoConta, double saldo,
			List<String> historico) {
		super();
		this.cliente = cliente;
		this.identificadorAgencia = identificadorAgencia;
		this.tipoConta = tipoConta;
		this.saldo = saldo;
		this.historico = historico;
		contadorDeContas +=1;
	}

	


	public Cliente getCliente() {
		return cliente;
	}




	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	public int getIdentificadorAgencia() {
		return identificadorAgencia;
	}




	public void setIdentificadorAgencia(int identificadorAgencia) {
		this.identificadorAgencia = identificadorAgencia;
	}




	public TipoContaEnun getTipoConta() {
		return tipoConta;
	}




	public void setTipoConta(TipoContaEnun tipoConta) {
		this.tipoConta = tipoConta;
	}




	public Double getSaldo() {
		return saldo;
	}




	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}




	public List<String> getHistorico() {
		return historico;
	}




	public void setHistorico(List<String> historico) {
		this.historico = historico;
	}


	 public void registrarOperacao(String operacao, double valor) {
	        historico.add(operacao + ": R$" + valor);
	    }

	    public void exibirHistorico() {
	        for (String operacao : historico) {
	            System.out.println(operacao);
	        }
	    }


	public String toString() {
		return "\nNome: " + this.cliente.getNome()+
				"\nCPF: " + this.cliente.getCpf()+
				"\nsenha: " + this.cliente.getSenha() +
		"\nId da agencia: " + this.identificadorAgencia +
		"\nTipo de usuario: " + this.getTipoConta();
	}

}




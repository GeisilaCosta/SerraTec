package principal;

import contas.Conta;

public class Aplicacao {

	public static void main(String[] args) {
		System.out.println("Hello World Again");

		
		Conta conta = new Conta();
		conta.numero = 3;
		System.out.println("o numero da conta :", + conta.numero);
	}

}

package java2;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	   private List<Cliente> clientes;
	    private List<Gerente> gerentes;
	    private List<Diretor> diretores;
	    private List<Presidente> presidentes;
	    

		public Banco() {
	        clientes = new ArrayList<>();
	        gerentes = new ArrayList<>();
	        diretores= new ArrayList<>();
	        presidentes = new ArrayList<>();
	        // Inicialize o banco com os dados lidos do arquivo de texto
	    }

	    public void carregarDadosDoArquivo(String nomeArquivo) {
	        // Implemente a lógica para carregar os dados do arquivo
	        // Você pode usar classes como FileReader e BufferedReader para ler o arquivo
	    }
	    
	    public Usuario fazerLogin(String cpf, String senha) {
	        // Implemente a lógica para fazer login do usuário
	        for (Cliente cliente : clientes) {
	            if (cliente.getCpf().equals(cpf) && cliente.getSenha().equals(senha)) {
	                return cliente;
	            }
	        }
	        for (Gerente gerente : gerentes) {
	            if (gerente.getCpf().equals(cpf) && gerente.getSenha().equals(senha)) {
	                return gerente;
	            }
	        }
	        for (Diretor diretor : diretores) {
	            if (diretor.getCpf().equals(cpf) && diretor.getSenha().equals(senha)) {
	                return diretor;
	            }
	        }
	        for (Presidente presidente : presidentes) {
	            if (presidente.getCpf().equals(cpf) && presidente.getSenha().equals(senha)) {
	                return presidente;
	            }
	        }
	        return null;
	    }
}

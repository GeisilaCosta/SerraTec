package java1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Diretor extends Funcionario{
	

	    // Método para gerar relatório com informações de todos os clientes em ordem alfabética
	    public void relatorioClientesEmOrdemAlfabetica(List<Cliente> clientes) {
	        // Criar uma lista auxiliar para armazenar as informações de todos os clientes
	        List<String> informacoesClientes = new ArrayList<>();

	        // Iterar sobre a lista de clientes para obter as informações de cada cliente
	        for (Cliente cliente : clientes) {
	            String informacaoCliente = "Nome: " + cliente.getNome() + ", CPF: " + cliente.getCPF() + ", Agência: " + cliente.getAgencia();
	            informacoesClientes.add(informacaoCliente);
	        }

	        // Ordenar a lista de informações de clientes em ordem alfabética
	        Collections.sort(informacoesClientes);

	        // Exibir ou armazenar o relatório ordenado
	        for (String informacaoCliente : informacoesClientes) {
	            System.out.println(informacaoCliente);
	        }
	    }
	}




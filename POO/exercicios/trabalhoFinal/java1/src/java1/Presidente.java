package java1;

public class Presidente extends Funcionario {

	 // Método para calcular o valor total do capital armazenado no banco
    public double calcularValorTotalCapital(List<Conta> contas) {
        double totalCapital = 0.0;
        for (Conta conta : contas) {
            totalCapital += conta.getSaldo();
        }
        return totalCapital;
    }
    
    
            // Supondo que 'listaContas' seja uma lista que contém todas as contas do banco
            Presidente presidente = new Presidente();
            double totalCapital = presidente.calcularValorTotalCapital(listaContas);
            System.out.println("Valor total do capital armazenado no banco: R$" + totalCapital);
        }
	public double calcularValorTotalCapital(List<Conta> contas) {
    if (contas == null || contas.isEmpty()) {
        throw new IllegalArgumentException("A lista de contas está vazia ou nula.");
    }

    double totalCapital = 0.0;
    for (Conta conta : contas) {
        totalCapital += conta.getSaldo();
    }
    return totalCapital;
}

    }

}

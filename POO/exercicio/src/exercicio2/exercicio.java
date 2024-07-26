package exercicio2;

public class exercicio {

	public static void main(String[] args) {
	
			int idade = 10;
			double peso = 82;
			double altura = 1.75;
			
			System.out.println("idade: " + idade);
			System.out.println("peso: " + peso);
			System.out.println("altura: " + altura);
			
			CalculadoraMedia calc = new CalculadoraMedia();
			
			double media = (calc.nota1 + calc.nota2 + calc.nota3 + calc.nota4)/4;
			
			System.out.println("Média: " + media);
			
		
	}

}

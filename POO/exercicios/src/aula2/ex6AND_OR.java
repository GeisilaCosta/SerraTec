package aula2;

public class ex6AND_OR {

	public static void main(String[] args) {
		int a=2, b=5, c=10;
		if((a>5) && (c>b)) {
			System.out.println("&& - Somente a primeira expressao e avaliada");
		}
		if((b==5) || (c==0)) {
			System.out.println("|| - Somente a primeira expressao e avaliada");
		}
		if((a>5) & (c>b)) {
			System.out.println("& - As duas expresses sao avaliadas");
		}
		if((b==5) | (c==0)) {
			System.out.println("| - As duas expresses sao avaliadas");
		}

	}

}

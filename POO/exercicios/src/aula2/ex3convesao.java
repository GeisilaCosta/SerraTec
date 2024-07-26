package aula2;

public class ex3convesao {

	public static void main(String[] args) {
		int a = 100;
		float b = a;
		double c = 4.19;
		int d = (int) c; //int d = c nao funciona
		float e = (float) c;
		float f = 6.18f;
		System.out.println(b+ "\n" +c + "\n" +d+ "\n"+ e + "\n"+f);

	}

}

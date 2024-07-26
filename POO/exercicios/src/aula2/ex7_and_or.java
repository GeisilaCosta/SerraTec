package aula2;

public class Ex7_and_or {

	public static void main(String[] args) {
		boolean a = 1==1;
		boolean b = 1==2;
		boolean c = 10==10;
		boolean d = 1==20;
		if(a && b) {
			System.out.println("avalia as duas expressoes");
		}; 
		if(b && c) {
			System.out.println("avalia apenas a primeira expressao");
		}; 
		if(a || c) {
			System.out.println("avalia apenas a primeira expressao");
		};
		if(b || c) {
			System.out.println("avalia as duas expressoes");
		};

	}

}

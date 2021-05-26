package exceptions.polymorphism;

public class Main {

	public static void main(String[] args) {
		A ab = new B();
		try {
			ab.m();
		} catch (E1 | E3 e) {
			
			e.printStackTrace();
		}

	}

}

package pl.sdacademy.tdd;

public class Fibonacci {
	public static int Fibonacci(int number) {
		if (number == 0 || number == 1) {
			return number;
		}
		return (Fibonacci(number - 1)) + (Fibonacci(number - 2));
	}


	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(Fibonacci(40));
		long end = System.currentTimeMillis();
		System.out.println("Elapsed time = " + (end-start));
	}


}
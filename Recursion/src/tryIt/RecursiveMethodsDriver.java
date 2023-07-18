package tryIt;

import java.util.Scanner;

public class RecursiveMethodsDriver {
	public static int fibonacci(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}

	}

	public static void m1(int n) {
		System.out.println(n);
		if (n > 1) {
			m1(n - 1);
		}
	}

	public static void m2(int n) {
		if (n > 1) {
			m2(n - 1);
		}
		System.out.println(n);
	}

	public static void m3(int n) {
		System.out.println(n);
		if (n > 1) {
			m1(n - 1);
		}
		if (n > 1) {
			m2(n - 1);
		}
		System.out.println(n);
	}

	public static void m4(int n) {
		for (int i = 0; i < n; i++)
			System.out.print("*");
		{
			System.out.println("");
		}
		if (n > 1)
			m4(n - 1);
		for (int j = 0; j < n; j++)
			System.out.print("!");
		{
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		int num = userInput.nextInt();
		userInput.nextLine();
		System.out.println(fibonacci(num));
		userInput.close();

		m1(5);
		System.out.println("");
		m2(5);
		m3(5);
		m4(5);

	}

}

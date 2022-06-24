package IOSystems;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Sum {

	public static void main(String[] args) throws IOException {
		sum();

	}

	public static void sum() throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintStream so = System.out;
		PrintStream er = System.err;
		int number = 0;
		so.println("Hello SUM!");
		while (!("end".equals(sc.next()))) {
			if(isInt(sc)) {
				System.out.println("Enter whole number: ");
				number += sc.nextInt();
			} else {
				er.println("Incorrect whole number value");
			}
		}
		so.println("Total SUM: " + number);
		sc.close();
		so.println("Bye SUM!");
	}

	public static boolean isInt(Scanner s) {
		if (s.hasNextInt()) {
			return true;
		} 
		return false;
	}
}

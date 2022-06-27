package IOSystems;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Sum {
	
	static Scanner sc = new Scanner(System.in);
	static PrintStream so = System.out;

	public static void main(String[] args) throws IOException {
		sumScanner();
		

	}

	public static void sumScanner() throws IOException {
		Integer number = 0;
		String data = "";
		so.println("Hello SUM!");
		so.println("Enter whole number: ");
		while(true) {
			data = sc.next();
			if(isValidScanner(sc, data)) {
				number += Integer.parseInt(data);
				so.println("Sum is: " + number);
				so.println("Enter whole number: ");
			}else if(!"end".equals(data)){
				System.err.println("Incorrect  whole number value");
			}else break;
			
		}
		sc.close();
		so.println("Bye SUM!");
	}

	public static boolean isValidScanner(Scanner s, String str) {
		try {
			if (s.hasNextInt()) {
				if(Integer.parseInt(str) >= 0) {
					return true;
				}else return false;
			}
		}catch (NumberFormatException e) {
			return false;
		}
		return false;
	}
	
	
	
}

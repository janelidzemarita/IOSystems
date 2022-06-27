package IOSystems;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumConsole {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		sumConsole();
	}

	public static void sumConsole() throws IOException {
		Console console = System.console();

		if (console == null) {
			System.err.println("No console.");
			System.exit(1);
		}
		String txt = "UTF-8";
		String username = console.readLine("Enter your username: ");
		char[] password = console.readPassword("Enter your password: ");
		int countUsername = 0;
		try (FileInputStream is = new FileInputStream("D:\\TBC_Academy\\IOSystems\\src\\IOSystems\\users.dat");
				BufferedInputStream bf = new BufferedInputStream(is);
				BufferedReader read = new BufferedReader(new InputStreamReader(bf, txt));) {
			String str = read.readLine();
			while (str != null) { // read file until you find username (or end)
				if (!str.equals(username)) { // check if you found username
					read.readLine();
					str = read.readLine();
				} else if (str.equals(username)) {
					str = read.readLine();
					if (password.length == str.length()) { // if you found username passwprd should be next readline
						for (int i = 0; i < str.length(); i++) { // validate password
							if (!(str.charAt(i) == password[i])) { // if even one char is different invalid pass.
								console.printf("Invalid username/password");
								System.exit(1);
							}
						} // username and password match. you are loged in.
						console.printf("Logged in as: %s%n", username);
					}
				}
			}
		}
		console.printf("Hello!");
		String helper = console.readLine("Please Enter number: ");
		while (true) {
			if (isValid(helper)) {
				countUsername += Integer.parseInt(helper);
				console.printf("Sum is: " + countUsername);
				helper = console.readLine("Please Enter number: ");
			} else {
				if ("end".equals(helper)) {
					break;
				} else {
					console.printf("Please Enter whole number");
				}

			}
		}
		console.printf("%nBye");
	}

	public static boolean isValid(String str) {
		try {
			if (!"end".equals(str)) {
				Integer x = Integer.parseInt(str);
				if (x >= 0)
					return true;
			} else
				return false;
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}
}

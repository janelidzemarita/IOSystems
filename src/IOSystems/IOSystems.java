package IOSystems;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class IOSystems {

	static PrintStream so = System.out;

	public static void main(String[] args) throws IOException {
		
		getMonthIndex(args); //task 5 check   use First letter uppercase and the rest lowercase;
		
		try {  //task 4 catching exceptions from task 3
			FileInputStream is = new FileInputStream("D:\\TBC_Academy\\IOSystems\\src\\IOSystems\\InputFileText");
			String txt = "UTF-8";

			String text = "Hello!\nგამარჯობა! \nΓειά Σας!";
			FileOutputStream os = new FileOutputStream("D:\\TBC_Academy\\IOSystems\\src\\IOSystems\\OutputFile");
			Task1Function(is, txt);
			Task2Function(os, text, txt);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (RuntimeException | IOException e2) {
			System.err.println(e2);
		}

	}
	public static void getMonthIndex(String[] args) {
		switch(args[0]) {
		case "January": so.println("odd position"); break;
		case "February": so.println("even position"); break;
		case "March": so.println("odd position"); break;
		case "April": so.println("even position"); break;
		case "May": so.println("odd position"); break;
		case "June": so.println("even position"); break;
		case "July": so.println("odd position"); break;
		case "August": so.println("even position"); break;
		case "September": so.println("odd position"); break;
		case "October": so.println("even position"); break;
		case "November": so.println("odd position"); break;
		case "December": so.println("even position"); break;
		default: System.err.println("Error!!!!") ;
		}
	}

	// for this function I created a new file where the read characters are written
	// (evey line)
	//task 3 (was task 1 from previous assignment
	public static void Task1Function(InputStream is, String encoding) throws IOException {  
		
		try (BufferedInputStream bf = new BufferedInputStream(is);
				BufferedReader read = new BufferedReader(new InputStreamReader(bf, encoding));) {

			String line = read.readLine();
			while (line != null) {
				so.println(line);
				line = read.readLine();
			}
		}
	}
	//task 3 (was task 2 from previous assignment
	public static void Task2Function(OutputStream os, String text, String encoding) throws IOException {
		try (OutputStreamWriter sOut = new OutputStreamWriter(os, Charset.forName(encoding));
				BufferedWriter bf = new BufferedWriter(sOut);) {
			
			bf.write(text);
		}
	}
}

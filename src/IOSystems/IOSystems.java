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

public class IOSystems {

	static PrintStream so = System.out;

	public static void main(String[] args) throws IOException {
		FileInputStream is = new FileInputStream("D:\\TBC_Academy\\IOSystems\\src\\IOSystems\\InputFileText");
		String txt = "UTF-8";
		Task1Function(is, txt);
		String text = "Hello!\nგამარჯობა! \nΓειά Σας!";
		FileOutputStream os = new FileOutputStream("D:\\TBC_Academy\\IOSystems\\src\\IOSystems\\OutputFile");
		Task2Function(os, text, txt);

	}

	// for this function I created a new file where the read characters are written
	// (evey line)
	public static void Task1Function(InputStream is, String encoding) {
		BufferedReader read = null;
		BufferedWriter bw = null;
		BufferedInputStream bf = null;

		try {
			bf = new BufferedInputStream(is);
			read = new BufferedReader(new InputStreamReader(bf, encoding));
			String line = read.readLine();

			while (line != null) {

				so.println(line);
				line = read.readLine();

			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e);
		} catch (IOException ioe) {
			System.out.println("I/O Exception: " + ioe);
		} finally {
			if (read != null && bw != null && bf != null) {
				try {
					bf.close();
					read.close();
					bw.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public static void Task2Function(OutputStream os, String text, String encoding) {

		BufferedWriter bf = null;
		OutputStreamWriter sOut = null;

		try {

			sOut = new OutputStreamWriter(os, encoding);

			bf = new BufferedWriter(sOut);

			bf.write(text);

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e);
		} catch (IOException ioe) {
			System.out.println("I/O Exception: " + ioe);
		} finally {
			if (bf != null && sOut != null) {
				try {
					bf.close();
					sOut.close();
				} catch (IOException e) {
				}
			}
		}
	}
}

package IOSystems;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.util.stream.Stream;

public class IOSystems {
	
	static PrintStream so = System.out;
	
	public static void main (String[] args) throws FileNotFoundException {
		FileInputStream is = new FileInputStream("D:\\TBC_Academy\\IOSystems\\src\\IOSystems\\InputFileText");
		String txt = "UTF-8";
		SomeFunctin(is, txt );
	}

	public static void SomeFunctin(InputStream is, String encoding) {
		InputStreamReader read = null;
		OutputStreamWriter out = null;

		
		try {
			out = new OutputStreamWriter(so, encoding);
			read = new InputStreamReader(is, encoding);
			String word = "";
			BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\TBC_Academy\\IOSystems\\src\\IOSystems\\OutputFile"));
			while(read.ready()) {
				word += (char) read.read();
			}
			bw.write(word);
			bw.close();
			//			while (read.readLine().length() > 0) {
//				char[] buff = new char[read.readLine().length()];
//				so.println(buff);
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found: " + e);
		} catch (IOException ioe) {
			System.out.println("I/O Exception: " + ioe);
		} finally {
			if (read != null) {
				try {
					read.close();
				} catch (IOException e) {
				}
			}
		}
	}
}

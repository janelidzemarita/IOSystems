package IOSystems;

import java.io.BufferedInputStream;
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
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.stream.Stream;

public class IOSystems {

	static PrintStream so = System.out;

	public static void main(String[] args) throws IOException {
		FileInputStream is = new FileInputStream("D:\\TBC_Academy\\IOSystems\\src\\IOSystems\\InputFileText");
		String txt = "UTF-8";
		Task1Function(is, txt);
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
			bw = new BufferedWriter(new FileWriter("D:\\TBC_Academy\\IOSystems\\src\\IOSystems\\OutputFile"));
			String line = read.readLine();

			while (line != null) {
				
				bw.write(line);
				
				line = read.readLine();
				if(line != null) {
					bw.newLine();
				}
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
}

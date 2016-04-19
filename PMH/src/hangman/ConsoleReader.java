package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

	private BufferedReader reader;

	public ConsoleReader(BufferedReader br) {

	}

	public char readNextChar() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			String eingabe = reader.readLine();
			char c = eingabe.charAt(0);
			return c;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}

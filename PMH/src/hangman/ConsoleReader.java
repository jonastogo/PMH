package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

	private BufferedReader reader;

	public ConsoleReader(BufferedReader br) {
		// wird nicht gebraucht
	}

	public char readNextChar() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			String eingabe = reader.readLine();
			char c = eingabe.charAt(0);
			return c;
		} catch (IOException | IndexOutOfBoundsException e) {
			System.out.println("Bitte gib einen gültigen Buchstaben ein!");
			readNextChar();
		}
		return 0;
	}
}

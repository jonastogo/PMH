
package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WordQuiz {
	protected String		quizword;
	protected char[]		guessedLetters;
	protected int			remainingAttempts;
	private ConsoleReader	cs;
	private WordlistReader	wlr;
	private BufferedReader	reader;
	private String			s;
	private int				buchstaben, fehlversuche, versuche = 0;

	private char[]			word, unknownword;

	public WordQuiz(int i, int j, ConsoleReader cs, WordlistReader wlr) {
		this.cs = cs;
		this.wlr = wlr;
	}

	protected int compareInput(char c) {
		// brauch ich nicht
		return 0;
	}

	protected void uncover(char c, int i) {
		// brauch ich nicht
	}

	/**
	 * Uncoverd die Buchstaben falls richtig
	 * 
	 * @param c
	 * @return ob Buchstaben gelöst wurden
	 */
	protected boolean uncover(char c) {
		boolean uncovered = false;
		for (int i = 0; i < word.length; i++) {
			if (word[i] == c) {
				unknownword[i] = c;
				uncovered = true;

			}
		}
		return uncovered;
	}

	/**
	 * Gewonnen-Abfrage
	 * 
	 * @return ob gewonnen
	 */

	public boolean gewonnen() {
		boolean unterstrich = true;
		for (int i = 0; i < unknownword.length; i++) {
			if (unknownword[i] == '_')
				return false;
		}
		return true;
	}

	/**
	 * initialisiere das Spiel
	 */

	public void playGame() {
		wlr.readListFromFile(null);
		startGame();
		if (pickWord(buchstaben) == null) {
			System.out.println("Kein Wort der Länge " + buchstaben + " gefunden");
			playGame();
			return;
		}
		word = pickWord(buchstaben);
		unknownword = new char[word.length];
		unknownword[0] = word[0];
		for (int a = 1; a < word.length; a++)
			unknownword[a] = '_';
		System.out.println("Wort wurde ausgesucht! Spieler 1 - Du darfst nun raten\n");
		printGameInfo();
		spielablauf();

	}

	/**
	 * Spielablauf
	 */
	public void spielablauf() {
		while (versuche < fehlversuche && gewonnen() != true) {
			if (uncover(cs.readNextChar()) == true) {
				System.out.println("Sehr gut - Dieser Buchstabe war dabei" + "\n");
			} else {
				System.out.print("Leider war dieser Buchstabe nicht dabei! - ");
				System.out.println("Versuch " + (versuche + 1) + " von " + fehlversuche + "\n");
				versuche++;
			}
			printGameInfo();
		}
		if (gewonnen() == true)
			System.out.println("Spieler 1 hat gewonnen!");
		else
			System.out.println("Spieler 2 hat gewonnen!");
		System.out.println("Das gesuchte Wort war: " + getWord());
	}

	private void printGameInfo() {
		for (int i = 0; i < unknownword.length; i++)
			System.out.print(unknownword[i] + " ");
		System.out.println();
	}

	/**
	 * Startet das Spiel
	 * 
	 * @return ob spiel gestartet werden kann;
	 */
	public boolean startGame() {
		try {
			System.out.println("Spieler 2 - Bitte gebe die Anzahl der Buchstaben ein!");
			reader = new BufferedReader(new InputStreamReader(System.in));
			String eingabe = reader.readLine();
			buchstaben = Integer.parseInt(eingabe);
			System.out.println("Spieler 2 - Bitte gebe die Anzahl der Fehlversuche ein!");
			reader = new BufferedReader(new InputStreamReader(System.in));
			String eingabe2 = reader.readLine();
			fehlversuche = Integer.parseInt(eingabe2);
		} catch (IOException | NumberFormatException e) {
			System.err.println("Bitte gib eine Zahl ein\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			startGame();
			return false;
		}
		return true;
	}

	/**
	 * Zufallswort mit Länge i
	 * 
	 * @param i
	 * @return Zufallswort
	 */
	public char[] pickWord(int i) {
		if (wlr.getWordsOfLength(i) != null) {
			ArrayList<String> words = wlr.getWordsOfLength(i);
			int zufallszahl = (int) (Math.random() * words.size());
			System.out.println();
			String s = words.get(zufallszahl);
			return s.toCharArray();
		}
		return null;
	}

	/**
	 * Richtiges Wort
	 * 
	 * @return das richtige Wort
	 */
	public String getWord() {

		return new String(word);
	}
}

package hangman;

import java.io.BufferedReader;

public class Spiel {
	private ConsoleReader	cs;
	private WordlistReader	wlr;
	private WordQuiz		wq;
	private BufferedReader	br;

	public Spiel() {
		cs = new ConsoleReader(br);
		wlr = new WordlistReader("data/wordlist.txt");
		wq = new WordQuiz(0, 0, cs, wlr);
	}

	public static void main(String[] args) {
		Spiel spiel = new Spiel();
		spiel.wq.playGame();
	}

}

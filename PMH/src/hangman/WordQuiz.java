package hangman;

public class WordQuiz {
	protected String		quizword;
	protected char[]		guessedLetters;
	protected int			remainingAttempts;
	private ConsoleReader	cs;
	private WordlistReader	wlr;

	public WordQuiz(int i, int j, ConsoleReader cs, WordlistReader wlr) {
		this.cs = cs;
		this.wlr = wlr;
	}

	protected int compareInput(char c) {
		return 0;
	}

	protected void uncover(char c, int i) {

	}

	public void playGame() {

	}

	private void printGameInfo() {

	}
}

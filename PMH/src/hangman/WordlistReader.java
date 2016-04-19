package hangman;

import java.util.ArrayList;

public class WordlistReader {
	private ArrayList<String> wordlist = new ArrayList<String>();

	public WordlistReader(String s) {

	}

	protected ArrayList<String> getList() {
		return wordlist;
	}

	protected boolean readListFromFile(String s) {
		return false;
	}

	public ArrayList<String> getWordsOfLength(int i) {
		return null;
	}

}

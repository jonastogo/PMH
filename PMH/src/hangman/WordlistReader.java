package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordlistReader {
	private ArrayList<String>	wordlist	= new ArrayList<String>();
	private String				datei;

	public WordlistReader(String s) {
		this.datei = s;
	}

	protected ArrayList<String> getList() {
		return wordlist;
	}

	protected boolean readListFromFile(String s) {
		String line;
		try {
			FileReader fread = new FileReader(datei);
			BufferedReader in = new BufferedReader(fread);
			while ((line = in.readLine()) != null) {
				getList().add(line);
			}
			in.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public ArrayList<String> getWordsOfLength(int i) {
		ArrayList<String> list = new ArrayList<String>();
		for (int a = 0; a < getList().size(); a++) {
			if (getList().get(a).length() == i)
				list.add(getList().get(a));
		}
		if (list.size() == 0)
			return null;
		return list;
	}

}

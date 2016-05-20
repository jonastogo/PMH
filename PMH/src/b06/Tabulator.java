package b06;

import java.util.regex.Pattern;

/**
 * Class for tabulator to avoid eye cancer while looking at the FormatterGUI
 * @author karl
 *
 */
public class Tabulator extends Token{
	private String content;
	
	public Tabulator(String content) {
		this();
		this.content = content;
	}
	public Tabulator() {
		pattern = Pattern.compile("^(\t)");
		priority = 9;
	}

	protected Token getToken() {
		Token tmp;
		
		try {
			tmp = new Tabulator(matcher.group(1));
		}
		catch (IllegalStateException e) {
			return null;
		}
		return tmp;
	}

	protected String htmlStart() {
		return "";
	}
	protected String htmlEnd() {
		return "&nbsp;&nbsp;&nbsp;&nbsp;";
	}
	protected String getContent() {
		return content;
	}
	public int getCompleteLength() {
		return 1; // UNIX "\n"
	}
}

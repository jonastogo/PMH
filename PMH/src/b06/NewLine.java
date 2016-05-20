package b06;

import java.util.regex.Pattern;


/**
 * A class for a newline token
 * @author karl
 *
 */
public class NewLine extends Token{
	private String content;
	
	public NewLine(String content) {
		this();
		this.content = content;
	}
	public NewLine() {
		pattern = Pattern.compile("^(\n{1})");
		priority = 8;
	}

	protected Token getToken() {
		Token tmp;
		
		try {
			tmp = new NewLine(matcher.group(1));
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
		return "<br />";
	}
	protected String getContent() {
		return content;
	}
	public int getCompleteLength() {
		return 1; // UNIX "\n"
	}

}

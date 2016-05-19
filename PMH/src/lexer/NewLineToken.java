package lexer;

import java.util.regex.Pattern;

public class NewLineToken extends Token{
	private String content;
	
	public NewLineToken(String content) {
		this();
		this.content = content;
	}
	public NewLineToken() {
		pattern = Pattern.compile("^(\n{1})");
		priority = 8;
	}

	protected Token getToken() {
		return new NewLineToken(matcher.group(0));
	}

	protected String htmlStart() {
		return "<br>";
	}
	protected String htmlEnd() {
		return "";
	}
	protected String getContent() {
		return content;
	}
	public int getCompleteLength() {
		return 1; // UNIX "\n"
	}

}

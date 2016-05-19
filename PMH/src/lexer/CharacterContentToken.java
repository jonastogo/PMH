package lexer;

import java.util.regex.Pattern;

public class CharacterContentToken extends Token {

	private String content; 
	
	
	public CharacterContentToken(String content) {
		this();
		this.content = content;
	}
	public CharacterContentToken() {
		pattern = Pattern.compile("^'(.*)'");
		priority = 5;
	}
	public int getCompleteLength() {
		return content.length()+2;
	}
	
	protected Token getToken() {
		return new CharacterContentToken(matcher.group(1));
	}

	protected String htmlStart() {
		return "<font color =\"blue\">";
	}

	protected String htmlEnd() {
		return "</font>";
	}

	protected String getContent() {
		return content;
	}

}

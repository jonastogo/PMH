package lexer;

import java.util.regex.Pattern;

public class StringContentToken extends Token{

	private String content; 
	
	
	public StringContentToken(String content) {
		this();
		this.content = content;
	}
	public StringContentToken() {
		pattern = Pattern.compile("^\"(.*)\"");
		priority = 4;
	}
	public int getCompleteLength() {
		return (content.length()+2);
	}
	
	protected Token getToken() {
		return new StringContentToken(matcher.group(1));
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

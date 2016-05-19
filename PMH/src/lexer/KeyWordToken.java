package lexer;

import java.util.regex.Pattern;

public class KeyWordToken extends Token{
	private String content; 
	
	
	public KeyWordToken(String content) {
		this();
		this.content = content;
	}
	public KeyWordToken() {
		pattern = Pattern.compile("^(import|class|public|private|final|static|return|if|else|while|try|catch|finally|package)");
		priority = 6;
	}
	public int getCompleteLength() {
		return content.length();
	}
	
	protected Token getToken() {
		return new KeyWordToken(matcher.group(0));
	}

	protected String htmlStart() {
		return "<font color =\"red\"><b>";
	}

	protected String htmlEnd() {
		return "</b></font >";
	}

	protected String getContent() {
		return content;
	}
	

}

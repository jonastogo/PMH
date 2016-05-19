package lexer;

import java.util.regex.Pattern;

public class CatchAllToken extends Token{
	private String content;
	
	public CatchAllToken(String content) {
		this();
		this.content = content;
	}
	public CatchAllToken() {
		pattern = Pattern.compile("^(.{1})");
	}

	protected Token getToken() {
		return new CatchAllToken(matcher.group(0));
	}

	protected String htmlStart() {
		return "";
	}
	protected String htmlEnd() {
		return "";
	}
	protected String getContent() {
		return content;
	}
	public int getCompleteLength() {
		return 1;
	}


}

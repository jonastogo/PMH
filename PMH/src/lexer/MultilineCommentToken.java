package lexer;

import java.util.regex.Pattern;

public class MultilineCommentToken extends Token{

	private String content; 
	
	
	public MultilineCommentToken(String content) {
		this();
		this.content = content;
	}
	public MultilineCommentToken() {
		pattern = Pattern.compile("^/\\*(.*)\\*/", Pattern.DOTALL);
		priority = 2;
	}
	public int getCompleteLength() {
		return (content.length()+4);
	}
	
	protected Token getToken() {
		return new MultilineCommentToken(matcher.group(1));
	}

	protected String htmlStart() {
		return "<font color =\"gray\"><i>/*";
	}

	protected String htmlEnd() {
		return "*/</i></font >";
	}

	protected String getContent() {
		return content;
	}

}

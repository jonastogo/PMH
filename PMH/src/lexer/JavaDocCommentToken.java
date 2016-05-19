package lexer;

import java.util.regex.Pattern;

public class JavaDocCommentToken extends Token {

	private String content; 
	
	
	public JavaDocCommentToken(String content) {
		this();
		this.content = content;
	}
	public JavaDocCommentToken() {
		pattern = Pattern.compile("^/\\*\\*(.*)\\*/", Pattern.DOTALL);
		priority = 3;
	}
	public int getCompleteLength() {
		return (content.length()+5);
	}
	
	protected Token getToken() {
		return new JavaDocCommentToken(matcher.group(1));
	}

	protected String htmlStart() {
		return "<font color =\"gray\"><i>/**";
	}

	protected String htmlEnd() {
		return "*/</i></font >";
	}
	protected String getContent() {
		return content;
	}

}

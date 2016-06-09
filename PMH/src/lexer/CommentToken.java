package lexer;

import java.util.regex.Pattern;

public class CommentToken extends Token {
	private String content;

	public CommentToken(String content) {
		this();
		this.content = content;
	}

	public CommentToken() {
		pattern = Pattern.compile("^\\/\\/(.*)\n");
		priority = 1;
	}

	public int getCompleteLength() {
		return (content.length() + 2);
	}

	protected Token getToken() {
		return new CommentToken(matcher.group(1));
	}

	protected String htmlStart() {
		return "<font color =\"grey\"><i>//";
	}

	protected String htmlEnd() {
		return "</i></font >";
	}

	protected String getContent() {
		return content;
	}

}

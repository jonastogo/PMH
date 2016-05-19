package lexer;

import java.util.regex.Pattern;

public class AnnotationToken extends Token{

	private String content; 
	
	
	public AnnotationToken(String content) {
		this();
		this.content = content;
	}
	public AnnotationToken() {
		pattern = Pattern.compile("^@(.*)[\n| ]");
		priority = 7;
	}
	public int getCompleteLength() {
		return content.length()+1;
	}
	
	protected Token getToken() {
		return new AnnotationToken(matcher.group(1));
	}

	protected String htmlStart() {
		return "<font color =\"blue\"><i>@";
	}

	protected String htmlEnd() {
		return "</i></font >";
	}

	protected String getContent() {
		return content;
	}
	

}

package b06;

import java.util.regex.Pattern;

/**
 * A class for the JAvaDocComment
 */

public class JavaDocComment extends Token {

	private String content; 
	
	
	public JavaDocComment(String content) {
		this();
		this.content = content;
	}
	public JavaDocComment() {
		pattern = Pattern.compile("^(/\\*\\*.*\\*/)", Pattern.DOTALL);
		priority = 3;
	}
	public int getCompleteLength() {
		return content.length();
	}
	
	protected Token getToken() {
		Token tmp;
		
		try {
			tmp = new JavaDocComment(matcher.group(1));
		}
		catch (IllegalStateException e) {
			return null;
		}
		return tmp;
	}

	protected String htmlStart() {
		return "<font color =\"grey\"><i>";
	}

	protected String htmlEnd() {
		return "</i></font >";
	}
	protected String getContent() {
		return content;
	}

}

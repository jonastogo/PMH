package b06;

import java.util.regex.Pattern;

/**
 * A class for a single lined comment
 * @author karl
 *
 */
public class Comment extends Token{
	private String content; 
	
	
	public Comment(String content) {
		this();
		this.content = content;
	}
	public Comment() {
		// Forced to code buggy code :(
		pattern = Pattern.compile("^(\\/\\/.*\n)");
		priority = 1;
	}
	public int getCompleteLength() {
		return content.length();
	}
	
	protected Token getToken() {
		Token tmp;
		
		try {
			tmp = new Comment(matcher.group(1));
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

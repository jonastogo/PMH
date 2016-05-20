package b06;

import java.util.regex.Pattern;


/**
 * A class for the multiline token
 * 
 */
public class MultilineComment extends Token{

	private String content; 
	
	
	public MultilineComment(String content) {
		this();
		this.content = content;
	}
	public MultilineComment() {
		pattern = Pattern.compile("^(/\\*.*\\*/)", Pattern.DOTALL);
		priority = 2;
	}
	public int getCompleteLength() {
		return content.length();
	}
	
	protected Token getToken() {
		Token tmp;
		
		try {
			tmp = new MultilineComment(matcher.group(1));
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

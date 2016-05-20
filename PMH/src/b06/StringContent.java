package b06;

import java.util.regex.Pattern;


/**
 * Class for double quoted content token
 * @author karl
 *
 */
public class StringContent extends Token{

	private String content; 
	
	
	public StringContent(String content) {
		this();
		this.content = content;
	}
	public StringContent() {
		pattern = Pattern.compile("^(\".*\")");
		priority = 4;
	}
	public int getCompleteLength() {
		return content.length();
	}
	
	protected Token getToken() {
		Token tmp;
		
		try {
			tmp = new StringContent(matcher.group(1));
		}
		catch (IllegalStateException e) {
			return null;
		}
		return tmp;
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

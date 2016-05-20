package b06;

import java.util.regex.Pattern;

/**
 * A class for single quoted token
 * @author karl
 *
 */
public class CharacterContent extends Token {

	private String content; 
	
	
	public CharacterContent(String content) {
		this();
		this.content = content;
	}
	public CharacterContent() {
		pattern = Pattern.compile("^('.*')");
		priority = 5;
	}
	public int getCompleteLength() {
		return content.length();
	}
	
	protected Token getToken() {
		Token tmp;
		
		try {
			tmp = new CharacterContent(matcher.group(1));
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

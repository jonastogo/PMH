package b06;

import java.util.regex.Pattern;

/**
 * A class for the catchall token
 * @author karl
 *
 */
public class CatchAll extends Token{
	private String content;
	
	public CatchAll(String content) {
		this();
		this.content = content;
	}
	public CatchAll() {
		pattern = Pattern.compile("^(.{1})");
	}

	protected Token getToken() {
		Token tmp;
		
		try {
			tmp = new CatchAll(matcher.group(1));
		}
		catch (IllegalStateException e) {
			return null;
		}
		return tmp;
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

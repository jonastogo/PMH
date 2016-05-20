package b06;

import java.util.regex.Pattern;


/**
 * A token for several keywords
 * @author karl
 *
 */
public class KeyWord extends Token{
	private String content; 
	
	
	public KeyWord(String content) {
		this();
		this.content = content;
	}
	public KeyWord() {
		pattern = Pattern.compile("^(finally|import|class|public|private|final|static|return|if|else|while|try|catch|finally|package|void|new)");
		priority = 6;
	}
	public int getCompleteLength() {
		return content.length();
	}
	
	protected Token getToken() {
		Token tmp;
		
		try {
			tmp = new KeyWord(matcher.group(1));
		}
		catch (IllegalStateException e) {
			return null;
		}
		return tmp;
	}

	protected String htmlStart() {
		return "<font color =\"red\"><b>";
	}

	protected String htmlEnd() {
		return "</b></font >";
	}

	protected String getContent() {
		return content;
	}
	

}

package b06;

import java.util.regex.Pattern;
/**
 * A class for the annotation token
 * @author karl
 *
 */
public class Annotation extends Token{

	private String content; 
	
	
	public Annotation(String content) {
		this();
		this.content = content;
	}
	public Annotation() {
		pattern = Pattern.compile("^(@\\w*)[ |\n]*");
		priority = 7;
	}
	
	public int getCompleteLength() {
		return content.length();
	}
	
	protected Token getToken() {
		Token tmp;
		
		try {
			tmp = new Annotation(matcher.group(1));
			System.out.print(matcher.group(1));
		}
		catch (IllegalStateException e) {
			return null;
		}
		return tmp;
	}

	protected String htmlStart() {
		return "<font color =\"blue\"><i>";
	}

	protected String htmlEnd() {
		return "</i></font >";
	}

	protected String getContent() {
		return content;
	}
	

}

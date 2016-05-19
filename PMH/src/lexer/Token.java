package lexer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Token implements Comparable<Token>{
	protected Pattern pattern;
	protected Matcher matcher;
	protected int priority;
	
	
	final public Token match(String input) {
		if(input == null) {
			System.out.println("No string set!");
			return null;
		}
		if(pattern == null) {
			System.out.println("No pattern set!");
			return null;
		}
		matcher = pattern.matcher(input);
		if(matcher.find())
			return getToken();
		else
			return null;
		
	}
	final public String getHtml() {
		return htmlStart() + getContent() + htmlEnd();
	}
	protected abstract Token getToken();
	protected abstract String htmlStart();
	protected abstract String htmlEnd();
	protected abstract String getContent();
	public abstract int getCompleteLength();
	
	public int compareTo(Token toCompare) {
        return this.priority-toCompare.priority;
	}
}

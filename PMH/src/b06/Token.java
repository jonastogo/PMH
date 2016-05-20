package b06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The base class for a token
 * @author karl
 *
 */
public abstract class Token implements Comparable<Token>{
	protected Pattern pattern;
	protected Matcher matcher;
	protected int priority;

	/**
	 * matches a string against a predefined pattern and returns a corresponding object
	 * @param input The string that gets matched
	 * @return The corresponding object
	 */
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
	/**
	 * Gets a html-formatted version of a token
	 * @return The html formatted token content
	 */
	final public String getHtml() {
		return htmlStart() + getContent() + htmlEnd();
	}
	protected abstract Token getToken();
	protected abstract String htmlStart();
	protected abstract String htmlEnd();
	protected abstract String getContent();
	public abstract int getCompleteLength();
	/**
	 * For sorting them by priority
	 */
	public int compareTo(Token toCompare) {
        return this.priority-toCompare.priority;
	}
}

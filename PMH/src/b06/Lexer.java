package b06;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for the lexer itself
 * @author karl
 *
 */
public class Lexer {
	private ArrayList<Token> token;
	private Token catchAll;
	
	public Lexer() {
		token = new ArrayList<Token>();
	}
	/**
	 * Registers a new token
	 * @param toRegister the token to be registered
	 */
	public void registerToken(Token toRegister) {
		if(toRegister == null) {
			System.out.println("toRegister is not set!");
			return;
		}
		if(token.contains(toRegister)) {
			System.out.println("token is already registrated!");
			return;			
		}
		token.add(toRegister);
	}
	/**
	 * Sets the CatchAll token
	 * @param toRegister The CatchAll taken to be set
	 */
	public void registerCatchAll(Token toRegister) {
		if(toRegister == null) {
			System.out.println("toRegister is not set!");
			return;
		}
		if(catchAll != null) {
			System.out.println("catchAll is already set!");
			return;			
		}
		catchAll = toRegister;
	}
	/**
	 * Generates a list of tokens from the input
	 * @param input The input
	 * @return The list of tokens
	 */
	public ArrayList<Token> tokenize(String input) {
		ArrayList<Token> resultingTokens = new ArrayList<Token>();
		Token newToken;
		
		if(input == null) {
			System.out.println("Input not set!");
			return null;
		}
		Collections.sort(token);
		
		while(input.length() > 0) {
			newToken = testTokens(input);
			input = input.substring(newToken.getCompleteLength());
			resultingTokens.add(newToken);
			
		}
		
		return resultingTokens;
	}
	private Token testTokens(String input) {
		Token newToken;
		
		
		for(Token tmp : token) {
			if((newToken = tmp.match(input)) != null) {
				//System.out.println("Found " + newToken.getClass().getName() + " html " + newToken.getHtml() +"||");
				return newToken;
			}
		}
		
		newToken = catchAll.match(input);
		return newToken;
	}
}

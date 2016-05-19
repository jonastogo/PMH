package lexer;

import java.util.ArrayList;
import java.util.Collections;

public class Lexer {
	private ArrayList<Token> token;
	private Token catchAll;
	
	public Lexer() {
		token = new ArrayList<Token>();
	}
	
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
			token.add(newToken);
			
		}
		
		return resultingTokens;
	}
	private Token testTokens(String input) {
		Token newToken;
		
		
		for(Token tmp : token) {
			if((newToken = tmp.match(input)) != null) {
				System.out.println("Found " + newToken.getClass().getName() + " html " + newToken.getHtml() +"||");
				return newToken;
			}
		}
		
		newToken = catchAll.match(input);
		return newToken;
	}
}

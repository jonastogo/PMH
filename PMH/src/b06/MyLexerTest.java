package b06;

import java.util.ArrayList;

public class MyLexerTest {

	public static void main(String[] args) {
		Lexer lexer = new Lexer();
		
		
		lexer.registerToken(new KeyWord());
		lexer.registerToken(new NewLine());
		lexer.registerToken(new CharacterContent());
		lexer.registerToken(new StringContent());
		lexer.registerToken(new JavaDocComment());
		lexer.registerToken(new Comment());
		lexer.registerToken(new Annotation());
		lexer.registerCatchAll(new CatchAll());
		
		ArrayList<Token> res = lexer.tokenize("//@test zuziuziuziu");
		for(Token tmp : res) {
			System.out.println(tmp.getContent());
		}

	}

}

package lexer;

import java.io.IOException;
import java.util.ArrayList;

public class LexerTest {

	public static void main(String[] args) {
		Lexer lexer = new Lexer();

		lexer.registerToken(new KeyWordToken());
		lexer.registerToken(new NewLineToken());
		lexer.registerToken(new CharacterContentToken());
		lexer.registerToken(new StringContentToken());
		lexer.registerToken(new JavaDocCommentToken());
		lexer.registerToken(new CommentToken());
		lexer.registerToken(new AnnotationToken());
		lexer.registerCatchAll(new CatchAllToken());

		ArrayList<Token> res = lexer.tokenize("@asdasdasd dsfdsfsdf");
		try {
			Write write = new Write("test.xls", res);
		} catch (IOException e) {

		}
	}

}

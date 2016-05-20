package b06;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Steven Yeates
 * @author Christian Gawlik
 * @author Matthias Guzy
 * @since SoSe 2105
 *
 */

public class LexerTest {

    Lexer lexer;
    String eingabe, ausgabe;

    @Before
    public void setUp() {
        lexer = new Lexer();
        lexer.registerToken(new KeyWord());
        lexer.registerToken(new Annotation());
        lexer.registerToken(new JavaDocComment());
        lexer.registerToken(new MultilineComment());
        lexer.registerToken(new Comment());
        lexer.registerToken(new NewLine());
        lexer.registerToken(new StringContent());
        lexer.registerToken(new CharacterContent());
        lexer.registerCatchAll(new CatchAll());

        ausgabe = "";
    }

    /**
     * lexerEmptyString prueft, ob der uebergebene String leer ist.
     */
    @Test
    public void lexerEmptyString() {
        for (Token t : lexer.tokenize("")) {
            ausgabe += t.getContent();
        }

        assertEquals("", ausgabe);
    }

    /**
     * lexerKeyWord prueft, das uebergebene Schluesselwort und testet, anhand
     * des Schluesselworts, die zusammengebauten HTML-Ausgabe.
     */
    @Test
    public void lexerKeyWord() {
        for (Token t : lexer.tokenize("void")) {
            ausgabe += t.getContent();
        }

        assertEquals("void", ausgabe);
    }

    /**
     * lexerAnnotation testet, ob die HTML-Ausgabe korrekt zusammengebaut wird
     * und den Vorgaben fuer die Annotations entspricht.
     */
    @Test
    public void lexerAnnotation() {
        for (Token t : lexer.tokenize("@irgendwas")) {
            ausgabe += t.getContent();
        }

        assertEquals("@irgendwas", ausgabe);
    }

    /**
     * lexerJavaDocComment baut eine HTML-Ausgabe entsprechend den Vorgaben fuer
     * JavaDoc-Kommentare und vergleicht die Ausgabe, ob sie den Erwartungen
     * entspricht.
     */
    @Test
    public void lexerJavaDocComment() {
        for (Token t : lexer.tokenize("/**Hier\n steht\n Text*/")) {
            ausgabe += t.getContent();
        }

        assertEquals("/**Hier\n steht\n Text*/", ausgabe);
    }

    /**
     * lexerMultilineComment erstellt die HTML-Ausgabe entsprechend den Vorgaben
     * und prueft, ob die Ausgabe den eigenen Erwartungen entspricht.
     */
    @Test
    public void lexerMultilineComment() {
        for (Token t : lexer.tokenize("/*Hier\n steht\n Text*/")) {
            ausgabe += t.getContent();
        }

        assertEquals("/*Hier\n steht\n Text*/", ausgabe);
    }

    /**
     * lexerComment erstellt die HTML-Ausgabe entsprechend den definierten
     * Vorgaben und prueft, ob die Ausgabe den Anforderungen fuer einzeilige
     * Kommentare entspricht.
     */
    @Test
    public void lexerComment() {
        for (Token t : lexer.tokenize("//irgendein Kommentar\n")) {
            ausgabe += t.getContent();
        }

        assertEquals("//irgendein Kommentar\n", ausgabe);
    }

    /**
     * lexerNewLine erstellt die HTML-Ausgabe entsprechend den Vorgaben und
     * prueft, ob das NewLine-Token entsprechend in ein HTML-Tag umgewandelt
     * wird.
     */
    @Test
    public void lexerNewLine() {
        for (Token t : lexer.tokenize("\n")) {
            ausgabe += t.getContent();
        }

        assertEquals("\n", ausgabe);
    }

    /**
     * lexerStringContent testet, ob die zusammengebaute HTML-Ausgabe auf einen
     * gegebenen String passt und das Token korrekt umgewandelt wird.
     */
    @Test
    public void lexerStringContent() {
        for (Token t : lexer.tokenize("\"das ist irgendein String\"")) {
            ausgabe += t.getContent();
        }

        assertEquals("\"das ist irgendein String\"", ausgabe);
    }

    /**
     * lexerCharacterContent testet, ob die zusammengebaute HTML-Ausgabe auf
     * einen gegebenen Character passt und das Token korrekt umgewandelt wird.
     */
    @Test
    public void lexerCharacterContent() {
        for (Token t : lexer.tokenize("\'A\'")) {
            ausgabe += t.getContent();
        }

        assertEquals("\'A\'", ausgabe);
    }

    /**
     * lexerCatchAll greift auf alle anderen nicht naeher definierten Tokens
     * zurueck und vergleicht die Ausgabe mit dem return-Wert der
     * getContent()-Methode.
     */
    @Test
    public void lexerCatchAll() {
        for (Token t : lexer.tokenize("+")) {
            ausgabe += t.getContent();
        }

        assertEquals("+", ausgabe);
    }

    /**
     * lexerAll nutzt mehrere Tokens und prueft, ob sich die zusammgebaute
     * Ausgabe der verschiedenen Schluesselwoerter mit der erwarteten Ausgabe
     * deckt.
     */
    @Test
    public void lexerAll() {
        for (Token t : lexer.tokenize("a void \n //kommentar\n /**javaDoc\nCommant*/ @annotation "
                + "/*Multiline\nCommant*/ \"string\" \'C\'")) {
            ausgabe += t.getContent();
        }

        assertEquals("a void \n //kommentar\n /**javaDoc\nCommant*/ @annotation "
                + "/*Multiline\nCommant*/ \"string\" \'C\'", ausgabe);
    }
}

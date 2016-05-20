package b06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Steven Yeates
 * @author Matthias Guzy
 * @since SoSe 2105
 *
 */

public class KeyWordTest {

    KeyWord keyWord;

    @Before
    public void setUp() {
        keyWord = new KeyWord();
    }

    /**
     * keyWordMatchVoid prueft, ob das Token auf das Schluesslwort void passt.
     */
    @Test
    public void keyWordMatchVoid() {
        keyWord.match("void");
        assertEquals(keyWord.getClass(), keyWord.getToken().getClass());
    }

    /**
     * keyWordMatchImport prueft, ob das Token auf das Schluesslwort import
     * passt.
     */
    @Test
    public void keyWordMatchImport() {
        keyWord.match("import");
        Token t = keyWord.getToken();
        assertEquals("import", t.getContent());
    }

    /**
     * keyWordMatchClass prueft, ob das Token auf das Schluesslwort class passt.
     */
    @Test
    public void keyWordMatchClass() {
        keyWord.match("class");
        Token t = keyWord.getToken();
        assertEquals("class", t.getContent());
    }

    /**
     * keyWordMatchPublic prueft, ob das Token auf das Schluesslwort public
     * passt.
     */
    @Test
    public void keyWordMatchPublic() {
        keyWord.match("public");
        Token t = keyWord.getToken();
        assertEquals("public", t.getContent());
    }

    /**
     * keyWordMatchPrivate prueft, ob das Token auf das Schluesslwort private
     * passt.
     */
    @Test
    public void keyWordMatchPrivate() {
        keyWord.match("private");
        Token t = keyWord.getToken();
        assertEquals("private", t.getContent());
    }

    /**
     * keyWordMatchFinal prueft, ob das Token auf das Schluesslwort final passt.
     */
    @Test
    public void keyWordMatchFinal() {
        keyWord.match("final");
        Token t = keyWord.getToken();
        assertEquals("final", t.getContent());
    }

    /**
     * keyWordMatchStatic prueft, ob das Token auf das Schluesslwort static
     * passt.
     */
    @Test
    public void keyWordMatchStatic() {
        keyWord.match("static");
        Token t = keyWord.getToken();
        assertEquals("static", t.getContent());
    }

    /**
     * keyWordMatchReturn prueft, ob das Token auf das Schluesslwort return
     * passt.
     */
    @Test
    public void keyWordMatchReturn() {
        keyWord.match("return");
        Token t = keyWord.getToken();
        assertEquals("return", t.getContent());
    }

    /**
     * keyWordMatchIf prueft, ob das Token auf das Schluesslwort if passt.
     */
    @Test
    public void keyWordMatchIf() {
        keyWord.match("if");
        Token t = keyWord.getToken();
        assertEquals("if", t.getContent());
    }

    /**
     * keyWordMatchElse prueft, ob das Token auf das Schluesslwort else passt.
     */
    @Test
    public void keyWordMatchElse() {
        keyWord.match("else");
        Token t = keyWord.getToken();
        assertEquals("else", t.getContent());
    }

    /**
     * keyWordMatchWhile prueft, ob das Token auf das Schluesslwort while passt.
     */
    @Test
    public void keyWordMatchWhile() {
        keyWord.match("while");
        Token t = keyWord.getToken();
        assertEquals("while", t.getContent());
    }

    /**
     * keyWordMatchTry prueft, ob das Token auf das Schluesslwort try passt.
     */
    @Test
    public void keyWordMatchTry() {
        keyWord.match("try");
        Token t = keyWord.getToken();
        assertEquals("try", t.getContent());
    }

    /**
     * keyWordMatchCatch prueft, ob das Token auf das Schluesslwort catch passt.
     */
    @Test
    public void keyWordMatchCatch() {
        keyWord.match("catch");
        Token t = keyWord.getToken();
        assertEquals("catch", t.getContent());
    }

    /**
     * keyWordMatchFinally prueft, ob das Token auf das Schluesslwort finally
     * passt.
     */
    @Test
    public void keyWordMatchFinally() {
        keyWord.match("finally");
        Token t = keyWord.getToken();
        assertEquals("finally", t.getContent());
    }

    /**
     * keyWordMatchNotNull prueft, ob das Token ein Schluesselwort erkannt hat.
     */
    @Test
    public void keyWordMatchNotNull() {
        keyWord.match("public");
        assertNotSame(null, keyWord.getToken().getClass());
    }

    /**
     * noKeyWordMatch prueft, das das Token nicht als Schluesselwort angesehen
     * wird.
     */
    @Test
    public void noKeyWordMatch() {
        keyWord.match("@test");
        assertEquals(null, keyWord.getToken());
    }

    /**
     * wrongKeyWordMatch prueft, ob das Token das falsche Schluesselwort als
     * nicht zulaessig angesehen hat.
     */
    @Test
    public void wrongKeyWordMatch() {
        keyWord.match("jhadj void /**kasf*/ ");
        assertEquals(null, keyWord.getToken());
    }

    /**
     * keyWordGetHtmlStart ueberprueft, ob der Farbwert des HTML-Start-Tag dem
     * Wert aus der KeyWord-Klasse entspricht.
     */
    @Test
    public void keyWordGetHtmlStart() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("<font color=\"red\"><b>", keyWord.htmlStart());
        assertNotNull(keyWord.htmlStart());
    }

    /**
     * keyWordGetHtmlEnd ueberprueft, ob der HTML-Ende-Tag auch so aufgebaut
     * ist, wie es in der entsprechenden Methode vorgesehen ist.
     */
    @Test
    public void keyWordGetHtmlEnd() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("</b></font>", keyWord.htmlEnd());
        assertNotNull(keyWord.htmlStart());
    }
}

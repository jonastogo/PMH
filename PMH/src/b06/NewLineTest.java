package b06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Steven Yeates
 * @author Matthias Guzy
 * @since SoSe 2105
 *
 */

public class NewLineTest {

    NewLine newLine;

    @Before
    public void setUp() {
        newLine = new NewLine();
    }

    /**
     * newLineMatch testet, ob die neue Zeile, die der Methode match()
     * uebergeben wird, dem definierten RegEx entspricht.
     */
    @Test
    public void newLineMatch() {
        newLine.match("\n");
        assertEquals(newLine.getClass(), newLine.getToken().getClass());
    }

    /**
     * newLineMatchNotNull testet auf NULL und schaut, ob eine neue Zeile auch
     * existiert.
     */
    @Test
    public void newLineMatchNotNull() {
        newLine.match("\n hjgjgkjgjkg");
        assertNotSame(null, newLine.getToken().getClass());
    }

    /**
     * noNewLineMatch testet, ob eine neue Zeile ueberhaupt vorhanden ist.
     */
    @Test
    public void noNewLineMatch() {
        newLine.match("//@test ");
        assertEquals(null, newLine.getToken());
    }

    /**
     * wrongNewLineMatch prueft, ob der die neue Zeile dem Regulaeren Ausdruck
     * entspricht.
     */
    @Test
    public void wrongNewLineMatch() {
        newLine.match("//jhadj kasf ");
        assertEquals(null, newLine.getToken());
    }

    /**
     * newLineGetHtmlStart ueberprueft, ob der Farbwert des HTML-Start-Tag dem
     * Wert aus der NewLine-Klasse entspricht.
     */
    @Test
    public void newLineGetHtmlStart() {
        assertEquals("", newLine.htmlStart());
    }

    /**
     * newLineGetHtmlEnd ueberprueft, ob der HTML-Ende-Tag auch so aufgebaut
     * ist, wie es in der entsprechenden Methode vorgesehen ist.
     */
    @Test
    public void newLineGetHtmlEnd() {
        assertEquals("<br />", newLine.htmlEnd());
    }

    /**
     * newLineGetContent, holt sich die neue Zeile und prueft, ob der Inhalt mit
     * den eigenen Erwartungen uebereinstimmt.
     */
    @Test
    public void newLineGetContent() {
        newLine.match("\n");
        Token t = newLine.getToken();
        assertEquals("\n", t.getContent());
    }
}

package b06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Steven Yeates
 * @author Christian Gawlik
 * @author Matthias Guzy
 * @since SoSe 2105
 *
 */

public class StringContentTest {

    StringContent stringContent;

    @Before
    public void setUp() {
        stringContent = new StringContent();
    }

    /**
     * stringContentMatch testet, ob der String, die der Methode match()
     * uebergeben wird, dem definierten RegEx entspricht.
     */
    @Test
    public void stringContentMach() {
        stringContent.match("\"kjskljdlkasf\"");
        assertEquals(stringContent.getClass(), stringContent.getToken().getClass());
    }

    /**
     * StringContentMatchNotNull testet auf NULL und schaut, ob ein String
     * ueberhaupt enthalten ist.
     */
    @Test
    public void stringContentMatchNotNull() {
        stringContent.match("\"@test zuziu\"ziuziu");
        assertNotSame(null, stringContent.getToken().getClass());
    }

    /**
     * noStringContentMatch testet, ob ueberhaupt ein String uebergeben wurde.
     */
    @Test
    public void noStringContentMatch() {
        stringContent.match("//@test ");
        assertEquals(null, stringContent.getToken());
    }

    /**
     * wrongStringContentMatch prueft, ob der String dem Regulaeren Ausdruck
     * entspricht.
     */
    @Test
    public void wrongStringContentMatch() {
        stringContent.match("//jhadj kasf ");
        assertEquals(null, stringContent.getToken());
    }

    /**
     * stringContentGetHtmlStart ueberprueft, ob der Farbwert des HTML-Start-Tag
     * dem Wert aus der StringContent-Klasse entspricht.
     */
    @Test
    public void stringContentGetHtmlStart() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("<font color=\"green\">", stringContent.htmlStart());
        assertNotNull(stringContent.htmlStart());
    }

    /**
     * stringContentGetHtmlEnd ueberprueft, ob der HTML-Ende-Tag auch so
     * aufgebaut ist, wie es in der entsprechenden Methode vorgesehen ist.
     */
    @Test
    public void stringContentGetHtmlEnd() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("</font>", stringContent.htmlEnd());
        assertNotNull(stringContent.htmlStart());
    }

    /**
     * stringContentGetContent, holt sich den Inhalt des Strings und prueft, ob
     * der Inhalt mit den eigenen Erwartungen uebereinstimmt.
     */
    @Test
    public void stringContentGetContent() {
        stringContent.match("\"test\"string");
        Token t = stringContent.getToken();
        assertEquals("\"test\"", t.getContent());
    }
}

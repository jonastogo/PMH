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

public class CatchAllTest {

    CatchAll catchAll;

    @Before
    public void setUp() {
        catchAll = new CatchAll();
    }

    /**
     * catchAllMatch testet den verbliebene Rest und entsprechend den Vorgaben
     * des catchAll-Tokens richtig erkannt wird.
     */
    @Test
    public void catchAllMatch() {
        catchAll.match("skadsklhd \"jkhadkj\"");
        assertEquals(catchAll.getClass(), catchAll.getToken().getClass());
    }

    /**
     * catchAllMatchNotNull prueft auf NULL und schaut, ob der Rest korrekt
     * notiert wurde.
     */
    @Test
    public void catchAllMatchNotNull() {
        catchAll.match("hjsdhdkajs\'@\'test zuziu\"ziuziu");
        assertNotSame(null, catchAll.getToken().getClass());
    }

    /**
     * catchAllGetHtmlStart ueberprueft, ob der Farbwert des HTML-Start-Tag dem
     * Wert aus der CatchAll-Klasse entspricht.
     */
    @Test
    public void catchAllGetHtmlStart() {
        assertEquals("", catchAll.htmlStart());
    }

    /**
     * catchAllGetHtmlEnd ueberprueft, ob der HTML-Ende-Tag auch so aufgebaut
     * ist, wie es in der entsprechenden Methode vorgesehen ist.
     */
    @Test
    public void catchAllGetHtmlEnd() {
        assertEquals("", catchAll.htmlEnd());
    }

    /**
     * catchAllGetContent, holt sich den Inhalt und prueft, ob der Inhalt mit
     * den eigenen Erwartungen uebereinstimmt.
     */
    @Test
    public void catchAllGetContent() {
        catchAll.match("a\'t\'eststring");
        Token t = catchAll.getToken();
        assertEquals("a", t.getContent());
    }
}

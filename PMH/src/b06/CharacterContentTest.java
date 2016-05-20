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

public class CharacterContentTest {

    CharacterContent characterContent;

    @Before
    public void setUp() {
        characterContent = new CharacterContent();
    }

    /**
     * charakterContentMatch testet, ob der Character, die der Methode match()
     * uebergeben wird, dem Regulaeren Ausdruck entspricht.
     */
    @Test
    public void characterContentMach() {
        characterContent.match("\'@\'");
        assertEquals(characterContent.getClass(), characterContent.getToken().getClass());
    }

    /**
     * characterContentMatchNotNull testet auf NULL und ueberprueft, ob ein
     * Character enthalten ist.
     */
    @Test
    public void characterContentMatchNotNull() {
        characterContent.match("\'@\'test zuziu\"ziuziu");
        assertNotSame(null, characterContent.getToken().getClass());
    }

    /**
     * noCharacterContentMatch prueft, ob auch wirklich kein Character enthalten
     * ist.
     */
    @Test
    public void noCharacterContentMatch() {
        characterContent.match("//@test ");
        assertEquals(null, characterContent.getToken());
    }

    /**
     * wrongCharacterMatch prueft, ob auch wirklich kein Character enthalten
     * ist.
     */
    @Test
    public void wrongCharacterContentMatch() {
        characterContent.match("//jhadj kasf ");
        assertEquals(null, characterContent.getToken());
    }

    /**
     * characterContentGetHtmlStart ueberprueft, ob der Farbwert des
     * HTML-Start-Tag dem Wert aus der CharacterContent-Klasse entspricht.
     */
    @Test
    public void characterContentGetHtmlStart() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("<font color=\"green\">", characterContent.htmlStart());
        assertNotNull(characterContent.htmlStart());
    }

    /**
     * characterContentGetHtmlEnd ueberprueft, ob der HTML-Ende-Tag auch so
     * aufgebaut ist, wie es in der entsprechenden Methode vorgesehen ist.
     */
    @Test
    public void characterContentGetHtmlEnd() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("</font>", characterContent.htmlEnd());
        assertNotNull(characterContent.htmlEnd());
    }

    /**
     * characterContentGetContent, holt sich den Inhalt der Annotation und
     * prueft, ob der Inhalt mit den eigenen Erwartungen uebereinstimmt.
     */
    @Test
    public void characterContentGetContent() {
        characterContent.match("\'t\'eststring");
        Token t = characterContent.getToken();
        assertEquals("\'t\'", t.getContent());
    }
}

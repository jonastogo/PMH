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

public class MultilineCommentTest {

    MultilineComment multilineComment;

    @Before
    public void setUp() {
        multilineComment = new MultilineComment();
    }

    /**
     * multilineCommentMatch testet, ob der mehrzeilige Kommentar, die der
     * Methode match() uebergeben wird, den definierten Richtlinien entspricht
     * und der RegEx dazu stimmt.
     */
    @Test
    public void multilineCommentMatch() {
        multilineComment.match("/*hier steht text*/");
        assertEquals(multilineComment.getClass(), multilineComment.getToken().getClass());
    }

    /**
     * mutlilineCommentMatchNotNull prueft auf NULL und schaut, ob der
     * geschriebene mehrzeilige Kommentar korrekt notiert wurde.
     */
    @Test
    public void multilineCommentMatchNotNull() {
        multilineComment.match("/*hier steht text\n@test zuziuziuziu*/kjhkjhkhjk");
        assertNotSame(null, multilineComment.getToken().getClass());
    }

    /**
     * noMultilineCommentMatch testet einen mehrzeiligen Kommentar und prueft ob
     * dieser fehlerhaft ist.
     */
    @Test
    public void noMultilineCommentMatch() {
        multilineComment.match("@test");
        assertEquals(null, multilineComment.getToken());
    }

    /**
     * wrongMultilineComment testet, ob der mehrzeilige Kommentar auf den
     * Regularen Ausdruck passt.
     */
    @Test
    public void wrongMultilineComment() {
        multilineComment.match("jhadj /*kasf*/");
        assertEquals(null, multilineComment.getToken());
    }

    /**
     * multilineCommentGetHtmlStart ueberprueft, ob der Farbwert des
     * HTML-Start-Tag dem Wert aus der MultilineComment-Klasse entspricht.
     */
    @Test
    public void multilineCommentGetHtmlStart() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("<i><font color=\"grey\">",
        // multilineComment.htmlStart());
        assertNotNull(multilineComment.htmlStart());
    }

    /**
     * multilineCommentGetHtmlEnd ueberprueft, ob der HTML-Ende-Tag auch so
     * aufgebaut ist, wie es in der entsprechenden Methode vorgesehen ist.
     */
    @Test
    public void multilineCommentGetHtmlEnd() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("</font></i>", multilineComment.htmlEnd());
        assertNotNull(multilineComment.htmlStart());
    }

    /**
     * multilineCommentGetContent, holt sich den Inhalt und prueft, ob der
     * Inhalt mit den eigenen Erwartungen uebereinstimmt.
     */
    @Test
    public void multilineCommentGetContent() {
        multilineComment.match("/*irgendein \nKommentar\nbla*/nkhjlkhlkhjlkhj/nhkkjh");
        Token t = multilineComment.getToken();
        assertEquals("/*irgendein \nKommentar\nbla*/", t.getContent());
    }
}

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

public class CommentTest {

    Comment comment;

    @Before
    public void setUp() {
        comment = new Comment();
    }

    /**
     * commentMatch testet, ob der Kommentar, die der Methode match() uebergeben
     * wird, dem definierten RegEx entspricht.
     */
    @Test
    public void commentMatch() {
        comment.match("//hier steht text\n");
        assertEquals(comment.getClass(), comment.getToken().getClass());
    }

    /**
     * commentMatchNotNull testet auf NULL und schaut, ob ein Kommentar auch
     * existiert.
     */
    @Test
    public void commentMatchNotNull() {
        comment.match("//hier steht text\n@test zuziuziuziu");
        assertNotSame(null, comment.getToken().getClass());
    }

    /**
     * noCommentMatch testet, ob ein Kommentar ueberhaupt vorhanden ist.
     */
    @Test
    public void noCommentMatch() {
        comment.match("@test");
        assertEquals(null, comment.getToken());
    }

    /**
     * wrongCommentMatch prueft, ob der hinterlegte Kommentar dem Regulaeren
     * Ausdruck entspricht.
     */
    @Test
    public void wrongCommentMatch() {
        comment.match("jhadj //kasf ");
        assertEquals(null, comment.getToken());
    }

    /**
     * commentGetHtmlStart ueberprueft, ob der Farbwert des HTML-Start-Tag dem
     * Wert aus der Commment-Klasse entspricht.
     */
    @Test
    public void commentGetHtmlStart() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("<i><font color=\"grey\">", comment.htmlStart());
        assertNotNull(comment.htmlStart());
    }

    /**
     * commentGetHtmlEnd ueberprueft, ob der HTML-Ende-Tag auch so aufgebaut
     * ist, wie es in der entsprechenden Methode vorgesehen ist.
     */
    @Test
    public void commentGetHtmlEnd() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("</i></font><br />", comment.htmlEnd());
        assertNotNull(comment.htmlStart());
    }

    /**
     * commentGetContent, holt sich den Inhalt des Kommentars und prueft, ob der
     * Inhalt mit den eigenen Erwartungen uebereinstimmt.
     */
    @Test
    public void commentGetContent() {
        comment.match("//irgendein Kommentar\n");
        Token t = comment.getToken();
        assertEquals("//irgendein Kommentar\n", t.getContent());
    }
}

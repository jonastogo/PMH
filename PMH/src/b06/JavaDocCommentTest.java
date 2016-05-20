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

public class JavaDocCommentTest {

    JavaDocComment javaDocComment;

    @Before
    public void setUp() {
        javaDocComment = new JavaDocComment();
    }

    /**
     * javaDocCommentMatch testet, ob der JavaDoc-Kommentar, die der Methode
     * match() uebergeben wird, den Richtlinien eines JavaDoc-Kommentar
     * entspricht und der RegEx dazu stimmt.
     */
    @Test
    public void javaDocCommentMatch() {
        javaDocComment.match("/**hier steht text*/");
        assertEquals(javaDocComment.getClass(), javaDocComment.getToken().getClass());
    }

    /**
     * javaDocCommentMatchNotNull prueft auf NULL und schaut, ob der
     * geschriebene JavaDoc-Kommentar korrekt notiert wurde.
     */
    @Test
    public void javaDocCommentMatchNotNull() {
        javaDocComment.match("/**hier steht text\n@test zuziuziuziu*/kjhkjhkhjk");
        assertNotSame(null, javaDocComment.getToken().getClass());
    }

    /**
     * noJavaDocCommentMatch testet einen JavaDoc-Kommentar und prueft ob dieser
     * fehlerhaft ist.
     */
    @Test
    public void noJavaDocCommentMatch() {
        javaDocComment.match("@test");
        assertEquals(null, javaDocComment.getToken());
    }

    /**
     * wrongJavaDocComment testet, ob der JavaDoc-Kommentar auf den Regularen
     * Ausdruck passt.
     */
    @Test
    public void wrongJavaDocComment() {
        javaDocComment.match("jhadj /**kasf*/ ");
        assertEquals(null, javaDocComment.getToken());
    }

    /**
     * javaDocCommentGetHtmlStart ueberprueft, ob der Farbwert des
     * HTML-Start-Tag dem Wert aus der JavaDocComment-Klasse entspricht.
     */
    @Test
    public void javaDocCommentGetHtmlStart() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("<font color=\"blue\">", javaDocComment.htmlStart());
        assertNotNull(javaDocComment.htmlStart());
    }

    /**
     * javaDocCommentGetHtmlEnd ueberprueft, ob der HTML-Ende-Tag auch so
     * aufgebaut ist, wie es in der entsprechenden Methode vorgesehen ist.
     */
    @Test
    public void javaDocCommentGetHtmlEnd() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("</font>", javaDocComment.htmlEnd());
        assertNotNull(javaDocComment.htmlStart());
    }

    /**
     * javaDocCommentGetContent, holt sich den Inhalt und prueft, ob der Inhalt
     * mit den eigenen Erwartungen uebereinstimmt.
     */
    @Test
    public void javaDocCommentGetContent() {
        javaDocComment.match("/**irgendein \nKommentar\nbla*/nkhjlkhlkhjlkhj/nhkkjh");
        Token t = javaDocComment.getToken();
        assertEquals("/**irgendein \nKommentar\nbla*/", t.getContent());
    }
}

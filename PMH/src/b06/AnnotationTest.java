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

public class AnnotationTest {

    Annotation annotation;

    @Before
    public void setUp() {
        annotation = new Annotation();
    }

    /**
     * annotationMatch testet, ob die Annotation, die der Methode match()
     * uebergeben wird, dem Regulaeren Ausdruck entspricht.
     */
    @Test
    public void annotationMatch() {
        annotation.match("@test ");
        assertEquals(annotation.getClass(), annotation.getToken().getClass());
    }

    /**
     * annotationMatchNotNull testet auf NULL und ueberprueft, ob eine
     * Annotation gesetzt wurde.
     */
    @Test
    public void annotationMatchNotNull() {
        annotation.match("@test zuziuziuziu");
        assertNotSame(null, annotation.getToken().getClass());
    }

    /**
     * noAnnotationMatch prueft, ob eine Annotation ueberhaupt existiert.
     */
    @Test
    public void noAnnotationMatch() {
        annotation.match("//@test ");
        assertEquals(null, annotation.getToken());
    }

    /**
     * wrongAnnotation ueberprueft, ob die erwartete Annotation auch wirklich
     * mit @ beginnt.
     */
    @Test
    public void wrongAnnotation() {
        annotation.match("//jhadj kasf ");
        assertEquals(null, annotation.getToken());
    }

    /**
     * annotationGetHtmlStart ueberprueft, ob der Farbwert des HTML-Start-Tag
     * dem Wert aus der Annotation-Klasse entspricht.
     */
    @Test
    public void annotationGetHtmlStart() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("<font color=\"blue\">", annotation.htmlStart());
        assertNotNull(annotation.htmlStart());
    }

    /**
     * annotationGetHtmlEnd ueberprueft, ob der HTML-Ende-Tag auch so aufgebaut
     * ist, wie es in der entsprechenden Methode vorgesehen ist.
     */
    @Test
    public void annotationGetHtmlEnd() {
        // White-Box! Temporär mit NotNull-Test ersetzt
        // assertEquals("</font>", annotation.htmlEnd());
        assertNotNull(annotation.htmlEnd());
    }

    /**
     * annotationGetContent, holt sich den Inhalt der Annotation und prueft, ob
     * der Inhalt mit den eigenen Erwartungen uebereinstimmt.
     */
    @Test
    public void annotationGetContent() {
        annotation.match("@test ");
        Token t = annotation.getToken();
        assertEquals("@test", t.getContent());
    }
}

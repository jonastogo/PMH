package b06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * @author Steven Yeates
 * @author Christian Gawlik
 * @author Matthias Guzy
 * @since SoSe 2105
 *
 */

public class TokenTest {

    Token ergebnis;

    /**
     * tokenIsAnnoation testet das Token, ob es auf eine Annotation zutrifft.
     */
    @Test
    public void tokenIsAnnotation() {
        Token annotation = new Annotation();
        Token ergebnis = annotation.match("@kjhsdkjshadk");
        assertEquals(ergebnis.getClass(), annotation.getClass());
    }

    /**
     * tokenIsCatchAll prueft ob alle verbliebenen Elemente, auf das
     * CatchAll-Token zutreffen.
     */
    @Test
    public void tokenIsCatchAll() {
        Token catchAll = new CatchAll();
        Token ergebnis = catchAll.match("dkjshadk");
        assertEquals(ergebnis.getClass(), catchAll.getClass());
    }

    /**
     * tokenIsCharacterContent prueft, ob der uebergeben Inhalt einen Character
     * enthaelt.
     */
    @Test
    public void tokenIsCharacterContent() {
        Token characterContent = new CharacterContent();
        Token ergebnis = characterContent.match("'d'kjshadk");
        assertEquals(ergebnis.getClass(), characterContent.getClass());
    }

    /**
     * tokenIsComment testet das Token, ob es auf einen Kommentar passt.
     */
    @Test
    public void tokenIsComment() {
        Token comment = new Comment();
        Token ergebnis = comment.match("//dkjshadk hjhk \n jkhk");
        assertEquals(ergebnis.getClass(), comment.getClass());
    }

    /**
     * tokenIsJavaDocComment testet das Token, ob es auf einen JavaDoc-Kommentar
     * zutrifft.
     */
    @Test
    public void tokenIsJavaDocComment() {
        Token javaDocComment = new JavaDocComment();
        Token ergebnis = javaDocComment.match("/**dkjshadk hjhk \n jkhk*/ jhd \n sfkjh");
        assertEquals(ergebnis.getClass(), javaDocComment.getClass());
    }

    /**
     * tokenIsKeyWord testet das Token, ob es auf einen der vordefinierten
     * Schluesselwoerter zutrifft.
     */
    @Test
    public void tokenIsKeyWord() {
        Token keyWord = new KeyWord();
        Token ergebnis = keyWord.match("import");
        assertEquals(ergebnis.getClass(), keyWord.getClass());
    }

    /**
     * tokenIsMultilineComment testet das Token, ob es auf einen mehrzeiligen
     * Kommentar zutrifft.
     */
    @Test
    public void tokenIsMultilineComment() {
        Token multilineComment = new MultilineComment();
        Token ergebnis = multilineComment.match("/*kjdkjdshak \n sdajkhads \n jhdsa */ jksdfkljas \n");
        assertEquals(ergebnis.getClass(), multilineComment.getClass());
    }

    /**
     * tokenIsNewLine testet das Token, ob es auf eine neue Zeile zutrifft.
     */
    @Test
    public void tokenIsNewLine() {
        Token newLine = new NewLine();
        Token ergebnis = newLine.match("\n sdajkhads \n jhdsa jksdfkljas \n");
        assertEquals(ergebnis.getClass(), newLine.getClass());
    }

    /**
     * tokenIsStringContent testet das Token, ob es auf einen String passt.
     */
    @Test
    public void tokenIsStringContent() {
        Token stringContent = new StringContent();
        Token ergebnis = stringContent.match("\"kjdkjd\"shak \n sdajkhads \n jhdsa */ jksdfkljas \n");
        assertEquals(ergebnis.getClass(), stringContent.getClass());
    }

    /**
     * tokenIsAnnoationWithNoMatch prueft, ob der uebergebene Inhalt als falsche
     * Annotation erkannt wird und liefert NULL zurueck.
     */
    @Test
    public void tokenIsAnnotationWithNoMatch() {
        Token annotation = new Annotation();
        Token ergebnis = annotation.match("ksdsfj");
        assertNull(ergebnis);
    }

    /**
     * tokenIsCatchAllWithNoMatch prueft, ob das CatchAll-Token auch wirklich
     * nur die Elemente filtert, die auf das Token zutreffen und liefert NULL
     * zurueck.
     */
    @Test
    public void tokenIsCatchAllWithNoMatch() {
        Token catchAll = new CatchAll();
        Token ergebnis = catchAll.match("");
        assertNull(ergebnis);
    }

    /**
     * tokenIsCharacterContentWithNoMatch prueft, ob der uebergebene Inhalt
     * keinen Character enthaelt und der Token somit nicht greift und liefert
     * entsprechend NULL zurueck.
     */
    @Test
    public void tokenIsCharacterContentWithNoMatch() {
        Token characterContent = new CharacterContent();
        Token ergebnis = characterContent.match("kjshadk");
        assertNull(ergebnis);
    }

    /**
     * tokenIsCommentWithNoMatch prueft, ob der uebergebene Inhalt als falscher
     * Kommentar erkannt wird und liefert NULL zurueck.
     */
    @Test
    public void tokenIsCommentWithNoMatch() {
        Token comment = new Comment();
        Token ergebnis = comment.match("dkjshadk hjhk \n jkhk");
        assertNull(ergebnis);
    }

    /**
     * tokenIsJavaDocCommentWithNoMatch prueft, ob der uebergebene Inhalt als
     * falscher JavaDoc-Kommentar erkannt wird und liefert NULL zurueck.
     */
    @Test
    public void tokenIsJavaDocCommentWithNoMatch() {
        Token javaDocComment = new JavaDocComment();
        Token ergebnis = javaDocComment.match("*dkjshadk hjhk \n jkhk*/ jhd \n sfkjh");
        assertNull(ergebnis);
    }

    /**
     * tokenIsKeyWordWithNoMatch prueft, ob der das uebergebene Schluesselwort
     * als ungueltiges Schluesselwort erkannt wird und liefert NULL zurueck.
     */
    @Test
    public void tokenIsKeyWordWithNoMatch() {
        Token keyWord = new KeyWord();
        Token ergebnis = keyWord.match("mpo");
        assertNull(ergebnis);
    }

    /**
     * tokenIsMulitlineCommentWithNoMatch prueft, ob der uebergebene Inhalt als
     * falscher mehrzeiliger Kommentar erkannt wird und liefert NULL zurueck.
     */
    @Test
    public void tokenIsMultilineCommentWithNoMatch() {
        Token multilineComment = new MultilineComment();
        Token ergebnis = multilineComment.match("//kjdkjdshak \n sdajkhads \n jhdsa */ jksdfkljas \n");
        assertNull(ergebnis);
    }

    /**
     * tokenIsNewLineWithNoMatch prueft, ob der uebergebene Inhalt keiner neuen
     * Zeile entspricht und liefert NULL zurueck.
     */
    @Test
    public void tokenIsNewLineWithNoMatch() {
        Token newLine = new NewLine();
        Token ergebnis = newLine.match("jh \n sdajkhads \n jhdsa jksdfkljas \n");
        assertNull(ergebnis);
    }

    /**
     * tokenIsStringContentWithNoMatch prueft, ob der uebergebene Inhalt als
     * falscher String erkannt wird und liefert NULL zurueck.
     */
    @Test
    public void tokenIsStringContentWithNoMatch() {
        Token stringContent = new StringContent();
        Token ergebnis = stringContent.match("kjdkjd\"shak \n sdajkhads \n jhdsa */ jksdfkljas \n");
        assertNull(ergebnis);
    }
}

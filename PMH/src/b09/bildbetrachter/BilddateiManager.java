package b09.bildbetrachter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * BilddateiManager ist eine kleine Hilfsklasse mit statischen Methoden zum
 * Laden und Speichern von Bildern.
 *
 * Zu lesende Dateien können im JPG- oder im PNG-Format vorliegen. Das Format
 * von Dateien, die von dieser Klasse geschrieben werden, wird durch die
 * Konstante BILDFORMAT festgelegt.
 *
 * Dieses Projekt ist Teil des Zusatzmaterials zum Buch "Java lernen mit BlueJ -
 * eine Einführung in die objektorientierte Programmierung", 3. Auflage David J.
 * Barnes und Michael Kölling Pearson Education Deutschland, 2006
 *
 * @author Michael Kölling und David J Barnes
 * @version 2.0
 */
public class BilddateiManager {
    // Eine Konstante, die das Format für geschriebene Dateien festgelegt.
    // Zulässige Formate sind "jpg" und "png".
    private static final String BILDFORMAT = "jpg";

    /**
     * Lies eine Bilddatei ein und liefere sie als ein Bild zurück. Diese
     * Methode kann Dateien im JPG- und im PNG-Format lesen. Bei Problemen
     * (etwa, wenn die Datei nicht existiert oder ein nicht lesbares Format hat
     * oder es einen sonstigen Lesefehler gibt) liefert diese Methode null.
     *
     * @param bilddatei
     *            Die zu ladende Bilddatei.
     * @return Das Bild-Objekt oder null, falls die Datei nicht lesbar ist.
     */
    public static Farbbild ladeBild(File bilddatei) {
        try {
            BufferedImage bild = ImageIO.read(bilddatei);
            if (bild == null || (bild.getWidth(null) < 0)) {
                // Bild konnte nicht geladen werden - vermutlich falsches Format
                return null;
            }
            return new Farbbild(bild);
        } catch (IOException exc) {
            return null;
        }
    }

    /**
     * Schreibe das gegebene Bild in eine Bilddatei im JPG-Format. Bei etwaigen
     * Problemen beendet sich diese Methode stillschweigend.
     *
     * @param bild
     *            Das zu speichernde Bild.
     * @param datei
     *            Die Datei, in die gespeichert werden soll.
     */
    public static void speichereBild(Farbbild bild, File datei) {
        try {
            ImageIO.write(bild, BILDFORMAT, datei);
        } catch (IOException exc) {
            return;
        }
    }
}

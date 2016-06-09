package b09.bildbetrachter;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Farbbild ist eine Klasse, die Farbbilder mit einer bequemen Schnittstelle
 * definiert.
 *
 * Dieses Projekt ist Teil des Zusatzmaterials zum Buch "Java lernen mit BlueJ -
 * eine Einführung in die objektorientierte Programmierung", 3. Auflage David J.
 * Barnes und Michael Kölling Pearson Education Deutschland, 2006
 *
 * @author Michael Kölling und David J. Barnes
 * @version 1.1
 */
public class Farbbild extends BufferedImage {

	DunklerFilter		dunkler;
	HellerFilter		heller;
	SchwellwertFilter	schwellwert;
	InvertierenFilter	invertieren;
	SpiegelnYFilter		spiegelnY;
	SpiegelnXFilter		spiegelnX;
	BlurFilter			blur;

	/**
	 * Erzeuge ein Farbbild als Kopie von einem BufferedImage.
	 *
	 * @param image
	 *            das zu kopierende BufferedImage.
	 */
	public Farbbild(BufferedImage image) {
		super(image.getColorModel(), image.copyData(null), image.isAlphaPremultiplied(), null);
		dunkler = new DunklerFilter(this);
		heller = new HellerFilter(this);
		schwellwert = new SchwellwertFilter(this);
		invertieren = new InvertierenFilter(this);
		spiegelnY = new SpiegelnYFilter(this);
		spiegelnX = new SpiegelnXFilter(this);
		blur = new BlurFilter(this);
	}

	/**
	 * Erzeuge ein Farbbild mit der angegebenen Größe mit undefiniertem Inhalt.
	 *
	 * @param breite
	 *            die Breite des Bildes.
	 * @param hoehe
	 *            die Hoehe des Bildes.
	 */
	public Farbbild(int breite, int hoehe) {
		super(breite, hoehe, TYPE_INT_ARGB);
	}

	/**
	 * Setze den angegebenen Bildpunkt dieses Bildes auf die angegebene Farbe.
	 *
	 * @param x
	 *            die x-Koordinate des Bildpunktes.
	 * @param y
	 *            die y-Koordinate des Bildpunktes.
	 * @param col
	 *            die Farbe des Bildpunktes.
	 */
	public void setzePunktfarbe(int x, int y, Color col) {
		int punktfarbe = col.getRGB();
		setRGB(x, y, punktfarbe);
	}

	/**
	 * Liefere die Farbe des angegebenen Bildpunktes.
	 *
	 * @param x
	 *            die x-Koordinate des Bildpunktes.
	 * @param y
	 *            die y-Koordinate des Bildpunktes.
	 * @return die Farbe des Bildpunktes an der angegebenen Position.
	 */
	public Color gibPunktfarbe(int x, int y) {
		int punktfarbe = getRGB(x, y);
		return new Color(punktfarbe);
	}

	/**
	 * Alle Bildpunkte invertieren
	 */
	public void inventieren() {
		invertieren.activateFilter();
	}

	/**
	 * Spiegelt das Bild an der Y-Achse
	 */
	public void spiegelnY() {
		spiegelnY.activateFilter();
	}

	/**
	 * Spiegelt das Bild an der X-Achse
	 */
	public void spiegelnX() {
		spiegelnX.activateFilter();
	}

	/**
	 * Weichzeichner
	 */
	public void blur() {
		blur.activateFilter();
	}

	/**
	 * Dunkle diese Bild etwas ab.
	 */
	public void abdunkeln() {
		dunkler.activateFilter();
	}

	/**
	 * Helle diese Bild etwas auf.
	 */
	public void aufhellen() {
		heller.activateFilter();
	}

	/**
	 * Wende eine dreistufige Schwellwertoperation an. Heißt: Zeichne das Bild
	 * erneut mit lediglich drei Farbwerten: weiß, grau und schwarz.
	 */
	public void schwellwerteAnwenden() {
		schwellwert.activateFilter();
	}
}

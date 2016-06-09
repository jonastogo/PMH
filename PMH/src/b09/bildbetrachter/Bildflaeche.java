package b09.bildbetrachter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

/**
 * Bildflaeche ist eine Swing-Komponente, die ein Farbbild anzeigen kann. Sie
 * ist konstruiert als eine Subklasse von JComponent und bietet die zusätzliche
 * Funktionalität, dass ein eingetragenes Farbbild an der Oberfläche dieser
 * Komponente angezeigt wird.
 *
 * Dieses Projekt ist Teil des Zusatzmaterials zum Buch "Java lernen mit BlueJ -
 * eine Einführung in die objektorientierte Programmierung", 3. Auflage David J.
 * Barnes und Michael Kölling Pearson Education Deutschland, 2006
 *
 * @author Michael Kölling und David J. Barnes
 * @version 1.0
 */
public class Bildflaeche extends JComponent {
	private static final long	serialVersionUID	= 20060330L;

	// Die aktuelle Breite und Höhe dieser Bildfläche
	private int					breite, hoehe;

	// Ein interner Bildpuffer, der zum Zeichnen verwendet wird.
	// Wenn die Fläche tatsächlich angezeigt werden soll, wird dieser
	// Puffer auf den Bildschirm kopiert.
	private Farbbild			bild;

	/**
	 * Erzeuge eine neue, leere Bildfläche.
	 */
	public Bildflaeche() {
		breite = 360; // beliebig gewählte Größe
		hoehe = 240;
		bild = null;
	}

	/**
	 * Setze das Bild, das diese Bildfläche anzeigen soll.
	 *
	 * @param bild
	 *            das anzuzeigende Bild.
	 */
	public void setzeBild(Farbbild bild) {
		if (bild != null) {
			breite = bild.getWidth();
			hoehe = bild.getHeight();
			this.bild = bild;
			repaint();
		}
	}

	/**
	 * Lösche die Bildfläche.
	 */
	public void loeschen() {
		Graphics bildGraphics = bild.getGraphics();
		bildGraphics.setColor(Color.LIGHT_GRAY);
		bildGraphics.fillRect(0, 0, breite, hoehe);
		repaint();
	}

	// Die folgenden Methoden redefinieren Methoden, die aus
	// Superklassen geerbt wurden.

	/**
	 * Teile dem Layout-Manager mit, wie groß diese Komponente sein soll. (Diese
	 * Methode wird vom Layout-Manager aufgerufen, um die Komponenten geeignet
	 * platzieren zu können.)
	 *
	 * @return Die bevorzugte Größe (als Dimension) dieser Komponente.
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(breite, hoehe);
	}

	/**
	 * Diese Komponente soll erneut angezeigt werden. Kopiere das intern
	 * gehaltene Bild auf den Bildschirm. (Diese Methode wird von Swing aus
	 * jedesmal aufgerufen, wenn diese Komponente angezeigt werden soll.)
	 *
	 * @param g
	 *            Der Grafik-Kontext, mit dem auf dieser Komponente gezeichnet
	 *            werden kann.
	 */
	@Override
	public void paintComponent(Graphics g_) {
		Dimension size = getSize();
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.clearRect(0, 0, size.width, size.height);
		if (bild != null) {
			g.drawImage(bild, 0, 0, null);
		}
	}
}

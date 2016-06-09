package b09.bildbetrachter;

import java.awt.Color;

public class InvertierenFilter implements Filter {

	private Farbbild	bild;
	private int			hoehe;
	private int			breite;

	public InvertierenFilter(Farbbild bild) {
		this.bild = bild;
		this.hoehe = bild.getHeight();
		this.breite = bild.getWidth();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activateFilter() {
		int hoehe = this.hoehe;
		int breite = this.breite;
		for (int y = 0; y < hoehe; y++) {
			for (int x = 0; x < breite; x++) {
				bild.setzePunktfarbe(x, y, invertPunktfarbe(x, y));
			}
		}
	}

	/**
	 * Liefert die invertierte Farbe des angegebenen Bildpunktes
	 * 
	 * @param x
	 *            die x-Koordinate des Bildpunktes.
	 * @param y
	 *            die y-Koordinate des Bildpunktes.
	 * @return die Farbe des Bildpunktes an der angegebenen Position.
	 */
	public Color invertPunktfarbe(int x, int y) {
		int punktfarbe = bild.getRGB(x, y);
		Color col = new Color(punktfarbe, true);
		int red = col.getRed();
		int green = col.getGreen();
		int blue = col.getBlue();
		int alpha = col.getAlpha();
		Color newColor = new Color(255 - red, 255 - green, 255 - blue, alpha);
		return newColor;
	}

}

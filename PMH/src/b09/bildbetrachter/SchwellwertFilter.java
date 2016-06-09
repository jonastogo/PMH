package b09.bildbetrachter;

import java.awt.Color;

public class SchwellwertFilter implements Filter {

	private Farbbild	bild;
	private int			hoehe;
	private int			breite;

	public SchwellwertFilter(Farbbild bild) {
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
				Color farbe = bild.gibPunktfarbe(x, y);
				int helligkeit = (farbe.getRed() + farbe.getBlue() + farbe.getGreen()) / 3;
				if (helligkeit <= 85) {
					bild.setzePunktfarbe(x, y, Color.BLACK);
				} else if (helligkeit <= 170) {
					bild.setzePunktfarbe(x, y, Color.GRAY);
				} else {
					bild.setzePunktfarbe(x, y, Color.WHITE);
				}
			}
		}
	}
}

package b09.bildbetrachter;

import java.awt.Color;

public class SpiegelnYFilter implements Filter {

	private Farbbild	bild;
	private int			hoehe;
	private int			breite;

	public SpiegelnYFilter(Farbbild bild) {
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

		int tmpX = 0;
		Color tmpColor;
		for (int y = 0; y < hoehe; y++) {
			for (int x = 0; x < breite / 2; x++) {
				tmpX = breite - 1 - x;
				tmpColor = bild.gibPunktfarbe(x, y);
				bild.setzePunktfarbe(x, y, bild.gibPunktfarbe(tmpX, y));
				bild.setzePunktfarbe(tmpX, y, tmpColor);
			}
		}
	}

}

package b09.bildbetrachter;

import java.awt.Color;

public class SpiegelnXFilter implements Filter {

	private Farbbild	bild;
	private int			hoehe;
	private int			breite;

	public SpiegelnXFilter(Farbbild bild) {
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
		int tmpY = 0;
		Color tmpColor;
		for (int y = 0; y < hoehe / 2; y++) {
			for (int x = 0; x < breite; x++) {
				tmpY = hoehe - 1 - y;
				tmpColor = bild.gibPunktfarbe(x, y);
				bild.setzePunktfarbe(x, y, bild.gibPunktfarbe(x, tmpY));
				bild.setzePunktfarbe(x, tmpY, tmpColor);
			}
		}
	}

}

package b09.bildbetrachter;

import java.awt.Color;

public class BlurFilter implements Filter {

	private Farbbild	bild;
	private int			hoehe;
	private int			breite;

	public BlurFilter(Farbbild bild) {
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
		int[][] coordsXY = new int[hoehe + 1][breite + 1];
		int averageRed = 0;
		int averageGreen = 0;
		int averageBlue = 0;

		for (int y = 0; y < hoehe; y++) {
			for (int x = 0; x < breite; x++) {
				if (y > 0 && y < hoehe - 1 && x > 0 && x < breite - 1) {
					averageRed = 0;
					averageGreen = 0;
					averageBlue = 0;
					averageRed += bild.gibPunktfarbe(x - 1, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x - 1, y).getRed();
					averageRed += bild.gibPunktfarbe(x, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x, y).getRed();
					averageRed += bild.gibPunktfarbe(x - 1, y + 1).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y + 1).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y).getRed();
					averageRed += bild.gibPunktfarbe(x, y + 1).getRed();
					averageGreen += bild.gibPunktfarbe(x - 1, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x - 1, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x - 1, y + 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y + 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y + 1).getGreen();
					averageBlue += bild.gibPunktfarbe(x - 1, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x - 1, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x - 1, y + 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y + 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y + 1).getBlue();
					averageRed /= 9;
					averageGreen /= 9;
					averageBlue /= 9;
					Color col = new Color(averageRed, averageGreen, averageBlue, bild.gibPunktfarbe(x, y).getAlpha());
					coordsXY[x][y] = col.getRGB();
				} else if (y == 0 && x > 0 && x < breite - 1) {
					averageRed = 0;
					averageGreen = 0;
					averageBlue = 0;
					averageRed += bild.gibPunktfarbe(x - 1, y).getRed();
					averageRed += bild.gibPunktfarbe(x, y).getRed();
					averageRed += bild.gibPunktfarbe(x - 1, y + 1).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y + 1).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y).getRed();
					averageRed += bild.gibPunktfarbe(x, y + 1).getRed();
					averageGreen += bild.gibPunktfarbe(x - 1, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x - 1, y + 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y + 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y + 1).getGreen();
					averageBlue += bild.gibPunktfarbe(x - 1, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x - 1, y + 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y + 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y + 1).getBlue();
					averageRed /= 6;
					averageGreen /= 6;
					averageBlue /= 6;
					Color col = new Color(averageRed, averageGreen, averageBlue, bild.gibPunktfarbe(x, y).getAlpha());
					coordsXY[x][y] = col.getRGB();
				} else if (y > 0 && x == 0 && y < hoehe - 1) {
					averageRed = 0;
					averageGreen = 0;
					averageBlue = 0;
					averageRed += bild.gibPunktfarbe(x, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x, y).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y + 1).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y).getRed();
					averageRed += bild.gibPunktfarbe(x, y + 1).getRed();
					averageGreen += bild.gibPunktfarbe(x, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y + 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y + 1).getGreen();
					averageBlue += bild.gibPunktfarbe(x, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y + 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y + 1).getBlue();
					averageRed /= 6;
					averageGreen /= 6;
					averageBlue /= 6;
					Color col = new Color(averageRed, averageGreen, averageBlue, bild.gibPunktfarbe(x, y).getAlpha());
					coordsXY[x][y] = col.getRGB();
				} else if (x < breite - 1 && x > 0 && y == hoehe - 1) {
					averageRed = 0;
					averageGreen = 0;
					averageBlue = 0;
					averageRed += bild.gibPunktfarbe(x - 1, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x - 1, y).getRed();
					averageRed += bild.gibPunktfarbe(x, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x, y).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y).getRed();
					averageGreen += bild.gibPunktfarbe(x - 1, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x - 1, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y).getGreen();
					averageBlue += bild.gibPunktfarbe(x - 1, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x - 1, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y).getBlue();
					averageRed /= 6;
					averageGreen /= 6;
					averageBlue /= 6;
					Color col = new Color(averageRed, averageGreen, averageBlue, bild.gibPunktfarbe(x, y).getAlpha());
					coordsXY[x][y] = col.getRGB();
				} else if (x == breite - 1 && y > 0 && y < hoehe - 1) {
					averageRed = 0;
					averageGreen = 0;
					averageBlue = 0;
					averageRed += bild.gibPunktfarbe(x - 1, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x - 1, y).getRed();
					averageRed += bild.gibPunktfarbe(x, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x, y).getRed();
					averageRed += bild.gibPunktfarbe(x - 1, y + 1).getRed();
					averageRed += bild.gibPunktfarbe(x, y + 1).getRed();
					averageGreen += bild.gibPunktfarbe(x - 1, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x - 1, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x - 1, y + 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y + 1).getGreen();
					averageBlue += bild.gibPunktfarbe(x - 1, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x - 1, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x - 1, y + 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y + 1).getBlue();
					averageRed /= 6;
					averageGreen /= 6;
					averageBlue /= 6;
					Color col = new Color(averageRed, averageGreen, averageBlue, bild.gibPunktfarbe(x, y).getAlpha());
					coordsXY[x][y] = col.getRGB();
				} else if (x == breite - 1 && y == hoehe - 1) {
					averageRed = 0;
					averageGreen = 0;
					averageBlue = 0;
					averageRed += bild.gibPunktfarbe(x - 1, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x - 1, y).getRed();
					averageRed += bild.gibPunktfarbe(x, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x, y).getRed();
					averageGreen += bild.gibPunktfarbe(x - 1, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x - 1, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y).getGreen();
					averageBlue += bild.gibPunktfarbe(x - 1, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x - 1, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y).getBlue();
					averageRed /= 4;
					averageGreen /= 4;
					averageBlue /= 4;
					Color col = new Color(averageRed, averageGreen, averageBlue, bild.gibPunktfarbe(x, y).getAlpha());
					coordsXY[x][y] = col.getRGB();
				} else if (x == 0 && y == 0) {
					averageRed = 0;
					averageGreen = 0;
					averageBlue = 0;
					averageRed += bild.gibPunktfarbe(x, y).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y + 1).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y).getRed();
					averageRed += bild.gibPunktfarbe(x, y + 1).getRed();
					averageGreen += bild.gibPunktfarbe(x, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y + 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y + 1).getGreen();
					averageBlue += bild.gibPunktfarbe(x, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y + 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y + 1).getBlue();
					averageRed /= 4;
					averageGreen /= 4;
					averageBlue /= 4;
					Color col = new Color(averageRed, averageGreen, averageBlue, bild.gibPunktfarbe(x, y).getAlpha());
					coordsXY[x][y] = col.getRGB();
				} else if (x == 0 && y == hoehe) {
					averageRed = 0;
					averageGreen = 0;
					averageBlue = 0;
					averageRed += bild.gibPunktfarbe(x, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x, y).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y - 1).getRed();
					averageRed += bild.gibPunktfarbe(x + 1, y).getRed();
					averageGreen += bild.gibPunktfarbe(x, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y - 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x + 1, y).getGreen();
					averageBlue += bild.gibPunktfarbe(x, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y - 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x + 1, y).getBlue();
					averageRed /= 4;
					averageGreen /= 4;
					averageBlue /= 4;
					Color col = new Color(averageRed, averageGreen, averageBlue, bild.gibPunktfarbe(x, y).getAlpha());
					coordsXY[x][y] = col.getRGB();
				} else if (x == breite && y == 0) {
					averageRed = 0;
					averageGreen = 0;
					averageBlue = 0;
					averageRed += bild.gibPunktfarbe(x - 1, y).getRed();
					averageRed += bild.gibPunktfarbe(x, y).getRed();
					averageRed += bild.gibPunktfarbe(x - 1, y + 1).getRed();
					averageRed += bild.gibPunktfarbe(x, y + 1).getRed();
					averageGreen += bild.gibPunktfarbe(x - 1, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y).getGreen();
					averageGreen += bild.gibPunktfarbe(x - 1, y + 1).getGreen();
					averageGreen += bild.gibPunktfarbe(x, y + 1).getGreen();
					averageBlue += bild.gibPunktfarbe(x - 1, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y).getBlue();
					averageBlue += bild.gibPunktfarbe(x - 1, y + 1).getBlue();
					averageBlue += bild.gibPunktfarbe(x, y + 1).getBlue();
					averageRed /= 4;
					averageGreen /= 4;
					averageBlue /= 4;
					Color col = new Color(averageRed, averageGreen, averageBlue, bild.gibPunktfarbe(x, y).getAlpha());
					coordsXY[x][y] = col.getRGB();
				}
			}
		}
		for (int y = 0; y < hoehe; y++)
			for (int x = 0; x < breite; x++)
				bild.setzePunktfarbe(x, y, new Color(coordsXY[x][y]));
	}

}

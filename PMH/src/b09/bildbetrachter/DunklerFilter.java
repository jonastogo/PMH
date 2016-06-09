package b09.bildbetrachter;

public class DunklerFilter implements Filter {

	private Farbbild	bild;
	private int			hoehe;
	private int			breite;

	public DunklerFilter(Farbbild bild) {
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
				bild.setzePunktfarbe(x, y, bild.gibPunktfarbe(x, y).darker());
			}
		}

	}

}

package b07;

/**
 * @author Carsten Gips
 * @since 02.03.2016
 *
 */
public class GameOfLife {

	// Fill me :)

	/**
	 * Definiert die Gr��e der Welt (x-y-Matrix)
	 *
	 * @param x
	 *            Anzahl der Felder in x-Richtung
	 * @param y
	 *            Anzahl der Felder in y-Richtung
	 *
	 */
	public GameOfLife(int x, int y) {

		// Fill me :)

	}

	/**
	 * Initialisiert die Welt mit einem bestimmten Startmuster.
	 *
	 * Im String ist ein "X" f�r eine lebendige Zelle und ein " " (Leerzeichen)
	 * f�r jede tote Zelle. Die Zellen werden zeilenweise im String dargestellt.
	 *
	 * Wenn der String zu kurz oder zu lang f�r die Welt ist, soll die Methode
	 * eine passende Exception werfen.
	 *
	 * @param s
	 *            String mit dem Startmuster
	 */
	public void initGame(String s) {

		// Fill me :)

	}

	/**
	 * Berechnet die n�chste Generation anhand der vier Regeln (siehe
	 * �bungsblatt).
	 *
	 * @return true, wenn sich die Welt ge�ndert hat; false sonst
	 */
	public boolean nextGen() {

		// Fill me :)

		return false;
	}

	/**
	 * Berechnet die Stringrepr�sentation der aktuellen Welt.
	 *
	 * Es soll ein "X" f�r eine lebendige Zelle und ein " " (Leerzeichen) f�r
	 * jede tote Zelle genutzt werden. Im Gegensatz zur Initialisierung soll mit
	 * Hilfe von Zeilenumbr�chen die Matrixform direkt erhalten bleiben.
	 *
	 */
	@Override
	public String toString() {

		// Fill me :)

		return null;
	}

	/**
	 * Hauptprogramm: Einlesen einer Welt von Tastatur oder aus Datei und
	 * Schleife mit Neuberechnung der Generation, bis keine �nderung mehr.
	 */
	public static void main(String[] args) {

		// Fill me :)

	}

}

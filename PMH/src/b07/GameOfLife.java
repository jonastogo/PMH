package b07;

/**
 * @author Carsten Gips
 * @since 02.03.2016
 *
 */
public class GameOfLife {

	// Fill me :)

	/**
	 * Definiert die Größe der Welt (x-y-Matrix)
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
	 * Im String ist ein "X" für eine lebendige Zelle und ein " " (Leerzeichen)
	 * für jede tote Zelle. Die Zellen werden zeilenweise im String dargestellt.
	 *
	 * Wenn der String zu kurz oder zu lang für die Welt ist, soll die Methode
	 * eine passende Exception werfen.
	 *
	 * @param s
	 *            String mit dem Startmuster
	 */
	public void initGame(String s) {

		// Fill me :)

	}

	/**
	 * Berechnet die nächste Generation anhand der vier Regeln (siehe
	 * Übungsblatt).
	 *
	 * @return true, wenn sich die Welt geändert hat; false sonst
	 */
	public boolean nextGen() {

		// Fill me :)

		return false;
	}

	/**
	 * Berechnet die Stringrepräsentation der aktuellen Welt.
	 *
	 * Es soll ein "X" für eine lebendige Zelle und ein " " (Leerzeichen) für
	 * jede tote Zelle genutzt werden. Im Gegensatz zur Initialisierung soll mit
	 * Hilfe von Zeilenumbrüchen die Matrixform direkt erhalten bleiben.
	 *
	 */
	@Override
	public String toString() {

		// Fill me :)

		return null;
	}

	/**
	 * Hauptprogramm: Einlesen einer Welt von Tastatur oder aus Datei und
	 * Schleife mit Neuberechnung der Generation, bis keine Änderung mehr.
	 */
	public static void main(String[] args) {

		// Fill me :)

	}

}

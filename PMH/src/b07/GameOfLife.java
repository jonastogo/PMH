package b07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Carsten Gips
 * @since 02.03.2016
 *
 */
public class GameOfLife {

	public String[][]	game;
	public String[][]	game2;

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
		this.game = new String[x][y];
		this.game2 = new String[x][y];
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
		if (s.length() < ((this.game.length + 1) * (this.game[1].length + 1))) {
			int i = 0;
			String[] list;
			list = s.split("");

			for (int x = 0; x < this.game.length; x++) {
				for (int y = 0; y < this.game[x].length; y++) {
					if (i <= list.length) {
						this.game[x][y] = list[i];
						i++;
					}

				}
			}
		} else {
			System.out.println("Zu lang!");
		}
	}

	/**
	 * Berechnet die nächste Generation anhand der vier Regeln (siehe
	 * Übungsblatt).
	 *
	 * @return true, wenn sich die Welt geändert hat; false sonst
	 */
	public boolean nextGen() {
		boolean s = false;
		for (int x = 0; x < this.game.length; x++) {
			for (int y = 0; y < this.game[x].length; y++) {
				this.game2[x][y] = this.game[x][y];
			}
		}

		for (int x = 0; x < this.game.length; x++) {
			for (int y = 0; y < this.game[x].length; y++) {
				int counts = 0;
				int counts2 = 0;
				int yp = y + 1;
				int ym = y - 1;
				int xp = x + 1;
				int xm = x - 1;
				if ((x - 1) < 0) {
					xm = this.game.length - 1;
				}
				if ((x + 1) > (this.game.length - 1)) {
					xp = 0;
				}
				if ((y - 1) < 0) {
					ym = this.game[x].length - 1;
				}
				if ((y + 1) > (this.game[x].length - 1)) {
					yp = 0;
				}
				if (this.game[x][y].equals("X")) {
					if (this.game[xm][y].equals("X")) {
						counts++;
					}
					if (this.game[xp][y].equals("X")) {
						counts++;
					}
					if (this.game[x][ym].equals("X")) {
						counts++;
					}
					if (this.game[x][yp].equals("X")) {
						counts++;
					}
					if (this.game[xm][ym].equals("X")) {
						counts++;
					}
					if (this.game[xp][ym].equals("X")) {
						counts++;
					}
					if (this.game[xm][yp].equals("X")) {
						counts++;
					}
					if (this.game[xp][yp].equals("X")) {
						counts++;
					}

				}
				if (this.game[x][y].equals(" ")) {

					if (this.game[xm][y].equals("X")) {
						counts2++;
					}
					if (this.game[xp][y].equals("X")) {
						counts2++;
					}
					if (this.game[x][ym].equals("X")) {

						counts2++;
					}
					if (this.game[x][yp].equals("X")) {
						counts2++;
					}
					if (this.game[xm][ym].equals("X")) {
						counts2++;
					}
					if (this.game[xp][ym].equals("X")) {
						counts2++;
					}
					if (this.game[xm][yp].equals("X")) {
						counts2++;
					}
					if (this.game[xp][yp].equals("X")) {
						counts2++;
					}
				}

				//Regeln
				if ((counts < 2) && (counts > 0)) {
					if (!this.game[x][y].equals(" ")) {
						this.game2[x][y] = " ";
						s = true;
					}
				}

				if ((counts == 2) || (counts == 3)) {
					if (!this.game[x][y].equals("X")) {
						this.game2[x][y] = "X";
						s = true;
					}
				}
				if (counts > 3) {
					if (!this.game[x][y].equals(" ")) {
						this.game2[x][y] = " ";
						s = true;
					}
				}
				if (counts2 == 3) {
					if (!this.game[x][y].equals("X")) {
						this.game2[x][y] = "X";
						s = true;
					}
				}

			}
		}

		if (s == true) {
			for (int x = 0; x < this.game.length; x++) {
				for (int y = 0; y < this.game[x].length; y++) {
					this.game[x][y] = this.game2[x][y];
				}
			}
			return true;
		} else {
			return false;
		}

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
		String s = "";
		for (int x = 0; x < this.game.length; x++) {
			s = s + "\n";
			for (int y = 0; y < this.game[x].length; y++) {
				s = s + this.game[x][y] + "-";
			}
		}

		return s;
	}

	/**
	 * Hauptprogramm: Einlesen einer Welt von Tastatur oder aus Datei und
	 * Schleife mit Neuberechnung der Generation, bis keine Änderung mehr.
	 *
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		GameOfLife run;
		System.out.println("Geben sie den X wert für das feld an");
		String eingabe = br.readLine();
		int x = Integer.parseInt(eingabe);
		System.out.println("Geben sie den Y wert für das feld an");
		String eingabe2 = br.readLine();
		int y = Integer.parseInt(eingabe2);
		System.out.println("Geben sie die StartConfig ein");
		String eingabe3 = br.readLine();
		run = new GameOfLife(x, y);
		run.initGame(eingabe3);
		System.out.println("Feld " + run.toString());
		System.out.println("---------------------------------------");

		while (run.nextGen() != false) {//run.nextGen() != false) {
			System.out.println("Feld " + run.toString());
			System.out.println("---------------------------------------");
		}

	}

}

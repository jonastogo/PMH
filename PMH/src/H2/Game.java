package H2;

import java.util.List;

public interface Game {
	// Spieler X setzen
	void setPlayerX(Player p);

	// Spieler O setzen
	void setPlayerO(Player p);

	// Wer ist gerade dran?
	Player currentPlayer();

	// Welche Zuege sind noch moeglich (aka freie Felder)
	List<Move> remainingMoves();

	// Zug ausfuehren (Feld setzen), naechster Spieler ist "dran"
	void doMove(Move m);

	// Zug zuruecknehmen (Feld setzen), voriger Spieler ist "dran"
	void undoMove(Move m);

	// Spiel zuende?
	boolean ended();

	// Bewertung des Zustandes aus Sicht des Players p
	// +1: p hat gewonnen
	// -1: p hat verloren
	// 0: Unentschieden
	int evalState(Player p);

	// Zeichne das aktuelle Feld auf der Konsole
	void printField();
}

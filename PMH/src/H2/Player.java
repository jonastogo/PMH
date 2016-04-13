package H2;

public interface Player {
	// Spielstrategie setzen
	void setStrategy(GameStrategy s);

	// Naechsten Zug berechnen (Delegation an Strategie!)
	Move nextMove(Game g);

	// Zeichen fuer den Spieler liefern
	char getSymbol();
}

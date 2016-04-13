package H2;

import TicTacToe.FieldStatus;

public interface Player {

	public void setStrategy(GameStrategy s);

	// Naechsten Zug berechnen (Delegation an Strategie!)
	public Move nextMove(Game g);

	// Zeichen fuer den Spieler liefern
	public FieldStatus getSymbol();

	public void setSymbol(FieldStatus fs);
}

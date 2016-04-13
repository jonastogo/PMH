package Owner;

import H2.Game;
import H2.GameStrategy;
import H2.Move;
import H2.Player;
import TicTacToe.FieldStatus;

public class Spieler implements Player {
	private FieldStatus spieler;

	public Spieler(FieldStatus spieler) {
		this.spieler = spieler;
	}

	@Override
	public void setStrategy(GameStrategy s) {
		// TODO Auto-generated method stub

	}

	@Override
	public Move nextMove(Game g) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FieldStatus getSymbol() {
		return spieler;
	}

	@Override
	public void setSymbol(FieldStatus fs) {
		spieler = fs;
	}

}

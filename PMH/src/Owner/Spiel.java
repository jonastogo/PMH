package Owner;

import java.util.List;

import H2.Game;
import H2.Move;
import H2.Player;
import TicTacToe.FieldStatus;

public class Spiel implements Game {
	private FieldStatus	currentP	= FieldStatus.P1;
	private Player		currentPlayer;
	private Main		main;

	public Spiel(Main main) {
		this.main = main;
	}

	@Override
	public void setPlayerX(Player p) {
		p.setSymbol(FieldStatus.P1);
	}

	@Override
	public void setPlayerO(Player p) {
		p.setSymbol(FieldStatus.P2);

	}

	@Override
	public Player currentPlayer() {
		if (main.getSpielerliste().get(0).getSymbol() == currentP) {
			currentPlayer = main.getSpielerliste().get(0);
		} else if (main.getSpielerliste().get(0).getSymbol() == currentP) {
			currentPlayer = main.getSpielerliste().get(1);
		}
		return currentPlayer;
	}

	@Override
	public List<Move> remainingMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doMove(Move m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void undoMove(Move m) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean ended() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int evalState(Player p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printField() {
		// TODO Auto-generated method stub

	}

	public void setCurrentP(FieldStatus fs) {
		this.currentP = fs;
	}

	public FieldStatus getCurrentP() {
		return currentP;
	}

}

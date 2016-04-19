package Owner;

import java.util.ArrayList;

import H2.Player;
import TicTacToe.FieldStatus;

public class Main {
	private static ArrayList<Player>	spielerliste	= new ArrayList<Player>();
	private Spiel						spiel;
	private Spielzuege					spielzuege;

	public Main() {
		spiel = new Spiel(this);
	}

	public static void main(String[] args) {
		spielerliste.add(new Spieler(FieldStatus.P1));
		spielerliste.add(new Spieler(FieldStatus.P2));
	}

	protected static ArrayList<Player> getSpielerliste() {
		return spielerliste;
	}

	protected static void setSpielerliste(ArrayList<Player> spielerliste) {
		Main.spielerliste = spielerliste;
	}

	protected Spiel getSpiel() {
		return spiel;
	}

	protected void setSpiel(Spiel spiel) {
		this.spiel = spiel;
	}

	protected Spielzuege getSpielzuege() {
		return spielzuege;
	}

	protected void setSpielzuege(Spielzuege spielzuege) {
		this.spielzuege = spielzuege;
	}
}

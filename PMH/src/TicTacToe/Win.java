package TicTacToe;

public class Win {
	public FieldStatus pruef(TTTPanel TTTPanel, FieldStatus fs) {
		if (fs == FieldStatus.P1)
			return Spieler1(TTTPanel);
		if (fs == FieldStatus.P2)
			return Spieler2(TTTPanel);
		return null;
	}

	public FieldStatus Spieler1(TTTPanel TTTPanel) {
		for (int i = 0; i <= 2; i++) {
			if ((TTTPanel.getField()[0][i].getStatus() == FieldStatus.P1 && TTTPanel.getField()[1][i].getStatus() == FieldStatus.P1 && TTTPanel.getField()[2][i].getStatus() == FieldStatus.P1)) {
				return FieldStatus.P1;
			}
		}
		for (int j = 0; j <= 2; j++) {
			if (TTTPanel.getField()[j][0].getStatus() == FieldStatus.P1 && TTTPanel.getField()[j][1].getStatus() == FieldStatus.P1 && TTTPanel.getField()[j][2].getStatus() == FieldStatus.P1) {
				return FieldStatus.P1;
			}
		}
		if (TTTPanel.getField()[0][0].getStatus() == FieldStatus.P1 && TTTPanel.getField()[1][1].getStatus() == FieldStatus.P1 && TTTPanel.getField()[2][2].getStatus() == FieldStatus.P1) {
			return FieldStatus.P1;
		}
		if (TTTPanel.getField()[2][0].getStatus() == FieldStatus.P1 && TTTPanel.getField()[1][1].getStatus() == FieldStatus.P1 && TTTPanel.getField()[0][2].getStatus() == FieldStatus.P1) {
			return FieldStatus.P1;
		}
		return null;
	}

	public FieldStatus Spieler2(TTTPanel TTTPanel) {
		for (int i = 0; i <= 2; i++) {
			if ((TTTPanel.getField()[0][i].getStatus() == FieldStatus.P2 && TTTPanel.getField()[1][i].getStatus() == FieldStatus.P2 && TTTPanel.getField()[2][i].getStatus() == FieldStatus.P2)) {
				return FieldStatus.P2;
			}
		}
		for (int j = 0; j <= 2; j++) {
			if (TTTPanel.getField()[j][0].getStatus() == FieldStatus.P2 && TTTPanel.getField()[j][1].getStatus() == FieldStatus.P2 && TTTPanel.getField()[j][2].getStatus() == FieldStatus.P2) {
				return FieldStatus.P2;
			}
		}
		if (TTTPanel.getField()[0][0].getStatus() == FieldStatus.P2 && TTTPanel.getField()[1][1].getStatus() == FieldStatus.P2 && TTTPanel.getField()[2][2].getStatus() == FieldStatus.P2) {
			return FieldStatus.P2;
		}
		if (TTTPanel.getField()[2][0].getStatus() == FieldStatus.P2 && TTTPanel.getField()[1][1].getStatus() == FieldStatus.P2 && TTTPanel.getField()[0][2].getStatus() == FieldStatus.P2) {
			return FieldStatus.P2;
		}
		return null;
	}
}

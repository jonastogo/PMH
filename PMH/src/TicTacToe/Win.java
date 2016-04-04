package TicTacToe;

public class Win {
	public boolean pruef(TTTPanel TTTPanel) {
		boolean win = false;
		while (win != true) {
			for (int i = 0; i <= 2; i++) {
				for (int e = 0; e <= 2; e++) {
					System.out.println(i + " - " + e);
					if (TTTPanel.getField()[i][e].getStatus() == FieldStatus.P1 && TTTPanel.getField()[i][e].getStatus() == FieldStatus.P1 && TTTPanel.getField()[i][e].getStatus() == FieldStatus.P1) {
						win = true;
						System.out.println("Win Player 1");
					}
					if ((TTTPanel.getField()[0][0].getStatus() == FieldStatus.P1 && TTTPanel.getField()[1][1].getStatus() == FieldStatus.P1 && TTTPanel.getField()[2][2].getStatus() == FieldStatus.P1) || (TTTPanel.getField()[0][2].getStatus() == FieldStatus.P1 && TTTPanel.getField()[1][1].getStatus() == FieldStatus.P1 && TTTPanel.getField()[2][0].getStatus() == FieldStatus.P1)) {
						win = true;
						System.out.println("Win Player 1");
					}
					if (TTTPanel.getField()[i][e].getStatus() == FieldStatus.P2 && TTTPanel.getField()[i][e].getStatus() == FieldStatus.P2 && TTTPanel.getField()[i][e].getStatus() == FieldStatus.P2) {
						win = true;
						System.out.println("Win Player 2");
					}
					if ((TTTPanel.getField()[0][0].getStatus() == FieldStatus.P2 && TTTPanel.getField()[1][1].getStatus() == FieldStatus.P2 && TTTPanel.getField()[2][2].getStatus() == FieldStatus.P2) || (TTTPanel.getField()[0][2].getStatus() == FieldStatus.P2 && TTTPanel.getField()[1][1].getStatus() == FieldStatus.P2 && TTTPanel.getField()[2][0].getStatus() == FieldStatus.P2)) {
						win = true;
						System.out.println("Win Player 2");
					}
				}
			}
		}
		return win;

	}

	public boolean alexistscheiße(TTTPanel TTTPanel) {
		boolean win = false;
		for (int i = 0; i <= 2; i++) {
			if ((TTTPanel.getField()[0][i].getStatus() == FieldStatus.P1 && TTTPanel.getField()[1][i].getStatus() == FieldStatus.P1 && TTTPanel.getField()[2][i].getStatus() == FieldStatus.P1) || (TTTPanel.getField()[0][i].getStatus() == FieldStatus.P2 && TTTPanel.getField()[1][i].getStatus() == FieldStatus.P2 && TTTPanel.getField()[2][i].getStatus() == FieldStatus.P2)) {
				return win = true;
			}
		}
		for (int j = 0; j <= 2; j++) {
			if ((TTTPanel.getField()[j][0].getStatus() == FieldStatus.P1 && TTTPanel.getField()[j][1].getStatus() == FieldStatus.P1 && TTTPanel.getField()[j][2].getStatus() == FieldStatus.P1) || (TTTPanel.getField()[j][0].getStatus() == FieldStatus.P2 && TTTPanel.getField()[j][1].getStatus() == FieldStatus.P2 && TTTPanel.getField()[j][2].getStatus() == FieldStatus.P2)) {
				return win = true;
			}
		}
		if ((TTTPanel.getField()[0][0].getStatus() == FieldStatus.P1 && TTTPanel.getField()[1][1].getStatus() == FieldStatus.P1 && TTTPanel.getField()[2][2].getStatus() == FieldStatus.P1) || (TTTPanel.getField()[0][0].getStatus() == FieldStatus.P2 && TTTPanel.getField()[1][1].getStatus() == FieldStatus.P2 && TTTPanel.getField()[2][2].getStatus() == FieldStatus.P2)) {
			return win = true;
		}
		if ((TTTPanel.getField()[2][0].getStatus() == FieldStatus.P1 && TTTPanel.getField()[1][1].getStatus() == FieldStatus.P1 && TTTPanel.getField()[0][2].getStatus() == FieldStatus.P1) || (TTTPanel.getField()[2][0].getStatus() == FieldStatus.P2 && TTTPanel.getField()[1][1].getStatus() == FieldStatus.P2 && TTTPanel.getField()[0][2].getStatus() == FieldStatus.P2)) {
			return win = true;
		}
		return win;
	}
}

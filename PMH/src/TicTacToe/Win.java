package TicTacToe;

public class Win {
    public boolean pruef(TTTPanel TTTPanel) {
        boolean win = false;
        while (win != true) {
            for (int i = 0; i <= 2; i++) {
                for (int e = 0; e <= 2; e++) {
                    if (TTTPanel.getField()[i][e].getStatus()== P1 && TTTPanel.getField()[i][e].getStatus()== P1 && TTTPanel.getField()[i][e].getStatus() == P1) {
                        win = true;
                        System.out.println("Win Player 1");
                    }
                    if (TTTPanel.getField()[0][0].getStatus()== P1 && TTTPanel.getField()[1]1].getStatus()== P1&& TTTPanel.getField()[2][2].getStatus() == P1
                            || (TTTPanel.getField()[0][2].getStatus()== P1 && TTTPanel.getField()[1][1].getStatus()== P1&& TTTPanel.getField()[2][0].getStatus() == P1) {
                        win = true;
                        System.out.println("Win Player 1");
                    }
                    if (TTTPanel.getField()[i][e].getStatus() == P2 && TTTPanel.getField()[i][e].getStatus()== P2 && TTTPanel.getField()[i][e].getStatus()== P2) {
                        win = true;
                        System.out.println("Win Player 2");
                    }
                    if (TTTPanel.getField()[0][0].getStatus()== P2 && TTTPanel.getField()[1][1].getStatus()== P2 && TTTPanel.getField()[2][2].getStatus() == P2
                            || TTTPanel.getField()[0][2].getStatus()== P2 && TTTPanel.getField()[1]1].getStatus()== P2 && TTTPanel.getField()[2][0].getStatus() == P2) {
                        win = true;
                        System.out.println("Win Player 2");
                    }
                }
            }
        }
        return win;
 
    }
 
}
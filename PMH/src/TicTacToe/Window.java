package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener {

	public final int		numberOfColumns	= 3;
	public JPanel			contentPane;
	public JButton			selectColumn;
	public FieldStatus		status			= FieldStatus.P1;
	public TTTPanel			TTTPanel;
	public JPanel			restarter;
	public JButton			restart;
	public boolean			columnfull		= false;
	private int				response;

	public static Window	instance;
	public static Win		win;

	public static void main(String[] args) {
		Window frame = new Window("TicTacToe");
		win = new Win();
		frame.setForeground(Color.BLACK);
		frame.setVisible(true);
	}

	public Window(String title) {
		super(title);
		instance = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(numberOfColumns * 3 / 4 * 70 + 105, numberOfColumns * 3 / 4 * 70 + 160);
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		TTTPanel = new TTTPanel(numberOfColumns, this);
		restarter = new JPanel();
		contentPane.add(TTTPanel, BorderLayout.CENTER);
		contentPane.add(restarter, BorderLayout.SOUTH);
		restart = new JButton("Restart");
		restarter.add(restart);
		restart.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				restart();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String label;
		label = e.getActionCommand();
		for (int i = 0; i < numberOfColumns; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				if (label.equals("row" + j + " " + i)) {
					if (TTTPanel.getField()[j][i].getStatus() == FieldStatus.Empty) {
						if (status == FieldStatus.P1) {
							TTTPanel.getField()[j][i].setStatus(FieldStatus.P1);
							TTTPanel.getField()[j][i].setColor(Color.RED);
							if (win.pruef(TTTPanel, FieldStatus.P1) != null) {
								response = JOptionPane.showConfirmDialog(null, "Spieler 1 hat gewonnen! Spieler 2, du bist scheiße!", "Spieler 1 Win", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
								if (response == JOptionPane.CLOSED_OPTION || response == JOptionPane.OK_OPTION)
									restart();
							}
							status = FieldStatus.P2;
							break;
						} else if (status == FieldStatus.P2) {
							TTTPanel.getField()[j][i].setStatus(FieldStatus.P2);
							TTTPanel.getField()[j][i].setColor(Color.GREEN);
							if (win.pruef(TTTPanel, FieldStatus.P2) != null) {
								response = JOptionPane.showConfirmDialog(null, "Spieler 2 hat gewonnen! Spieler1, du bist scheiße!", "Spieler 2 Win", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
								if (response == JOptionPane.CLOSED_OPTION || response == JOptionPane.OK_OPTION)
									restart();
							}
							status = FieldStatus.P1;
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null, "Bitte wählen sie ein anderes Feld!", "Feld belegt", JOptionPane.WARNING_MESSAGE);
						break;
					}
				}
				this.repaint();
			}
		}
	}

	public void restart() {
		System.out.println("restart");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				TTTPanel.getField()[i][j].setStatus(FieldStatus.Empty);
				TTTPanel.getField()[i][j].setColor(Color.BLACK);
			}
		}
	}
}

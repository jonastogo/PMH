package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener {

	private JPanel			contentPane;
	private FieldStatus		status	= FieldStatus.P1;
	private TTTPanel		TTTPanel;
	private JPanel			restarter;
	private JButton			restart;
	private int				full	= 0;
	private int				response;
	public static Window	instance;
	public static Win		win;

	public static void main(String[] args) {
		Window frame = new Window("TicTacToe");
		win = new Win();
		final Dimension d = frame.getToolkit().getScreenSize();
		frame.setLocation((int) ((d.getWidth() - frame.getWidth()) / 2), (int) ((d.getHeight() - frame.getHeight()) / 2));
		frame.setVisible(true);
	}

	public Window(String title) {
		super(title);
		instance = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(9 / 4 * 70 + 105, 9 / 4 * 70 + 163);
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		TTTPanel = new TTTPanel(this);
		restarter = new JPanel();
		contentPane.add(TTTPanel, BorderLayout.CENTER);
		contentPane.add(restarter, BorderLayout.SOUTH);
		restart = new JButton("Restart");
		restarter.add(restart);
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand(); // field 1 2
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (label.equals("field " + j + " " + i)) {
					if (TTTPanel.getField()[j][i].getStatus() == FieldStatus.Empty) {
						if (getStatus() == FieldStatus.P1) {
							TTTPanel.getField()[j][i].setStatus(FieldStatus.P1);
							TTTPanel.getField()[j][i].setColor(Color.RED);
							if (win.pruef(TTTPanel, FieldStatus.P1) != null) {
								response = JOptionPane.showConfirmDialog(null, "Spieler 1 hat gewonnen! Spieler 2, du bist scheiße!", "Spieler 1 Win", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
								if (response == JOptionPane.CLOSED_OPTION || response == JOptionPane.OK_OPTION) {
									restart();
									return;
								}
							}
							setStatus(FieldStatus.P2);
							full++;
							if (full == 9) {
								response = JOptionPane.showConfirmDialog(null, "Das Spiel ist Unentschieden ausgegangen!", "Unentschieden", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
								if (response == JOptionPane.CLOSED_OPTION || response == JOptionPane.OK_OPTION) {
									restart();
									return;
								}
							}
							break;
						} else if (getStatus() == FieldStatus.P2) {
							TTTPanel.getField()[j][i].setStatus(FieldStatus.P2);
							TTTPanel.getField()[j][i].setColor(Color.GREEN);
							if (win.pruef(TTTPanel, FieldStatus.P2) != null) {
								response = JOptionPane.showConfirmDialog(null, "Spieler 2 hat gewonnen! Spieler1, du bist scheiße!", "Spieler 2 Win", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
								if (response == JOptionPane.CLOSED_OPTION || response == JOptionPane.OK_OPTION) {
									restart();
									return;
								}
							}
							setStatus(FieldStatus.P1);
							full++;
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
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				TTTPanel.getField()[i][j].setStatus(FieldStatus.Empty);
				TTTPanel.getField()[i][j].setColor(Color.BLACK);
			}
		}
		full = 0;
		setStatus(FieldStatus.P1);
		this.repaint();
	}

	public FieldStatus getStatus() {
		return status;
	}

	public void setStatus(FieldStatus status) {
		this.status = status;
	}
}

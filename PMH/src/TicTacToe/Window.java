package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends JFrame implements ActionListener {

	public final int		numberOfColumns	= 3;
	public JPanel			contentPane;
	public JPanel			buttons;
	public JButton			selectColumn;
	public FieldStatus		status			= FieldStatus.P1;
	public TTTPanel			TTTPanel;
	public JPanel			restarter;
	public boolean			columnfull		= false;

	public static Window	instance;

	public static void main(String[] args) {
		Window frame = new Window("TicTacToe");
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
		restarter.add(new JButton("Restart"));
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
							status = FieldStatus.P2;
							break;
						} else if (status == FieldStatus.P2) {
							TTTPanel.getField()[j][i].setStatus(FieldStatus.P2);
							TTTPanel.getField()[j][i].setColor(Color.GREEN);
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
}

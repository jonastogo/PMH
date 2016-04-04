package TicTacToe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TTTPanel extends JPanel implements MouseListener {

	private Window		parent;
	private PanelButton	field[][]	= new PanelButton[3][3];

	public TTTPanel(Window w) {
		this.parent = w;
		for (int i = 0; i < field[0].length; i++) {
			for (int j = 0; j < field.length; j++) {
				field[j][i] = new PanelButton((j * 70) + 15, i * 70 + 30, 67, 67, "", "field " + j + " " + i);
			}
		}
		this.addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g_) {
		Graphics2D g = (Graphics2D) g_;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		String player = "Spieler " + (this.parent.getStatus().ordinal() + 1) + " ist an der Reihe!";
		g.setColor(Color.BLACK);
		g.drawString(player, (int) (14 + this.getBounds().getX()), 20);
		for (int i = 0; i < field[0].length; i++) {
			for (int j = 0; j < field.length; j++) {
				field[j][i].draw(g);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		y -= 25;
		for (int i = 0; i < field[0].length; i++) {
			for (int j = 0; j < field.length; j++) {
				if (field[j][i].isInMe(x, y)) {
					this.parent.actionPerformed(new ActionEvent("button", ActionEvent.ACTION_PERFORMED, field[j][i].getCmd()));
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public Window getParent() {
		return parent;
	}

	protected void setParent(Window parent) {
		this.parent = parent;
	}

	protected PanelButton[][] getField() {
		return field;
	}

	protected void setField(PanelButton[][] field) {
		this.field = field;
	}
}

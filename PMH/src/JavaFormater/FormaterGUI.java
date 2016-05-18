package JavaFormater;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class FormaterGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormaterGUI frame = new FormaterGUI("JavaFormater");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormaterGUI(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(620);
		contentPane.add(splitPane, BorderLayout.CENTER);

		JPanel panelLeft = new JPanel();
		panelLeft.setBorder(new TitledBorder(null, "Input", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setLeftComponent(panelLeft);
		panelLeft.setLayout(new BorderLayout(0, 0));

		JEditorPane inputPane = new JEditorPane();
		JScrollPane scrollPaneLeft = new JScrollPane(inputPane);
		panelLeft.add(scrollPaneLeft);

		JPanel panelRight = new JPanel();
		panelRight.setBorder(new TitledBorder(null, "Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setRightComponent(panelRight);
		panelRight.setLayout(new BorderLayout(0, 0));

		JEditorPane outputPane = new JEditorPane();
		JScrollPane scrollPaneRight = new JScrollPane(outputPane);
		panelRight.add(scrollPaneRight);

	}

}

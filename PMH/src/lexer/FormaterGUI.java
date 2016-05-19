package lexer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import b06.Token;

public class FormaterGUI extends JFrame {

	private JPanel			contentPane;
	private Lexer			lexer;
	private Document		doc;
	private StyleSheet		styleSheet;
	private HTMLEditorKit	kit;

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
		lexer = new Lexer();
		lexer.registerToken(new KeyWordToken());
		lexer.registerToken(new NewLineToken());
		lexer.registerToken(new CharacterContentToken());
		lexer.registerToken(new StringContentToken());
		lexer.registerToken(new JavaDocCommentToken());
		lexer.registerToken(new CommentToken());
		lexer.registerToken(new AnnotationToken());
		lexer.registerCatchAll(new CatchAllToken());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 744);
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
		this.kit = new HTMLEditorKit();
		outputPane.setEditorKit(this.kit);

		this.styleSheet = this.kit.getStyleSheet();
		this.styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
		this.styleSheet.addRule("h1 {color: blue;}");
		this.styleSheet.addRule("h2 {color: #ff0000;}");

		this.styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");
		this.doc = this.kit.createDefaultDocument();
		outputPane.setDocument(this.doc);
		JScrollPane scrollPaneRight = new JScrollPane(outputPane);
		panelRight.add(scrollPaneRight);
		outputPane.setText("<body></body>");

		JButton convert = new JButton("Highlighting");
		contentPane.add(convert, BorderLayout.SOUTH);
		convert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(inputPane.getText());

				String output = "<body>";
				for (Token t : lexer.tokenize(inputPane.getText())) {
					output += t.getHtml();
				}
				output += "</body>";
				outputPane.setText(output);
		});

	}

}

package b09.bildbetrachter;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * Bildbetrachter ist die Hauptklasse der Bildbetrachter-Anwendung. Sie erstellt
 * die GUI der Anwendung, zeigt sie an und initialisiert alle anderen
 * Komponenten.
 *
 * Erzeugen Sie ein Exemplar dieser Klasse, um die Anwendung zu starten.
 *
 * Dieses Projekt ist Teil des Zusatzmaterials zum Buch "Java lernen mit BlueJ -
 * eine Einführung in die objektorientierte Programmierung", 3. Auflage David J.
 * Barnes und Michael Kölling Pearson Education Deutschland, 2006
 *
 * @author Michael Kölling und David J. Barnes
 * @version 1.0
 */
public class Bildbetrachter {
	// statische Datenfelder (Klassenkonstanten und -variablen)
	private static final String	VERSION				= "Version 1.0";
	private static JFileChooser	dateiauswahldialog	= new JFileChooser(System.getProperty("user.dir"));

	// Datenfelder
	private JFrame				fenster;
	private Bildflaeche			bildflaeche;
	private JLabel				dateinameLabel;
	private JLabel				statusLabel;
	private Farbbild			aktuellesBild;

	/**
	 * Erzeuge einen Bildbetrachter und zeige seine GUI auf dem Bildschirm an.
	 */
	public Bildbetrachter() {
		aktuellesBild = null;
		fensterErzeugen();
	}

	// ---- Implementierung der Menü-Funktionen ----

	/**
	 * 'Datei oeffnen'-Funktion: öffnet einen Dateiauswahldialog zur Auswahl
	 * einer Bilddatei und zeigt das selektierte Bild an.
	 */
	private void dateiOeffnen() {
		int ergebnis = dateiauswahldialog.showOpenDialog(fenster);

		if (ergebnis != JFileChooser.APPROVE_OPTION) { // abgebrochen
			return;
		}
		File selektierteDatei = dateiauswahldialog.getSelectedFile();
		aktuellesBild = BilddateiManager.ladeBild(selektierteDatei);

		if (aktuellesBild == null) { // Bilddatei nicht im gültigen Format
			JOptionPane.showMessageDialog(fenster, "Die Datei hat keines der unterstützten Formate.", "Fehler beim Bildladen", JOptionPane.ERROR_MESSAGE);
			return;
		}

		bildflaeche.setzeBild(aktuellesBild);
		dateinameAnzeigen(selektierteDatei.getPath());
		statusAnzeigen("Datei geladen.");
		fenster.pack();
	}

	/**
	 * 'Schliessen'-Funktion: Schließt das aktuelle Bild.
	 */
	private void schliessen() {
		aktuellesBild = null;
		bildflaeche.loeschen();
		dateinameAnzeigen(null);
	}

	/**
	 * 'Beenden'-Funktion: Beendet die Anwendung.
	 */
	private void beenden() {
		System.exit(1);
	}

	/**
	 * 'Dunkler'-Funktion: Das aktuelle Bild etwas abdunkeln.
	 */
	private void dunkler() {
		if (aktuellesBild != null) {
			aktuellesBild.abdunkeln();
			fenster.repaint();
			statusAnzeigen("Angewendet: Dunkler");
		} else {
			statusAnzeigen("Kein Bild geladen.");
		}
	}

	/**
	 * 'Heller'-Funktion: Das aktuelle Bild etwas aufhellen.
	 */
	private void heller() {
		if (aktuellesBild != null) {
			aktuellesBild.aufhellen();
			fenster.repaint();
			statusAnzeigen("Angewendet: Heller");
		} else {
			statusAnzeigen("Kein Bild geladen.");
		}
	}

	/**
	 * Invertiert alle Bildpunkte
	 */
	private void invertieren() {
		if (aktuellesBild != null) {
			aktuellesBild.inventieren();
			fenster.repaint();
			statusAnzeigen("Angewendet: invertieren");
		} else {
			statusAnzeigen("Wurde nicht invertiert.");
		}
	}

	/**
	 * Spiegelt das Bild an der Y-Achse (Mitte)
	 */
	private void spiegelnY() {
		if (aktuellesBild != null) {
			aktuellesBild.spiegelnY();
			fenster.repaint();
			statusAnzeigen("Angewendet: invertieren");
		} else {
			statusAnzeigen("Wurde nicht invertiert.");
		}
	}

	/**
	 * Spiegelt das Bild an der X-Achse (Mitte)
	 */
	private void spiegelnX() {
		if (aktuellesBild != null) {
			aktuellesBild.spiegelnX();
			fenster.repaint();
			statusAnzeigen("Angewendet: invertieren");
		} else {
			statusAnzeigen("Wurde nicht invertiert.");
		}
	}

	/**
	 * Zeichnet das Bild blur
	 */
	private void weichzeichnen() {
		if (aktuellesBild != null) {
			aktuellesBild.blur();
			fenster.repaint();
			statusAnzeigen("Angewendet: invertieren");
		} else {
			statusAnzeigen("Wurde nicht invertiert.");
		}
	}

	/**
	 * 'Schwellwert'-Funktion: Schwellwerte auf das aktuelle Bild anwenden.
	 */
	private void schwellwert() {
		if (aktuellesBild != null) {
			aktuellesBild.schwellwerteAnwenden();
			fenster.repaint();
			statusAnzeigen("Angewendet: Schwellwert");
		} else {
			statusAnzeigen("Kein Bild geladen.");
		}
	}

	// ---- Hilfsmethoden ----

	/**
	 * Zeigt den Dateinamen des aktuellen Bildes auf dem Label für den
	 * Dateinamen. Der Parameter sollte 'null' sein, wenn kein Bild geladen ist.
	 *
	 * @param dateiname
	 *            Der anzuzeigende Dateiname, oder null für 'keine Datei'.
	 */
	private void dateinameAnzeigen(String dateiname) {
		if (dateiname == null) {
			dateinameLabel.setText("Keine Datei angezeigt.");
		} else {
			dateinameLabel.setText("Datei: " + dateiname);
		}
	}

	/**
	 * Zeige den gegebenen Text in der Statuszeile am unteren Rand des Fensters.
	 *
	 * @param text
	 *            der anzuzeigende Statustext.
	 */
	private void statusAnzeigen(String text) {
		statusLabel.setText(text);
	}

	// ---- Swing-Anteil zum Erzeugen des Fensters mit allen Komponenten ----

	/**
	 * Erzeuge das Swing-Fenster samt Inhalt.
	 */
	private void fensterErzeugen() {
		fenster = new JFrame("Bildbetrachter");
		menuezeileErzeugen(fenster);

		Container contentPane = fenster.getContentPane();

		// Ein Layout mit hübschen Abständen definieren
		contentPane.setLayout(new BorderLayout(6, 6));

		// Die Bildfläche in der Mitte erzeugen
		bildflaeche = new Bildflaeche();
		contentPane.add(bildflaeche, BorderLayout.CENTER);

		// Zwei Labels oben und unten für den Dateinamen und Statusmeldungen
		dateinameLabel = new JLabel();
		contentPane.add(dateinameLabel, BorderLayout.NORTH);

		statusLabel = new JLabel(VERSION);
		contentPane.add(statusLabel, BorderLayout.SOUTH);

		// Aufbau abgeschlossen - Komponenten arrangieren lassen
		dateinameAnzeigen(null);
		fenster.pack();

		// Das Fenster in der Mitte des Bildschirms platzieren und anzeigen
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		fenster.setLocation(d.width / 2 - fenster.getWidth() / 2, d.height / 2 - fenster.getHeight() / 2);
		fenster.setVisible(true);
	}

	/**
	 * Die Menüzeile des Hauptfensters erzeugen.
	 *
	 * @param fenster
	 *            Das Fenster, in das die Menüzeile eingefügt werden soll.
	 */
	private void menuezeileErzeugen(JFrame fenster) {
		final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

		JMenuBar menuezeile = new JMenuBar();
		fenster.setJMenuBar(menuezeile);

		JMenu menue;
		JMenuItem eintrag;

		// Das Datei-Menü erzeugen
		menue = new JMenu("Datei");
		menuezeile.add(menue);

		eintrag = new JMenuItem("öffnen...");
		eintrag.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, SHORTCUT_MASK));
		eintrag.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dateiOeffnen();
			}
		});
		menue.add(eintrag);

		eintrag = new JMenuItem("Schließen");
		eintrag.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, SHORTCUT_MASK));
		eintrag.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				schliessen();
			}
		});
		menue.add(eintrag);
		menue.addSeparator();

		eintrag = new JMenuItem("Beenden");
		eintrag.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
		eintrag.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				beenden();
			}
		});
		menue.add(eintrag);

		// Das Filter-Menü erzeugen
		menue = new JMenu("Filter");
		menuezeile.add(menue);

		eintrag = new JMenuItem("Dunkler");
		eintrag.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dunkler();
			}
		});

		menue.add(eintrag);

		eintrag = new JMenuItem("Heller");
		eintrag.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				heller();
			}
		});

		menue.add(eintrag);

		eintrag = new JMenuItem("Schwellwert");
		eintrag.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				schwellwert();
			}
		});

		menue.add(eintrag);

		eintrag = new JMenuItem("Invertieren");
		eintrag.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				invertieren();
			}
		});
		menue.add(eintrag);

		eintrag = new JMenuItem("Spiegeln an Y");
		eintrag.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				spiegelnY();
			}
		});
		menue.add(eintrag);

		eintrag = new JMenuItem("Spiegeln an X");
		eintrag.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				spiegelnX();
			}
		});
		menue.add(eintrag);

		eintrag = new JMenuItem("Weichzeichner");
		eintrag.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				weichzeichnen();
			}
		});
		menue.add(eintrag);

	}
}

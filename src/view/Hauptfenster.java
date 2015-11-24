package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.Spieler;
import model.Spielplan;
 
/***
 * Das Hauptfenster.
 * @author Christian Olmscheid
 *
 */

public class Hauptfenster extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JMenuItem neu;
	private SpielplanFeld feld;

	public Hauptfenster() {
		
    	// Fenstereigenschaften
		super("Liga Manager"); 
		setResizable(false);
		setSize(1500,350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// Komponenten
		erstelleMenu();
    }
	
	private void erstelleMenu() {
		
		// Menu bar.
		JMenuBar menuBar = new JMenuBar();
		
		// Menu Spielplan
		JMenu menu_spielplan = new JMenu("Spielplan");
		menuBar.add(menu_spielplan);
		
		// Menu Item Neu
		neu = new JMenuItem("Neu");
		neu.addActionListener(this);
		menu_spielplan.add(neu);
		
		// Menunbar hinzufuegen
		this.setJMenuBar(menuBar);
	}

	public void actionPerformed(ActionEvent e) {

		// Neu Button betaetigt
		if (e.getSource() == neu) {
			
			// Ruft Dialog zur Eingabe der Spieler auf
			SpielerDialog dialog = new SpielerDialog(this, 4);
			Spieler[] spieler = dialog.showDialog();
			if (spieler == null)
				return;
			
			Spielplan spielplan = new Spielplan(spieler);
			
			// Fuegt das Spielplan Feld hinzu
			if (feld != null)
				remove(feld);
			
			feld = new SpielplanFeld(spielplan);
			add(feld);
			validate();
			repaint();
		}  
	}
}
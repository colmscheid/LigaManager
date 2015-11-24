package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Spieler;

/***
 * Dialog, der die Spieler und Mannschaften erfragt.
 * @author Christian Olmscheid
 *
 */

public class SpielerDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = -4808623583335292137L;
	private int anzahl;
	private JButton ok;
	private JButton abbruch;
	private Spieler[] spieler;
	private JTextField[] spieler_namen;
	private JTextField[] mannschaften;
	
	public SpielerDialog(JFrame fenster, int anzahl) {
		
		super(fenster, "Spieler eingeben", true);
		
		this.anzahl = anzahl;
		erstelleFenster();
		setSize(600,300);
		setLocationRelativeTo(null);  
		setResizable(false);
		setUndecorated(true); 
	}
	
	private void erstelleFenster() {
		
		// Ueberschrift
		JLabel ueberschrift = new JLabel("Spieler und Mannschaften eingeben!");
		
		// Layout planen
		Container c = this.getContentPane();

	    GridBagLayout gbl = new GridBagLayout();
	    c.setLayout(gbl);

	    //                                   x  y  w  h  wx   wy  padding 
	    addComponent(c, gbl, ueberschrift,   0, 0, 4, 1, 0,   0,  0, 0, 10, 0);
	    
	    // Eingabe Spieler und Mannschaften
	    spieler_namen = new JTextField[anzahl];
	    mannschaften = new JTextField[anzahl];
	    
	    
		for (int i = 0; i < anzahl; i++) {
			
			spieler_namen[i] = new JTextField(15);
			mannschaften[i] = new JTextField(15);
			
            //                                                   x  y    w  h  wx  wy  padding 
			addComponent(c, gbl, new JLabel("Spieler " + (i+1)), 0, i+2, 1, 1, 0,  0,  10, 10, 0, 0);
			addComponent(c, gbl, spieler_namen[i],               1, i+2, 1, 1, 0,  0,  10, 10, 0, 0);
			addComponent(c, gbl, new JLabel("Mannschaft"),       2, i+2, 1, 1, 0,  0,  10, 10, 0, 0);
			addComponent(c, gbl, mannschaften[i],                3, i+2, 1, 1, 0,  0,  10, 10, 0, 0);
		}
		
		// Button
		ok = new JButton("OK");
		ok.setSize(new Dimension(30, 20));
		ok.addActionListener(this);
		
		abbruch = new JButton("Abbruch");
		abbruch.setSize(new Dimension(30, 20));
		abbruch.addActionListener(this);
		
		//                            x  y         w  h  wx  wy  padding 
		addComponent(c, gbl, ok,      0, anzahl+2, 2, 1, 0,  0,  20, 10, 0, 0);
		addComponent(c, gbl, abbruch, 2, anzahl+2, 2, 1, 0,  0,  20, 10, 0, 0);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// OK Button betaetigt
		if (e.getSource() == ok){
            
			spieler = erstelleSpieler();
			
			// Falsche Eingabe
			if (spieler == null) {
				JOptionPane.showMessageDialog(this,
					    "Bitte fuellen Sie alle Felder aus!",
					    "Fehlende Eingabe",
					    JOptionPane.ERROR_MESSAGE);
			
			// Korrekte Eingabe	
			} else {
				
				setVisible(false);
				dispose();
			}
        } 
		
		// Abbruch Button betaetigt
		else {
        	
			setVisible(false);
			spieler = null;
			dispose();
        }
	}
	
	private Spieler[] erstelleSpieler() {
		
		Spieler[] spieler = new Spieler[anzahl];
		
		// Durchlaufen aller Spieler
		for (int i = 0; i < anzahl; i++) {

			// Fehlende Eingabe abfangen
			if (spieler_namen[i].getText().trim().equals("") || mannschaften[i].getText().trim().equals("")) {
				return null;
			}
			
			// Spieler erstellen
			spieler[i] = new Spieler(spieler_namen[i].getText().trim(), mannschaften[i].getText().trim());
		}
		
		return spieler;
	}
	
	public Spieler[]  showDialog() {
		
		setVisible(true);
		return spieler;
	}

	static void addComponent( Container cont,
            GridBagLayout gbl,
            Component c,
            int x, int y,
            int width, int height,
            double weightx, double weighty,
            int top, int left, int bottom, int right) {
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x; gbc.gridy = y;
		gbc.gridwidth = width; gbc.gridheight = height;
		gbc.weightx = weightx; gbc.weighty = weighty;
		gbc.insets = new Insets(top, left, bottom, right);
		gbl.setConstraints( c, gbc );
		cont.add(c);
	}
}
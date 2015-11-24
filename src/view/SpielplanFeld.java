package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.SpielplanFeldController;
import model.Spielplan;

/***
 * Diese Feld enthaelt das Feld fuer die Spiele und die Tabelle.
 * @author Christian Olmscheid
 *
 */

public class SpielplanFeld extends JPanel {

	private static final long serialVersionUID = 1L;
	private Spielplan spielplan;
	private SpielplanFeldController controller;
	
	public SpielplanFeld(Spielplan spielplan) {
		
		super();
		this.spielplan = spielplan;
		erstelleFeld();
	}
	
	private void erstelleFeld() {
		
		// Ueberschrift
		JLabel ueberschrift = new JLabel("Spielplan");
				
		// Layout planen
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		
		//                                      x  y  w  h  wx   wy  padding 
		addComponent(this, gbl, ueberschrift,   0, 0, 2, 1, 0,   0,  0, 0, 10, 0);
		
		// Panels fuer Spiele und Tabelle
		SpieleFeld spiele = null;
		TabellenFeld tabelle = null;
		
		controller = new SpielplanFeldController(spiele, tabelle, spielplan);
		
		spiele = new SpieleFeld(this, spielplan);
		tabelle = new TabellenFeld(this);
		//                                 x  y  w  h  wx   wy  padding 
		addComponent(this, gbl, spiele,    0, 1, 1, 1, 0,   0,  0, 0, 0, 0);
		addComponent(this, gbl, tabelle,   1, 1, 1, 1, 0,   0,  0, 50, 0, 0);
		
		controller = new SpielplanFeldController(spiele, tabelle, spielplan);
	}
	
	public SpielplanFeldController getController() {
		
		return controller;
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

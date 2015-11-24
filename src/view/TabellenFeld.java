package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.TabellenModell;

/***
 * Dieses Feld enthaelt die Tabelle.
 * @author Christian Olmscheid
 *
 */

public class TabellenFeld extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private SpielplanFeld spielplanFeld;
	private TabellenModell model;

	public TabellenFeld(SpielplanFeld spielplanFeld) {
		
		super();
		this.spielplanFeld = spielplanFeld;
		erstelleFeld();
	}
	
	private void erstelleFeld() {
		
		// Ueberschrift
		JLabel ueberschrift = new JLabel("Tabelle");
				
		// Layout planen
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		
		//                                      x  y  w  h  wx   wy  padding 
		addComponent(this, gbl, ueberschrift,   0, 0, 2, 1, 0,   0,  0, 0, 10, 0);
		
		// Tabelle
		model = new TabellenModell(spielplanFeld.getController().getTabelle());
		JTable tabelle = new JTable(model);
		tabelle.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pane = new JScrollPane(tabelle);
		pane.setPreferredSize(new Dimension(830, 100));
		
		//                                 x  y  w  h  wx   wy  padding 
		addComponent(this, gbl, pane,   1, 1, 1, 1, 0,   0,  0, 0, 0, 0);
	}
	
	public void neuZeichnen() {
		
		model.fireTableDataChanged();
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

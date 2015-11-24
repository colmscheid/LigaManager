package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Spiel;
import model.Spielplan;

/***
 * Das Feld, auf welchem die Spiele angezeigt werden.
 * @author Christian Olmscheid
 *
 */

public class SpieleFeld extends JPanel implements ChangeListener {

	private static final long serialVersionUID = 1L;
	private Spielplan spielplan;
	private SpielplanFeld spielplanfeld;

	public SpieleFeld(SpielplanFeld spielplanfeld, Spielplan spielplan) {
		
		super();
		this.spielplanfeld = spielplanfeld;
		this.spielplan = spielplan;
		setSize(100,100);
		erstelleFeld();
	}
	
	private void erstelleFeld() {
		
		// Ueberschrift
		JLabel ueberschrift = new JLabel("Spiele");
				
		// Layout planen
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		
		//                                      x  y  w  h  wx   wy  padding 
		addComponent(this, gbl, ueberschrift,   0, 0, 4, 1, 0,   0,  0, 0, 10, 0);
		
		// Spiele anzeigen
		Spiel spiel;
		ZaehlFeld[] heimtore = new ZaehlFeld[spielplan.getAnzahlSpiele()];
		ZaehlFeld[] auswaertstore = new ZaehlFeld[spielplan.getAnzahlSpiele()];
		
		for (int i = 0; i < spielplan.getAnzahlSpiele(); i++) {
			
			spiel = spielplan.getSpiel(i);
			ZaehlFeld heimtor = new ZaehlFeld(true, i);
			heimtor.addChangeListener(this);
			ZaehlFeld auswaertstor = new ZaehlFeld(false, i);
			auswaertstor.addChangeListener(this);
			heimtore[i] = heimtor;
			auswaertstore[i] = auswaertstor;
			
			//                                                                            x  y    w  h  wx   wy  padding 
			addComponent(this, gbl, new JLabel(spiel.getHeimTeam().getMannschaft()),      0, i+1, 1, 1, 0,   0,  10, 0, 0, 0);
			addComponent(this, gbl, heimtor,      										  1, i+1, 1, 1, 0,   0,  10, 10, 0, 0);
			addComponent(this, gbl, auswaertstor,                                         2, i+1, 1, 1, 0,   0,  10, 10, 0, 0);
			addComponent(this, gbl, new JLabel(spiel.getAuswaertsTeam().getMannschaft()), 3, i+1, 1, 1, 0,   0,  10, 10, 0, 0);
		}
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

	public void stateChanged(ChangeEvent e) {
		
		// Zaehler, der verwendet wurde
		ZaehlFeld feld = (ZaehlFeld) e.getSource();
		
		String tore = feld.getTore();
		
		// Das neue Ergebnis wird im Spielplan vermerkt, "-" entspricht noch nicht gespielt
		if (tore.equals("-"))
			spielplan.setTore(-1, feld.getSpiel(), feld.isHeim());
		
		else
			spielplan.setTore(Integer.parseInt(tore), feld.getSpiel(), feld.isHeim());
		
		// Tabelle neu zeichnen
		spielplanfeld.getController().tabelleNeuZeichnen();;
	}
}

package controller;

import model.Spielplan;
import model.Tabelle;
import view.SpieleFeld;
import view.TabellenFeld;

/***
 * Der Controller regelt die Kommunikation zwischen den Spielen und der Tabelle. Er sorgt
 * dafuer, dass die Tabelle immer aktualisiert wird.
 * @author Christian Olmscheid
 *
 */

public class SpielplanFeldController {
	
	private TabellenFeld tabellenfeld;
	private Spielplan spielplan;
	
	public SpielplanFeldController(SpieleFeld spielefeld, TabellenFeld tabellenfeld, Spielplan spielplan) {
		
		this.tabellenfeld = tabellenfeld;
		this.spielplan = spielplan;
	}
	
	public Tabelle getTabelle() {

		return spielplan.getTabelle();
	}
	
	public void tabelleNeuZeichnen() {
		
		tabellenfeld.neuZeichnen();
	}
}
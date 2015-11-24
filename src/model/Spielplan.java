package model;

/***
 * Klasse fuer einen Spielplan. Enthaelt Lister fuer Spieler und Spiele sowie der Tabelle.
 * @author Christian Olmscheid
 *
 */
public class Spielplan {

	private Spieler[] spieler;
	private Spiel [] spiele;
	private Tabelle tabelle;
	
	public Spielplan(Spieler[] spieler) {
		
		this.spieler = spieler;
		erstelleSpielplan();
		this.tabelle = new Tabelle(spieler, spiele);
	}
	
	private void erstelleSpielplan() {
		
		spiele = new Spiel[6];
		spiele[0] = new Spiel(spieler[0], spieler[1]);
		spiele[1] = new Spiel(spieler[2], spieler[3]);
		spiele[2] = new Spiel(spieler[0], spieler[2]);
		spiele[3] = new Spiel(spieler[1], spieler[3]);
		spiele[4] = new Spiel(spieler[0], spieler[3]);
		spiele[5] = new Spiel(spieler[1], spieler[2]);
	}
	
	public Spiel getSpiel(int i) {
		
		return spiele[i];
	}
	
	public int getAnzahlSpiele() {
		
		return spiele.length;
	}
	
	public Tabelle getTabelle() {
		
		return tabelle;
	}
	
	public void setTore(int tore, int spiel, boolean heim) {
		
		if (heim) {
			
			spiele[spiel].setHeimTore(tore);
			
		} else {
			
			spiele[spiel].setAuswaertsTore(tore);
		}
		
		tabelle.errechneTabelle();
	}
}
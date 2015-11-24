package model;

import java.util.Arrays;

/***
 * Klasse fuer Tabelle.
 * @author Christian Olmscheid
 *
 */

public class Tabelle {

	private Spieler[] spieler;
	private Spiel[] spiele;
	private Reihe[] reihen;
			
	public Tabelle(Spieler[] spieler, Spiel[] spiele) {
		
		setSpieler(spieler);
		setSpiele(spiele);
		reihen = new Reihe[spieler.length];
		errechneTabelle();
	}
	
	
	public Reihe getReihe(int i) {
		
		return reihen[i];
	}
	
	/***
	 * Gibt Reiher zurueck, in welcher der angegebene Spieler zu finden ist.
	 * @param spieler
	 * @return
	 */
	public Reihe getReihe(Spieler spieler) {
		
		// Reihen fuer jeden Spieler erstellen
		for (int i = 0; i < reihen.length; i++) {
			
			if (reihen[i].getSpieler() == spieler)
				return reihen[i];
		}
		
		return null;
	}
	
	/***
	 * Berechnet die Tabelle anhand der vorhandenen Ergebnisse.
	 */
	public void errechneTabelle() {
		
		// Reihen fuer jeden Spieler erstellen
		for (int i = 0; i < spieler.length; i++) {
			
			reihen[i] = new Reihe();
			reihen[i].setSpieler(spieler[i]);
		}
		
		// Ergebnisse eintragen
		Reihe heim;
		Reihe auswaerts;
		
		for (int i = 0; i < spiele.length; i++) {
			
			if (spiele[i].getHeimTore() == -1 || spiele[i].getAuswaertsTore() == -1) 
				continue;
			
			heim = getReihe(spiele[i].getHeimTeam());
			auswaerts = getReihe(spiele[i].getAuswaertsTeam());
			
			heim.addSpiel();
			auswaerts.addSpiel();
			
			heim.addTore(spiele[i].getHeimTore());
			heim.addGegentore(spiele[i].getAuswaertsTore());
			auswaerts.addTore(spiele[i].getAuswaertsTore());
			auswaerts.addGegentore(spiele[i].getHeimTore());
			
			if (spiele[i].getHeimTore() > spiele[i].getAuswaertsTore()) {
				heim.addSiege();
				auswaerts.addNiederlage();
			} else if (spiele[i].getHeimTore() < spiele[i].getAuswaertsTore()) {
				heim.addNiederlage();
				auswaerts.addSiege();
			} else {
				heim.addRemis();
				auswaerts.addRemis();
			}
		}
		
		// Tabelle sortieren
		Arrays.sort(reihen); 
	}


	public Spieler[] getSpieler() {
		
		return spieler;
	}


	public void setSpieler(Spieler[] spieler) {
		
		this.spieler = spieler;
	}


	public Spiel[] getSpiele() {
		
		return spiele;
	}


	public void setSpiele(Spiel[] spiele) {
		
		this.spiele = spiele;
	}
	
	public String toString() {
		
		String output = "";
		
		for (Reihe reihe : reihen)  {
			
			output += "" + reihe.getSpieler().getMannschaft();
			output += " " + reihe.getTore();
		}
		
		return output;
	}
}
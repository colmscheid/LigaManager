package model;

/***
 * Entspricht einer Reihe in der Tabelle
 * @author Christian Olmscheid
 *
 */

public class Reihe implements Comparable<Object> {
	
	private Spieler spieler;
	private int spiel_anzahl;
	private int siege;
	private int remis;
	private int niederlagen;
	private int tore;
	private int gegentore;
	
	public Reihe() {
		
		
	}

	public Spieler getSpieler() {
		
		return spieler;
	}

	public void setSpieler(Spieler spieler) {
		
		this.spieler = spieler;
	}

	public int getSpiele() {
		
		return spiel_anzahl;
	}

	public void setSpiele(int spiel_anzahl) {
		
		this.spiel_anzahl = spiel_anzahl;
	}
	
	public void addSpiel() {
		
		this.spiel_anzahl++;
	}

	public int getSiege() {
		
		return siege;
	}

	public void setSiege(int siege) {
		
		this.siege = siege;
	}
	
	public void addSiege() {
		
		this.siege++;
	}

	public int getRemis() {
		
		return remis;
	}

	public void setRemis(int remis) {
		
		this.remis = remis;
	}
	
	public void addRemis() {
		
		this.remis++;
	}

	public int getNiederlagen() {
		
		return niederlagen;
	}

	public void setNiederlagen(int niederlagen) {
		
		this.niederlagen = niederlagen;
	}
	
	public void addNiederlage() {
		
		this.niederlagen++;
	}

	public int getTore() {
		
		return tore;
	}

	public void setTore(int tore) {
		
		this.tore = tore;
	}
	
	public void addTore(int tore) {
		
		this.tore += tore;
	}

	public int getGegentore() {
		
		return gegentore;
	}

	public void setGegentore(int gegentore) {
		
		this.gegentore = gegentore;
	}
	
	public void addGegentore(int gegentore) {
		
		this.gegentore += gegentore;
	}

	public int getDifferenz() {
		
		return tore - gegentore;
	}

	public int getPunkte() {
		
		return siege * 3 + remis;
	}

	public int compareTo(Object o) {

		Reihe andere = (Reihe) o;
		
		if (getPunkte() > andere.getPunkte()) {
			
			return -1;
			
		} else if (getPunkte() < andere.getPunkte()) {
			
			return 1;
		
		} else {
			
			if (getDifferenz() > andere.getDifferenz()) {
				
				return -1;
				
			} else if (getDifferenz() < andere.getDifferenz()) {
				
				return 1;
			
			} else {
				
				if (getTore() > andere.getTore()) {
					
					return -1;
					
				} else if (getTore() < andere.getTore()) {
					
					return 1;
				
				} else {
					
					return 0;
				}
			}
		}
	}
}

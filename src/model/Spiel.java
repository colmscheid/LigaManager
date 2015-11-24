package model;

/***
 * Klasse fuer ein Spiel zwischen 2 Spieler
 * @author Christian Olmscheid
 *
 */

public class Spiel {

	private Spieler heimTeam;
	private Spieler auswaertsTeam;
	private int heimTore = -1;
	private int auswaertsTore = -1;
	
	public Spiel(Spieler heimTeam, Spieler auswaertsTeam) {
		
		setHeimTeam(heimTeam);
		setAuswaertsTeam(auswaertsTeam);
	}

	public Spieler getHeimTeam() {
		
		return heimTeam;
	}

	public void setHeimTeam(Spieler heimTeam) {
		
		this.heimTeam = heimTeam;
	}

	public Spieler getAuswaertsTeam() {
		
		return auswaertsTeam;
	}

	public void setAuswaertsTeam(Spieler auswaertsTeam) {
		
		this.auswaertsTeam = auswaertsTeam;
	}

	public int getHeimTore() {
		
		return heimTore;
	}

	public void setHeimTore(int heimTore) {
		
		this.heimTore = heimTore;
	}

	public int getAuswaertsTore() {
		
		return auswaertsTore;
	}

	public void setAuswaertsTore(int auswaertsTore) {

		this.auswaertsTore = auswaertsTore;
	}
}
package model;

/***
 * Klasse fuer einen Spieler und dessen Mannschaft
 * @author Christian Olmscheid
 *
 */

public class Spieler {
	
	private String name;
	private String mannschaft;
	
	public Spieler(String name, String mannschaft) {
		
		setName(name);
		setMannschaft(mannschaft);
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getName() {
		
		return name;
	}

	public String getMannschaft() {
		
		return mannschaft;
	}

	public void setMannschaft(String mannschaft) {
		
		this.mannschaft = mannschaft;
	}

}

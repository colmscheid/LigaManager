package view;

import java.awt.Dimension;

import javax.swing.JSpinner;

import model.ToreModell;

public class ZaehlFeld extends JSpinner {
	
	private static final long serialVersionUID = 1L;
	private ToreModell sm;
	private boolean heim;
	private int spiel;

	public ZaehlFeld(boolean heim, int spiel) {
		
		super();
		sm = new ToreModell();
		this.setModel(sm);
		
		setHeim(heim);
		setSpiel(spiel);
		
		setPreferredSize(new Dimension(50, 10));
	}

	public boolean isHeim() {
		
		return heim;
	}

	public void setHeim(boolean heim) {
		
		this.heim = heim;
	}

	public int getSpiel() {
		
		return spiel;
	}

	public void setSpiel(int spiel) {
		
		this.spiel = spiel;
	}
	
	public String getTore() {
		
		return sm.getValue().toString();
	}
}
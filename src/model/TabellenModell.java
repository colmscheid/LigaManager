package model;

import javax.swing.table.AbstractTableModel;

/***
 * Modell fuer unsere Tabelle.
 * @author Christian Olmscheid
 *
 */

public class TabellenModell extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private Tabelle tabelle;

	public TabellenModell(Tabelle tabelle) {

		this.tabelle = tabelle;
	}

	public Tabelle getTabelle() {
		
		return tabelle;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		
		switch (columnIndex) {
	        case 0:  return "Platz";
	        case 1:  return "Spieler";
	        case 2:  return "Mannschaft";
	        case 3:  return "Spiele";
	        case 4:  return "Siege";
	        case 5:  return "Remis";
	        case 6:  return "Niederlagen";
	        case 7:  return "Tore";
	        case 8:  return "Gegentore";
	        case 9:  return "Differenz";
	        case 10: return "Punkte";
		}
		return null; 
	}
	
	public int getRowCount() {

		return tabelle.getSpieler().length;
	}

	public int getColumnCount() {

		return 11;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Reihe reihe = tabelle.getReihe(rowIndex);
		
		switch (columnIndex) {
        case 0:  return (Object) (rowIndex + 1);
        case 1:  return (Object) reihe.getSpieler().getName();
        case 2:  return (Object) reihe.getSpieler().getMannschaft();
        case 3:  return (Object) reihe.getSpiele();
        case 4:  return (Object) reihe.getSiege();
        case 5:  return (Object) reihe.getRemis();
        case 6:  return (Object) reihe.getNiederlagen();
        case 7:  return (Object) reihe.getTore();
        case 8:  return (Object) reihe.getGegentore();
        case 9:  return (Object) reihe.getDifferenz();
        case 10: return (Object) reihe.getPunkte();
		}
		return null; 
	}
}
package model;

import javax.swing.AbstractSpinnerModel;

/***
 * Modell fuer das Zaehlfeld, welches wir fuer die EIngabe der Tore verwenden.
 * @author Christian Olmscheid
 *
 */

public class ToreModell extends AbstractSpinnerModel {
	
	private static final long serialVersionUID = 1L;
	String value = "-";
	
	public ToreModell() {
		
		
	}

	public Object getValue() {

		return value;
	}

	public void setValue(Object value) {
	
		this.value = value.toString();
		fireStateChanged();
	}

	public Object getNextValue() {

		if (value.equals("-"))
			return "0";
		
		return Integer.toString(Integer.parseInt(value) + 1);
	}

	public Object getPreviousValue() {

		if (value.equals("0"))
			return "-";
		
		if (value.equals("-"))
			return null;
		
		return Integer.toString(Integer.parseInt(value) - 1);
	}
}

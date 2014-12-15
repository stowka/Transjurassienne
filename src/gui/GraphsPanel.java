package gui;

import javax.swing.JPanel;

import app.Year;

public class GraphsPanel extends JPanel {
	Year year;
	String raceCat;
	
	public GraphsPanel(Year _year, String raceCat) {
		year = _year;
		this.raceCat = raceCat;
	}
	
	public void updateField(Year _year, String raceCat) {
		
	}
}

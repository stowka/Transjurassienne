package gui;

import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JTable;

import app.Year;

@SuppressWarnings("serial")
public class StatsPanel extends JPanel {
	JTable table;
	HashMap<String, JPanel> rows;
	Year year;

	public StatsPanel(Year _year) {
		super();
		// TODO tout doux
		table = new JTable(7, 2);
		table.setEnabled(false);
		year = _year;
		add(table);
	}
}

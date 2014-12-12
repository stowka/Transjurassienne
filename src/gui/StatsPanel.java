package gui;

import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class StatsPanel extends JPanel {
	JTable table;
	HashMap<String, JPanel> rows;

	public StatsPanel() {
		super();
		// TODO tout doux
		table = new JTable(7, 2);
		table.setEnabled(false);
		add(table);
	}
}

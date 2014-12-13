package gui;

import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import app.Results;
import app.Skier;

@SuppressWarnings("serial")
public class ResultsPanel extends JPanel {
	JTable table;
	JScrollPane jsp;
	
	public ResultsPanel(HashMap<Skier, Results> data) {
		super();
		// TODO tout doux
		table = new JTable(new ResultsTable(data));
		add(table);
	}
}

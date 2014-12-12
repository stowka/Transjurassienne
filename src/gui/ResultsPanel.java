package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class ResultsPanel extends JPanel {
	JTable table;
	JScrollPane jsp;
	
	public ResultsPanel() {
		super();
		// TODO tout doux
		jsp = new JScrollPane();
		
		table = new JTable(100, 7);
		jsp.add(table);
		
		add(jsp);
	}
}

package gui;

import java.awt.Cursor;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import app.Results;
import app.Skier;

@SuppressWarnings("serial")
public class ResultsPanel extends JPanel {
	private JTable table;
	
	public ResultsPanel(HashMap<Skier, Results> data) {
		super();
		setLayout(new GridLayout(1, 1));
		table = new JTable(new ResultsTable(data));
		table.getColumn("#").setPreferredWidth(100);
		table.getColumn("Name").setPreferredWidth(800);
		table.getColumn("Birth year").setPreferredWidth(300);
		table.getColumn("Club").setPreferredWidth(700);
		table.getColumn("Time").setPreferredWidth(400);
		table.getColumn("Category rank").setPreferredWidth(400);
		table.getColumn("Country").setPreferredWidth(200);
		
		table.setAutoCreateRowSorter(true);
		table.setColumnSelectionAllowed(false);
		table.setFont(MainFrame.FONT);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		JTableHeader header = table.getTableHeader();
		header.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		table.setDefaultRenderer(Integer.class, centerRenderer);
		add(new JScrollPane(table));
	}
	
	public void setData(HashMap<Skier, Results> data) {
		this.table = new JTable(new ResultsTable(data));
	}
}

package gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultRowSorter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import app.Results;
import app.Skier;

@SuppressWarnings("serial")
public class ResultsPanel extends JPanel {
	private JTable table;

	public ResultsPanel(HashMap<Skier, Results> data) {
		super();
		updateField(data);
	}

	public void setData(HashMap<Skier, Results> data) {
		this.table = new JTable(new ResultsTable(data));
	}
	
	public void updateField(HashMap<Skier, Results> data) {
		this.removeAll();
		this.revalidate();
		
		setLayout(new BorderLayout());
		
		if(!data.isEmpty()) {
			table = new JTable(new ResultsTable(data));
			table.getColumn("#").setPreferredWidth(100);
			table.getColumn("Name").setPreferredWidth(800);
			table.getColumn("Birth year").setPreferredWidth(300);
			table.getColumn("Club").setPreferredWidth(700);
			table.getColumn("Time").setPreferredWidth(400);
			table.getColumn("Category").setPreferredWidth(300);
			table.getColumn("Category rank").setPreferredWidth(400);
			table.getColumn("Country").setPreferredWidth(200);

			table.setAutoCreateRowSorter(true);
			table.setColumnSelectionAllowed(false);
			table.setFont(MainFrame.FONT);

			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

			centerRenderer.setHorizontalAlignment(JLabel.CENTER);

			JTableHeader header = table.getTableHeader();
			header.setCursor(new Cursor(Cursor.HAND_CURSOR));
			header.setReorderingAllowed(false);
		
			DefaultRowSorter<?, ?> sorter = ((DefaultRowSorter<?, ?>)table.getRowSorter()); 
			ArrayList<SortKey> list = new ArrayList<SortKey>();
			list.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        	sorter.setSortKeys(list);
        	sorter.sort();

        	table.setDefaultRenderer(Integer.class, centerRenderer);
        	add(new JScrollPane(table), BorderLayout.CENTER);
		} else {
			add(new JLabel("This category didn't take place this year.", SwingConstants.CENTER), BorderLayout.CENTER);
		}
	}
}

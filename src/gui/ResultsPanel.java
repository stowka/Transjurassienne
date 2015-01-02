package gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

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
import event.ResultPanelListener;

@SuppressWarnings("serial")
public class ResultsPanel extends JPanel implements MouseListener {
	private JTable table;
	private ResultPanelListener listener;

	public ResultsPanel(HashMap<Skier, Results> data) {
		super();
		updateField(data);
	}

	public void updateField(HashMap<Skier, Results> data) {
		this.removeAll();
		this.revalidate();

		setLayout(new BorderLayout());

		if (!data.isEmpty()) {
			table = new JTable(new ResultsTable(data));
			table.addMouseListener(this);
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

			DefaultRowSorter<?, ?> sorter = ((DefaultRowSorter<?, ?>) table
					.getRowSorter());
			ArrayList<SortKey> list = new ArrayList<SortKey>();
			list.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
			sorter.setSortKeys(list);
			sorter.sort();

			table.setDefaultRenderer(Integer.class, centerRenderer);
			add(new JScrollPane(table), BorderLayout.CENTER);
		} else {
			add(new JLabel("This category didn't take place this year.",
					SwingConstants.CENTER), BorderLayout.CENTER);
		}
	}

	public void globalSearchSkiers(TreeSet<Skier> lstSkiers) {
		this.removeAll();
		this.revalidate();

		setLayout(new BorderLayout());

		table = new JTable(new SearchGlobalSkiersTable(lstSkiers));
		table.addMouseListener(this);
		table.getColumn("Name").setPreferredWidth(800);
		table.getColumn("Birth year").setPreferredWidth(300);
		table.getColumn("Club").setPreferredWidth(700);
		table.getColumn("Country").setPreferredWidth(200);

		table.setAutoCreateRowSorter(true);
		table.setColumnSelectionAllowed(false);
		table.setFont(MainFrame.FONT);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		JTableHeader header = table.getTableHeader();
		header.setCursor(new Cursor(Cursor.HAND_CURSOR));
		header.setReorderingAllowed(false);

		DefaultRowSorter<?, ?> sorter = ((DefaultRowSorter<?, ?>) table
				.getRowSorter());
		ArrayList<SortKey> list = new ArrayList<SortKey>();
		list.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(list);
		sorter.sort();

		table.setDefaultRenderer(Integer.class, centerRenderer);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void setListener(ResultPanelListener listener) {
		this.listener = listener;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Nothing

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Nothing

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Nothing

	}

	@Override
	public void mousePressed(MouseEvent e) {
		JTable table = (JTable) e.getSource();
		Point p = e.getPoint();
		int row = table.rowAtPoint(p);
		if (e.getClickCount() == 2) {
			listener.sendName((String) table.getValueAt(row,
					table.getColumn("Name").getModelIndex()));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Nothing
	}
}

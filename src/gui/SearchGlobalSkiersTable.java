package gui;

import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import app.Skier;

@SuppressWarnings("serial")
public class SearchGlobalSkiersTable extends AbstractTableModel {
	
	private final static String PATH_TO_IMG = "./assets/img/";
	private TreeSet<Skier> lstSkier;
	private Object[][] data;
	private String[] columnTitles = {"Name", "Birth year", "Club", "Country" };
	
	public SearchGlobalSkiersTable(TreeSet<Skier> lstSkier) {
		this.lstSkier = lstSkier;
		data = new Object[lstSkier.size()][4];
		int n = 0;
		for(Skier skier : this.lstSkier) {
			data[n][0] = skier.getName();
			data[n][1] = skier.getBirthYear();
			data[n][2] = skier.getClub();
			data[n][3] = new ImageIcon(PATH_TO_IMG + skier.getNationality().toLowerCase() + ".gif");
			n++;
		}
	}
	
	@Override
	public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}
	
	@Override
	public int getColumnCount() {
		return columnTitles.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	public String getColumnName(int col) {
		return columnTitles[col];
	}
}

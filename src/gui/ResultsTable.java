package gui;

import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import app.Results;
import app.Skier;
import data.DataManager;

@SuppressWarnings("serial")
public class ResultsTable extends AbstractTableModel {
	private final static String PATH_TO_IMG = "./assets/img/";
	private HashMap<Skier, Results> hm;
	private Object[][] data;
	private String[] columnTitles = { "#", "Name", "Birth year", "Club", "Time",
			"Category rank", "Country" };

	public ResultsTable(HashMap<Skier, Results> _data) {
		hm = _data;
		data = new Object[hm.size()][7];
		Results r;
		int n = 0;
		for (Skier s : hm.keySet()) {
			r = hm.get(s);
			data[n][0] = r.getRank();
			data[n][1] = s.getName();
			data[n][2] = s.getBirthYear();
			data[n][3] = s.getClub();
			data[n][4] = DataManager.formatTime(r.getTime());
			data[n][5] = r.getCategoryRank();
			data[n][6] = new ImageIcon(PATH_TO_IMG + s.getNationality().toLowerCase() + ".gif");
			n += 1;
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

package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import data.DataManager;

@SuppressWarnings("serial")
public class NorthPanel extends JPanel implements ActionListener {
	private JLabel yearLabel;
	private JLabel raceCatLabel;
	private JLabel searchFieldLabel;
	private JComboBox raceCat;
	private JComboBox year;
	private JTextField search;
	private JButton searchBtn;
	private DataListener listener;

	public NorthPanel() {
		super();

		yearLabel = new JLabel("Year : ");
		raceCatLabel = new JLabel("Category : ");
		searchFieldLabel = new JLabel("Search : ");
		search = new JTextField(15);
		searchBtn = new JButton("Ok");

		// Set up the pannel
		setLayout(new FlowLayout(FlowLayout.CENTER));
		Border outter = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createCompoundBorder(outter, inner));

		// Set up the yearLabel
		yearLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		add(yearLabel, this);

		// Set up the year ComboBox
		String[] yearsString = new String[DataManager.getInstance().getYears()
				.size()];
		int it = 0;
		for (String y : DataManager.getInstance().getYears().keySet()) {
			yearsString[it] = y;
			it += 1;
		}
		Arrays.sort(yearsString);
		year = new JComboBox(yearsString);
		year.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
		year.addActionListener(this);
		add(year, this);

		// Set up the raceCatLabel
		raceCatLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		add(raceCatLabel, this);

		// Set up the raceCat ComboBox
		String[] raceCategoryString = { "25CTF", "25CTM", "25FTF", "25FTM",
				"50CTF", "50CTM", "76FTF", "76FTM" };
		raceCat = new JComboBox(raceCategoryString);
		raceCat.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
		raceCat.addActionListener(this);
		add(raceCat, this);

		// Set up the searchFieldLabel
		searchFieldLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		add(searchFieldLabel, this);

		// Set up the search TextField
		search.setBorder(BorderFactory.createEtchedBorder());
		add(search, this);
		
		// Set up the search button
		//searchBtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		searchBtn.addActionListener(this);
		add(searchBtn, this);
	}
	
	public void setDataListener(DataListener listener) {
		this.listener = listener;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(listener != null) {
			String yearData = (String) year.getSelectedItem();
			String raceCatData = (String) raceCat.getSelectedItem();
			String searchData = search.getText();
			
			DataEvent dataEvent = new DataEvent(yearData, raceCatData, searchData);
			
			listener.dataEmitted(dataEvent);
		}
	}
}

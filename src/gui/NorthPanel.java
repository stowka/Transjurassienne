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
import event.DataEvent;
import event.DataListener;
import event.Key;

@SuppressWarnings("serial")
public class NorthPanel extends JPanel implements ActionListener {
	private JLabel yearLabel;
	private JLabel raceCatLabel;
	private JLabel searchFieldLabel;
	private JComboBox raceCat;
	private JComboBox year;
	private JTextField searchField;
	private JButton searchBtn;
	private DataListener listener;
	
	private String[] yearsString;
	private String[] raceCategoryString = {"25CTF", "25CTM", "25FTF", "25FTM",
			"50CTF", "50CTM", "76FTF", "76FTM"};

	public NorthPanel() {
		super();

		yearLabel = new JLabel("Year : ");
		yearLabel.setFont(MainFrame.FONT);
		
		raceCatLabel = new JLabel("Category : ");
		raceCatLabel.setFont(MainFrame.FONT);
		
		searchFieldLabel = new JLabel("Search : ");
		searchFieldLabel.setFont(MainFrame.FONT);
		searchField = new JTextField(15);
		searchField.addKeyListener(Key.getInstance());
		searchField.setFont(MainFrame.FONT);
		
		searchBtn = new JButton("OK");
		searchBtn.setFont(MainFrame.FONT);

		// Set up the pannel
		setLayout(new FlowLayout(FlowLayout.CENTER));
		Border outter = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createCompoundBorder(outter, inner));

		// Set up the yearLabel
		yearLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		add(yearLabel, this);

		// Set up the year ComboBox
		yearsString = new String[DataManager.getInstance().getYears()
				.size()];
		int it = 0;
		for (String y : DataManager.getInstance().getYears().keySet()) {
			yearsString[it] = y;
			it += 1;
		}
		Arrays.sort(yearsString);
		year = new JComboBox(yearsString);
		year.setName("year");
		year.setFont(MainFrame.FONT);
		year.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
		year.addActionListener(this);
		add(year, this);

		// Set up the raceCatLabel
		raceCatLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		add(raceCatLabel, this);

		// Set up the raceCat ComboBox
		raceCat = new JComboBox(raceCategoryString);
		raceCat.setName("race");
		raceCat.setFont(MainFrame.FONT);
		raceCat.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
		raceCat.addActionListener(this);
		add(raceCat, this);

		// Set up the searchFieldLabel
		searchFieldLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		add(searchFieldLabel, this);

		// Set up the search TextField
		searchField.setBorder(BorderFactory.createEtchedBorder());
		add(searchField, this);
		
		// Set up the search button
		//searchBtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		searchBtn.addActionListener(this);
		add(searchBtn, this);
	}

	public void setDataListener(DataListener listener) {
		this.listener = listener;
	}

	public void actionPerformed(ActionEvent e) {
		if (listener != null) {
			String yearData = (String) year.getSelectedItem();
			String raceCatData = (String) raceCat.getSelectedItem();
			String searchData = searchField.getText();

			DataEvent dataEvent = new DataEvent(yearData, raceCatData,
					searchData);

			listener.dataEmitted(dataEvent);
			
		}
	}
	
	public String getSelectedYear() {
		return yearsString[year.getSelectedIndex()];
	}
	
	public String getSelectedRace() {
		return raceCategoryString[raceCat.getSelectedIndex()];
	}
}

package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import app.Year;
import data.DataManager;

@SuppressWarnings("serial")
public class StatsPanel extends JPanel {
	DataManager dm;
	JTable table;
	Year year;
	String raceCat;
	JLabel nbParticipantsLabel;
	JLabel averageTimeLabel;
	JLabel nbOfCountryLabel;
	JLabel timeGapLabel;
	JTextField nbParticipants;
	JTextField averageTime;
	JTextField nbOfCountry;
	JTextField timeGap;

	public StatsPanel(Year _year, String raceCat) {
		dm = DataManager.getInstance();
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		//First row
		gc.gridy = 0;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.fill = GridBagConstraints.NONE;
		nbParticipantsLabel = new JLabel("Number of Participant: ");
		add(nbParticipantsLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		nbParticipants = new JTextField(10);
		nbParticipants.setEditable(false);
		nbParticipants.setBackground(Color.WHITE);
		nbParticipants.setText("" + dm.numberOfParticipants(""+_year.getYear(), raceCat));
		add(nbParticipants, gc);
		
		//Next row
		gc.gridy = 1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		averageTimeLabel = new JLabel("Average time: ");
		add(averageTimeLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		averageTime = new JTextField(10);
		averageTime.setEditable(false);
		averageTime.setBackground(Color.WHITE);
		averageTime.setText(dm.averageTime(""+_year.getYear(), raceCat));
		add(averageTime, gc);
		
		//Next row
		gc.gridy = 2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		nbOfCountryLabel = new JLabel("Number of country: ");
		add(nbOfCountryLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		nbOfCountry = new JTextField(10);
		nbOfCountry.setEditable(false);
		nbOfCountry.setBackground(Color.WHITE);
		nbOfCountry.setText("" + dm.nbCountry(""+_year.getYear(), raceCat));
		add(nbOfCountry, gc);
		
		//Next row
		gc.gridy = 3;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		timeGapLabel = new JLabel("Time gap: ");
		add(timeGapLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		timeGap = new JTextField(10);
		timeGap.setEditable(false);
		timeGap.setBackground(Color.WHITE);
		timeGap.setText(dm.gapTime(""+_year.getYear(), raceCat));
		add(timeGap, gc);
	}
}

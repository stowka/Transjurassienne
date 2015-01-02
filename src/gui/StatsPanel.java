package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
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
	JLabel minTimeLabel;
	JLabel maxTimeLabel;
	JLabel timeGapLabel;
	JTextField nbParticipants;
	JTextField averageTime;
	JTextField nbOfCountry;
	JTextField minTime;
	JTextField maxTime;
	JTextField timeGap;
	JPanel flagsPanel;
	Insets insets;

	public StatsPanel(Year _year, String raceCat) {
		dm = DataManager.getInstance();
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		insets = new Insets(10, 0, 0, 0);
		gc.insets = insets;
		
		//First row //////////////////////////////////////////////////////////
		gc.gridy = 0;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.fill = GridBagConstraints.NONE;
		nbParticipantsLabel = new JLabel("Number of Participant: ");
		nbParticipantsLabel.setFont(MainFrame.FONT);
		add(nbParticipantsLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		nbParticipants = new JTextField(10);
		nbParticipants.setFont(MainFrame.FONT);
		nbParticipants.setEditable(false);
		nbParticipants.setBackground(Color.WHITE);
		add(nbParticipants, gc);
		
		insets.set(10, 50, 0, 0);
		
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		minTimeLabel = new JLabel("Minimum time: ");
		minTimeLabel.setFont(MainFrame.FONT);
		add(minTimeLabel, gc);
		
		insets.set(10, 0, 0, 0);
		
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		minTime = new JTextField(10);
		minTime.setFont(MainFrame.FONT);
		minTime.setEditable(false);
		minTime.setBackground(Color.WHITE);
		add(minTime, gc);
		
		//Next row //////////////////////////////////////////////////////////
		gc.gridy = 1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		averageTimeLabel = new JLabel("Average time: ");
		averageTimeLabel.setFont(MainFrame.FONT);
		add(averageTimeLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		averageTime = new JTextField(10);
		averageTime.setFont(MainFrame.FONT);
		averageTime.setEditable(false);
		averageTime.setBackground(Color.WHITE);
		add(averageTime, gc);
		
		insets.set(10, 50, 0, 0);
		
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		maxTimeLabel = new JLabel("Maximum time: ");
		maxTimeLabel.setFont(MainFrame.FONT);
		add(maxTimeLabel, gc);
		
		insets.set(10, 0, 0, 0);
		
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		maxTime = new JTextField(10);
		maxTime.setFont(MainFrame.FONT);
		maxTime.setEditable(false);
		maxTime.setBackground(Color.WHITE);
		add(maxTime, gc);
		
		//Next row //////////////////////////////////////////////////////////
		gc.gridy = 2;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		nbOfCountryLabel = new JLabel("Number of country: ");
		nbOfCountryLabel.setFont(MainFrame.FONT);
		add(nbOfCountryLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		nbOfCountry = new JTextField(10);
		nbOfCountry.setFont(MainFrame.FONT);
		nbOfCountry.setEditable(false);
		nbOfCountry.setBackground(Color.WHITE);
		add(nbOfCountry, gc);
		
		insets.set(10, 50, 0, 0);
		
		gc.gridx = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		timeGapLabel = new JLabel("Time gap: ");
		timeGapLabel.setFont(MainFrame.FONT);
		add(timeGapLabel, gc);
		
		insets.set(10, 0, 0, 0);
		
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		timeGap = new JTextField(10);
		timeGap.setFont(MainFrame.FONT);
		timeGap.setEditable(false);
		timeGap.setBackground(Color.WHITE);
		add(timeGap, gc);
		
		//Next Row 
		gc.gridy = 3;
		
		gc.gridx = 0;
		gc.gridwidth = 4;
		gc.gridheight = 2;
		gc.fill = GridBagConstraints.BOTH;
		flagsPanel = new JPanel();
		flagsPanel.setLayout(new FlowLayout());
		add(flagsPanel, gc);
		
		updateField(_year, raceCat);
		
	}
	
	public void updateField(Year _year, String raceCat) {
		nbParticipants.setText("" + dm.numberOfParticipants(""+_year.getYear(), raceCat));
		minTime.setText(DataManager.formatTime(dm.minTime(""+_year.getYear(), raceCat)));
		maxTime.setText(DataManager.formatTime(dm.maxTime(""+_year.getYear(), raceCat)));
		averageTime.setText(dm.averageTime(""+_year.getYear(), raceCat));
		nbOfCountry.setText("" + dm.nbCountry(""+_year.getYear(), raceCat));
		timeGap.setText(DataManager.formatTime(dm.gapTime(""+_year.getYear(), raceCat)));
		flagsPanel.removeAll();
		for(String str : dm.nationality(""+_year.getYear(), raceCat)) {
			flagsPanel.add(new JLabel(new ImageIcon("assets/img/" + str + ".gif")));
		}
	}
}

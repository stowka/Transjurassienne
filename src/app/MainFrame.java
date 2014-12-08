package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private JPanel mainPanel;
	private JPanel northPanel;
	private JPanel tab1;
	private JPanel tab2;
	private JPanel tab3;
	private JLabel yearLabel;
	private JLabel raceCategoryLabel;
	private JLabel nbParticipantsLabel;
	private JLabel averageTimeLabel;
	private JTextField nbParticipants;
	private JTextField averageTime;
	private JComboBox year;
	private JComboBox raceCategory;;
	private JTabbedPane tabs;
	
	public MainFrame() {
		setLocationRelativeTo(null);
		setTitle("Transjurassienne");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setSize(new Dimension(getWidth(), getHeight()));
		setSize(new Dimension(640, 480));
		
		//Set the main panel with a border layout
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		
		//NorthPannel with gridLayout
		northPanel = new JPanel();
		mainPanel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		//Year label
		yearLabel = new JLabel("Year : ");
		northPanel.add(yearLabel);
		
		//Year ComboBox
		String[] yearsString = {"2011", "2012", "2013", "2014"}; //This is temporary 
		year = new JComboBox(yearsString);
		northPanel.add(year);
		
		//Race Category Label
		raceCategoryLabel = new JLabel("Race category : ");
		raceCategoryLabel.setLocation(new Point(raceCategoryLabel.getX() + 100, raceCategoryLabel.getY()));
		northPanel.add(raceCategoryLabel);
		
		//Race Category ComboBox
		String[] raceCategoryString = {"25CTF", "25CTM", "25FTF", "25FTM", "50CTF", "50CTM", "76FTF", "76FTM"};
		raceCategory = new JComboBox(raceCategoryString);
		northPanel.add(raceCategory);
		
		//Set up tabbed pane
		tabs = new JTabbedPane();
		
		//Tab 1
		tab1 = new JPanel();
		tabs.addTab("Result", tab1);
		
		//Tab 2
		tab2 = new JPanel();
		tabs.addTab("Stats", tab2);
		
		//Tab 3
		tab3 = new JPanel();
		tabs.addTab("Graphics", tab3);
		
		mainPanel.add(tabs, BorderLayout.CENTER);
		
		//Tab 1 : label nb participants
		nbParticipantsLabel = new JLabel("Number of Participants : ");
		tab1.add(nbParticipantsLabel);
		
		//Tab 1 : text field nb participants
		nbParticipants = new JTextField();
		nbParticipants.setText("" + 25);
		nbParticipants.setEditable(false);
		tab1.add(nbParticipants);
		
		//Tab 1 : average time label
		averageTimeLabel = new JLabel("Average time : ");
		tab1.add(averageTimeLabel);
		
		//Tab 1 : average time textField
		averageTime = new JTextField();
		averageTime.setText("" + 25);
		averageTime.setEditable(false);
		tab1.add(averageTime);
		
		setVisible(true);
		
	}
}

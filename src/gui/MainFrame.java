package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import app.Race;
import app.Year;
import data.DataManager;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener, KeyListener {
	private JPanel mainPanel;
	private JPanel northPanel;
	private JPanel resultsPanel;
	private JPanel statsPanel;
	private JPanel graphsPanel;

	private JLabel yearLabel;
	private JLabel raceCategoryLabel;
	private JLabel nbParticipantsLabel;
	private JLabel averageTimeLabel;
	private JLabel nbParticipants;

	private JLabel averageTime;
	private JTextField searchField;

	private JButton searchButton;

	private JComboBox year;
	private JComboBox raceCategory;
	
	private Year currentYear;

	private JTabbedPane tabs;

	private final static Font FONT = new Font("Lato", Font.PLAIN, 12);

	public MainFrame() {
		setTitle("Trans-Jurassienne Ñ BŽligat und De Gieter, das gelbe vom ei!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		;
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		// setSize(new Dimension(getWidth(), getHeight()));
		setSize(new Dimension(800, 600));
		setLocationRelativeTo(null);

		// Set the main panel with a border layout
		mainPanel = new JPanel();
		setContentPane(mainPanel);
		mainPanel.setLayout(new BorderLayout());

		// NorthPannel with gridLayout
		northPanel = new JPanel();
		mainPanel.add(northPanel, BorderLayout.NORTH);

		// Year label
		yearLabel = new JLabel("Year : ");
		yearLabel.setFont(FONT);
		northPanel.add(yearLabel);

		// Year ComboBox
		String[] yearsString = new String[DataManager.getInstance().getYears()
				.size()];
		int it = 0;
		for (String y : DataManager.getInstance().getYears().keySet()) {
			yearsString[it] = y;
			it += 1;
		}
		Arrays.sort(yearsString);
		currentYear = DataManager.getInstance().getYears().get(yearsString[0]);
		year = new JComboBox(yearsString);
		year.setFont(FONT);
		year.addActionListener(this);
		northPanel.add(year);

		// Race Category Label
		raceCategoryLabel = new JLabel("Race category : ");
		raceCategoryLabel.setFont(FONT);
		raceCategoryLabel.setLocation(new Point(raceCategoryLabel.getX() + 100,
				raceCategoryLabel.getY()));
		northPanel.add(raceCategoryLabel);

		// Race Category ComboBox
		String[] raceCategoryString = { "25CTF", "25CTM", "25FTF", "25FTM",
				"50CTF", "50CTM", "76FTF", "76FTM" };
		raceCategory = new JComboBox(raceCategoryString);
		raceCategory.setFont(FONT);
		raceCategory.addActionListener(this);
		northPanel.add(raceCategory);

		// Search component
		searchField = new JTextField();
		searchField.setForeground(Color.GRAY);
		searchField.setFont(new Font("Andale Mono", Font.ITALIC, 12));
		searchField.setColumns(18);
		searchField.addKeyListener(this);
		northPanel.add(searchField);

		searchButton = new JButton("Search");
		searchButton.setFont(FONT);
		searchButton.addActionListener(this);
		northPanel.add(searchButton);

		// Set up tabbed pane
		tabs = new JTabbedPane();
		tabs.setFont(FONT);

		// Tab results
		resultsPanel = new ResultsPanel(currentYear.getRaces().get(raceCategoryString[0]).getParticipants());
		tabs.addTab("Results", resultsPanel);

		// Tab stats
		statsPanel = new StatsPanel();
		tabs.addTab("Stats", statsPanel);

		// Tab graphs
		graphsPanel = new GraphsPanel();
		tabs.addTab("Graphics", graphsPanel);

		mainPanel.add(tabs, BorderLayout.CENTER);

		setVisible(true);
	}

	@SuppressWarnings("unused")
	private void fillResult(String year, String category) {
		Race race = DataManager.getInstance().getYears().get(year).getRaces()
				.get(category);
		// TODO
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO

		/*
		 * JComboBox: action performed on year/category change:
		 */
		if (event.getSource() == raceCategory) {
			System.out.println("Changed category: "
					+ raceCategory.getSelectedItem());
		}

		if (event.getSource() == year) {
			System.out.println("Changed year: " + year.getSelectedItem());
		}

		/*
		 * JButton: action performed on search button click:
		 */
		if (event.getSource() == searchButton) {
			search(searchField.getText().replace(' ', '+'));
		}
	}

	private void search(String pattern) {
		System.out.println("Search pattern: " + pattern);
		// TODO
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getSource() == searchField
				&& event.getKeyCode() == KeyEvent.VK_ENTER) {
			search(searchField.getText().replace(' ', '+'));
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
	}

	@Override
	public void keyTyped(KeyEvent event) {
	}
}

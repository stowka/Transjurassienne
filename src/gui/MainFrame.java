package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import app.Race;
import app.Year;
import data.DataManager;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements KeyListener {
	private NorthPanel northPanel;
	private JPanel resultsPanel;
	private JPanel statsPanel;
	private JPanel graphsPanel;

	private Menu menu;

	private JTextField searchField;

	private JTabbedPane tabs;

	private Year currentYear;

	final static Font FONT = new Font("Lato", Font.PLAIN, 12);

	public MainFrame() {
		super("Trans-Jurassienne | BŽligat et De Gieter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800, 600));
		setLocationRelativeTo(null);

		// Set menu
		menu = new Menu();
		setJMenuBar(menu);

		// Set the main panel with a border layout
		setLayout(new BorderLayout());

		// Add northPannel to the main panel
		northPanel = new NorthPanel();
		currentYear = DataManager.getInstance().getYears()
				.get(northPanel.getSelectedYear());
		northPanel.setDataListener(new DataListener() {
			public void dataEmitted(DataEvent e) {
				System.out.println("Year : " + e.getYear()
						+ "\nRace Category : " + e.getRaceCat()
						+ "\nSearch Pattern : " + e.getSearch());
			}
		});
		add(northPanel, BorderLayout.NORTH);

		// Set up tabbed pane
		tabs = new JTabbedPane();
		tabs.setFont(FONT);

		// Tab results
		resultsPanel = new ResultsPanel(currentYear.getRaces()
				.get(northPanel.getSelectedRace()).getParticipants());
		tabs.addTab("Results", resultsPanel);

		// Tab stats
		statsPanel = new StatsPanel();
		tabs.addTab("Stats", statsPanel);

		// Tab graphs
		graphsPanel = new GraphsPanel();
		tabs.addTab("Graphics", graphsPanel);

		add(tabs, BorderLayout.CENTER);

		setVisible(true);
	}

	@SuppressWarnings("unused")
	private void fillResult(String year, String category) {
		Race race = DataManager.getInstance().getYears().get(year).getRaces()
				.get(category);
		// TODO
	}

	/*
	 * @Override public void actionPerformed(ActionEvent event) { // TODO
	 * 
	 * 
	 * if (event.getSource() == raceCategory) {
	 * System.out.println("Changed category: " +
	 * raceCategory.getSelectedItem()); }
	 * 
	 * if (event.getSource() == year) { System.out.println("Changed year: " +
	 * year.getSelectedItem()); }
	 * 
	 * if (event.getSource() == searchButton) {
	 * search(searchField.getText().replace(' ', '+')); } }
	 */

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

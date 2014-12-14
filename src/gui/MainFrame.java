package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import app.Year;
import data.DataManager;
import event.DataEvent;
import event.DataListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private NorthPanel northPanel;
	private JPanel resultsPanel;
	private JPanel statsPanel;
	private JPanel graphsPanel;

	private Menu menu;
	private JTabbedPane tabs;

	private Year currentYear;
	private String raceCat;

	final static Font FONT = new Font("Lato", Font.PLAIN, 12);

	public MainFrame() {
		super("Trans-Jurassienne | B�ligat et De Gieter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800, 600));
		setLocationRelativeTo(null);

		// Set menu
		menu = new Menu();
		setJMenuBar(menu);

		// Set up tabbed pane
		tabs = new JTabbedPane();
		tabs.setFont(FONT);
		
		// Set the main panel with a border layout
		setLayout(new BorderLayout());

		// Add northPannel to the main panel
		northPanel = new NorthPanel();
		currentYear = DataManager.getInstance().getYears()
				.get(northPanel.getSelectedYear());
		raceCat = northPanel.getSelectedRace();
		northPanel.setDataListener(new DataListener() {
			public void dataEmitted(DataEvent e) {
				currentYear = DataManager.getInstance().getYears().get(e.getYear());
				resultsPanel = new ResultsPanel(currentYear.getRaces().get(e.getRaceCat()).getParticipants());
				statsPanel = new StatsPanel(currentYear, e.getRaceCat());
				graphsPanel = new GraphsPanel(currentYear);
				
				tabs.removeTabAt(0);
				tabs.removeTabAt(0);
				tabs.removeTabAt(0);
				
				tabs.addTab("Results", resultsPanel);
				tabs.addTab("Stats", statsPanel);
				tabs.addTab("Graphs", graphsPanel);
			}
		});
		add(northPanel, BorderLayout.NORTH);

		// Tab results
		resultsPanel = new ResultsPanel(currentYear.getRaces()
				.get(northPanel.getSelectedRace()).getParticipants());
		tabs.addTab("Results", resultsPanel);

		// Tab stats
		statsPanel = new StatsPanel(currentYear, raceCat);
		tabs.addTab("Stats", statsPanel);

		// Tab graphs
		graphsPanel = new GraphsPanel(currentYear);
		tabs.addTab("Graphics", graphsPanel);

		add(tabs, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void search(String pattern) {
		System.out.println("Search pattern: " + pattern);
	}
}

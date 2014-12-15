package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import app.Year;
import data.DataManager;
import event.DataEvent;
import event.DataListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private NorthPanel northPanel;
	private ResultsPanel resultsPanel;
	private StatsPanel statsPanel;
	private GraphsPanel graphsPanel;

	private Menu menu;
	private JTabbedPane tabs;

	private Year currentYear;
	private String raceCat;

	final static Font FONT = new Font("Lato", Font.PLAIN, 12);

	public MainFrame() {
		super("Trans-Jurassienne | Beligat et De Gieter");
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

		// Tab results
		resultsPanel = new ResultsPanel(currentYear.getRaces()
				.get(northPanel.getSelectedRace()).getParticipants());
		tabs.addTab("Results", resultsPanel);

		// Tab stats
		statsPanel = new StatsPanel(currentYear, raceCat);
		tabs.addTab("Stats", statsPanel);

		// Tab graphs
		graphsPanel = new GraphsPanel(currentYear, raceCat);
		tabs.addTab("Graphics", graphsPanel);
		
		// Listening event from northPanel
		northPanel.setDataListener(new DataListener() {
			public void dataEmitted(DataEvent e) {
				currentYear = DataManager.getInstance().getYears().get(e.getYear());
				raceCat = e.getRaceCat();
				
				resultsPanel.updateField(currentYear.getRaces().get(raceCat).getParticipants());
				statsPanel.updateField(currentYear, raceCat);
				graphsPanel.updateField(currentYear, raceCat);
			}
		});
		
		add(northPanel, BorderLayout.NORTH);
		add(tabs, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void search(String pattern) {
		System.out.println("Search pattern: " + pattern);
	}
}

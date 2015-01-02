package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import app.Results;
import app.Skier;
import app.Year;
import data.DataManager;
import event.DataEvent;
import event.DataListener;
import event.ResultPanelListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private NorthPanel northPanel;
	private ResultsPanel resultsPanel;
	private StatsPanel statsPanel;

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
		resultsPanel.setListener(new ResultPanelListener() {
			
			@Override
			public void sendName(String name) {
				new SkierInformations(MainFrame.this, name);
			}
		});
		tabs.addTab("Results", resultsPanel);

		// Tab stats
		statsPanel = new StatsPanel(currentYear, raceCat);
		tabs.addTab("Stats", statsPanel);
		
		// Listening event from northPanel
		northPanel.setDataListener(new DataListener() {
			public void dataEmitted(DataEvent e) {
				currentYear = DataManager.getInstance().getYears().get(e.getYear());
				raceCat = e.getRaceCat();
				
				resultsPanel.updateField(currentYear.getRaces().get(raceCat).getParticipants());
				statsPanel.updateField(currentYear, raceCat);
			}
			
			public void searchResult(String pattern) {
		
				TreeSet<Skier> lstSkiers = DataManager.getInstance().getSkiers();
				TreeSet<Skier> newLstSkiers = new TreeSet<Skier>();
				for(Skier skier : lstSkiers) {
					if(Pattern.matches("[\\s\\w]*"+pattern+"[\\s\\w]*", skier.getName())) {
						newLstSkiers.add(skier);
					}
				}
				if(!newLstSkiers.isEmpty()) 
					resultsPanel.globalSearchSkiers(newLstSkiers);
				else
					JOptionPane.showMessageDialog(MainFrame.this, "No results found.");
			}
			
			public void searchResult(DataEvent e) {
				currentYear = DataManager.getInstance().getYears().get(e.getYear());
				raceCat = e.getRaceCat();
				
				HashMap<Skier, Results> newLstSkier = new HashMap<Skier, Results>();
				HashMap<Skier, Results> lstSkier = currentYear.getRaces().get(raceCat).getParticipants();
				for(Skier skier : lstSkier.keySet()) {
					if(Pattern.matches("[\\s\\w]*" + e.getPattern() + "[\\s\\w]*", skier.getName())) {
						newLstSkier.put(skier, lstSkier.get(skier));
					}
				}
				if(!newLstSkier.isEmpty())
					resultsPanel.updateField(newLstSkier);
				else
					JOptionPane.showMessageDialog(MainFrame.this, "No results found.");
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

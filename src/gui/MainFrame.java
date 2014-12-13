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
public class MainFrame extends JFrame implements KeyListener {
	private NorthPanel northPanel;
	private JPanel resultsPanel;
	private JPanel statsPanel;
	private JPanel graphsPanel;

	private JTextField searchField;

	private JButton searchButton;

	private JTabbedPane tabs;

	private final static Font FONT = new Font("Lato", Font.PLAIN, 12);

	public MainFrame() {
		super("Trans-Jurassienne | Béligat et De Gieter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(800, 600));
		setLocationRelativeTo(null);

		// Set the main panel with a border layout
		setLayout(new BorderLayout());

		// Add northPannel to the main panel
		northPanel = new NorthPanel();
		add(northPanel, BorderLayout.NORTH);

		// Set up tabbed pane
		tabs = new JTabbedPane();
		tabs.setFont(FONT);

		// Tab results
		//resultsPanel = new ResultsPanel(currentYear.getRaces().get(raceCategoryString[0]).getParticipants());
		tabs.addTab("Results", new JScrollPane(resultsPanel));

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

	/*@Override
	public void actionPerformed(ActionEvent event) {
		// TODO


		if (event.getSource() == raceCategory) {
			System.out.println("Changed category: "
					+ raceCategory.getSelectedItem());
		}

		if (event.getSource() == year) {
			System.out.println("Changed year: " + year.getSelectedItem());
		}

		if (event.getSource() == searchButton) {
			search(searchField.getText().replace(' ', '+'));
		}
	}*/

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

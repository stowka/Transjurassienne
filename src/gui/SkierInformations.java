package gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import app.Race;
import app.Results;
import app.Skier;
import app.Year;
import data.DataManager;

@SuppressWarnings("serial")
public class SkierInformations extends JDialog implements ActionListener {
	String name;
	JLabel nameLabel;
	JButton okButton;
	JPanel centerPanel;

	public SkierInformations(Frame owner, String name) {
		super(owner, "Informations", true);
		setSize(500, 500);

		setLayout(new BorderLayout());

		this.name = name;

		// North Panel
		nameLabel = new JLabel(name, SwingConstants.CENTER);
		add(nameLabel, BorderLayout.NORTH);

		// Center Panel
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		centerPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(5, 5, 5, 5),
				BorderFactory.createBevelBorder(1)));
		HashMap<String, String> infosSkier = informationsAboutSkier();
		
		//First Row
		gc.gridy = 0;
		gc.gridx = 0;
		centerPanel.add(new JLabel("BirthYear"), gc);
		gc.gridx = 1;
		centerPanel.add(new JLabel(infosSkier.get("birthYear")), gc);
		
		//Second row
		gc.gridy = 1;
		gc.gridx = 0;
		centerPanel.add(new JLabel("Club"), gc);
		gc.gridx = 1;
		centerPanel.add(new JLabel(infosSkier.get("club")), gc);
		
		//Third row
		gc.gridy = 2;
		gc.gridx = 0;
		centerPanel.add(new JLabel("Category"), gc);
		gc.gridx = 1;
		centerPanel.add(new JLabel(infosSkier.get("category")), gc);
		
		//Fourth row
		gc.gridy = 3;
		gc.gridx = 0;
		centerPanel.add(new JLabel("Nationality"), gc);
		gc.gridx = 1;
		
		centerPanel.add(new JLabel(infosSkier.get("nationality")), gc);

		/*
		 * centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		 * HashMap<Year, HashMap<Race, Results>> infos =
		 * informationsAboutRaces(); for(Year y : infos.keySet()) {
		 * centerPanel.add(new JLabel(""+y.getYear(), SwingConstants.CENTER));
		 * HashMap<Race, Results> detail = infos.get(y); for(Race r :
		 * detail.keySet()) { centerPanel.add(new JLabel(""+r.toString(),
		 * SwingConstants.CENTER)); Results results = detail.get(r); JPanel
		 * tmpPanel = new JPanel(); tmpPanel.setLayout(new FlowLayout());
		 * tmpPanel.add(new JLabel(""+results.getRank())); tmpPanel.add(new
		 * JLabel(""+results.getTime())); tmpPanel.add(new
		 * JLabel(""+results.getCategoryRank())); centerPanel.add(tmpPanel); } }
		 */
		add(centerPanel, BorderLayout.CENTER);

		// South Panel
		okButton = new JButton("Ok");
		okButton.addActionListener(this);
		add(okButton, BorderLayout.SOUTH);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		dispose();
	}

	private HashMap<Year, HashMap<Race, Results>> informationsAboutRaces() {
		DataManager dm = DataManager.getInstance();
		HashMap<Year, HashMap<Race, Results>> infos = new HashMap<Year, HashMap<Race, Results>>();
		for (Year y : dm.getYears().values()) {
			HashMap<Race, Results> tmp = new HashMap<Race, Results>();
			for (Race r : y.getRaces().values()) {
				for (Skier s : r.getParticipants().keySet()) {
					if (s.getName().equals(name)) {
						tmp.put(r, r.getResults(s));
					}
				}
			}
			if (!tmp.isEmpty())
				infos.put(y, tmp);
		}
		return infos;
	}

	private HashMap<String, String> informationsAboutSkier() {
		HashMap<String, String> infos = new HashMap<String, String>();

		for (Skier s : DataManager.getInstance().getSkiers()) {
			if (s.getName().equals(name)) {
				infos.put("birthYear", ""+ s.getBirthYear());
				infos.put("club", s.getClub());
				infos.put("category", s.getCategory());
				infos.put("nationality", s.getNationality());
			}
		}

		return infos;
	}
}

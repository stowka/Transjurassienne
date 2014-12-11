package data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import app.Results;
import app.Skier;
import app.SkierFemale;
import app.SkierMale;
import app.Year;

public class DataManager {
	private TreeSet<Skier> skiers;
	private HashMap<String, Year> years;

	private final static String PATH_TO_FILES = ".";
	private final static String REGEX_MATCHING_FILES = "201[12].csv";
	
	private static DataManager _instance = null;
	
	public static DataManager getInstance() {
		if (null == _instance)
			_instance = new DataManager();
		return _instance;
	}
	
	private DataManager() {
		File directory = new File(PATH_TO_FILES);
		ArrayList<HashMap<String, String>> data;

		Skier tmpSkier;
		Year tmpYear;
		Results tmpResults;

		years = new HashMap<String, Year>();
		skiers = new TreeSet<Skier>();
		File[] directoryListing = directory.listFiles();

		String name = "";
		int birthYear = 0;
		String club = "";
		String nationality = "";
		String category = "";
		int rank = 0;
		int categoryRank = 0;
		String time = "";

		for (File child : directoryListing) { // browse files
			if (child.getName().matches(REGEX_MATCHING_FILES)) {
				tmpYear = new Year(Integer.parseInt(child.getName().substring(
						0, 4)));
				years.put(child.getName().substring(0, 4), tmpYear);
				data = CSVParser.parse(child);

				for (HashMap<String, String> entry : data) { // browse entries

					name = entry.get("Nom");
					birthYear = Integer.parseInt(entry.get("Naissance"));
					club = entry.get("Club");
					nationality = entry.get("Nation");
					category = entry.get("Nom_Categorie");
					rank = Integer.parseInt(entry.get("Classement"));
					categoryRank = Integer
							.parseInt(entry.get("Classement_cat"));
					time = entry.get("Arrivee");

					if ('F' == entry.get("Course").charAt(
							entry.get("Course").length() - 1))
						tmpSkier = new SkierFemale(name, birthYear, club,
								nationality, category);
					else
						tmpSkier = new SkierMale(name, birthYear, club,
								nationality, category);

					tmpResults = new Results(rank, categoryRank, time);

					tmpYear.getRaces().get(entry.get("Course"))
							.addParticipant(tmpSkier, tmpResults);

					skiers.add(tmpSkier);
				}	
			}
		}
	}

	public HashMap<String, Year> getYears() {
		return _instance.years;
	}

	public TreeSet<Skier> getSkiers() {
		return _instance.skiers;
	}
}

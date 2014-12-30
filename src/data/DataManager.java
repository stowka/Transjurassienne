package data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import app.Race;
import app.Results;
import app.Skier;
import app.SkierFemale;
import app.SkierMale;
import app.Year;

public class DataManager {
	private TreeSet<Skier> skiers;
	private HashMap<String, Year> years;

	private final static String PATH_TO_FILES = "./assets/csv/";
	private final static String REGEX_MATCHING_FILES = "201[123456789].csv";

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
				data = CSVParser.parse(child);

				for (HashMap<String, String> entry : data) { // browse entries

					if (!entry.get("Nom").isEmpty()
							&& !entry.get("Nation").isEmpty()
							&& !(null == entry.get("Course"))
							&& !entry.get("Naissance").isEmpty()) {
						name = entry.get("Nom");
						try {
							birthYear = Integer
									.parseInt(entry.get("Naissance"));
						} catch (NumberFormatException e) {
							birthYear = 0;
						}
						club = entry.get("Club");
						nationality = entry.get("Nation");
						category = entry.get("Nom_Categorie");
						rank = Integer.parseInt(entry.get("Classement"));
						categoryRank = Integer.parseInt(entry
								.get("Classement_cat"));
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
				years.put(child.getName().substring(0, 4), tmpYear);
			}
		}
	}

	public HashMap<String, Year> getYears() {
		return _instance.years;
	}

	public TreeSet<Skier> getSkiers() {
		return _instance.skiers;
	}

	// TODO stats calculations
	public int numberOfParticipants(String year, String category) {
		return _instance.getYears().get(year).getRaces().get(category)
				.getParticipants().size();
	}

	public HashMap<String, Integer> numberOfParticipants(String year) {
		HashMap<String, Integer> tmp = new HashMap<String, Integer>();
		for (String key : _instance.getYears().get(year).getRaces().keySet()) {
			tmp.put(key, _instance.getYears().get(year).getRaces().get(key)
					.getParticipants().size());
		}
		return tmp;
	}

	public HashMap<String, Integer> averageTime(String year) {
		HashMap<String, Integer> tmp = new HashMap<String, Integer>();
		long tmpSum = 0;
		int nbPart = 0;
		for (String key : _instance.getYears().get(year).getRaces().keySet()) {
			for (Results r : _instance.getYears().get(year).getRaces().get(key)
					.getParticipants().values()) {
				tmpSum += r.getTime();
				nbPart += 1;
			}
			tmp.put(key, (int) (tmpSum / nbPart));
			tmpSum = 0;
			nbPart = 0;
		}
		return tmp;
	}

	public String averageTime(String year, String raceCat) {
		long tmpSum = 0;
		int nbPart = 0;
		Race tmp = _instance.getYears().get(year).getRaces().get(raceCat);
		for (Results r : tmp.getParticipants().values()) {
			tmpSum += r.getTime();
			nbPart++;
		}
		if(tmpSum != 0)
			tmpSum /= nbPart;
		return formatTime((int) tmpSum);
	}

	public int nbCountry(String year, String raceCat) {
		TreeSet<String> nationality = new TreeSet<String>();
		for (Skier skier : _instance.getYears().get(year).getRaces()
				.get(raceCat).getParticipants().keySet()) {
			nationality.add(skier.getNationality());
		}
		return nationality.size();
	}
	
	public int minTime(String year, String raceCat){
		int shortestTime = 0;
		for (Results result : _instance.getYears().get(year).getRaces()
				.get(raceCat).getParticipants().values()) {
			int current = result.getTime();
			shortestTime = (shortestTime == 0 || shortestTime > current) ? current : shortestTime;
		}
		return shortestTime;
	}
	
	public int maxTime(String year, String raceCat){
		int longestTime = 0;
		for (Results result : _instance.getYears().get(year).getRaces()
				.get(raceCat).getParticipants().values()) {
			int current = result.getTime();
			longestTime = (longestTime == 0 || longestTime < current) ? current : longestTime;
		}
		return longestTime;
	}

	public int gapTime(String year, String raceCat) {
		return (maxTime(year, raceCat) - minTime(year, raceCat));
	}

	public static String formatTime(int time) {
		StringBuilder strb = new StringBuilder();
		int h, m, s, cs;

		h = (time - (time % 360000)) / 360000;
		time -= h * 360000;
		m = (time - (time % 6000)) / 6000;
		time -= m * 6000;
		s = (time - (time % 100)) / 100;
		time -= s * 100;
		cs = time;

		if (0 < h)
			strb.append(h + ":");

		if (10 > m)
			strb.append("0");
		strb.append(m + ".");

		if (10 > s)
			strb.append("0");
		strb.append(s + ",");

		if (10 > cs)
			strb.append("0");
		strb.append(cs);

		return strb.toString();
	}
}

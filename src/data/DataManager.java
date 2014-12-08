package data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import app.Skier;
import app.Year;

public class DataManager {
	private static TreeSet<Skier> skiers;
	private static TreeSet<Year> years;

	public static void addSkier(Skier skier) {
		skiers.add(skier);
	}

	public static void init() {
		File dir = new File(".");
		ArrayList<HashMap<String, String>> data;
		years = new TreeSet<Year>();
		File[] directoryListing = dir.listFiles();
		for (File child : directoryListing) {
			if (child.getName().matches("[0-9]{4}.csv")) {
				years.add(new Year(Integer.parseInt(child.getName().substring(0, 4))));
				data = CSVParser.parse(child);
				for(HashMap<String, String> line : data) {
					System.out.println(line.get("nom"));
				}
			}
		}
	}
}

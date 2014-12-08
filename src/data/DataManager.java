package data;

import java.io.File;
import java.util.ArrayList;
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
		ArrayList<String[]> data;
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				if (child.getName().split(".")[-1].equals("csv")) {
					System.out.println(child.getName());
					years.add(new Year(Integer.parseInt(child.getName().split(
							".")[0])));
					data = CSVParser.parse(child);
					for (String[] str : data) {
						for (int iterator = 0; iterator < str.length; iterator += 1) {
							System.out.print(str[iterator]);
						}
						System.out.println();
					}
				}
			}
		} else {
			System.err.println("No file to be found.");
		}
	}
}

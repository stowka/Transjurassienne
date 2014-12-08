package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVParser {
	private static BufferedReader br;

	public static ArrayList<HashMap<String, String>> parse(File file) {
		ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					file), "UTF8"));
			String line = "";
			int lineNumber = 0;
			HashMap<String, String> tmpLine;
			
			while (null != (line = br.readLine())) {
				if (0 != lineNumber) {
					tmpLine = new HashMap<String, String>();
					tmpLine.put("dossard", line.split(";")[0]);
					tmpLine.put("classement", line.split(";")[1]);
					tmpLine.put("nom", line.split(";")[2]);
					tmpLine.put("naissance", line.split(";")[3]);
					tmpLine.put("club", line.split(";")[4]);
					tmpLine.put("nation", line.split(";")[5]);
					tmpLine.put("arrivee", line.split(";")[6]);
					tmpLine.put("course", line.split(";")[7]);
					tmpLine.put("nom_categorie", line.split(";")[8]);
					tmpLine.put("classement_categorie", line.split(";")[9]);
					data.add(tmpLine);
				}
				lineNumber += 1;
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Unable to open " + file.getName());
		} catch (IOException e) {
			System.err.println("Unable to read " + file.getName());
		}
		return data;
	}
}

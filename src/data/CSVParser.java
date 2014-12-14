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
					file), "ISO-8859-1"));
			String line = "";
			int lineNumber = 0;
			int col = 0;
			HashMap<String, String> tmpLine;
			line = br.readLine();
			String[] keys = line.split(";");
			while (null != (line = br.readLine())) {
				if (0 != lineNumber) {
					tmpLine = new HashMap<String, String>();
					col = 0;
					for (String key : keys) {
						tmpLine.put(key, line.split(";")[col]);
						col += 1;
					}
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

package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CSVParser {
	private static BufferedReader br;

	public static ArrayList<String[]> parse(File file) {
		ArrayList<String[]> data = new ArrayList<String[]>();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
			String line = "";
			int lineNumber = 0;
			while (null != (line = br.readLine())) {
				if (0 != lineNumber) {
					String[] tmpLine = line.split(";");
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

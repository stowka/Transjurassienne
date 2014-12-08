package app;

import java.util.HashMap;

public class Year {
	private int year;
	private HashMap<String, Race> races;
	
	public Year(int _year) {
		year = _year;
		races = new HashMap<String, Race>();
	}
}

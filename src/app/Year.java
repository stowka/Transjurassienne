package app;

import java.util.HashMap;

@SuppressWarnings("rawtypes")
public class Year implements Comparable {
	private int year;
	private HashMap<String, Race> races;

	public Year(int _year) {
		year = _year;
		races = new HashMap<String, Race>();
		races.put("25CTF", new RaceCT(year, true, 25));
		races.put("25FTF", new RaceFT(year, true, 25));
		races.put("50CTF", new RaceCT(year, true, 50));
		races.put("50FTF", new RaceFT(year, true, 50));
		races.put("76FTF", new RaceFT(year, true, 76));
		
		races.put("25FTM", new RaceFT(year, false, 25));
		races.put("25CTM", new RaceCT(year, false, 25));
		races.put("50CTM", new RaceCT(year, false, 50));
		races.put("50FTM", new RaceFT(year, false, 50));
		races.put("76FTM", new RaceFT(year, false, 76));
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Year [year=" + year + "]";
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the races
	 */
	public HashMap<String, Race> getRaces() {
		return races;
	}

	@Override
	public int compareTo(Object arg0) {
		Year y = (Year)arg0;
		if (y.getYear() == year)
			return 0;
		else if (y.getYear() < year)
			return 1;
		else 
			return -1;
	}

}

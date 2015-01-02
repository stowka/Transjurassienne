package event;

public class DataEvent {
	private String year;
	private String raceCat;
	private String pattern;
	
	public DataEvent(String year, String raceCat, String pattern) {
		this.year = year;
		this.raceCat = raceCat;
		this.pattern = pattern;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRaceCat() {
		return raceCat;
	}

	public void setRaceCat(String raceCat) {
		this.raceCat = raceCat;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String search) {
		this.pattern = search;
	}
}

package event;

public class DataEvent {
	private String year;
	private String raceCat;
	private String search;
	
	public DataEvent(String year, String raceCat, String search) {
		this.year = year;
		this.raceCat = raceCat;
		this.search = search;
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

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
}

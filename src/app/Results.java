package app;

public class Results {
	private int rank;
	private int categoryRank;
	private String time;
	
	public Results(int _rank, int _categoryRank, String _time) {
		rank = _rank;
		categoryRank = _categoryRank;
		time = _time;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @return the categoryRank
	 */
	public int getCategoryRank() {
		return categoryRank;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
}

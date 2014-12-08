package app;

public class Results {
	private int rank;
	private int categoryRank;
	private long time;
	
	public Results(int _rank, int _categoryRank, long _time) {
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
	public long getTime() {
		return time;
	}
}

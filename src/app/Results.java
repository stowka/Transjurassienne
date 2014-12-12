package app;

public class Results {
	private int rank;
	private int categoryRank;
	private String timeStr;
	private int time;

	public Results(int _rank, int _categoryRank, String _time) {
		rank = _rank;
		categoryRank = _categoryRank;
		timeStr = _time;
		int hours = 0, minutes = 0, seconds = 0, cseconds = 0;
		try {
			try {
				hours = Integer.parseInt(timeStr.split(":")[0]);
			} catch (NumberFormatException e) {
			}
			try {
				minutes = Integer
						.parseInt(timeStr.split("\\.")[0].split(":")[1]);
			} catch (ArrayIndexOutOfBoundsException e) {
				minutes = Integer.parseInt(timeStr.split("\\.")[0]);
			}

			seconds = Integer.parseInt(timeStr.split("\\.")[1].split(",")[0]);
			cseconds = Integer.parseInt(timeStr.split("\\.")[1].split(",")[1]);
		} catch (Exception e) {
			System.err.println("Something went wrong while parsing time");
		}
		time = hours * 360000 + minutes * 6000 + seconds * 100 + cseconds;
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
	public int getTime() {
		return time;
	}
}

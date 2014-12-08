package app;

public class Race {
	private int distance;
	
	public Race(int _distance) {
		distance = _distance;
	}

	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
}

package app;

/**
 * Abstract class race
 * @author Antoine De Gieter
 * @author Fran&ccedil;ois-Xavier B&eacute;ligat
 *
 */
public abstract class Race {
	protected int distance;
	protected int year;
	protected boolean gender; // 0 = man / 1 = woman
	
	/**
	 * 
	 * @param _year
	 * @param _gender
	 * @param _distance
	 */
	public Race(int _year, boolean _gender, int _distance) {
		year = _year;
		gender = _gender;
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

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the gender
	 */
	public boolean isGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(boolean gender) {
		this.gender = gender;
	}
}

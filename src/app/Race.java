package app;

import java.util.HashMap;

/**
 * Abstract class race
 * 
 * @author Antoine De Gieter
 * @author Fran&ccedil;ois-Xavier B&eacute;ligat
 * 
 */
public abstract class Race {
	protected int distance;
	protected int year;
	protected boolean gender; // 0 = man / 1 = woman
	protected HashMap<Skier, Results> participants;

	/**
	 * 
	 * @param _year
	 * @param _gender
	 * @param _distance
	 */
	protected Race(int _year, boolean _gender, int _distance) {
		year = _year;
		gender = _gender;
		distance = _distance;
		participants = new HashMap<Skier, Results>();
	}

	/**
	 * @param the new participant (skier)
	 */
	public void addParticipant(Skier participant, Results results) {
		participants.put(participant, results);
	}
	
	/**
	 * 
	 * @return the list of participants
	 */
	public HashMap<Skier, Results> getParticipants() {
		return participants;
	}
	
	/**
	 * 
	 * @param participant
	 * @return the results for a given participant
	 */
	public Results getResults(Skier participant) {
		return participants.get(participant);
	}

	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 *            the distance to set
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
	 * @param year
	 *            the year to set
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
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(boolean gender) {
		this.gender = gender;
	}
}

package app;

/**
 * Abstract class skier
 * @author Antoine De Gieter
 * @author Fran&ccedil;ois-Xavier B&eacute;ligat
 *
 */
@SuppressWarnings("rawtypes")
public abstract class Skier implements Comparable {
	protected String name;
	protected int birthYear;
	protected String club;
	protected String nationality;
	protected String category;

	protected Skier(String _name, int _birthYear, String _club,
			String _nationality, String _category) {
		name = _name;
		birthYear = _birthYear;
		club = _club;
		nationality = _nationality;
		category = _category;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Skier [name=" + name + ", birthYear=" + birthYear + ", club="
				+ club + ", nationality=" + nationality + ", category="
				+ category + "]";
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Skier)) {
			return false;
		}
		Skier other = (Skier) obj;
		if (birthYear != other.birthYear) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthYear
	 */
	public int getBirthYear() {
		return birthYear;
	}

	/**
	 * @param birthYear the birthYear to set
	 */
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	/**
	 * @return the club
	 */
	public String getClub() {
		return club;
	}

	/**
	 * @param club the club to set
	 */
	public void setClub(String club) {
		this.club = club;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	@Override
	public int compareTo(Object arg0) {
		Skier s = (Skier)arg0;
		return getName().compareTo(s.getName());
	}
}

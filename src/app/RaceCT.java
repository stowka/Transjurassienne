package app;

/**
 * Class classical type race
 * @author Antoine De Gieter
 * @author Fran&ccedil;ois-Xavier B&eacute;ligat
 *
 */
public class RaceCT extends Race {

	public RaceCT(int _year, boolean _gender, int _distance) {
		super(_year, _gender, _distance);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(""+distance);
		sb.append("CT");
		if(!gender)
			sb.append("M");
		else
			sb.append("F");
		return sb.toString();
	}

}

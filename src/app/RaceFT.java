package app;

/**
 * Class free type race
 * @author Antoine De Gieter
 * @author Fran&ccedil;ois-Xavier B&eacute;ligat
 *
 */
public class RaceFT extends Race {

	public RaceFT(int _year, boolean _gender, int _distance) {
		super(_year, _gender, _distance);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(""+distance);
		sb.append("FT");
		if(!gender)
			sb.append("M");
		else
			sb.append("F");
		return sb.toString();
	}
}

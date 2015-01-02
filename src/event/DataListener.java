package event;


public interface DataListener {
	public void dataEmitted(DataEvent e);
	public void searchResult(String pattern);
}

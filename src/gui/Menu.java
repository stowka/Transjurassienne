package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class Menu extends JMenuBar {
	private JMenu file, help;
	private JMenuItem open, delete, close, credits;
	
	public Menu() {
		super();
		file = new JMenu("File");
		file.setFont(MainFrame.FONT);
		help = new JMenu("?");
		help.setFont(MainFrame.FONT);
		
		open = new JMenuItem("Open");
		open.setFont(MainFrame.FONT);
		delete = new JMenuItem("Delete");
		delete.setFont(MainFrame.FONT);
		close = new JMenuItem("Close");
		close.setFont(MainFrame.FONT);
		credits = new JMenuItem("Credits");
		credits.setFont(MainFrame.FONT);
		
		file.add(open);
		file.add(delete);
		file.add(new JSeparator());
		file.add(close);
		
		help.add(credits);
		add(file);
		add(help);
	}

	/**
	 * @return the open
	 */
	public JMenuItem getOpen() {
		return open;
	}

	/**
	 * @return the delete
	 */
	public JMenuItem getDelete() {
		return delete;
	}

	/**
	 * @return the close
	 */
	public JMenuItem getClose() {
		return close;
	}

	/**
	 * @return the credits
	 */
	public JMenuItem getCredits() {
		return credits;
	}
}

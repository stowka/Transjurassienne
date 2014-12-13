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
		help = new JMenu("?");
		open = new JMenuItem("Open");
		delete = new JMenuItem("Delete");
		close = new JMenuItem("Close");
		credits = new JMenuItem("Credits");
		
		file.add(open);
		file.add(delete);
		file.add(new JSeparator());
		file.add(close);
		
		help.add(credits);
		add(file);
		add(help);
	}
}

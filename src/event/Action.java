package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;

public class Action implements ActionListener {
	private static Action _instance = null;
	public static Action getInstance() {
		if (null == _instance)
			_instance = new Action();
		return _instance;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source instanceof JButton) {
			if (((JButton) source).getText().equals("OK")) {
				
			}
		} else if (source instanceof JMenuItem) {
			if (((JMenuItem) source).getText().equals("Open")) {
				
			} else if (((JMenuItem) source).getText().equals("Delete")) {
				
			} else if (((JMenuItem) source).getText().equals("Close")) {
				
			}
		} else if (source instanceof JComboBox) {
			if (((JComboBox) source).getName().equals("year")) {
				System.out.println("Year changed");
			} else if (((JComboBox) source).getName().equals("race")) {
				
			}
		}
	}

}

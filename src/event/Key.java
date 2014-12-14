package event;

import gui.MainFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class Key implements KeyListener {
	private static Key _instance = null;
	public static Key getInstance() {
		if (null == _instance)
			_instance = new Key();
		return _instance;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getSource() instanceof JTextField
				&& event.getKeyCode() == KeyEvent.VK_ENTER) {
			MainFrame.search(((JTextField)event.getSource()).getText().replace(' ', '+'));
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		
	}

}

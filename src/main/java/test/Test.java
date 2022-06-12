package test;

import javax.swing.UIManager;

import view.HomeView;
import view.LoginView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			LoginView frame = new LoginView();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 
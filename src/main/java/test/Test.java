package test;

import javax.swing.UIManager;

import view.HomeView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			HomeView frame = new HomeView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

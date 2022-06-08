package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.HomeView;

public class TabTicketManagementController implements ActionListener {

	private HomeView homeView;
	
	public TabTicketManagementController(HomeView homeView) {
		this.homeView = homeView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Cancel ticket")) {
			int choose = JOptionPane.showConfirmDialog(homeView, "Are you cancel ticket?");
			if(choose==0)
				this.homeView.cancelTicket();
		}
	}
}

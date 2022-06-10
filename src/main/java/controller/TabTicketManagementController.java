package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import view.FormUpdateInfoTicket;
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
		} else if(src.equals("Modify")) {
			if(homeView.getTableTicket().getSelectedRow()==-1)
			{
				JOptionPane.showMessageDialog(homeView, "Please select the object to edit!");
			} else {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					new FormUpdateInfoTicket(this.homeView.getTableTicket(), homeView);
				} catch (Exception e1) {
					e1.printStackTrace();
				}				
			}
		}
	}
}

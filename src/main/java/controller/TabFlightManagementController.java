package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import view.HomeView;
import view.InputFlightView;

public class TabFlightManagementController implements ActionListener{

	private HomeView homeView;
	
	public TabFlightManagementController(HomeView homeView) {
		this.homeView = homeView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		this.homeView.selectedKey = src;
		if(src.equals("Add")) {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				InputFlightView frame = new InputFlightView(homeView);
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if(src.equals("Delete")) {
			this.homeView.deleteFlight();
			this.homeView.getTableFlight().clearSelection();
		} else if(src.equals("Modify")) {
			if(this.homeView.getTableFlight().getSelectedRow()!=-1) {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					InputFlightView frame = new InputFlightView(homeView);
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(homeView, "Vui lòng chọn đối tượng cần sửa");
			}
		} else if(src.equals("Refresh")) {
			this.homeView.loadDataTableFlight(this.homeView.getFlightModel().getFlights());
		} else if(src.equals("Search")) {
			this.homeView.searchFlight();
		}
	}

}

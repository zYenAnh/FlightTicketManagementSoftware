package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import net.bytebuddy.asm.Advice.This;
import view.HomeView;

public class NavigationController implements ActionListener{

	private HomeView viewHome;
	
	
	public NavigationController(HomeView v) {
		this.viewHome = v;
	}

	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("TICKET MANAGEMENT")) {
			this.viewHome.getFlightManagement().setVisible(false);
			this.viewHome.getEmployeeManagerPanel().setVisible(false);
			this.viewHome.getTicketManagementPanel().setVisible(true);
			this.viewHome.PREBUTTON.setBackground(Color.WHITE);
			this.viewHome.PREBUTTON = this.viewHome.btnTicketMNM;
			this.viewHome.btnTicketMNM.setBackground(Color.LIGHT_GRAY);
		} else if(src.equals("FLIGHT MANAGEMENT")) {
			this.viewHome.getTicketManagementPanel().setVisible(false);
			this.viewHome.getEmployeeManagerPanel().setVisible(false);
			this.viewHome.getFlightManagement().setVisible(true);
			this.viewHome.PREBUTTON.setBackground(Color.WHITE);
			this.viewHome.PREBUTTON = this.viewHome.btnFlightMNM;
			this.viewHome.btnFlightMNM.setBackground(Color.LIGHT_GRAY);
		} else if(src.equals("EMPLOYEE MANAGEMENT")) {
			this.viewHome.getTicketManagementPanel().setVisible(false);
			this.viewHome.getFlightManagement().setVisible(false);
			this.viewHome.getEmployeeManagerPanel().setVisible(true);
			this.viewHome.PREBUTTON.setBackground(Color.WHITE);
			this.viewHome.PREBUTTON = this.viewHome.btnEmployeeMNM;
			this.viewHome.btnEmployeeMNM.setBackground(Color.LIGHT_GRAY);
		}
	}
	
	
}

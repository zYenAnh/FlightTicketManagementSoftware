package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.FormUpdateInfoTicket;

public class FormInfoTicketController implements ActionListener{

	private FormUpdateInfoTicket formInfoTicket;
	
	public FormInfoTicketController(FormUpdateInfoTicket formInfoTicket) {
		this.formInfoTicket = formInfoTicket;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Cancel")) {
			this.formInfoTicket.closeForm();
		} else if(src.equals("Save")) {
			int choose = JOptionPane.showConfirmDialog(formInfoTicket, "Are you sure to save this change?");
			if(choose ==0) {
				this.formInfoTicket.updateTicket();
				this.formInfoTicket.closeForm();
			}
		} 
		
	}
	
}

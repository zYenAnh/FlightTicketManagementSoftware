package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entities.Account;
import entities.Employee;
import view.EmployeeInformationEntryForm;

public class InployeeInformationEntryFormController implements ActionListener{

	private EmployeeInformationEntryForm empIEFView;
	
	public InployeeInformationEntryFormController(EmployeeInformationEntryForm v) {
		this.empIEFView = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		String selectedKeyInTabEmpManagement = this.empIEFView.getSelectedKey();
		if(src.equals("Cancel")) {
			this.empIEFView.closeForm();
		} else if(src.equals("Save")) {
			Employee empSave = this.empIEFView.getDataFromEmployeeInput();
			int choose = JOptionPane.showConfirmDialog(empIEFView,"Are you sure to add/edit this employee");
			if(choose == 0) {
				int checkAdd = 0;
				if(selectedKeyInTabEmpManagement=="Add") {
					checkAdd = this.empIEFView.addEmp(empSave);		
				} else {
					this.empIEFView.updateEmp(empSave, this.empIEFView.rowSelectedIndex);
					this.empIEFView.setVisible(false);
				}
				if(checkAdd!=0) {
					JOptionPane.showMessageDialog(empIEFView, "Successfully");
					this.empIEFView.setVisible(false);
				}
			}
		}
		
	}
}

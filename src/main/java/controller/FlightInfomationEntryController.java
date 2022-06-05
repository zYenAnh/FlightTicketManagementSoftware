package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entities.Flight;
import view.InputFlightView;

public class FlightInfomationEntryController implements ActionListener{

	private InputFlightView inputFlightView;
	
	public FlightInfomationEntryController(InputFlightView inFV) {
		this.inputFlightView= inFV;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		String selectedKeyInTabFlightManagement = this.inputFlightView.getSelectedKey();
		if(src.equals("Cancel")) {
			this.inputFlightView.closeForm();
		} else if(src.equals("Save")) {
			Flight flight = this.inputFlightView.getDataFromEmployeeInput();
			int choose = JOptionPane.showConfirmDialog(inputFlightView,"Are you sure to add/edit this flight");
			if(choose == 0) {
				int checkAdd=0;
				if(selectedKeyInTabFlightManagement=="Add") {
					checkAdd = this.inputFlightView.addFlight(flight);
				} else {
					this.inputFlightView.updateFlight(flight, this.inputFlightView.rowSelectedIndex);
					this.inputFlightView.setVisible(false);
				}
				if(checkAdd!=0) {
					JOptionPane.showMessageDialog(inputFlightView, "Successfully");
					this.inputFlightView.setVisible(false);
				}
			}
		}
	}

}

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

class RowPopupEmp extends JPopupMenu {
	private static final long serialVersionUID = 365419627976873526L;
	
	public RowPopupEmp(JTable table) {
		JMenuItem edit  = new JMenuItem("Edit");
		JMenuItem active = new JMenuItem("Active");
		this.add(edit);
		this.add(active);
	}
}

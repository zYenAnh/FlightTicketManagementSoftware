package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.UIManager;

public class RowPopupTicket extends JPopupMenu {

	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	public RowPopupTicket(JTable table,HomeView homeView) {
		JMenuItem cancelTicket  = new JMenuItem("Cancel Ticket");
		JMenuItem detailsTicket  = new JMenuItem("Ticket Details");
		cancelTicket.setFont(font_JetBrains);
		detailsTicket.setFont(font_JetBrains);
		
		cancelTicket.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int choose = JOptionPane.showConfirmDialog(homeView, "Are you sure cancel ticket?");
				if(choose==0)
					homeView.cancelTicket();
			}
		});
		this.add(cancelTicket);
		this.add(detailsTicket);
	}
}

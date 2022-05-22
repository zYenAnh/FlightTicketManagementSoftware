package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NoticeDeleteTicketView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoticeDeleteTicketView frame = new NoticeDeleteTicketView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NoticeDeleteTicketView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,250);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 222);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitleNotice = new JLabel("Are you sure you want to");
		lblTitleNotice.setBounds(85, 34, 323, 31);
		lblTitleNotice.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		panel.add(lblTitleNotice);
		
		JLabel lblDeleteThisTicket = new JLabel("delete this ticket information");
		lblDeleteThisTicket.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteThisTicket.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblDeleteThisTicket.setBounds(54, 71, 393, 31);
		panel.add(lblDeleteThisTicket);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnCancel.setBounds(83, 149, 117, 46);
		panel.add(btnCancel);
		
		JButton btnCofirmDelTicket = new JButton("Yes");
		btnCofirmDelTicket.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnCofirmDelTicket.setBounds(295, 149, 117, 46);
		panel.add(btnCofirmDelTicket);
	}
}
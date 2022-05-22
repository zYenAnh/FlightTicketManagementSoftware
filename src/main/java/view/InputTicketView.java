package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color; 
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class InputTicketView extends JFrame {

	private JPanel contentPane;
	private JTextField inputTicketID;
	private JTextField inputFlightID;
	private JTextField inputPassengerName;
	private JTextField inputCustomerID;
	private JTextField inputTicketClassID;
	private JTextField inputEmployeeID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputTicketView frame = new InputTicketView();
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
	public InputTicketView() {
		int Location_jtx = 185;
		Font font_LucidaFont_18 = new Font("Lucida Grande", Font.BOLD, 18);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 550);
		setLocationRelativeTo(null);	
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(Color.LIGHT_GRAY);
		inputPanel.setBounds(0, 0, 450, 470);
		contentPane.add(inputPanel);
		inputPanel.setLayout(null);
		
		JLabel lblTicketID = new JLabel("Ticket ID");
		lblTicketID.setBounds(13, 11, 89, 16);
		lblTicketID.setFont(font_LucidaFont_18);
		inputPanel.add(lblTicketID);
		
		JLabel lblFlightID = new JLabel("Flight ID");
		lblFlightID.setFont(font_LucidaFont_18);
		lblFlightID.setBounds(13, 53, 147, 22);
		inputPanel.add(lblFlightID);
		
		JLabel lblCustomerID = new JLabel("Customer ID");
		lblCustomerID.setFont(font_LucidaFont_18);
		lblCustomerID.setBounds(13, 111, 147, 16);
		inputPanel.add(lblCustomerID);
		
		JLabel lblTicketClassID = new JLabel("Ticket Class ID");
		lblTicketClassID.setFont(font_LucidaFont_18);
		lblTicketClassID.setBounds(13, 160, 147, 29);
		inputPanel.add(lblTicketClassID);
		
		JLabel lblEmployeeID = new JLabel("Employee ID");
		lblEmployeeID.setFont(font_LucidaFont_18);
		lblEmployeeID.setBounds(13, 218, 132, 22);
		inputPanel.add(lblEmployeeID);
		
		JLabel lblTicketType = new JLabel("Ticket Type");
		lblTicketType.setFont(font_LucidaFont_18);
		lblTicketType.setBounds(13, 269, 147, 28);
		inputPanel.add(lblTicketType);
		
		JLabel lblPassengerName = new JLabel("Passenger Name");
		lblPassengerName.setFont(font_LucidaFont_18);
		lblPassengerName.setBounds(13, 328, 160, 22);
		inputPanel.add(lblPassengerName);
		
		JLabel lblBoardingTime = new JLabel("Boarding Time");
		lblBoardingTime.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblBoardingTime.setBounds(13, 382, 160, 22);
		inputPanel.add(lblBoardingTime);
		
		JLabel lblFlightDate = new JLabel("Flight Date");
		lblFlightDate.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblFlightDate.setBounds(13, 437, 160, 22);
		inputPanel.add(lblFlightDate);
		
		inputTicketID = new JTextField();
		inputTicketID.setBounds(Location_jtx, 10, 247, 22);
		inputPanel.add(inputTicketID);
		inputTicketID.setColumns(10);
		
		inputFlightID = new JTextField();
		inputFlightID.setColumns(10);
		inputFlightID.setBounds(Location_jtx, 55, 247, 22);
		inputPanel.add(inputFlightID);
		
		inputCustomerID = new JTextField();
		inputCustomerID.setColumns(10);
		inputCustomerID.setBounds(Location_jtx, 110, 247, 22);
		inputPanel.add(inputCustomerID);
		
		inputTicketClassID = new JTextField();
		inputTicketClassID.setColumns(10);
		inputTicketClassID.setBounds(Location_jtx, 165, 247, 22);
		inputPanel.add(inputTicketClassID);
		
		inputEmployeeID = new JTextField();
		inputEmployeeID.setColumns(10);
		inputEmployeeID.setBounds(Location_jtx, 220, 247, 22);
		inputPanel.add(inputEmployeeID);
		
		JComboBox cbboxTicketType = new JComboBox();
		cbboxTicketType.setBackground(Color.WHITE);
		cbboxTicketType.setBounds(Location_jtx, 275, 250, 22);
		inputPanel.add(cbboxTicketType);
		
		inputPassengerName = new JTextField();
		inputPassengerName.setColumns(10);
		inputPassengerName.setBounds(Location_jtx, 330, 247, 22);
		inputPanel.add(inputPassengerName);
		
		JComboBox cbboxBoardingTime = new JComboBox();
		cbboxBoardingTime.setBackground(Color.WHITE);
		cbboxBoardingTime.setBounds(Location_jtx, 385, 250, 22);
		inputPanel.add(cbboxBoardingTime);
		
		JComboBox cbboxFlightDate = new JComboBox();
		cbboxFlightDate.setBackground(Color.WHITE);
		cbboxFlightDate.setBounds(Location_jtx, 440, 250, 22);
		inputPanel.add(cbboxFlightDate);
		
		JPanel btnPanel =  new JPanel();
		btnPanel.setBackground(Color.LIGHT_GRAY);
		btnPanel.setForeground(Color.BLACK);
		btnPanel.setBounds(0, 470, 450, 52);
		contentPane.add(btnPanel);
		btnPanel.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.RED);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnCancel.setBounds(43, 0, 127, 49);
		btnPanel.add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnSave.setBounds(285, 0, 127, 49);
		btnPanel.add(btnSave);
	}
}

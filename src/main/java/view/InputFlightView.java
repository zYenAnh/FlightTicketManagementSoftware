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

public class InputFlight extends JFrame {

	private JPanel contentPane;
	private JTextField inputFlightID;
	private JTextField inputAircraftID;
	private JTextField inputAirpodID;
	private JTextField inputDeparture;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputFlight frame = new InputFlight();
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
	public InputFlight() {
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
		
		JLabel lblFlightID = new JLabel("Flight ID");
		lblFlightID.setFont(font_LucidaFont_18);
		lblFlightID.setBounds(13, 15, 147, 22);
		inputPanel.add(lblFlightID);
		
		JLabel lblAircraftID = new JLabel("Aircraft ID");
		lblAircraftID.setFont(font_LucidaFont_18);
		lblAircraftID.setBounds(13, 75, 147, 16);
		inputPanel.add(lblAircraftID);
		
		JLabel lblAirpodID = new JLabel("Airpod ID");
		lblAirpodID.setFont(font_LucidaFont_18);
		lblAirpodID.setBounds(13, 135, 147, 29);
		inputPanel.add(lblAirpodID);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setFont(font_LucidaFont_18);
		lblDeparture.setBounds(13, 195, 132, 22);
		inputPanel.add(lblDeparture);
		
		JLabel lblTofT = new JLabel("Take Off Time");
		lblTofT.setFont(font_LucidaFont_18);
		lblTofT.setBounds(13, 255, 147, 28);
		inputPanel.add(lblTofT);
		
		JLabel lblDes = new JLabel("Destination");
		lblDes.setFont(font_LucidaFont_18);
		lblDes.setBounds(13, 315, 160, 22);
		inputPanel.add(lblDes);
		
		JLabel lblLandingTime = new JLabel("Landing Time");
		lblLandingTime.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblLandingTime.setBounds(13, 375, 160, 22);
		inputPanel.add(lblLandingTime);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblStatus.setBounds(13, 435, 160, 22);
		inputPanel.add(lblStatus);
		
		inputFlightID = new JTextField();
		inputFlightID.setColumns(10);
		inputFlightID.setBounds(Location_jtx, 15, 247, 22);
		inputPanel.add(inputFlightID);
		
		inputAircraftID = new JTextField();
		inputAircraftID.setColumns(10);
		inputAircraftID.setBounds(Location_jtx, 75, 247, 22);
		inputPanel.add(inputAircraftID);
		
		inputAirpodID = new JTextField();
		inputAirpodID.setColumns(10);
		inputAirpodID.setBounds(Location_jtx, 135, 247, 22);
		inputPanel.add(inputAirpodID);
		
		inputDeparture = new JTextField();
		inputDeparture.setColumns(10);
		inputDeparture.setBounds(Location_jtx, 195, 247, 22);
		inputPanel.add(inputDeparture);
		
		JComboBox cbboxTakeOffTime = new JComboBox();
		cbboxTakeOffTime.setBackground(Color.WHITE);
		cbboxTakeOffTime.setBounds(Location_jtx, 255, 250, 22);
		inputPanel.add(cbboxTakeOffTime);
		
		JComboBox cbboxDestination = new JComboBox();
		cbboxDestination.setBackground(Color.WHITE);
		cbboxDestination.setBounds(185, 315, 250, 22);
		inputPanel.add(cbboxDestination);
		
		JComboBox cbboxLandingTime = new JComboBox();
		cbboxLandingTime.setBackground(Color.WHITE);
		cbboxLandingTime.setBounds(Location_jtx, 375, 250, 22);
		inputPanel.add(cbboxLandingTime);
		
		JComboBox cbboxStatus = new JComboBox();
		cbboxStatus.setBackground(Color.WHITE);
		cbboxStatus.setBounds(Location_jtx, 435, 250, 22);
		inputPanel.add(cbboxStatus);
		
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

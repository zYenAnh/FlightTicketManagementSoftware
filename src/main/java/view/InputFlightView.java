package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color; 
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EtchedBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import entities.Province;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class InputFlightView extends JFrame {

	private JPanel contentPane;
	private JTextField FlightTextField;
	private JTextField dateofbirth;
	private JTextField citizenidentifyTextField;
	private JTextField phoneTextField;
	private ActionListener empIEFController;
	private JDatePickerImpl dateDeparturePicker;
	private JComboBox departureComboBox;
	private JComboBox roleComboBox;
	private JComboBox destinationComboBox;
	
	

	public int rowSelectedIndex;
	
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_14_Thin = new Font("Poppins", Font.PLAIN, 14);
	private JTextField priceTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputFlightView frame = new InputFlightView();
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
	public InputFlightView() {
		int Location_jtx = 185;
		Font font_LucidaFont_18 = new Font("Lucida Grande", Font.BOLD, 18);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(456, 569);
		setLocationRelativeTo(null);	
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Flight Information");
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(98, 5, 278, 51);
		contentPane.add(lblNewLabel);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBounds(32, 60, 379, 369);
		inputPanel.setLayout(new GridLayout(8,2,0,20));
		contentPane.add(inputPanel);
		
		JLabel flightLable = new JLabel("Flight");
		flightLable.setFont(font_14_Thin);
		flightLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(flightLable);
		
		FlightTextField = new JTextField();
		FlightTextField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(FlightTextField);
		FlightTextField.setColumns(10);
		
		JLabel roleLable = new JLabel("Aircraft");
		roleLable.setFont(font_14_Thin);
		roleLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(roleLable);
		
		roleComboBox = new JComboBox();
		roleComboBox.addItem("Management Staff");
		roleComboBox.addItem("Ticket Seller");
		inputPanel.add(roleComboBox);
		
		JLabel genderLable = new JLabel("Departure");
		genderLable.setFont(font_14_Thin);
		genderLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(genderLable);
		
		departureComboBox = new JComboBox();
		departureComboBox.addItem("Male");
		departureComboBox.addItem("Female");
		inputPanel.add(departureComboBox);
		
		JLabel destinationLable = new JLabel("Destination");
		destinationLable.setFont(font_14_Thin);
		destinationLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(destinationLable);
		
		destinationComboBox = new JComboBox();
		
		inputPanel.add(destinationComboBox);
		
		JLabel flightDateLable = new JLabel("flightDate");
		flightDateLable.setFont(font_14_Thin);
		flightDateLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(flightDateLable);
		
		SqlDateModel modelSQLDate = new SqlDateModel();
		Properties properties = new Properties();
		properties.put("text.day", "Day");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
		
		JDatePanelImpl panle = new JDatePanelImpl(modelSQLDate, properties);
		dateDeparturePicker = new JDatePickerImpl(panle, new AbstractFormatter() {
			
			@Override
			public String valueToString(Object value) throws ParseException {
				if(value!=null) {
					Calendar calendar = (Calendar) value;
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String dateString = format.format(calendar.getTime());
					return dateString;
				}				
				return "";
			}
			@Override
			public Object stringToValue(String text) throws ParseException {return null;}
		});
		
		inputPanel.add(dateDeparturePicker);
		ArrayList<Province> provinces = Province.getDSTinh();
		for(Province p: provinces) {
			destinationComboBox.addItem(p.getTenTinhString());
		}
		
		JLabel takeOfTimeLable = new JLabel("TakeOfTime");
		takeOfTimeLable.setFont(font_14_Thin);
		takeOfTimeLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(takeOfTimeLable);
		
		citizenidentifyTextField = new JTextField();
		citizenidentifyTextField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(citizenidentifyTextField);
		citizenidentifyTextField.setColumns(10);
		
		JLabel phoneLable = new JLabel("LandingTime");
		phoneLable.setFont(font_14_Thin);
		phoneLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(phoneLable);
		
		phoneTextField = new JTextField();
		phoneTextField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(phoneTextField);
		phoneTextField.setColumns(10);
		
		JLabel lblPricebasic = new JLabel("PriceBasic");
		lblPricebasic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPricebasic.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputPanel.add(lblPricebasic);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		priceTextField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(priceTextField);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(72, 458, 304, 51);
		buttonPanel.setLayout(new GridLayout(1,2,30,0));
		contentPane.add(buttonPanel);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(empIEFController);
		cancelBtn.setFont(font_16);
		cancelBtn.setForeground(Color.RED);
		buttonPanel.add(cancelBtn);
		
		JButton saveBtn = new JButton("Save");
		saveBtn.addActionListener(empIEFController);
		saveBtn.setFont(font_16);
		buttonPanel.add(saveBtn);
//		if(this.homeView.selectedKey=="Modify")
//			loadEmpToInputCell();
	}
}

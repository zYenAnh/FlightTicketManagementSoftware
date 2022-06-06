package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.raven.swing.TimePicker;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import controller.FlightInfomationEntryController;
import dataAccessObject.EmployeeDAO;
import dataAccessObject.FlightDAO;
import entities.Aircraft;
import entities.Airport;
import entities.Employee;
import entities.Flight;
import model.AirCraftModel;
import model.AirportModel;
import model.FlightModel;
import model.Province;
import net.bytebuddy.asm.Advice.This;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class InputFlightView extends JFrame {

	private HomeView homeView;
	private JPanel contentPane;
	private JTextField FlightTextField;
	private JTextField dateofbirth;
	private JTextField phoneTextField;
	private ActionListener empIEFController;
	private JDatePickerImpl dateDeparturePicker;
	private JComboBox departureComboBox;
	private JComboBox airCraftComboBox;
	private JComboBox destinationComboBox;
	private AirCraftModel aircraftModel;
	private AirportModel airportModel;
	private FlightModel flightModel;
	private ArrayList<Aircraft> aircrafts;
	private ArrayList<Airport> airports;
	public int rowSelectedIndex;
	private TimePicker takeOfTimeTPK;
	private TimePicker landingTimePicker;
	private ActionListener acFlightInfoController;
	private JTextField landingTimeTF;
	private JTextField takeOfTimeInputLbl;
	
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_14_Thin = new Font("Poppins", Font.PLAIN, 14);
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	private JTextField priceTextField;
	
	/**
	 * Create the frame.
	 */
	public InputFlightView(HomeView homeView) {
		acFlightInfoController = new FlightInfomationEntryController(this);
		this.homeView = homeView;
		int Location_jtx = 185;
		Font font_LucidaFont_18 = new Font("Lucida Grande", Font.BOLD, 18);
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
		FlightTextField.setFont(font_JetBrains);
		FlightTextField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(FlightTextField);
		FlightTextField.setColumns(10);
		
		JLabel roleLable = new JLabel("Aircraft");
		roleLable.setFont(font_14_Thin);
		roleLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(roleLable);
		
		aircraftModel = new AirCraftModel();
		airCraftComboBox = new JComboBox();
		airCraftComboBox.setFont(font_JetBrains);
		aircrafts = this.aircraftModel.getAircrafts();
		for(Aircraft a: aircrafts) {
			airCraftComboBox.addItem(a.getAircraftId());
		}
		inputPanel.add(airCraftComboBox);
		
		JLabel depatureLable = new JLabel("Departure");
		depatureLable.setFont(font_14_Thin);
		depatureLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(depatureLable);
		
		airportModel = new AirportModel();
		departureComboBox = new JComboBox();
		departureComboBox.setFont(font_JetBrains);
		airports = airportModel.getAirports();
		inputPanel.add(departureComboBox);
		
		JLabel destinationLable = new JLabel("Destination");
		destinationLable.setFont(font_14_Thin);
		destinationLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(destinationLable);
		
		destinationComboBox = new JComboBox();
		destinationComboBox.setFont(font_JetBrains);
		for(Airport a: airports) {
			departureComboBox.addItem(a.getAirportName());
			destinationComboBox.addItem(a.getAirportName());
		}
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
		dateDeparturePicker.setPreferredSize(new Dimension(195, 200));
		dateDeparturePicker.getComponent(0).setFont(font_JetBrains);
		dateDeparturePicker.getComponent(0).setPreferredSize(new Dimension(75,28)); //JFormattedTextField
		dateDeparturePicker.getComponent(1).setPreferredSize(new Dimension(40,20));
		
		dateDeparturePicker.getJFormattedTextField().setHorizontalAlignment(SwingConstants.LEFT);
		inputPanel.add(dateDeparturePicker);
		
		JLabel takeOfTimeLable = new JLabel("TakeOfTime");
		takeOfTimeLable.setFont(font_14_Thin);
		takeOfTimeLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(takeOfTimeLable);

		takeOfTimeTPK = new TimePicker();
		JPanel inputTakeOfTime = new JPanel(); 
		inputTakeOfTime.setLayout(null);
		
		JButton selectTimeTOT = new JButton("...");
		selectTimeTOT.setBounds(146, 0, 43, 28);
		inputTakeOfTime.add(selectTimeTOT);
		
		takeOfTimeInputLbl = new JTextField("");
		takeOfTimeInputLbl.setFont(font_JetBrains);
		takeOfTimeInputLbl.setOpaque(true);
		takeOfTimeInputLbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		takeOfTimeInputLbl.setBackground(Color.WHITE);
		takeOfTimeInputLbl.setBounds(0, 0, 142, 28);
		inputTakeOfTime.add(takeOfTimeInputLbl);
		
		takeOfTimeTPK.setDisplayText(takeOfTimeInputLbl);
		selectTimeTOT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				takeOfTimeTPK.showPopup(inputPanel, 30, 30);
			}
		});
		
		inputPanel.add(inputTakeOfTime);
		
		JLabel phoneLable = new JLabel("LandingTime");
		phoneLable.setFont(font_14_Thin);
		phoneLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(phoneLable);
		
		landingTimePicker = new TimePicker();

		JPanel inputLandingTime = new JPanel(); 
		inputLandingTime.setLayout(null);
		
		JButton selectLandingTime = new JButton("...");
		selectLandingTime.setBounds(146, 0, 43, 28);
		inputLandingTime.add(selectLandingTime);
		
		landingTimeTF = new JTextField("");
		landingTimeTF.setFont(font_JetBrains);
		landingTimeTF.setOpaque(true);
		landingTimeTF.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		landingTimeTF.setBackground(Color.WHITE);
		landingTimeTF.setBounds(0, 0, 142, 28);
		inputLandingTime.add(landingTimeTF);
		
		landingTimePicker.setDisplayText(landingTimeTF);
		selectLandingTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				landingTimePicker.showPopup(inputPanel, 30, 30);
			}
		});
		
		inputPanel.add(inputLandingTime);
		
		JLabel lblPricebasic = new JLabel("PriceBasic");
		lblPricebasic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPricebasic.setFont(new Font("Poppins", Font.PLAIN, 14));
		inputPanel.add(lblPricebasic);
		
		priceTextField = new JTextField();
		priceTextField.setFont(font_JetBrains);
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
		saveBtn.addActionListener(acFlightInfoController);
		saveBtn.addActionListener(empIEFController);
		saveBtn.setFont(font_16);
		buttonPanel.add(saveBtn);
		if(this.homeView.selectedKey=="Modify")
		 	loadFlightToInputCell();
		rowSelectedIndex = this.homeView.getTableFlight().getSelectedRow();
	}
	
	public void closeForm() {
		this.setVisible(false);
	}
	
	public void updateFlight(Flight e, int rowIndex) {
		FlightDAO.getInstance().update(e);
		DefaultTableModel tableModel = (DefaultTableModel) this.homeView.getTableFlight().getModel();
		this.homeView.getFlightModel().update(e);
		tableModel.setValueAt(e.getAircraft().getAircraftId() , rowIndex, 1);
		tableModel.setValueAt(e.getAirportByDepartureId().getAirportName(), rowIndex, 2);
		tableModel.setValueAt(e.getAirportByDestinationId().getAirportName(), rowIndex, 3);
		tableModel.setValueAt(e.getNumberOfBusinessSeats() , rowIndex, 4);
		tableModel.setValueAt(e.getNumberOfEconomySeats(), rowIndex, 5);
		tableModel.setValueAt(e.getTakeOffTime() , rowIndex, 6);
		tableModel.setValueAt(e.getLandingTime() , rowIndex, 7);
		tableModel.setValueAt(e.getFlightDate() , rowIndex, 8);
		tableModel.setValueAt(e.getBasicPrice() , rowIndex, 9);
	}
	
	public int addFlight(Flight e) {
		int checkAdd =0;
		checkAdd = FlightDAO.getInstance().add(e);
		if(checkAdd!=0) {
			this.homeView.getFlightModel().insert(e);
			this.homeView.loadDataTableFlight(this.homeView.getFlightModel().getFlights());
			return checkAdd;
		} else {
				JOptionPane.showMessageDialog(null,"Flight already exists, please re-enter");
		}
		return checkAdd;
	}
	
	public String getSelectedKey() {
		return this.homeView.selectedKey;
	}
	
	public Flight getDataFromEmployeeInput() {
		Flight result = new Flight();
		result.setFlightId(this.FlightTextField.getText());
		Aircraft aircraftSelect = this.aircraftModel.search(this.airCraftComboBox.getSelectedItem()+"");
		result.setAircraft(aircraftSelect);
		result.setAirportByDepartureId(this.airportModel.searchByName(this.departureComboBox.getSelectedItem()+""));
		result.setAirportByDestinationId(this.airportModel.searchByName(this.destinationComboBox.getSelectedItem()+""));
		Date dateSelected = (Date) this.dateDeparturePicker.getModel().getValue();
		result.setTakeOffTime(takeOfTimeTPK.getSelectedTime());
		result.setLandingTime(landingTimePicker.getSelectedTime());
		result.setFlightDate(dateSelected);
		result.setNumberOfBusinessSeats(aircraftSelect.getBusinessClassSeats());
		result.setNumberOfEconomySeats(aircraftSelect.getEconomyClassSeats());
		result.setStatus("waiting");
		result.setBasicPrice(this.priceTextField.getText());
		result.setIsActive(1);
		return result;
	}
	
	public void loadFlightToInputCell() {
		int rowIndex = this.homeView.getTableFlight().getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.homeView.getTableFlight().getModel();
		this.FlightTextField.setText(tableModel.getValueAt(rowIndex, 0)+"");
		this.airCraftComboBox.setSelectedItem(tableModel.getValueAt(rowIndex, 1));
		this.departureComboBox.setSelectedItem(tableModel.getValueAt(rowIndex, 2));
		this.destinationComboBox.setSelectedItem(tableModel.getValueAt(rowIndex, 3));
		this.takeOfTimeInputLbl.setText(tableModel.getValueAt(rowIndex, 6)+"");
		this.landingTimeTF.setText(tableModel.getValueAt(rowIndex, 7)+"");
		this.priceTextField.setText(tableModel.getValueAt(rowIndex, 9)+"");
	}
	
	
}

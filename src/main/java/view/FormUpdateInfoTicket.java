package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.raven.swing.TimePicker;
import com.toedter.calendar.JDateChooser;

import org.hibernate.Session;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import controller.CustomKeyListener;
import controller.FormCreateTicketController;
import controller.FormInfoTicketController;
import dataAccessObject.CustomerDAO;
import dataAccessObject.EmployeeDAO;
import dataAccessObject.FlightDAO;
import dataAccessObject.HibernateUtils;
import dataAccessObject.InvoiceDAO;
import dataAccessObject.TicketDAO;
import entities.Account;
import entities.Aircraft;
import entities.Airport;
import entities.Customer;
import entities.Employee;
import entities.Flight;
import entities.Invoice;
import entities.Ticket;
import entities.Ticketclass;
import model.AirCraftModel;
import model.AirportModel;
import model.FlightModel;
import model.Province;
import model.TicketClassModel;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SpringLayout;

public class FormUpdateInfoTicket extends JFrame {

	private JPanel contentPane;
	public int rowSelectedIndex;
	private JLabel departureLbl;
	private JLabel destinationLbl;
	private JLabel departureDayLbl;
	private JLabel departureTimeLbl;
	private JLabel priceLbl;
	private TicketClassModel ticketClassModel;
	private JComboBox ticketTypeCbb;
	private JTable getTable;
	private JTextField addressTxtF;
	private JComboBox genderCbb;
	private HomeView homeView;
	private JDateChooser dateChooser;
	private ActionListener acFormInfoTicket;
	DecimalFormat format = new DecimalFormat("###,###,###");
	
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_14_bold = new Font("Poppins", Font.BOLD, 14);
	Font font_14_Thin = new Font("Poppins", Font.PLAIN, 14);
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	Font font_JetBrains_14 = new Font("JetBrains Mono", Font.BOLD, 14);
	private JTextField nameTxtF;
	private JTextField textField_1;
	private JTextField citizenidentifyTxtF;
	private JTextField phoneTxtF;
	private SpringLayout springLayout;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FormUpdateInfoTicket(JTable table,HomeView homeView) {
		acFormInfoTicket = new FormInfoTicketController(this);
		getTable = table;
		this.homeView =homeView;
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Create Ticket");
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(344, 10, 215, 51);
		contentPane.add(lblNewLabel);
	
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(165, 588, 585, 65);
		buttonPanel.setLayout(new GridLayout(1,2,30,0));
		contentPane.add(buttonPanel);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(acFormInfoTicket);
		cancelBtn.setFont(font_16);
		cancelBtn.setForeground(Color.RED);
		buttonPanel.add(cancelBtn);
		
		JButton createBtn = new JButton("Save");
		createBtn.addActionListener(acFormInfoTicket);
		createBtn.setFont(font_16);
		buttonPanel.add(createBtn);
		
		JPanel infoCustomerPanel = new JPanel(new GridLayout(7,2,0,20));
		infoCustomerPanel.setBounds(87, 231, 654, 340);
		contentPane.add(infoCustomerPanel);
		
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(nameLbl);
		
		nameTxtF = new JTextField();
		nameTxtF.addKeyListener(new CustomKeyListener(nameTxtF, 50));
		nameTxtF.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		nameTxtF.setColumns(10);
		nameTxtF.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		infoCustomerPanel.add(nameTxtF);
		
		JLabel genderLbl = new JLabel("Gender");
		genderLbl.setHorizontalAlignment(SwingConstants.CENTER);
		genderLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(genderLbl);
		
		genderCbb = new JComboBox();
		genderCbb.addItem("Male");
		genderCbb.addItem("Female");
		genderCbb.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		infoCustomerPanel.add(genderCbb);
		
		JLabel addressLbl = new JLabel("Address");
		addressLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addressLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(addressLbl);
		
		addressTxtF = new JTextField();
		addressTxtF.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		infoCustomerPanel.add(addressTxtF);
		
		JLabel dateOfBirthLbl = new JLabel("Date Of Birth");
		dateOfBirthLbl.setHorizontalAlignment(SwingConstants.CENTER);
		dateOfBirthLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(dateOfBirthLbl);
		
		dateChooser = new JDateChooser();
		infoCustomerPanel.add(dateChooser);
			
		JLabel citizenidentifyLbl = new JLabel("Citizenidentify");
		citizenidentifyLbl.setHorizontalAlignment(SwingConstants.CENTER);
		citizenidentifyLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(citizenidentifyLbl);
		
		citizenidentifyTxtF = new JTextField();
		citizenidentifyTxtF.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		citizenidentifyTxtF.setColumns(10);
		citizenidentifyTxtF.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		infoCustomerPanel.add(citizenidentifyTxtF);
		
		JLabel phoneLbl = new JLabel("Phone");
		phoneLbl.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(phoneLbl);
		
		phoneTxtF = new JTextField();
		phoneTxtF.addKeyListener(new CustomKeyListener(phoneTxtF,10));
		phoneTxtF.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		phoneTxtF.setColumns(10);
		phoneTxtF.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		infoCustomerPanel.add(phoneTxtF);
		
		JLabel typeTicketLbl = new JLabel("Select ticket type");
		typeTicketLbl.setHorizontalAlignment(SwingConstants.CENTER);
		typeTicketLbl.setFont(new Font("Poppins", Font.PLAIN, 14));
		infoCustomerPanel.add(typeTicketLbl);
		
		ticketClassModel = new TicketClassModel();
		ticketTypeCbb = new JComboBox();
		for(Ticketclass tc: ticketClassModel.getTicketclasses()) {
			ticketTypeCbb.addItem(tc.getTicketClassType());
		}
		ticketTypeCbb.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		infoCustomerPanel.add(ticketTypeCbb);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 207, 808, 2);
		contentPane.add(separator);
		
		JPanel panel = new JPanel(new GridLayout(3,4,0,10));
		panel.setBounds(165, 80, 623, 117);
		contentPane.add(panel);
		

		JLabel lblNewLabel_2 = new JLabel("From: ");
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(font_14_Thin);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		departureLbl = new JLabel("");
		departureLbl.setFont(font_JetBrains_14);
		panel.add(departureLbl);
		
		JLabel lblNewLabel_3 = new JLabel("To:");
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(font_14_Thin);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		
		destinationLbl = new JLabel("");
		destinationLbl.setFont(font_JetBrains_14);
		panel.add(destinationLbl);
		
		JLabel lblNewLabel_4 = new JLabel("Departure Day: ");
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(font_14_Thin);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		
		departureDayLbl = new JLabel("");
		departureDayLbl.setFont(font_JetBrains_14);
		panel.add(departureDayLbl);
		
		JLabel lblNewLabel_5 = new JLabel("Departure Time: ");
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(font_14_Thin);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		
		departureTimeLbl = new JLabel("");
		departureTimeLbl.setFont(font_JetBrains_14);
		panel.add(departureTimeLbl);
		
		JLabel lblNewLabel_6 = new JLabel("Price:");
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(font_14_Thin);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		
		priceLbl = new JLabel("");
		priceLbl.setFont(font_JetBrains_14);
		panel.add(priceLbl);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(33, 71, 808, 2);
		contentPane.add(separator_1);
		loadInfoFlight(table);
	}
	
	public void loadInfoFlight(JTable table) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int rowSelect = table.getSelectedRow();
		Flight flight = this.homeView.getFlightModel().searchById(tableModel.getValueAt(rowSelect, 1)+"");
		Ticket ticket = this.homeView.getTicketModel().searchTicketById(Integer.valueOf(tableModel.getValueAt(rowSelect, 0)+""));
		Customer customer = ticket.getCustomer();
		
		departureLbl.setText(flight.getAirportByDepartureId().getAirportName());
		destinationLbl.setText(flight.getAirportByDestinationId().getAirportName());
		departureDayLbl.setText(flight.getFlightDate()+"");
		departureTimeLbl.setText(flight.getTakeOffTime());
		priceLbl.setText(flight.getBasicPrice()+" VND");
		this.ticketTypeCbb.setSelectedItem(ticket.getTicketclass().getTicketClassType());
		this.dateChooser.setDate(customer.getDateOfBirth());
		this.nameTxtF.setText(customer.getCustomerName());
		this.genderCbb.setSelectedItem(customer.getGender());
		this.addressTxtF.setText(customer.getAddress());
		this.citizenidentifyTxtF.setText(customer.getCitizenIdentify());
		this.phoneTxtF.setText(customer.getPhone());
	}

	public Customer getInfoCustomerFromCell() {
		Customer customer = new Customer();
		customer.setCustomerName(this.nameTxtF.getText());
		customer.setDateOfBirth((Date)this.dateChooser.getDate());
		customer.setGender(this.genderCbb.getSelectedItem()+"");
		customer.setAddress(this.addressTxtF.getText());
		customer.setCitizenIdentify(this.citizenidentifyTxtF.getText());
		customer.setPhone(this.phoneTxtF.getText());
		customer.setIsActive(1);
		return customer;
	}
	public void closeForm() {
		this.setVisible(false);
	}
	
	public void updateTicket() {
		DefaultTableModel tableModel = (DefaultTableModel) getTable.getModel();
		int rowSelect = getTable.getSelectedRow();
		Flight flight = this.homeView.getFlightModel().searchById(tableModel.getValueAt(rowSelect, 1)+"");
		Ticket ticket = this.homeView.getTicketModel().searchTicketById(Integer.valueOf(tableModel.getValueAt(rowSelect, 0)+""));
		Customer customer = getInfoCustomerFromCell();
		customer.setCustomerId(ticket.getCustomer().getCustomerId());
		ticket.setPassengerName(customer.getCustomerName());
		Ticketclass ticketclass = ticketClassModel.searchByName(this.ticketTypeCbb.getSelectedItem()+"");
		if(!ticketclass.getTicketClassId().equals(ticket.getTicketclass().getTicketClassId())) {
			ticket.setTicketclass(ticketclass);
			if(ticketclass.getTicketClassId().equals("BC")) {
				if (flight.getNumberOfBusinessSeats() == 0) {
					JOptionPane.showMessageDialog(this, "Sold out!!!");
					return;
				}
				flight.decreaseBCNumber();
				flight.ascendingECNumber();
			}	else {
				if (flight.getNumberOfEconomySeats() == 0) {
					JOptionPane.showMessageDialog(this, "Sold out!!!");
					return;
				}
				flight.decreaseECNumber();
				flight.ascendingBCNumber();
			}			
		}
		CustomerDAO.getInstance().update(customer);
		FlightDAO.getInstance().update(flight);
		TicketDAO.getInstance().update(ticket);
		ticket.setCustomer(customer);
		this.homeView.getFlightModel().update(flight);
		this.homeView.getTicketModel().update(ticket);
		this.homeView.loadDataTableTicket(this.homeView.getTicketModel().getTickets());
		this.homeView.loadDataTableFlight(this.homeView.getFlightModel().getFlights());
	}
}
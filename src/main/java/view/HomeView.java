package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
// Test
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import controller.NavigationController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;

public class HomeView extends JFrame {

	private JPanel mainPanel;
	private JTextField searchTextField;
	private JTable tableTicket;
	private JTable tableFlight;
	private MouseListener mouseListenerNavi;
	Font font_20 = new Font("Poppins", Font.BOLD, 18);
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_12 = new Font("Poppins", Font.BOLD, 12);
	Font font_14 = new Font("Poppins", Font.BOLD, 14);
	Font font_12_Thin = new Font("Poppins", Font.PLAIN, 12);
	Font font_10 = new Font("Poppins", Font.BOLD, 10);
//		Font font_LucidaFont_16 = new Font("Lucida Grande", Font.BOLD, 16);

	public HomeView() {
		mouseListenerNavi = new NavigationController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
		setResizable(false);
		setLocationRelativeTo(null);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
// Call function create
		createNavigation();
//		createTabTicketManagement();
		createTabFlightManagement();
		
		this.setVisible(true);
	}
	
	public void createTabFlightManagement() {
		JPanel FlightManagement = new JPanel();
		FlightManagement.setLayout(null);
		FlightManagement.setBounds(305, 0, 951, 683);
		mainPanel.add(FlightManagement);
		
		JPanel toolFlightPanel = new JPanel();
		toolFlightPanel.setLayout(null);
		toolFlightPanel.setBounds(0, 11, 980, 80);
		FlightManagement.add(toolFlightPanel);
		
		JButton addFlightBtn = new JButton("");
		addFlightBtn.setBounds(18, 1, 64, 57);
		toolFlightPanel.add(addFlightBtn);
		
		JButton deleteFlightBtn = new JButton("");
		deleteFlightBtn.setBounds(94, 1, 64, 57);
		toolFlightPanel.add(deleteFlightBtn);
		
		JButton modifyFlightBtn = new JButton("");
		modifyFlightBtn.setBounds(170, 1, 64, 57);
		toolFlightPanel.add(modifyFlightBtn);
		
		JLabel addFlightLabel = new JLabel("ADD");
		addFlightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addFlightLabel.setFont(new Font("Poppins", Font.BOLD, 10));
		addFlightLabel.setBounds(18, 58, 61, 16);
		toolFlightPanel.add(addFlightLabel);
		
		JLabel deleteFlightLabel = new JLabel("DELETE");
		deleteFlightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deleteFlightLabel.setFont(new Font("Poppins", Font.BOLD, 10));
		deleteFlightLabel.setBounds(94, 58, 61, 16);
		toolFlightPanel.add(deleteFlightLabel);
		
		JLabel modifyFlightLabel = new JLabel("MODIFY");
		modifyFlightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		modifyFlightLabel.setFont(new Font("Poppins", Font.BOLD, 10));
		modifyFlightLabel.setBounds(173, 58, 61, 16);
		toolFlightPanel.add(modifyFlightLabel);
		
		JButton refreshFlightBtn = new JButton("");
		refreshFlightBtn.setBounds(244, 1, 64, 57);
		toolFlightPanel.add(refreshFlightBtn);
		
		JLabel refreshFlightLable = new JLabel("REFRESH");
		refreshFlightLable.setHorizontalAlignment(SwingConstants.CENTER);
		refreshFlightLable.setFont(new Font("Poppins", Font.BOLD, 10));
		refreshFlightLable.setBounds(250, 58, 54, 16);
		toolFlightPanel.add(refreshFlightLable);
		
		JLabel departureLable = new JLabel("Departure");
		departureLable.setBounds(354, 9, 97, 14);
		departureLable.setFont(font_12);
		toolFlightPanel.add(departureLable);
		
		JComboBox departureComboBox = new JComboBox();
		departureComboBox.setFont(font_12_Thin);
		departureComboBox.setBounds(461, 1, 189, 31);
		toolFlightPanel.add(departureComboBox);
		
		JLabel destinationLable = new JLabel("Destination");
		destinationLable.setFont(font_12);
		destinationLable.setBounds(354, 51, 108, 14);
		toolFlightPanel.add(destinationLable);
		
		JComboBox destinationComboBox = new JComboBox();
		departureComboBox.setFont(font_12_Thin);
		destinationComboBox.setBounds(461, 43, 189, 31);
		toolFlightPanel.add(destinationComboBox);
		
		JLabel lblDepartureDay = new JLabel("Flight Date");
		lblDepartureDay.setFont(font_12);
		lblDepartureDay.setBounds(670, 9, 108, 14);
		toolFlightPanel.add(lblDepartureDay);
		
		JDatePickerImpl dateDeparturePicker;
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
			public Object stringToValue(String text) throws ParseException {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		dateDeparturePicker.setBounds(786,4, 163, 23);
		toolFlightPanel.add(dateDeparturePicker);
		
		JLabel iconSearchJLabel_1 = new JLabel("");
		dateDeparturePicker.add(iconSearchJLabel_1);
		
		JButton searchFlightBtn = new JButton("Search");
		searchFlightBtn.setBounds(670, 34, 279, 41);
		searchFlightBtn.setFont(font_20);
		toolFlightPanel.add(searchFlightBtn);
		
		JPanel flightTablePanel = new JPanel();
		flightTablePanel.setLayout(null);
		flightTablePanel.setBounds(0, 91, 951, 640);
		FlightManagement.add(flightTablePanel);
		

		tableFlight = new JTable();
		tableFlight.setBackground(Color.LIGHT_GRAY);
		tableFlight.setBounds(23, 0, 933, 597);
		tableFlight.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"Flight ID", " AirCraft ", "Departure", "Destination", "Business ticket", "General ticket", "Take-Off Time", "Landing Time", "Price business", "Price general"
				}));
		JScrollPane scrollTableFight = new JScrollPane(tableFlight);
		scrollTableFight.setBounds(10, 0, 941, 597);
		JTableHeader tableFlightHeader = tableFlight.getTableHeader();
		tableFlightHeader.setFont(font_12_Thin);
		flightTablePanel.add(scrollTableFight);
	}
	
	public void createTabTicketManagement() {
		JPanel toolTabTicketPanel = new JPanel();
		toolTabTicketPanel.setBounds(0, 11, 980, 80);
		toolTabTicketPanel.setLayout(null);
		
// Create search		
		JLabel iconSearchJLabel = new JLabel("");
		iconSearchJLabel.setBounds(912, 16, 37, 31);
		toolTabTicketPanel.add(iconSearchJLabel);
		ImageIcon iconSearch = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//searchIcon.png");
		Image imgSearch = iconSearch.getImage();
        Image imgSearchScale = imgSearch.getScaledInstance(iconSearchJLabel.getWidth(), iconSearchJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconSearch = new ImageIcon(imgSearchScale);
        iconSearchJLabel.setIcon(scaledIconSearch);
		
		searchTextField = new JTextField();
		searchTextField.setBackground(Color.LIGHT_GRAY);
		searchTextField.setFont(font_16);
		searchTextField.setBounds(318, 6, 631, 52);
		toolTabTicketPanel.add(searchTextField);
		searchTextField.setColumns(10);
		
// Create button Add
		JButton addBtn = new JButton("");
		addBtn.setBounds(18, 1, 64, 57);
		toolTabTicketPanel.add(addBtn);
		ImageIcon iconAdd = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//addIcon.png");
		Image addImg = iconAdd.getImage();
        Image imgAddScale = addImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconAdd = new ImageIcon(imgAddScale);
        addBtn.setIcon(scaledIconAdd);
        
        JLabel addLabel = new JLabel("ADD");
        addLabel.setFont(font_10);
        addLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addLabel.setBounds(18, 58, 61, 16);
        toolTabTicketPanel.add(addLabel);
		
// Create button Delete
		JButton deleteBtn = new JButton("");
		deleteBtn.setBounds(94, 1, 64, 57);
		toolTabTicketPanel.add(deleteBtn);
		ImageIcon deleteIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//deleteIcon.png");
		Image deleteImg = deleteIcon.getImage();
        Image deleteScaleImg = deleteImg.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDelete = new ImageIcon(deleteScaleImg);
        deleteBtn.setIcon(scaledIconDelete);
        
        JLabel deleteLabel = new JLabel("DELETE");
        deleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        deleteLabel.setFont(font_10);
        deleteLabel.setBounds(94, 58, 61, 16);
        toolTabTicketPanel.add(deleteLabel);
		
// Create button Modify
		JButton modifyBtn = new JButton("");
		modifyBtn.setBounds(170, 1, 64, 57);
		toolTabTicketPanel.add(modifyBtn);
		ImageIcon modifyIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//settingIcon.png");
		Image modifyImg = modifyIcon.getImage();
        Image modifyScaleImg = modifyImg.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaledIconModify = new ImageIcon(modifyScaleImg);
        modifyBtn.setIcon(scaledIconModify);
		
		JLabel modifyLabel = new JLabel("MODIFY");
		modifyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		modifyLabel.setFont(font_10);
		modifyLabel.setBounds(173, 58, 61, 16);
		toolTabTicketPanel.add(modifyLabel);
		
// Create button reload 		
		JButton refreshBtn = new JButton("");
		refreshBtn.setBounds(244, 1, 64, 57);
		toolTabTicketPanel.add(refreshBtn);
		ImageIcon iconRefresh = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//refresh_reload_icon.png");
		Image imgRefresh = iconRefresh.getImage();
        Image imgRefreshScale = imgRefresh.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaleIconRefresh = new ImageIcon(imgRefreshScale);
        refreshBtn.setIcon(scaleIconRefresh);
		
		JLabel refreshLable = new JLabel("REFRESH");
		refreshLable.setHorizontalAlignment(SwingConstants.CENTER);
		refreshLable.setFont(new Font("Poppins", Font.BOLD, 10));
		refreshLable.setBounds(250, 58, 54, 16);
		toolTabTicketPanel.add(refreshLable);
		
		JPanel ticketPanel = new JPanel();
		ticketPanel.setBounds(0, 91, 951, 640);
		ticketPanel.setLayout(null);
		
// Create Table
		tableTicket = new JTable();
		tableTicket.setBackground(Color.LIGHT_GRAY);
		tableTicket.setBounds(23, 0, 933, 597);
		tableTicket.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"Ticket ID", "Flight ", "Customer Name", "Employee Name", "Ticket Type", "Passenger Name", "Boarding Time", "Flight Date"
				}));
		JScrollPane tableTicketScrP = new JScrollPane(tableTicket);
		tableTicketScrP.setBounds(10, 0, 941, 597);
		JTableHeader tableTicketHeader = tableTicket.getTableHeader();
		tableTicketHeader.setFont(font_12_Thin);
		ticketPanel.add(tableTicketScrP);
		
		JPanel ticketManagementPanel = new JPanel();
		ticketManagementPanel.setBounds(305, 0, 951, 683);
		ticketManagementPanel.setLayout(null);
		ticketManagementPanel.add(toolTabTicketPanel,BorderLayout.NORTH);
		ticketManagementPanel.add(ticketPanel, BorderLayout.CENTER);
		
		mainPanel.add(ticketManagementPanel);
	}
	
	public void createNavigation() {
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBounds(0,0,300,720);
		mainPanel.add(navigationPanel);
		navigationPanel.setLayout(null);
		
		
// Create Title
		JLabel titleJLabel = new JLabel("AIRCRAFT TICKET MANAGEMENT");
		titleJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleJLabel.setFont(font_16);
		titleJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleJLabel.setBounds(0,0,300,80);
		titleJLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		navigationPanel.add(titleJLabel);
		
// Create panelTicketManagement
		JPanel panelTicketManagement = new JPanel();
		panelTicketManagement.setForeground(Color.LIGHT_GRAY);
		panelTicketManagement.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTicketManagement.setBounds(0, 80, 300, 80);
		panelTicketManagement.setLayout(null);
		
		panelTicketManagement.addMouseListener(mouseListenerNavi);
		
		ImageIcon iconTicket = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//ticket.png");
		JLabel iconTicketJLabel = new JLabel(iconTicket);
		iconTicketJLabel.setBounds(20, 25, 36, 32);
		panelTicketManagement.add(iconTicketJLabel);
		Image imgTicket = iconTicket.getImage();
        Image imgTicketScale = imgTicket.getScaledInstance(iconTicketJLabel.getWidth(), iconTicketJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconTicket = new ImageIcon(imgTicketScale);
        iconTicketJLabel.setIcon(scaledIconTicket);
        
        JLabel ticketManagementJlabel = new JLabel("TICKET MANAGEMENT");
        ticketManagementJlabel.setBounds(67, 25, 209, 34);
        panelTicketManagement.add(ticketManagementJlabel);
        ticketManagementJlabel.setIcon(null);
        ticketManagementJlabel.setHorizontalTextPosition(SwingConstants.CENTER);
        ticketManagementJlabel.setFont(font_16);
        ticketManagementJlabel.setBorder(null);
        
        navigationPanel.add(panelTicketManagement);
        
        
// Create flightManagement
        JPanel panelFlightManagement = new JPanel();
        panelFlightManagement.setLayout(null);
        panelFlightManagement.setForeground(Color.LIGHT_GRAY);
        panelFlightManagement.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelFlightManagement.setBounds(0, 159, 300, 80);
        
        panelFlightManagement.addMouseListener(mouseListenerNavi);
        
        JLabel iconFlightMNMJLabel = new JLabel("");
		iconFlightMNMJLabel.setBounds(20, 25, 36, 32);
		panelFlightManagement.add(iconFlightMNMJLabel);
		ImageIcon iconFlight = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//plane.png");
		Image imgFlight = iconFlight.getImage();
        Image imgFlightScale = imgFlight.getScaledInstance(iconFlightMNMJLabel.getWidth(), iconFlightMNMJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconFlight = new ImageIcon(imgFlightScale);
        iconFlightMNMJLabel.setIcon(scaledIconFlight);
        
        JLabel flightManagementJLabel = new JLabel("FLIGHT MANAGEMENT");
        flightManagementJLabel.setBounds(66, 30, 208, 27);
        panelFlightManagement.add(flightManagementJLabel);
        flightManagementJLabel.setIcon(null);
        
        flightManagementJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        flightManagementJLabel.setFont(font_16);
        flightManagementJLabel.setBorder(null);
        
        navigationPanel.add(panelFlightManagement);
        
// Create employeeManagementPanel        
        JPanel panelEmplopyeeManagement = new JPanel();
        panelEmplopyeeManagement.setLayout(null);
        panelEmplopyeeManagement.setForeground(Color.LIGHT_GRAY);
        panelEmplopyeeManagement.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelEmplopyeeManagement.setBounds(0, 238, 300, 80);
		
		JLabel iconEmployeeManagement = new JLabel("");
		iconEmployeeManagement.setBounds(20, 25, 36, 32);
		panelEmplopyeeManagement.add(iconEmployeeManagement);
		ImageIcon iconEmployee = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//nameIcon.png");
		Image imgEmployee = iconEmployee.getImage();
        Image imgEmployeeScale = imgEmployee.getScaledInstance(iconEmployeeManagement.getWidth(), iconEmployeeManagement.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconEmployee = new ImageIcon(imgEmployeeScale);
        iconEmployeeManagement.setIcon(scaledIconEmployee);
        
        JLabel employeeManagementJLabel = new JLabel("EMPLOYEE MANAGEMENT");
        employeeManagementJLabel.setBounds(68, 25, 226, 30);
        panelEmplopyeeManagement.add(employeeManagementJLabel);
        employeeManagementJLabel.setIcon(null);
        
        employeeManagementJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        employeeManagementJLabel.setFont(font_16);
        employeeManagementJLabel.setBorder(null);
        
        navigationPanel.add(panelEmplopyeeManagement);
        
// Create invoiceManagementPanel        
        JPanel panelInvoiceManagement = new JPanel();
        panelInvoiceManagement.setLayout(null);
        panelInvoiceManagement.setForeground(Color.LIGHT_GRAY);
        panelInvoiceManagement.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelInvoiceManagement.setBounds(0, 317, 300, 80);
        panelEmplopyeeManagement.setBackground(new Color(0,0,0,54));
        
        JLabel iconInvoiceManagementJLabel = new JLabel("");
		iconInvoiceManagementJLabel.setBounds(20, 25, 36, 32);
		panelInvoiceManagement.add(iconInvoiceManagementJLabel);
		ImageIcon iconInvoice = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//invoiceIcon.png");
		Image imgInvoice = iconInvoice.getImage();
        Image imgInvoiceScale = imgInvoice.getScaledInstance(iconInvoiceManagementJLabel.getWidth(), iconInvoiceManagementJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconInvoice = new ImageIcon(imgInvoiceScale);
        iconInvoiceManagementJLabel.setIcon(scaledIconInvoice);
        
        JLabel invoiceManagementJLabel = new JLabel("INVOICE MANAGEMENT");
        invoiceManagementJLabel.setBounds(68, 25, 204, 33);
        panelInvoiceManagement.add(invoiceManagementJLabel);
        invoiceManagementJLabel.setIcon(null);

        invoiceManagementJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        invoiceManagementJLabel.setFont(font_16);
        invoiceManagementJLabel.setBorder(null);
        
        navigationPanel.add(panelInvoiceManagement);
        
// Create statisticManagementPanel
        JPanel panelStatisticManagement = new JPanel();
        panelStatisticManagement.setLayout(null);
        panelStatisticManagement.setForeground(Color.LIGHT_GRAY);
        panelStatisticManagement.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelStatisticManagement.setBounds(0, 396, 300, 80);
        navigationPanel.add(panelStatisticManagement);
        
        		//Create JLabel STATISTIC
        JLabel statisticJLabel = new JLabel("STATISTIC");
        statisticJLabel.setBounds(67, 25, 97, 34);
        panelStatisticManagement.add(statisticJLabel);
        statisticJLabel.setIcon(null);
        		
        statisticJLabel.setHorizontalTextPosition(SwingConstants.LEADING);
        statisticJLabel.setFont(font_16);
        statisticJLabel.setBorder(null);
		
		JLabel iconStatisticJLabel = new JLabel("");
		iconStatisticJLabel.setBounds(20, 25, 36, 32);
		panelStatisticManagement.add(iconStatisticJLabel);
		ImageIcon iconStatistic = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//statisticIcon.png");
		Image imgStatistic = iconStatistic.getImage();
        Image imgStatisticScale = imgStatistic.getScaledInstance(iconStatisticJLabel.getWidth(), iconStatisticJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconStatistic = new ImageIcon(imgStatisticScale);
        iconStatisticJLabel.setIcon(scaledIconStatistic);
	}
}
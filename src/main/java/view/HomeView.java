package view;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
// Test
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import commons.ExcelHelpers;
import controller.NavigationController;
import controller.TabEmployeeManagementController;
import controller.TabFlightManagementController;
import controller.TabTicketManagementController;
import dataAccessObject.AccountDAO;
import dataAccessObject.EmployeeDAO;
import dataAccessObject.FlightDAO;
import dataAccessObject.TicketDAO;
import entities.Account;
import entities.Aircraft;
import entities.Airport;
import entities.Employee;
import entities.Flight;
import entities.Invoice;
import entities.Ticket;
import model.AirCraftModel;
import model.AirportModel;
import model.EmployeeModel;
import model.FlightModel;
import model.TicketModel;
import net.bytebuddy.asm.Advice.This;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.event.ActionEvent;

public class HomeView extends JFrame {

	private AirportModel airportModel;
	private EmployeeModel employeeModel;
	private TicketModel ticketModel;
	private FlightModel flightModel;
	private AirCraftModel airCraftModel;
	private JPanel mainPanel;
	private JTextField searchTextField;
	private JTextField searchEmpTextField;
	private JTable tableTicket;
	private JTable tableFlight;
	private JTable tableEmployee;
	private JPanel FlightManagement;
	private JPanel ticketManagementPanel;
	private JPanel employeeManagerPanel;
	public JButton btnStatistic;
	public JButton btnTicketMNM;
	public JButton btnFlightMNM;
	public JButton btnEmployeeMNM;
	public JButton btnInvoiceMNM;
	public JButton searchTicketBtn;
	private JComboBox departureComboBox;
	private JComboBox destinationComboBox;
	private JLabel message;
	JDatePickerImpl dateDeparturePicker;
	private Account loginAccount;
	private JDateChooser fromDateChooser;
	private JDateChooser toDateChoose;
	DecimalFormat format = new DecimalFormat("###,###,###");

	public JButton PREBUTTON;
	public String selectedKey = "";
	
	ActionListener acNavigation = new NavigationController(this);
	ActionListener acTabEmployee = new TabEmployeeManagementController(this);
	ActionListener acTabFlight = new TabFlightManagementController(this);
	ActionListener acTabTicket = new TabTicketManagementController(this);
	
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	Font font_20 = new Font("Poppins", Font.BOLD, 18);
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_12 = new Font("Poppins", Font.BOLD, 12);
	Font font_14 = new Font("Poppins", Font.BOLD, 14);
	Font font_12_Thin = new Font("Poppins", Font.PLAIN, 12);
	Font font_8_Thin = new Font("Poppins", Font.PLAIN, 8);
	Font font_10 = new Font("Poppins", Font.BOLD, 10);
	private JTextField idExportFlight;

	public HomeView(Account account,LoginView loginView) {
		this.loginAccount = account;
		this.ticketModel = new TicketModel();
		this.airportModel = new AirportModel();
		this.employeeModel = new EmployeeModel();
		this.flightModel = new FlightModel();
		this.airCraftModel = new AirCraftModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,725);
		setResizable(false);
		setLocationRelativeTo(null);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null); 
		
// Call function create
		createNavigation();
		createTabTicketManagement();
		createTabFlightManagement();
		createTabEmployeeManagement();
		
		ticketManagementPanel.setVisible(true);
		FlightManagement.setVisible(false);
		employeeManagerPanel.setVisible(false);
		PREBUTTON = this.btnTicketMNM;
		
		JLabel UsernameLbl = new JLabel("");
		UsernameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		UsernameLbl.setText(account.getEmployee().getEmployeeName());
		UsernameLbl.setFont(new Font("JetBrains Mono", Font.BOLD, 18));
		UsernameLbl.setBounds(10, 608, 240, 28);
		mainPanel.add(UsernameLbl);
		
		HomeView homeView = this;
		
		JButton logOutBtn = new JButton("Log out");
		logOutBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int choose = JOptionPane.showConfirmDialog(homeView, "Are you sure you want to sign out?");
				if(choose==0) {
					closeForm();
					loginView.setVisible(true);					
				}
			}
		});
		logOutBtn.setFont(font_JetBrains);
		logOutBtn.setBounds(60, 646, 130, 25);
		mainPanel.add(logOutBtn);
		handleDecentralization(account);
		this.setVisible(true);
	}
	
	public void handleDecentralization(Account account) {
		String role = account.getRole();
		if(role.equals("ADMIN") || role.equals("Management Staff")) {
			
		} else if(role.equals("Ticket Seller")) {
			btnEmployeeMNM.setEnabled(false);
		}
	}
	
	public void closeForm() {
		this.setVisible(false);
	}
	
	public void createTabFlightManagement() {
		FlightManagement = new JPanel();
		FlightManagement.setLayout(null);
		FlightManagement.setBounds(230, 0, 1023, 683);
		mainPanel.add(FlightManagement);
		
// Tool
		JPanel toolFlightPanel = new JPanel();
		toolFlightPanel.setLayout(null);
		toolFlightPanel.setBounds(10, 11, 1017, 115);
		FlightManagement.add(toolFlightPanel);
		ImageIcon iconAdd = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//addIcon.png");
		Image addImg = iconAdd.getImage();
        Image imgAddScale = addImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconAdd = new ImageIcon(imgAddScale);
		ImageIcon deleteIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//deleteIcon.png");
		Image deleteImg = deleteIcon.getImage();
        Image deleteScaleImg = deleteImg.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDelete = new ImageIcon(deleteScaleImg);
		ImageIcon modifyIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//settingIcon.png");
		Image modifyImg = modifyIcon.getImage();
        Image modifyScaleImg = modifyImg.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaledIconModify = new ImageIcon(modifyScaleImg);
		ImageIcon iconRefresh = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//refresh_reload_icon.png");
		Image imgRefresh = iconRefresh.getImage();
        Image imgRefreshScale = imgRefresh.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaleIconRefresh = new ImageIcon(imgRefreshScale);
		
	// Choose Flight day	
		JLabel lblDepartureDay = new JLabel("From date:");
		lblDepartureDay.setFont(font_16);
		lblDepartureDay.setBounds(618, 6, 97, 26);
		toolFlightPanel.add(lblDepartureDay);
		
		fromDateChooser = new JDateChooser();
		fromDateChooser.getComponent(1).setFont(font_14);
		fromDateChooser.setSize(243, 31);
		fromDateChooser.setLocation(764, 43);
		toolFlightPanel.add(fromDateChooser);
		
		//Create Button Search
		JButton searchFlightBtn = new JButton("Search");
		searchFlightBtn.addActionListener(acTabFlight);
		searchFlightBtn.setBounds(770, 79, 237, 31);
		searchFlightBtn.setFont(font_JetBrains);
		toolFlightPanel.add(searchFlightBtn);
		ImageIcon iconSearch = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//searchIcon.png");
		Image imgSearch = iconSearch.getImage();
        Image imgSearchScale = imgSearch.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconSearch = new ImageIcon(imgSearchScale);
        searchFlightBtn.setIcon(scaledIconSearch);
		
		tableFlight = new JTable();
		tableFlight.setDefaultEditor(Object.class, null);
		tableFlight.setFont(font_JetBrains);
		tableFlight.setBounds(23, 0, 933, 597);
		tableFlight.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"Flight ID", " AirCraft ", "Departure", "Destination", "Business ticket", "General ticket", "Take-Off Time", "Landing Time", "Date", "Price"
				}));
		JScrollPane scrollTableFight = new JScrollPane(tableFlight);
		scrollTableFight.setBounds(30, 127, 985, 511);
		JTableHeader tableFlightHeader = tableFlight.getTableHeader();
		tableFlightHeader.setFont(font_12_Thin);
		
		final RowPopupFlight popTableFlight =new RowPopupFlight(tableFlight,this);
		
		tableFlight.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					popTableFlight.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		});
		
		tableFlight.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		        int r = tableFlight.rowAtPoint(e.getPoint());
		        if (r >= 0 && r < tableFlight.getRowCount()) {
		        	tableFlight.setRowSelectionInterval(r, r);
		        } else {
		        	tableFlight.clearSelection();
		        }

		        int rowindex = tableFlight.getSelectedRow();
		        if (rowindex < 0)
		            return;
		        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
		            JPopupMenu popup = popTableFlight;
		            popup.show(e.getComponent(), e.getX(), e.getY());
		        }
		    }
		});
		
		tableFlight.setRowHeight(30);
		
		FlightManagement.add(toolFlightPanel);
		// Departure
			JLabel departureLable = new JLabel("Departure:");
			departureLable.setBounds(18, 88, 97, 14);
			toolFlightPanel.add(departureLable);
			departureLable.setFont(font_16);
			
			departureComboBox = new JComboBox();
			departureComboBox.setBounds(125, 79, 253, 31);
			toolFlightPanel.add(departureComboBox);
			departureComboBox.setFont(font_JetBrains);
			
	// Destination
			JLabel destinationLable = new JLabel("Destination:");
			destinationLable.setBounds(389, 87, 108, 14);
			toolFlightPanel.add(destinationLable);
			destinationLable.setFont(font_16);
			
			destinationComboBox = new JComboBox();
			destinationComboBox.setBounds(506, 79, 254, 31);
			toolFlightPanel.add(destinationComboBox);
			destinationComboBox.setFont(font_JetBrains);
		
	        ArrayList<Airport> airports = this.airportModel.getAirports();
			
			
			for(Airport a:airports) {
				departureComboBox.addItem(a.getAirportName());
				destinationComboBox.addItem(a.getAirportName());
			}
			
			toDateChoose = new JDateChooser();
			toDateChoose.getComponent(1).setFont(font_14);
			toDateChoose.setBounds(764, 6, 243, 31);
			toolFlightPanel.add(toDateChoose);
			
			JLabel lblTo = new JLabel("To:");
			lblTo.setFont(font_16);
			lblTo.setBounds(617, 43, 67, 26);
			toolFlightPanel.add(lblTo);
			
			JPanel panelControlBtn = new JPanel(new GridLayout(1,4,15,0));
			panelControlBtn.setBounds(18, 1, 555, 68);
			toolFlightPanel.add(panelControlBtn);
			
	// Add
			JButton addFlightBtn = new JButton();
			panelControlBtn.add(addFlightBtn);
			addFlightBtn.addActionListener(acTabFlight);
			addFlightBtn.setFont(font_12_Thin);
			addFlightBtn.setText("Add");
			addFlightBtn.setIcon(scaledIconAdd);
			
	// Modify
			JButton modifyFlightBtn = new JButton("Modify");
			panelControlBtn.add(modifyFlightBtn);
			modifyFlightBtn.addActionListener(acTabFlight);
			modifyFlightBtn.setFont(font_12_Thin);
			modifyFlightBtn.setIcon(scaledIconModify);
			
	// Delete
			JButton deleteFlightBtn = new JButton("Delete");
			panelControlBtn.add(deleteFlightBtn);
			deleteFlightBtn.addActionListener(acTabFlight);
			deleteFlightBtn.setFont(font_12_Thin);
			deleteFlightBtn.setIcon(scaledIconDelete);
			
	// Refresh
			JButton refreshFlightBtn = new JButton("Refresh");
			panelControlBtn.add(refreshFlightBtn);
			refreshFlightBtn.addActionListener(acTabFlight);
			refreshFlightBtn.setFont(font_12_Thin);
			refreshFlightBtn.setIcon(scaleIconRefresh);
		FlightManagement.add(scrollTableFight);
		
		JButton importBtn = new JButton("Import");
		importBtn.addActionListener(acTabFlight);
		importBtn.setFont(font_JetBrains);
		importBtn.setBounds(764, 645, 110, 35);
		FlightManagement.add(importBtn);
		
		JButton exportBtn = new JButton("Export");
		exportBtn.addActionListener(acTabFlight);
		exportBtn.setFont(font_JetBrains);
		exportBtn.setBounds(905, 645, 110, 35);
		FlightManagement.add(exportBtn);
		
		loadDataTableFlight(this.flightModel.getFlights());
		
		FlightManagement.setVisible(false);
	}
	
	public void createTabTicketManagement() {
		
		ticketManagementPanel = new JPanel();
		ticketManagementPanel.setBounds(230, 0, 1023, 683);
		ticketManagementPanel.setLayout(null);
		
		JPanel toolTabTicketPanel = new JPanel();
		toolTabTicketPanel.setBounds(10, 11, 1017, 117);
		toolTabTicketPanel.setLayout(null);
		
		searchTextField = new JTextField();
		searchTextField.setMargin(new Insets(0,12,0,0));
		searchTextField.setBackground(Color.WHITE);
		searchTextField.setFont(font_JetBrains);
		searchTextField.setBounds(583, 36, 424, 33);
		toolTabTicketPanel.add(searchTextField);
		searchTextField.setColumns(10);
		
		searchTicketBtn = new JButton("Search");
		searchTicketBtn.setFont(font_JetBrains);
		searchTicketBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchTicket();
			}
		});
		searchTicketBtn.setBounds(770, 79, 237, 31);
		toolTabTicketPanel.add(searchTicketBtn);
		ImageIcon searchIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//searchIcon.png");
		Image searchImg = searchIcon.getImage();
        Image imgSearchScale = searchImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledSearchIcon = new ImageIcon(imgSearchScale);
        searchTicketBtn.setIcon(scaledSearchIcon);
        
        toolTabTicketPanel.add(searchTicketBtn);
		ImageIcon iconAdd = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//addIcon.png");
		Image addImg = iconAdd.getImage();
        Image imgAddScale = addImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconAdd = new ImageIcon(imgAddScale);
		ImageIcon deleteIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//deleteIcon.png");
		Image deleteImg = deleteIcon.getImage();
        Image deleteScaleImg = deleteImg.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDelete = new ImageIcon(deleteScaleImg);
		ImageIcon modifyIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//settingIcon.png");
		Image modifyImg = modifyIcon.getImage();
        Image modifyScaleImg = modifyImg.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaledIconModify = new ImageIcon(modifyScaleImg);
		ImageIcon iconRefresh = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//refresh_reload_icon.png");
		Image imgRefresh = iconRefresh.getImage();
        Image imgRefreshScale = imgRefresh.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaleIconRefresh = new ImageIcon(imgRefreshScale);
		
// Create Table
		tableTicket = new JTable();
		tableTicket.setDefaultEditor(Object.class, null);
		tableTicket.setFont(font_JetBrains);
		tableTicket.setBounds(23, 0, 933, 597);
		tableTicket.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"Ticket ID", "Flight", "Passenger's Name","Phone", "Creator", "Ticket Type", "Boarding Time", "Flight Date"
				}));
		
		final RowPopupTicket popTableTicket =new RowPopupTicket(tableTicket,this);
		
		tableTicket.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					popTableTicket.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		});
		
		tableTicket.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		        int r = tableTicket.rowAtPoint(e.getPoint());
		        if (r >= 0 && r < tableTicket.getRowCount()) {
		        	tableTicket.setRowSelectionInterval(r, r);
		        } else {
		        	tableTicket.clearSelection();
		        }

		        int rowindex = tableTicket.getSelectedRow();
		        if (rowindex < 0)
		            return;
		        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
		            JPopupMenu popup = popTableTicket;
		            popup.show(e.getComponent(), e.getX(), e.getY());
		        }
		    }
		});
		
		JScrollPane tableTicketScrollPane = new JScrollPane(tableTicket);
		tableTicketScrollPane.setBounds(30, 127, 985, 511);
		JTableHeader tableTicketHeader = tableTicket.getTableHeader();
		tableTicketHeader.setFont(font_12_Thin);
		tableTicket.setRowHeight(30);
		loadDataTableTicket(this.ticketModel.getTickets());
		
		ticketManagementPanel.add(toolTabTicketPanel,BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Enter your name or phone number:");
		lblNewLabel_3.setFont(new Font("Poppins", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(583, 1, 355, 25);
		toolTabTicketPanel.add(lblNewLabel_3);
		
		JPanel panel = new JPanel(new GridLayout(1,4,15,0));
		panel.setBounds(18, 1, 555, 68);
		toolTabTicketPanel.add(panel);
		
// Create button Delete
		JButton deleteBtn = new JButton("Cancel ticket");
		panel.add(deleteBtn);
		deleteBtn.addActionListener(acTabTicket);
		deleteBtn.setFont(font_12_Thin);
		deleteBtn.setIcon(scaledIconDelete);
		
// Create button Modify
		JButton modifyBtn = new JButton("Modify");
		panel.add(modifyBtn);
		modifyBtn.setFont(font_12_Thin);
		modifyBtn.addActionListener(acTabTicket);
		modifyBtn.setIcon(scaledIconModify);
		
// Create button reload 		
		JButton refreshBtn = new JButton("Refresh");
		panel.add(refreshBtn);
		refreshBtn.addActionListener(acTabTicket);
		refreshBtn.setFont(font_12_Thin);
		refreshBtn.setIcon(scaleIconRefresh);
		
		message = new JLabel("");
		message.setForeground(Color.RED);
		message.setFont(font_JetBrains);
		message.setBounds(18, 85, 683, 25);
		toolTabTicketPanel.add(message);
		ticketManagementPanel.add(tableTicketScrollPane, BorderLayout.CENTER);
		
		mainPanel.add(ticketManagementPanel);
		
		JButton exportBtn = new JButton("Export");
		exportBtn.addActionListener(acTabTicket);
		exportBtn.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		exportBtn.setBounds(905, 645, 110, 35);
		ticketManagementPanel.add(exportBtn);
		
		idExportFlight = new JTextField();
		idExportFlight.setBounds(707, 648, 171, 32);
		ticketManagementPanel.add(idExportFlight);
		idExportFlight.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter the flight to export the ticket list:");
		lblNewLabel_2.setFont(font_JetBrains);
		lblNewLabel_2.setBounds(383, 648, 310, 32);
		ticketManagementPanel.add(lblNewLabel_2);
	}
	
	public void createTabEmployeeManagement() {
		
		employeeManagerPanel = new JPanel();
		employeeManagerPanel.setBounds(230, 0, 1023, 683);
		employeeManagerPanel.setLayout(null);
		
		JPanel toolTabEmployeePanel = new JPanel();
		toolTabEmployeePanel.setBounds(10, 11, 1017, 113);
		toolTabEmployeePanel.setLayout(null);
		
		searchEmpTextField = new JTextField();
		searchEmpTextField.setMargin(new Insets(0,12,0,0));
		searchEmpTextField.setFont(font_JetBrains);
		searchEmpTextField.setBackground(Color.WHITE);
		searchEmpTextField.setBounds(583, 36, 424, 33);
		toolTabEmployeePanel.add(searchEmpTextField);
		searchEmpTextField.setColumns(10);
		
		JButton searchEmpBtn = new JButton("Search");
		searchEmpBtn.addActionListener(acTabEmployee);
		searchEmpBtn.setFont(font_JetBrains);
		searchEmpBtn.setBounds(770, 79, 237, 31);
		toolTabEmployeePanel.add(searchEmpBtn);
		ImageIcon searchIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//searchIcon.png");
		Image searchImg = searchIcon.getImage();
        Image imgSearchScale = searchImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledSearchIcon = new ImageIcon(imgSearchScale);
        searchEmpBtn.setIcon(scaledSearchIcon);
		ImageIcon iconAdd = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//addIcon.png");
		Image addImg = iconAdd.getImage();
        Image imgAddScale = addImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconAdd = new ImageIcon(imgAddScale);
		ImageIcon deleteIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//deleteIcon.png");
		Image deleteImg = deleteIcon.getImage();
        Image deleteScaleImg = deleteImg.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDelete = new ImageIcon(deleteScaleImg);
		ImageIcon modifyIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//settingIcon.png");
		Image modifyImg = modifyIcon.getImage();
        Image modifyScaleImg = modifyImg.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaledIconModify = new ImageIcon(modifyScaleImg);
		ImageIcon iconRefresh = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//refresh_reload_icon.png");
		Image imgRefresh = iconRefresh.getImage();
        Image imgRefreshScale = imgRefresh.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaleIconRefresh = new ImageIcon(imgRefreshScale);
				
// Create Table
		DefaultTableCellRenderer centeRenderer = new DefaultTableCellRenderer();
		centeRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tableEmployee = new JTable();
		tableEmployee.setFont(font_JetBrains);
		tableEmployee.setDefaultEditor(Object.class, null);
		tableEmployee.setBounds(23, 0, 933, 597);
		tableEmployee.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"ID", "Name", "Role", "Gender", "Date of birth", "Phone", "Address", "CitizenIdentify","isActive"
				}));
		
		final RowPopupEmp popTableEmp =new RowPopupEmp(tableEmployee,this);
		
		tableEmployee.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					popTableEmp.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		});
		
		tableEmployee.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		        int r = tableEmployee.rowAtPoint(e.getPoint());
		        if (r >= 0 && r < tableEmployee.getRowCount()) {
		        	tableEmployee.setRowSelectionInterval(r, r);
		        } else {
		        	tableEmployee.clearSelection();
		        }

		        int rowindex = tableEmployee.getSelectedRow();
		        if (rowindex < 0)
		            return;
		        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
		            JPopupMenu popup = popTableEmp;
		            popup.show(e.getComponent(), e.getX(), e.getY());
		        }
		    }
		});
		
		tableEmployee.setRowHeight(30);
		
		JScrollPane tableEmpScrollPane = new JScrollPane(tableEmployee);
		tableEmpScrollPane.setBounds(30, 127, 985, 511);
		JTableHeader tableEmpHeader = tableEmployee.getTableHeader();
		tableEmpHeader.setFont(font_12_Thin);
		
		loadDataTableEmployee(this.employeeModel.getEmployees());
		tableEmployee.setDefaultRenderer(String.class, centeRenderer);
		
		
		employeeManagerPanel.add(toolTabEmployeePanel,BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Enter your name or phone number:");
		lblNewLabel_3.setFont(new Font("Poppins", Font.ITALIC, 12));
		lblNewLabel_3.setBounds(583, 1, 355, 25);
		toolTabEmployeePanel.add(lblNewLabel_3);
		
		JPanel panel = new JPanel(new GridLayout(1,4,15,0));
		panel.setBounds(18, 1, 555, 68);
		toolTabEmployeePanel.add(panel);
		
// Create button Add
		JButton addEmpBtn = new JButton("Add");
		panel.add(addEmpBtn);
		addEmpBtn.setFont(font_12_Thin);
		addEmpBtn.setHideActionText(true);
		addEmpBtn.addActionListener(acTabEmployee);
		addEmpBtn.setIcon(scaledIconAdd);
		
// Create button Delete
		JButton deleteEmpBtn = new JButton("Lock");
		panel.add(deleteEmpBtn);
		deleteEmpBtn.setFont(font_12_Thin);
		deleteEmpBtn.addActionListener(acTabEmployee);
		deleteEmpBtn.setIcon(scaledIconDelete);
		
// Create button Modify
		JButton modifyEmpBtn = new JButton("Modify");
		panel.add(modifyEmpBtn);
		modifyEmpBtn.setFont(font_12_Thin);
		modifyEmpBtn.addActionListener(acTabEmployee);
		modifyEmpBtn.setIcon(scaledIconModify);
		
// Create button reload 		
		JButton refreshEmpTableBtn = new JButton("Refresh");
		panel.add(refreshEmpTableBtn);
		refreshEmpTableBtn.setFont(font_12_Thin);
		refreshEmpTableBtn.addActionListener(acTabEmployee);
		refreshEmpTableBtn.setIcon(scaleIconRefresh);
		employeeManagerPanel.add(tableEmpScrollPane, BorderLayout.CENTER);
		
		mainPanel.add(employeeManagerPanel);
	}
	
	public void createNavigation() {
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBackground(Color.WHITE);
		navigationPanel.setBorder(new LineBorder(Color.black));
		navigationPanel.setBounds(0,90,250,300);
		mainPanel.add(navigationPanel);
		navigationPanel.setLayout(null);
		navigationPanel.setLayout(new GridLayout(5,1));
		
// Create title
		
		JPanel panelTitle = new JPanel();
        panelTitle.setBorder(new LineBorder(UIManager.getColor("CheckBox.disabledText")));
        panelTitle.setBounds(0, 0, 250, 90);
//        navigationPanel.add(panelTitle);
        panelTitle.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("AIRCRAFT TICKET");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 20, 230, 30);
        panelTitle.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 24));
        
        JLabel lblNewLabel = new JLabel("MANAGEMENT");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(40, 55, 173, 16);
        panelTitle.add(lblNewLabel);
        lblNewLabel.setFont(font_20);
        
        mainPanel.add(panelTitle);
// Create Button TicketManagement
		
        btnTicketMNM = new JButton("TICKET MANAGEMENT");
        btnTicketMNM.setOpaque(true);
		btnTicketMNM.setBorderPainted(false);
		btnTicketMNM.setBackground(Color.LIGHT_GRAY);
        btnTicketMNM.addActionListener(acNavigation);
        
        btnTicketMNM.setHorizontalAlignment(SwingConstants.LEFT);
        btnTicketMNM.setFont(font_12);
        btnTicketMNM.setBounds(6, 0, 239, 80);
        ImageIcon iconTicket = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//ticket.png");
		JLabel iconTicketJLabel = new JLabel("");
		iconTicketJLabel.setBounds(20, 25, 36, 32);
		Image imgTicket = iconTicket.getImage();
        Image imgTicketScale = imgTicket.getScaledInstance(iconTicketJLabel.getWidth(), iconTicketJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconTicket = new ImageIcon(imgTicketScale);
        btnTicketMNM.setIcon(scaledIconTicket);
        navigationPanel.add(btnTicketMNM);
// Create Button flightManagement

        btnFlightMNM = new JButton("FLIGHT MANAGEMENT");
        btnFlightMNM.setOpaque(true);
        btnFlightMNM.setBorderPainted(false);
        btnFlightMNM.addActionListener(acNavigation);
        
        btnFlightMNM.setHorizontalAlignment(SwingConstants.LEFT);
        btnFlightMNM.setFont(font_12);
        btnFlightMNM.setBounds(6, 0, 239, 80);
        navigationPanel.add(btnFlightMNM);
        JLabel iconFlightMNMJLabel = new JLabel("");
		iconFlightMNMJLabel.setBounds(20, 25, 36, 32);
        ImageIcon iconFlight = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//plane.png");
		Image imgFlight = iconFlight.getImage();
        Image imgFlightScale = imgFlight.getScaledInstance(iconFlightMNMJLabel.getWidth(), iconFlightMNMJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconFlight = new ImageIcon(imgFlightScale);
        btnFlightMNM.setIcon(scaledIconFlight);
        
// Create Button employeeManagementPanel        
        btnEmployeeMNM = new JButton("EMPLOYEE MANAGEMENT");
        btnEmployeeMNM.setOpaque(true);
        btnEmployeeMNM.setBorderPainted(false);
        btnEmployeeMNM.addActionListener(acNavigation);
        
        btnEmployeeMNM.setHorizontalAlignment(SwingConstants.LEFT);
        btnEmployeeMNM.setBounds(6, 0, 239, 80);
        btnEmployeeMNM.setFont(font_12);
        JLabel iconEmployeeManagement = new JLabel("");
		iconEmployeeManagement.setBounds(20, 25, 36, 32);
        ImageIcon iconEmployee = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//nameIcon.png");
		Image imgEmployee = iconEmployee.getImage();
        Image imgEmployeeScale = imgEmployee.getScaledInstance(iconEmployeeManagement.getWidth(), iconEmployeeManagement.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconEmployee = new ImageIcon(imgEmployeeScale);
        btnEmployeeMNM.setIcon(scaledIconEmployee);
        navigationPanel.add(btnEmployeeMNM);
        
// Create Button invoiceManagementPanel        
        
        btnInvoiceMNM = new JButton("INVOICE MANAGEMENT");
        btnInvoiceMNM.setOpaque(true);
        btnInvoiceMNM.setBorderPainted(false);
        
        btnInvoiceMNM.setHorizontalAlignment(SwingConstants.LEFT);
        btnInvoiceMNM.setFont(font_12);
        btnInvoiceMNM.setBounds(6, 0, 239, 80);
        JLabel iconInvoiceManagementJLabel = new JLabel("");
		iconInvoiceManagementJLabel.setBounds(20, 25, 36, 32);
        ImageIcon iconInvoice = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//invoiceIcon.png");
		Image imgInvoice = iconInvoice.getImage();
        Image imgInvoiceScale = imgInvoice.getScaledInstance(iconInvoiceManagementJLabel.getWidth(), iconInvoiceManagementJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconInvoice = new ImageIcon(imgInvoiceScale);
        btnInvoiceMNM.setIcon(scaledIconInvoice);
        navigationPanel.add(btnInvoiceMNM);

//Create Button Statistic
        
        btnStatistic = new JButton("STATISTIC");
        btnStatistic.setOpaque(true);
        btnStatistic.setBorderPainted(false);
        
        btnStatistic.setHorizontalAlignment(SwingConstants.LEFT);
        btnStatistic.setFont(font_12);
        btnStatistic.setBounds(6, 0, 239, 80);
        JLabel iconStatisticJLabel = new JLabel("");
        iconStatisticJLabel.setBounds(20, 25, 36, 32);
        ImageIcon iconStatistic = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//statisticIcon.png");
		Image imgStatistic = iconStatistic.getImage();
        Image imgStatisticScale = imgStatistic.getScaledInstance(iconStatisticJLabel.getWidth(), iconStatisticJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconStatistic = new ImageIcon(imgStatisticScale);
        btnStatistic.setIcon(scaledIconStatistic);
        navigationPanel.add(btnStatistic);
	}
	
	public JPanel getFlightManagement() {
		return FlightManagement;
	}

	public void setFlightManagement(JPanel flightManagement) {
		FlightManagement = flightManagement;
	}

	public JPanel getTicketManagementPanel() {
		return ticketManagementPanel;
	}

	public void setTicketManagementPanel(JPanel ticketManagementPanel) {
		this.ticketManagementPanel = ticketManagementPanel;
	}
	
	public JPanel getEmployeeManagerPanel() {
		return employeeManagerPanel;
	}

	public void setEmployeeManagerPanel(JPanel employeeManagerPanel) {
		this.employeeManagerPanel = employeeManagerPanel;
	}
	
	public JTable getTableTicket() {
		return tableTicket;
	}

	public void setTableTicket(JTable tableTicket) {
		this.tableTicket = tableTicket;
	}

	public JTable getTableFlight() {
		return tableFlight;
	}

	public void setTableFlight(JTable tableFlight) {
		this.tableFlight = tableFlight;
	}

	public JTable getTableEmployee() {
		return tableEmployee;
	}

	public void setTableEmployee(JTable tableEmployee) {
		this.tableEmployee = tableEmployee;
	}
	
	public EmployeeModel getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}
	
	public FlightModel getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(FlightModel flightModel) {
		this.flightModel = flightModel;
	}
	
	public TicketModel getTicketModel() {
		return ticketModel;
	}

	public void setTicketModel(TicketModel ticketModel) {
		this.ticketModel = ticketModel;
	}

	public Account getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(Account loginAccount) {
		this.loginAccount = loginAccount;
	}
	
	public void loadDataTableEmployee(ArrayList<Employee> employees) {
		DefaultTableModel tableModel = (DefaultTableModel) tableEmployee.getModel();
		tableModel.getDataVector().removeAllElements();
		if(employees.isEmpty())
			return;
		for(Employee e: employees) {
			tableModel.addRow(new Object[] {
					e.getEmployeeId(),
					e.getEmployeeName(),
					e.getRole(),
					e.getGender(),
					e.getDateOfBirth(),
					e.getPhone(),
					e.getAddress(),
					e.getCitizenIdentify(),
					e.getIsActive()
			});
		}
	}
	
	public void deleteEmp() {
		int rowIndex = this.getTableEmployee().getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.getTableEmployee().getModel();
		int idSelect = Integer.valueOf(tableModel.getValueAt(rowIndex, 0)+"");
		ArrayList<Employee> employees = this.employeeModel.getEmployees();
		for(Employee e : employees) {
			if(e.getEmployeeId()==idSelect) {
				Employee updateE = e;
				updateE.setIsActive(0);
				EmployeeDAO.getInstance().update(updateE);
				this.employeeModel.update(e);
				loadDataTableEmployee(this.employeeModel.getEmployees());
				return;
			}	
		}
	}
	
	
	public void searchFlight() {
		ArrayList<Flight> listFlightSearch = new ArrayList<Flight>();
		String departure = this.departureComboBox.getSelectedItem()+"";
		String destination = this.destinationComboBox.getSelectedItem()+"";
		java.util.Date fromDate = this.fromDateChooser.getDate();
		java.util.Date toDate = this.toDateChoose.getDate();
		if(departure.equals(destination)) {
			JOptionPane.showMessageDialog(null,"Departure and destination cannot be the same");
			return;
		} else {
			ArrayList<Flight> flights = this.flightModel.getFlights();
			if(fromDate == null || toDate ==null) {
				JOptionPane.showMessageDialog(null,"Please select a time period to search!");
				return;
			} else {
				for(Flight f:flights) {
					System.out.println(toDate.compareTo(f.getFlightDate()));
					System.out.println(fromDate.compareTo(f.getFlightDate()));
					System.out.println("___________________________");
					if(f.getAirportByDepartureId().getAirportName().equals(departure) 
							&& f.getAirportByDestinationId().getAirportName().equals(destination) 
							&& toDate.compareTo(f.getFlightDate())<=0 && fromDate.compareTo(f.getFlightDate())>=0) {
						listFlightSearch.add(f);
					}
				}
			}
		}
		if(!listFlightSearch.isEmpty())
			loadDataTableFlight(listFlightSearch);
		else 
			JOptionPane.showMessageDialog(this, "Not found");
	}
	
	public void loadDataTableFlight(ArrayList<Flight> flights) {
		DefaultTableModel tableModel = (DefaultTableModel) tableFlight.getModel();
		tableModel.getDataVector().removeAllElements();
		if(flights.isEmpty())
			return;
		java.util.Date now = new java.util.Date();
		for(Flight f: flights) {
			if(f.getFlightDate().compareTo(now)>=0) {
				String priceString = format.format(Integer.valueOf(f.getBasicPrice()));
				java.util.Date flDate =f.getFlightDate();
				String dateFlight = flDate.getDate()+"/" +(flDate.getMonth()+1)+"/"+(flDate.getYear()+1900);
				tableModel.addRow(new Object[] {
						f.getFlightId(),
						f.getAircraft().getAircraftId(),
						f.getAirportByDepartureId().getAirportName(),
						f.getAirportByDestinationId().getAirportName(),
						f.getNumberOfBusinessSeats(),
						f.getNumberOfEconomySeats(),
						f.getTakeOffTime(),
						f.getLandingTime(),
						dateFlight,
						priceString
				});
			}
		}
	}
	
	public void deleteFlight() {
		int rowIndex = this.tableFlight.getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.tableFlight.getModel();
		String idSelect = tableModel.getValueAt(rowIndex, 0).toString();
		ArrayList<Flight> flights = this.flightModel.getFlights();
		for(Flight f : flights) {
			if(f.getFlightId().equals(idSelect)) {
				Flight updateF = f;
				updateF.setIsActive(0);
				FlightDAO.getInstance().update(updateF);
				this.flightModel.remove(f);
				loadDataTableFlight(this.flightModel.getFlights());
				return;
			}	
		}
	}

	public void loadDataTableTicket(ArrayList<Ticket> tickets) {
		DefaultTableModel tableModel = (DefaultTableModel) tableTicket.getModel();
		tableModel.getDataVector().removeAllElements();
		if(tickets.isEmpty())
			return;
		for(int i = tickets.size()-1;i>=0;i--) {
			tableModel.addRow(new Object[] {
					tickets.get(i).getTicketId(),
					tickets.get(i).getFlight().getFlightId(),
					tickets.get(i).getPassengerName(),
					tickets.get(i).getCustomer().getPhone(),
					tickets.get(i).getEmployee().getEmployeeName(),
					tickets.get(i).getTicketclass().getTicketClassType(),
					tickets.get(i).getFlight().getTakeOffTime(),
					tickets.get(i).getFlight().getFlightDate()
			});
		}
	}
	
	public void cancelTicket() {
		DefaultTableModel tableModel = (DefaultTableModel) tableTicket.getModel();
		int rowSelect = tableTicket.getSelectedRow();
		
		int ticketId = Integer.valueOf(tableModel.getValueAt(rowSelect, 0)+"");
		Ticket ticket = this.ticketModel.searchTicketById(ticketId);
		
		Flight flight = ticket.getFlight();
		if(ticket.getTicketclass().getTicketClassId().equals("BC")) {
			flight.ascendingBCNumber();
		} else {
			flight.ascendingECNumber();
		}
		
		ticketModel.remove(ticket);
		TicketDAO.getInstance().delele(ticket);
		FlightDAO.getInstance().update(flight);
		flightModel.update(flight);
		loadDataTableFlight(this.flightModel.getFlights());
		loadDataTableTicket(this.ticketModel.getTickets());
	}
	
	public void handleExportFlight(ArrayList<Flight> flights, java.io.File file) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Flight");
		int rowNum = 0;
		Row firstRow = sheet.createRow(rowNum++);
		String[] title = {"Flight ID","Aircraft","Departure","Destination","Date","Take Of Time","LandingTime","Bussiness seats","Economic seats","Basic Price"};
		for(int i=0;i<title.length;i++) {
			firstRow.createCell(i).setCellValue(title[i]);
		}
		for(Flight flight: flights) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(flight.getFlightId());
			row.createCell(1).setCellValue(flight.getAircraft().getAircraftId());
			row.createCell(2).setCellValue(flight.getAirportByDepartureId().getAirportName());
			row.createCell(3).setCellValue(flight.getAirportByDestinationId().getAirportName());
			row.createCell(4).setCellValue(flight.getFlightDate().toString());
			row.createCell(5).setCellValue(flight.getTakeOffTime());
			row.createCell(6).setCellValue(flight.getLandingTime());
			row.createCell(7).setCellValue(flight.getNumberOfBusinessSeats());
			row.createCell(8).setCellValue(flight.getNumberOfEconomySeats());
			row.createCell(9).setCellValue(flight.getBasicPrice());
		}
		try {
			FileOutputStream outputStream = new FileOutputStream(file.getPath());
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exportTicketByIdFlight(java.io.File file) {
		String flightId = idExportFlight.getText();
		ArrayList<Ticket> tickets = this.ticketModel.searchByFlight(flightId);
		handleExportTicket(tickets, file);
	}
	
	public void handleExportTicket(ArrayList<Ticket> tickets, java.io.File file) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Ticket");
		int rowNum = 0;
		Row firstRow = sheet.createRow(rowNum++);
		String[] title = {"Ticket ID","Flight ID","Customer ID","Passenger's Name","Departure","Destination","Date creation date","Flight Date","Take Of Time","Ticket type","Price"};
		for(int i=0;i<title.length;i++) {
			firstRow.createCell(i).setCellValue(title[i]);
		}
		for(Ticket ticket: tickets) {
			Set<Invoice> invoices = ticket.getInvoices();
			Invoice invoice = new Invoice();
			for(Invoice i:invoices) {
				invoice = i;
			}
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(ticket.getTicketId());
			row.createCell(1).setCellValue(ticket.getFlight().getFlightId());
			row.createCell(2).setCellValue(ticket.getCustomer().getCustomerId());
			row.createCell(3).setCellValue(ticket.getPassengerName());
			row.createCell(4).setCellValue(ticket.getFlight().getAirportByDepartureId().getAirportName());
			row.createCell(5).setCellValue(ticket.getFlight().getAirportByDestinationId().getAirportName());
			row.createCell(6).setCellValue(invoice.getEstablishedDate().toString());
			row.createCell(7).setCellValue(ticket.getFlight().getFlightDate().toString());
			row.createCell(8).setCellValue(ticket.getFlight().getTakeOffTime());
			row.createCell(9).setCellValue(ticket.getTicketclass().getTicketClassType());
			row.createCell(10).setCellValue(invoice.getTotal());
		}
		try {
			FileOutputStream outputStream = new FileOutputStream(file.getPath());
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void handleImport(java.io.File file) throws IOException {
		FileInputStream inputStream = new FileInputStream(file.getPath());
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		DataFormatter formatter = new DataFormatter();
		Iterator<Row> rowIterator = sheet.iterator();
		rowIterator.next();
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Flight flight = new Flight();
			flight.setFlightId(row.getCell(0).getStringCellValue());
			Aircraft aircraftSelect = this.airCraftModel.search(row.getCell(1).getStringCellValue());
			flight.setAircraft(aircraftSelect);
			flight.setAirportByDepartureId(this.airportModel.searchById(row.getCell(2).getStringCellValue()));
			flight.setAirportByDestinationId(this.airportModel.searchById(row.getCell(3).getStringCellValue()));
			flight.setFlightDate(row.getCell(4).getDateCellValue());
			LocalDateTime takeOfTime = row.getCell(5).getLocalDateTimeCellValue();
			LocalDateTime landingTime = row.getCell(6).getLocalDateTimeCellValue();
			flight.setTakeOffTime(handleTime(takeOfTime));
			flight.setLandingTime(handleTime(landingTime));
			flight.setNumberOfBusinessSeats(aircraftSelect.getBusinessClassSeats());
			flight.setNumberOfEconomySeats(aircraftSelect.getEconomyClassSeats());
			flight.setStatus("waiting");
			flight.setBasicPrice(formatter.formatCellValue(row.getCell(7))+"");
			flight.setIsActive(1);
			FlightDAO.getInstance().add(flight);
			this.flightModel.insert(flight);
		}
		loadDataTableFlight(this.flightModel.getFlights());
	}
	
	public void searchTicket() {
		String search = searchTextField.getText().toLowerCase();
		ArrayList<Ticket> ticketsSearch = new ArrayList<Ticket>();
		for(Ticket ticket: ticketModel.getTickets()) {
			String name = ticket.getCustomer().getCustomerName().toLowerCase();
			String phone = ticket.getCustomer().getPhone();
			if(name.contains(search) || phone.contains(search)) { 
				ticketsSearch.add(ticket);
			}
		}
		if(!ticketsSearch.isEmpty())
			loadDataTableTicket(ticketsSearch);
		else {
			this.message.setText(search.trim() +" not found in the document!");
		}
	}
	
	public void searchEmployee() {
		String search = searchEmpTextField.getText().toLowerCase();
		ArrayList<Employee> employeeSearch = new ArrayList<Employee>();
		for(Employee e: employeeModel.getEmployees()) {
			String name = e.getEmployeeName().toLowerCase();
			String phone = e.getPhone();
			if(name.contains(search) || phone.contains(search)) { 
				employeeSearch.add(e);
			}
		}
		if(!employeeSearch.isEmpty())
			loadDataTableEmployee(employeeSearch);
		else {
			this.message.setText(search.trim() +" not found in the document!");
		}
	}
	
	public String handleTime (LocalDateTime time) {
		String timeString = "";
		String midday = "";
		int hour = time.getHour();
		int minutes = time.getMinute();
		if(hour>12) {
			hour -=12;
			midday = "PM";
			if(minutes<10)
				timeString = "0" + hour +":0" +minutes+ " "+midday;
			else {
				timeString = "0" + hour +":" +minutes + " " +midday;
			}
		} else {
			midday = "AM";
			if(minutes<10)
				timeString = hour +":0" +minutes+ " "+midday;
			else {
				timeString = hour +":" +minutes + " " +midday;
			}
		}
		return timeString;
	}
}
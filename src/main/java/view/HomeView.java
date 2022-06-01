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

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import controller.NavigationController;
import controller.TabEmployeeManagementController;
import dataAccessObject.AccountDAO;
import dataAccessObject.EmployeeDAO;
import entities.Account;
import entities.Employee;
import entities.EmployeeModel;
import entities.Flight;
import entities.FlightModel;
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
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.event.ActionEvent;

public class HomeView extends JFrame {

	private EmployeeModel employeeModel;
	private FlightModel flightModel;
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

	public JButton PREBUTTON;
	public String selectedKey = "";
	
	ActionListener acNavigation = new NavigationController(this);
	ActionListener acTabEmployee = new TabEmployeeManagementController(this);
	
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	Font font_20 = new Font("Poppins", Font.BOLD, 18);
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_12 = new Font("Poppins", Font.BOLD, 12);
	Font font_14 = new Font("Poppins", Font.BOLD, 14);
	Font font_12_Thin = new Font("Poppins", Font.PLAIN, 12);
	Font font_8_Thin = new Font("Poppins", Font.PLAIN, 8);
	Font font_10 = new Font("Poppins", Font.BOLD, 10);

	public HomeView() {
		this.employeeModel = new EmployeeModel();
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
		createTabTicketManagement();
		createTabFlightManagement();
		createTabEmployeeManagement();
		
		ticketManagementPanel.setVisible(true);
		FlightManagement.setVisible(false);
		employeeManagerPanel.setVisible(false);
		PREBUTTON = this.btnTicketMNM;
		this.setVisible(true);
	}
	
	public void createTabFlightManagement() {
		FlightManagement = new JPanel();
		FlightManagement.setLayout(null);
		FlightManagement.setBounds(230, 0, 1023, 683);
		mainPanel.add(FlightManagement);
		
// Tool
		JPanel toolFlightPanel = new JPanel();
		toolFlightPanel.setLayout(null);
		toolFlightPanel.setBounds(10, 11, 1017, 80);
		FlightManagement.add(toolFlightPanel);
		
	// Add
		JButton addFlightBtn = new JButton();
		addFlightBtn.setFont(font_12_Thin);
		addFlightBtn.setText("Add");
		addFlightBtn.setBounds(18, 1, 126, 57);
		toolFlightPanel.add(addFlightBtn);
		ImageIcon iconAdd = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//addIcon.png");
		Image addImg = iconAdd.getImage();
        Image imgAddScale = addImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconAdd = new ImageIcon(imgAddScale);
        addFlightBtn.setIcon(scaledIconAdd);
		
	// Delete
		JButton deleteFlightBtn = new JButton("Delete");
		deleteFlightBtn.setFont(font_12_Thin);
		deleteFlightBtn.setBounds(157, 1, 126, 57);
		toolFlightPanel.add(deleteFlightBtn);
		ImageIcon deleteIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//deleteIcon.png");
		Image deleteImg = deleteIcon.getImage();
        Image deleteScaleImg = deleteImg.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDelete = new ImageIcon(deleteScaleImg);
        deleteFlightBtn.setIcon(scaledIconDelete);
		
	// Modify
		JButton modifyFlightBtn = new JButton("Modify");
		modifyFlightBtn.setFont(font_12_Thin);
		modifyFlightBtn.setBounds(293, 1, 126, 57);
		toolFlightPanel.add(modifyFlightBtn);
		ImageIcon modifyIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//settingIcon.png");
		Image modifyImg = modifyIcon.getImage();
        Image modifyScaleImg = modifyImg.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaledIconModify = new ImageIcon(modifyScaleImg);
        modifyFlightBtn.setIcon(scaledIconModify);
		
	// Refresh
		JButton refreshFlightBtn = new JButton("Refresh");
		refreshFlightBtn.setFont(font_12_Thin);
		refreshFlightBtn.setBounds(429, 1, 126, 57);
		toolFlightPanel.add(refreshFlightBtn);
		ImageIcon iconRefresh = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//refresh_reload_icon.png");
		Image imgRefresh = iconRefresh.getImage();
        Image imgRefreshScale = imgRefresh.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaleIconRefresh = new ImageIcon(imgRefreshScale);
        refreshFlightBtn.setIcon(scaleIconRefresh);
		
	// Departure
		JLabel departureLable = new JLabel("Departure");
		departureLable.setBounds(565, 9, 97, 14);
		departureLable.setFont(font_12);
		toolFlightPanel.add(departureLable);
		
		JComboBox departureComboBox = new JComboBox();
		departureComboBox.setFont(font_12_Thin);
		departureComboBox.setBounds(644, 1, 153, 31);
		toolFlightPanel.add(departureComboBox);
		
	// Destination
		JLabel destinationLable = new JLabel("Destination");
		destinationLable.setFont(font_12);
		destinationLable.setBounds(565, 50, 108, 14);
		toolFlightPanel.add(destinationLable);
		
		JComboBox destinationComboBox = new JComboBox();
		departureComboBox.setFont(font_12_Thin);
		destinationComboBox.setBounds(644, 42, 153, 31);
		toolFlightPanel.add(destinationComboBox);
		
	// Choose Flight day	
		JLabel lblDepartureDay = new JLabel("Date");
		lblDepartureDay.setFont(font_12);
		lblDepartureDay.setBounds(820, 9, 41, 14);
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
			public Object stringToValue(String text) throws ParseException {return null;}
		});
		dateDeparturePicker.setBounds(857,1, 150, 31);
		toolFlightPanel.add(dateDeparturePicker);
		
		//Create Button Search
		JButton searchFlightBtn = new JButton("Search");
		searchFlightBtn.setBounds(820, 41, 187, 31);
		searchFlightBtn.setFont(font_20);
		toolFlightPanel.add(searchFlightBtn);
		ImageIcon iconSearch = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//searchIcon.png");
		Image imgSearch = iconSearch.getImage();
        Image imgSearchScale = imgSearch.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconSearch = new ImageIcon(imgSearchScale);
        searchFlightBtn.setIcon(scaledIconSearch);
		
		tableFlight = new JTable();
		tableFlight.setBackground(Color.LIGHT_GRAY);
		tableFlight.setBounds(23, 0, 933, 597);
		tableFlight.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"Flight ID", " AirCraft ", "Departure", "Destination", "Business ticket", "General ticket", "Take-Off Time", "Landing Time", "Price business", "Price general"
				}));
		JScrollPane scrollTableFight = new JScrollPane(tableFlight);
		scrollTableFight.setBounds(30, 91, 985, 590);
		JTableHeader tableFlightHeader = tableFlight.getTableHeader();
		tableFlightHeader.setFont(font_12_Thin);
//		loadDataTableFlight();
		
		FlightManagement.add(toolFlightPanel);
		FlightManagement.add(scrollTableFight);
		
		
		FlightManagement.setVisible(false);
	}
	
	public void createTabTicketManagement() {
		
		ticketManagementPanel = new JPanel();
		ticketManagementPanel.setBounds(230, 0, 1023, 683);
		ticketManagementPanel.setLayout(null);
		
		JPanel toolTabTicketPanel = new JPanel();
		toolTabTicketPanel.setBounds(10, 11, 1017, 80);
		toolTabTicketPanel.setLayout(null);
		
// Create search		
		JLabel iconSearchJLabel = new JLabel("");
		iconSearchJLabel.setBounds(912, 16, 37, 31);
		toolTabTicketPanel.add(iconSearchJLabel);
		
		searchTextField = new JTextField();
		searchTextField.setMargin(new Insets(0,12,0,0));
		searchTextField.setBackground(Color.WHITE);
		searchTextField.setFont(new Font("Poppins", Font.PLAIN, 20));
		searchTextField.setBounds(575, 1, 355, 57);
		toolTabTicketPanel.add(searchTextField);
		searchTextField.setColumns(10);
		
		JButton searchTicketBtn = new JButton("");
		searchTicketBtn.setBounds(940, 1, 64, 57);
		toolTabTicketPanel.add(searchTicketBtn);
		ImageIcon searchIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//searchIcon.png");
		Image searchImg = searchIcon.getImage();
        Image imgSearchScale = searchImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledSearchIcon = new ImageIcon(imgSearchScale);
        searchTicketBtn.setIcon(scaledSearchIcon);
        
        toolTabTicketPanel.add(searchTicketBtn);
		
// Create button Add
		JButton addBtn = new JButton("Add");
		addBtn.setFont(font_12_Thin);
		addBtn.setBounds(21, 1, 126, 57);
		toolTabTicketPanel.add(addBtn);
		ImageIcon iconAdd = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//addIcon.png");
		Image addImg = iconAdd.getImage();
        Image imgAddScale = addImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconAdd = new ImageIcon(imgAddScale);
        addBtn.setIcon(scaledIconAdd);
		
// Create button Delete
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setFont(font_12_Thin);
		deleteBtn.setBounds(157, 1, 126, 57);
		toolTabTicketPanel.add(deleteBtn);
		ImageIcon deleteIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//deleteIcon.png");
		Image deleteImg = deleteIcon.getImage();
        Image deleteScaleImg = deleteImg.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDelete = new ImageIcon(deleteScaleImg);
        deleteBtn.setIcon(scaledIconDelete);
		
// Create button Modify
		JButton modifyBtn = new JButton("Modify");
		modifyBtn.setFont(font_12_Thin);
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		modifyBtn.setBounds(293, 1, 126, 57);
		toolTabTicketPanel.add(modifyBtn);
		ImageIcon modifyIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//settingIcon.png");
		Image modifyImg = modifyIcon.getImage();
        Image modifyScaleImg = modifyImg.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaledIconModify = new ImageIcon(modifyScaleImg);
        modifyBtn.setIcon(scaledIconModify);
		
// Create button reload 		
		JButton refreshBtn = new JButton("Refresh");
		refreshBtn.setFont(font_12_Thin);
		refreshBtn.setBounds(429, 1, 126, 57);
		toolTabTicketPanel.add(refreshBtn);
		ImageIcon iconRefresh = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//refresh_reload_icon.png");
		Image imgRefresh = iconRefresh.getImage();
        Image imgRefreshScale = imgRefresh.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaleIconRefresh = new ImageIcon(imgRefreshScale);
        refreshBtn.setIcon(scaleIconRefresh);
		
// Create Table
		tableTicket = new JTable();
		tableTicket.setBackground(Color.LIGHT_GRAY);
		tableTicket.setBounds(23, 0, 933, 597);
		tableTicket.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"Ticket ID", "Flight ", "Customer Name", "Employee Name", "Ticket Type", "Passenger Name", "Boarding Time", "Flight Date"
				}));
		JScrollPane tableTicketScrollPane = new JScrollPane(tableTicket);
		tableTicketScrollPane.setBounds(30, 91, 985, 590);
		JTableHeader tableTicketHeader = tableTicket.getTableHeader();
		tableTicketHeader.setFont(font_12_Thin);
		
		ticketManagementPanel.add(toolTabTicketPanel,BorderLayout.NORTH);
		ticketManagementPanel.add(tableTicketScrollPane, BorderLayout.CENTER);
		
		mainPanel.add(ticketManagementPanel);
	}
	
	public void createTabEmployeeManagement() {
		
		employeeManagerPanel = new JPanel();
		employeeManagerPanel.setBounds(230, 0, 1023, 683);
		employeeManagerPanel.setLayout(null);
		
		JPanel toolTabEmployeePanel = new JPanel();
		toolTabEmployeePanel.setBounds(10, 11, 1017, 80);
		toolTabEmployeePanel.setLayout(null);
		
// Create search		
		JLabel iconSearchJLabel = new JLabel("");
		iconSearchJLabel.setBounds(912, 16, 37, 31);
		toolTabEmployeePanel.add(iconSearchJLabel);
		
		searchEmpTextField = new JTextField();
		searchEmpTextField.setBackground(Color.WHITE);
		searchEmpTextField.setFont(font_16);
		searchEmpTextField.setBounds(575, 1, 355, 57);
		toolTabEmployeePanel.add(searchEmpTextField);
		searchEmpTextField.setColumns(10);
		
		JButton searchEmpBtn = new JButton("");
		searchEmpBtn.setBounds(940, 1, 64, 57);
		toolTabEmployeePanel.add(searchEmpBtn);
		ImageIcon searchIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//searchIcon.png");
		Image searchImg = searchIcon.getImage();
        Image imgSearchScale = searchImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledSearchIcon = new ImageIcon(imgSearchScale);
        searchEmpBtn.setIcon(scaledSearchIcon);
        
// Create button Add
		JButton addEmpBtn = new JButton("Add");
		addEmpBtn.setFont(font_12_Thin);
		addEmpBtn.setHideActionText(true);
		addEmpBtn.addActionListener(acTabEmployee);
		
		addEmpBtn.setBounds(21, 1, 126, 57);
		toolTabEmployeePanel.add(addEmpBtn);
		ImageIcon iconAdd = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//addIcon.png");
		Image addImg = iconAdd.getImage();
        Image imgAddScale = addImg.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconAdd = new ImageIcon(imgAddScale);
        addEmpBtn.setIcon(scaledIconAdd);
		
// Create button Delete
		JButton deleteEmpBtn = new JButton("Delete");
		deleteEmpBtn.setFont(font_12_Thin);
		deleteEmpBtn.addActionListener(acTabEmployee);
		
		deleteEmpBtn.setBounds(157, 1, 126, 57);
		toolTabEmployeePanel.add(deleteEmpBtn);
		ImageIcon deleteIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//deleteIcon.png");
		Image deleteImg = deleteIcon.getImage();
        Image deleteScaleImg = deleteImg.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDelete = new ImageIcon(deleteScaleImg);
        deleteEmpBtn.setIcon(scaledIconDelete);
		
// Create button Modify
		JButton modifyEmpBtn = new JButton("Modify");
		modifyEmpBtn.setFont(font_12_Thin);
		modifyEmpBtn.addActionListener(acTabEmployee);
		
		modifyEmpBtn.setBounds(293, 1, 126, 57);
		toolTabEmployeePanel.add(modifyEmpBtn);
		ImageIcon modifyIcon = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//settingIcon.png");
		Image modifyImg = modifyIcon.getImage();
        Image modifyScaleImg = modifyImg.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaledIconModify = new ImageIcon(modifyScaleImg);
        modifyEmpBtn.setIcon(scaledIconModify);
		
// Create button reload 		
		JButton refreshEmpTableBtn = new JButton("Refresh");
		refreshEmpTableBtn.setFont(font_12_Thin);
		refreshEmpTableBtn.addActionListener(acTabEmployee);
		
		refreshEmpTableBtn.setBounds(429, 1, 126, 57);
		toolTabEmployeePanel.add(refreshEmpTableBtn);
		ImageIcon iconRefresh = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//refresh_reload_icon.png");
		Image imgRefresh = iconRefresh.getImage();
        Image imgRefreshScale = imgRefresh.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaleIconRefresh = new ImageIcon(imgRefreshScale);
        refreshEmpTableBtn.setIcon(scaleIconRefresh);
				
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
						"ID", "Name", "Role", "Gender", "Date of birth", "Phone", "Address", "CitizenIdentify"
				}));
		
		final RowPopup popTableEmp =new RowPopup(tableEmployee);
		
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
		tableEmpScrollPane.setBounds(30, 91, 985, 590);
		JTableHeader tableEmpHeader = tableEmployee.getTableHeader();
		tableEmpHeader.setFont(font_12_Thin);
		
		loadDataTableEmployee();
		tableEmployee.setDefaultRenderer(String.class, centeRenderer);
		
		
		employeeManagerPanel.add(toolTabEmployeePanel,BorderLayout.NORTH);
		employeeManagerPanel.add(tableEmpScrollPane, BorderLayout.CENTER);
		
		mainPanel.add(employeeManagerPanel);
	}
	
	public void createNavigation() {
		JPanel navigationPanel = new JPanel();
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

	public void loadDataTableEmployee() {
		DefaultTableModel tableModel = (DefaultTableModel) tableEmployee.getModel();
		ArrayList<Employee> employees = this.employeeModel.getEmployees();
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
					e.getCitizenIdentify()
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
				this.employeeModel.remove(e);
				reloadTableEmployee();
				return;
			}	
		}
	}
	
	public void reloadTableEmployee() {
		DefaultTableModel tableModel = (DefaultTableModel) this.getTableEmployee().getModel();
		tableModel.getDataVector().removeAllElements();
		loadDataTableEmployee();
	}
	
	class RowPopup extends JPopupMenu {
		private static final long serialVersionUID = 365419627976873526L;
		
		public RowPopup(JTable table) {
			JMenuItem edit  = new JMenuItem("Edit");
			JMenuItem active = new JMenuItem("Active");
			
			active.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			this.add(edit);
			this.add(active);
		}
	}
	
//	"Flight ID", " AirCraft ", "Departure", "Destination", "Business ticket", "General ticket", "Take-Off Time", "Landing Time", "Status", "Price"
	public void loadDataTableFlight() {
		DefaultTableModel tableModel = (DefaultTableModel) tableFlight.getModel();
		ArrayList<Flight> flights = flightModel.getFlights();
		if(flights.isEmpty())
			return;
		for(Flight f: flights) {
			tableModel.addRow(new Object[] {
					f.getFlightId(),
					f.getAircraft(),
					f.getAirportByDepartureId().getAirportName(),
					f.getAirportByDestinationId().getAirportName(),
					f.getNumberOfBusinessSeats(),
					f.getNumberOfEconomySeats(),
					f.getTakeOffTime(),
					f.getLandingTime(),
					f.getStatus(),
					f.getBasicPrice()
			});
		}
	}
}
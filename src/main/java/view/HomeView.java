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
import controller.TabPaymentController;
import controller.TabTicketManagementController;
import dataAccessObject.AccountDAO;
import dataAccessObject.AircraftDAO;
import dataAccessObject.AirportDAO;
import dataAccessObject.EmployeeDAO;
import dataAccessObject.FlightDAO;
import dataAccessObject.TicketDAO;
import entities.Account;
import entities.Aircraft;
import entities.Airport;
import entities.Customer;
import entities.Employee;
import entities.Flight;
import entities.Invoice;
import entities.Ticket;
import model.AirCraftModel;
import model.AirportModel;
import model.CustomerModel;
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.Icon;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class HomeView extends JFrame {

	private Account loginAccount;
	private FlightModel listFlightWaiting;
	private CustomerModel listCustomerWaiting;
	private TicketModel listTicketWaiting;
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
	private JTable tableWaiting;
	private JPanel FlightManagement;
	private JPanel ticketManagementPanel;
	private JPanel employeeManagerPanel;
	private JPanel panelTabAccount;
	private JPanel panelTabPayment;
	public JButton btnStatistic;
	public JButton btnTicketMNM;
	public JButton btnFlightMNM;
	public JButton btnEmployeeMNM;
	public JButton btnPayment;
	public JButton searchTicketBtn;
	public JButton btnAccount;
	private JComboBox departureComboBox;
	private JComboBox destinationComboBox;
	private JLabel message;
	JDatePickerImpl dateDeparturePicker;
	private JDateChooser fromDateChooser;
	private JDateChooser toDateChoose;
	private boolean checkChangePassword;
	private JTextField TxtFCitizenidentifyValue;
	private JTextField TxtFRoleValue;
	private JTextField TxtFPhoneValue;
	private JTextField TxtFAddressValue;
	private JTextField TxtFGenderValue;
	private JTextField TxtFNameValue;
	private JLabel lblMessageRePass;
	private JLabel lblMessageCurrentPass;
	private JLabel lblMessageNewPassword;
	private JDateChooser dateChooserDateOfBirth;
	private JComboBox genderComboBox;
	DecimalFormat format = new DecimalFormat("###,###,###");

	public JButton PREBUTTON;
	public String selectedKey = "";
	
	ActionListener acNavigation = new NavigationController(this);
	ActionListener acTabEmployee = new TabEmployeeManagementController(this);
	ActionListener acTabFlight = new TabFlightManagementController(this);
	ActionListener acTabTicket = new TabTicketManagementController(this);
	ActionListener acTabPayment = new TabPaymentController(this);
	
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	Font font_JetBrains_14 = new Font("JetBrains Mono", Font.BOLD, 14);
	Font font_20 = new Font("Poppins", Font.BOLD, 18);
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_12 = new Font("Poppins", Font.BOLD, 12);
	Font font_14 = new Font("Poppins", Font.BOLD, 14);
	Font font_12_Thin = new Font("Poppins", Font.PLAIN, 12);
	Font font_8_Thin = new Font("Poppins", Font.PLAIN, 8);
	Font font_10 = new Font("Poppins", Font.BOLD, 10);
	private JTextField idExportFlight;
	private JPasswordField pfCurrentPassword;
	private JPasswordField pfNewPassword;
	private JPasswordField pfReNewPassword;
	private JButton btnPaymentTicket;

	public HomeView(Account account,LoginView loginView) {
		this.loginAccount = account;
		listCustomerWaiting = new CustomerModel();
		listFlightWaiting = new FlightModel();
		listTicketWaiting = new TicketModel();
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
		createTabAccount();
		createTabPayment();
		
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
	
	public void setEmptyAllList() {
		listCustomerWaiting.clearList();
		listFlightWaiting.clearList();
		listTicketWaiting.clearList();
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
	
	public void createTabPayment() {
		panelTabPayment = new JPanel();
		panelTabPayment.setBounds(260, 0, 993, 688);
		mainPanel.add(panelTabPayment);
		panelTabPayment.setLayout(null);
		
		btnPaymentTicket = new JButton("Payment");
		btnPaymentTicket.addActionListener(acTabPayment);
		btnPaymentTicket.setBounds(860, 639, 123, 39);
		btnPaymentTicket.setFont(font_JetBrains);
		panelTabPayment.add(btnPaymentTicket);
		
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
		
		JPanel panel = new JPanel(new GridLayout(1,4,15,0));
		panel.setBounds(0, 58, 489, 39);
		panelTabPayment.add(panel);
		
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
		
		tableWaiting = new JTable();
		tableWaiting.setDefaultEditor(Object.class, null);
		tableWaiting.setFont(font_JetBrains);
		tableWaiting.setBounds(23, 0, 933, 597);
		tableWaiting.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"STT", "Flight", "Passenger's Name","Phone", "Creator", "Ticket Type", "Boarding Time", "Flight Date"
				}));
		
		final RowPopupTableWaiting popupTableWaiting =new RowPopupTableWaiting(tableWaiting,this);
		
		tableWaiting.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					popupTableWaiting.show(e.getComponent(),e.getX(),e.getY());
				}
			}
		});
		
		tableWaiting.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		        int r = tableWaiting.rowAtPoint(e.getPoint());
		        if (r >= 0 && r < tableWaiting.getRowCount()) {
		        	tableWaiting.setRowSelectionInterval(r, r);
		        } else {
		        	tableWaiting.clearSelection();
		        }

		        int rowindex = tableWaiting.getSelectedRow();
		        if (rowindex < 0)
		            return;
		        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
		            JPopupMenu popup = popupTableWaiting;
		            popup.show(e.getComponent(), e.getX(), e.getY());
		        }
		    }
		});
		
		JScrollPane tableTicketBeingBooked = new JScrollPane(tableWaiting);
		tableTicketBeingBooked.setBounds(0, 117, 993, 512);
		JTableHeader tableWaitingHeader = tableTicket.getTableHeader();
		tableWaitingHeader.setFont(font_12_Thin);
		tableWaiting.setRowHeight(30);
		panelTabPayment.add(tableTicketBeingBooked);
		
		JLabel lblNewLabel_5 = new JLabel("Ticket list waiting for payment");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("JetBrains Mono Medium", Font.BOLD, 20));
		lblNewLabel_5.setBounds(239, -11, 539, 70);
		panelTabPayment.add(lblNewLabel_5);
		
		panelTabPayment.setVisible(false);
	}
	
	public void createTabAccount() {
		panelTabAccount = new JPanel();
		panelTabAccount.setBounds(260, 0, 993, 688);
		mainPanel.add(panelTabAccount);
		panelTabAccount.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("General account settings");
		lblNewLabel_4.setFont(new Font("Poppins", Font.BOLD, 20));
		lblNewLabel_4.setBounds(-1, 21, 288, 46);
		panelTabAccount.add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-1, 65, 984, 2);
		panelTabAccount.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBounds(9, 77, 974, 374);
		panelTabAccount.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(0, 1, 472, 36);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblName);
		lblName.setFont(font_JetBrains_14);
		
		TxtFNameValue = new JTextField("New label");
		TxtFNameValue.setBounds(437, 1, 255, 36);
		panel.add(TxtFNameValue);
		TxtFNameValue.setFont(font_JetBrains_14);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth");
		lblDateOfBirth.setBounds(0, 57, 472, 36);
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDateOfBirth);
		lblDateOfBirth.setFont(font_JetBrains_14);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(0, 113, 472, 36);
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGender);
		lblGender.setFont(font_JetBrains_14);
		
		genderComboBox = new JComboBox();
		genderComboBox.setBounds(0, 43, 130, -43);
		genderComboBox.setFont(font_JetBrains_14);
		genderComboBox.addItem("Male");
		genderComboBox.addItem("Female");
		panel.add(genderComboBox);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(0, 169, 472, 36);
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAddress);
		lblAddress.setFont(font_JetBrains_14);
		
		TxtFAddressValue = new JTextField("New label");
		TxtFAddressValue.setBounds(437, 169, 255, 36);
		panel.add(TxtFAddressValue);
		TxtFAddressValue.setFont(font_JetBrains_14);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(0, 225, 472, 36);
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPhone);
		lblPhone.setFont(font_JetBrains_14);
		
		TxtFPhoneValue = new JTextField("New label");
		TxtFPhoneValue.setBounds(437, 225, 255, 36);
		TxtFPhoneValue.setFont(font_JetBrains_14);
		panel.add(TxtFPhoneValue);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(0, 281, 472, 36);
		lblRole.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRole);
		lblRole.setFont(font_JetBrains_14);
		
		TxtFRoleValue = new JTextField("New label");
		TxtFRoleValue.setBounds(437, 281, 255, 36);
		panel.add(TxtFRoleValue);
		TxtFRoleValue.setFont(font_JetBrains_14);
		
		JLabel lblCitizenidentify = new JLabel("Citizenidentify");
		lblCitizenidentify.setBounds(0, 337, 472, 36);
		lblCitizenidentify.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCitizenidentify);
		lblCitizenidentify.setFont(font_JetBrains_14);
		
		TxtFCitizenidentifyValue = new JTextField("New label");
		TxtFCitizenidentifyValue.setBounds(437, 337, 255, 36);
		panel.add(TxtFCitizenidentifyValue);
		TxtFCitizenidentifyValue.setFont(font_JetBrains_14);
		
		JButton changeBtn = new JButton("Change info");
		changeBtn.setFont(font_JetBrains);
		changeBtn.setBounds(733, 340, 241, 32);
		panel.add(changeBtn);
		
		dateChooserDateOfBirth = new JDateChooser();
		dateChooserDateOfBirth.getComponent(1).setFont(font_JetBrains_14);
		dateChooserDateOfBirth.setBounds(437, 57, 255, 36);
		panel.add(dateChooserDateOfBirth);
		
		genderComboBox = new JComboBox();
		genderComboBox.addItem("Male");
		genderComboBox.addItem("Female");
		genderComboBox.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		genderComboBox.setBounds(437, 114, 255, 37);
		panel.add(genderComboBox);
		
		changeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(changeBtn.getText().equals("Change info")) {
					dateChooserDateOfBirth.setEnabled(true);;
					genderComboBox.enable();
					TxtFAddressValue.setEditable(true);
					TxtFPhoneValue.setEditable(true);
					changeBtn.setText("Save");
				} else {
					int choose = JOptionPane.showConfirmDialog(panelTabAccount, "Are you sure save this info?");
					if(choose==0)
					{
						saveInfoAccount();
						changeBtn.setText("Change info");
					}
				}
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(149, 515, 539, 173);
		panelTabAccount.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCurrentPassword = new JLabel("Current password");
		lblCurrentPassword.setBounds(0, 1, 258, 37);
		lblCurrentPassword.setFont(font_JetBrains);
		lblCurrentPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblCurrentPassword);
		
		pfCurrentPassword = new JPasswordField();
		pfCurrentPassword.setBounds(258, 1, 258, 37);
		panel_1.add(pfCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New password");
		lblNewPassword.setBounds(0, 42, 258, 37);
		lblNewPassword.setFont(font_JetBrains);
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewPassword);
		
		pfNewPassword = new JPasswordField();
		pfNewPassword.setBounds(258, 42, 258, 37);
		panel_1.add(pfNewPassword);
		
		JLabel lblReNewPassword = new JLabel("Re-enter new password");
		lblReNewPassword.setBounds(0, 83, 258, 37);
		lblReNewPassword.setFont(font_JetBrains);
		lblReNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblReNewPassword);
		
		pfReNewPassword = new JPasswordField();
		pfReNewPassword.setBounds(258, 83, 258, 37);
		panel_1.add(pfReNewPassword);
		
		JButton btnSaveChange = new JButton("Save change");
		btnSaveChange.setFont(font_JetBrains);
		btnSaveChange.setBounds(122, 126, 258, 37);
		panel_1.add(btnSaveChange);
		btnSaveChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changePassword();
			}
		});
		
		JLabel lblChangePassword = new JLabel("Change password");
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(font_JetBrains_14);
		lblChangePassword.setBounds(298, 482, 203, 23);
		panelTabAccount.add(lblChangePassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-1, 470, 984, 2);
		panelTabAccount.add(separator_1);
		
		lblMessageCurrentPass = new JLabel("");
		lblMessageCurrentPass.setForeground(Color.RED);
		lblMessageCurrentPass.setBounds(697, 528, 203, 13);
		panelTabAccount.add(lblMessageCurrentPass);
		
		lblMessageNewPassword = new JLabel("");
		lblMessageNewPassword.setForeground(Color.RED);
		lblMessageNewPassword.setBounds(697, 571, 203, 13);
		panelTabAccount.add(lblMessageNewPassword);
		
		lblMessageRePass = new JLabel("");
		lblMessageRePass.setForeground(Color.RED);
		lblMessageRePass.setBounds(697, 616, 203, 13);
		panelTabAccount.add(lblMessageRePass);
		
		loadInfoUserToCell();
		panelTabAccount.setVisible(false);
	}
	
	public void saveInfoAccount() {
		Employee employee = loginAccount.getEmployee();
		employee.setDateOfBirth(dateChooserDateOfBirth.getDate());
		employee.setGender(genderComboBox.getSelectedItem()+"");
		employee.setAddress(TxtFAddressValue.getText());
		employee.setPhone(TxtFPhoneValue.getText());
		EmployeeDAO.getInstance().update(employee);
		dateChooserDateOfBirth.setEnabled(false);;
		genderComboBox.disable();
		TxtFAddressValue.setEditable(false);
		TxtFPhoneValue.setEditable(false);
	}
	
	public void changePassword() {
		String currentPassword = this.pfCurrentPassword.getText();
		String newPassword = this.pfNewPassword.getText();
		String reNewPassword = this.pfReNewPassword.getText();
		lblMessageCurrentPass.setText("");
		lblMessageRePass.setText("");
		if(!currentPassword.equals(loginAccount.getPassword())) {
			lblMessageCurrentPass.setText("Current password is incorrect!");
		} else {
			if(!reNewPassword.equals(newPassword)) {
				lblMessageRePass.setText("password incorrect!");
			} else {
				int choose = JOptionPane.showConfirmDialog(null, "Are you sure change password?");
				if(choose==0) {
					loginAccount.setPassword(reNewPassword);
					AccountDAO.getInstance().update(loginAccount);
					JOptionPane.showMessageDialog(null, "Change success");
					this.pfCurrentPassword.setText("");
					this.pfNewPassword.setText("");
					this.pfReNewPassword.setText("");
				}
			}
		}
	}
	
	public void loadInfoUserToCell() {
		Employee employeeLogin = loginAccount.getEmployee();
		TxtFNameValue.setText(employeeLogin.getEmployeeName());
		TxtFNameValue.setEditable(false);
		dateChooserDateOfBirth.setDate(employeeLogin.getDateOfBirth());
		dateChooserDateOfBirth.setEnabled(false);
		genderComboBox.setSelectedItem(employeeLogin.getGender());
		genderComboBox.disable();
		TxtFAddressValue.setText(employeeLogin.getAddress());
		TxtFAddressValue.setEditable(false);
		TxtFPhoneValue.setText(employeeLogin.getPhone());
		TxtFPhoneValue.setEditable(false);
		TxtFRoleValue.setText(employeeLogin.getRole());
		TxtFRoleValue.setEditable(false);
		TxtFCitizenidentifyValue.setText(employeeLogin.getCitizenIdentify());
		TxtFCitizenidentifyValue.setEditable(false);
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
		tableFlight.setRowHeight(30);
		
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
		
		refreshTableFlight();
		FlightManagement.add(toolFlightPanel);
		// Departure
			JLabel departureLable = new JLabel("Departure:");
			departureLable.setBounds(18, 88, 97, 14);
			toolFlightPanel.add(departureLable);
			departureLable.setFont(font_16);
			
			departureComboBox = new JComboBox();
			departureComboBox.setBounds(125, 79, 198, 31);
			toolFlightPanel.add(departureComboBox);
			departureComboBox.setFont(font_JetBrains);
			
	// Destination
			JLabel destinationLable = new JLabel("Destination:");
			destinationLable.setBounds(444, 87, 108, 14);
			toolFlightPanel.add(destinationLable);
			destinationLable.setFont(font_16);
			
			destinationComboBox = new JComboBox();
			destinationComboBox.setBounds(562, 79, 198, 31);
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
			
			JButton btnReverse = new JButton("Reverse");
			btnReverse.addActionListener(acTabFlight);
			btnReverse.setBounds(343, 80, 83, 31);
			toolFlightPanel.add(btnReverse);
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
		refreshTableTicket();
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Enter flight: ");
		lblNewLabel_2.setBounds(18, 78, 101, 32);
		toolTabTicketPanel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(font_JetBrains);
		
		idExportFlight = new JTextField();
		ArrayList<Ticket> tickets = TicketDAO.getInstance().selectAll();
		idExportFlight.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				String condition = idExportFlight.getText() +e.getKeyChar();
				ArrayList<Ticket> show = new ArrayList<>();
				try {
					for(Ticket ticket :tickets) {
						if(ticket.getFlight().getFlightId().equals(condition)) {
							show.add(ticket);
						}
					}
					if(!show.isEmpty())
						loadDataTableTicket(show);
					else
						refreshTableTicket();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		idExportFlight.setBounds(140, 80, 222, 32);
		toolTabTicketPanel.add(idExportFlight);
		idExportFlight.setColumns(10);
		ticketManagementPanel.add(tableTicketScrollPane, BorderLayout.CENTER);
		
		mainPanel.add(ticketManagementPanel);
		
		JButton exportBtn = new JButton("Export");
		exportBtn.addActionListener(acTabTicket);
		exportBtn.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		exportBtn.setBounds(905, 645, 110, 35);
		ticketManagementPanel.add(exportBtn);
		
		message = new JLabel("");
		message.setBounds(30, 648, 683, 25);
		ticketManagementPanel.add(message);
		message.setForeground(Color.RED);
		message.setFont(font_JetBrains);
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
		
		refreshTableEmployee();
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
		navigationPanel.setBounds(0,90,250,352);
		mainPanel.add(navigationPanel);
		navigationPanel.setLayout(null);
		navigationPanel.setLayout(new GridLayout(6,1));
		
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
        
        btnPayment = new JButton("PAYMENT");
        btnPayment.addActionListener(acNavigation);
        btnPayment.setOpaque(true);
        btnPayment.setBorderPainted(false);
        
        btnPayment.setHorizontalAlignment(SwingConstants.LEFT);
        btnPayment.setFont(font_12);
        btnPayment.setBounds(6, 0, 239, 80);
        JLabel iconInvoiceManagementJLabel = new JLabel("");
		iconInvoiceManagementJLabel.setBounds(20, 25, 36, 32);
        ImageIcon iconInvoice = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//invoiceIcon.png");
		Image imgInvoice = iconInvoice.getImage();
        Image imgInvoiceScale = imgInvoice.getScaledInstance(iconInvoiceManagementJLabel.getWidth(), iconInvoiceManagementJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconInvoice = new ImageIcon(imgInvoiceScale);
        btnPayment.setIcon(scaledIconInvoice);
        navigationPanel.add(btnPayment);

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
        
//Create Button Account
        
        btnAccount = new JButton("ACCOUNT");
        btnAccount.addActionListener(acNavigation);
        btnAccount.setOpaque(true);
        btnAccount.setBorderPainted(false);
        btnAccount.setHorizontalAlignment(SwingConstants.LEFT);
        btnAccount.setFont(font_12);
        btnAccount.setBounds(6, 0, 239, 80);
        
        JLabel iconAccountJLb = new JLabel("");
        iconAccountJLb.setBounds(20, 25, 36, 32);
        ImageIcon iconAccount = new ImageIcon("..//FlightTicketManagementSoftware//src//main//resources//Icon//userIcon.png");
		Image imgAccount = iconAccount.getImage();
        Image imgAccountScale = imgAccount.getScaledInstance(iconAccountJLb.getWidth(), iconAccountJLb.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconAccount = new ImageIcon(imgAccountScale);
        btnAccount.setIcon(scaledIconAccount);
        navigationPanel.add(btnAccount);
	}
	
	
	
	public TicketModel getListTicketWaiting() {
		return listTicketWaiting;
	}

	public void setListTicketWaiting(TicketModel listTicketWaiting) {
		this.listTicketWaiting = listTicketWaiting;
	}

	public JPanel getPanelTabPayment() {
		return panelTabPayment;
	}

	public void setPanelTabPayment(JPanel panelTabPayment) {
		this.panelTabPayment = panelTabPayment;
	}

	public JPanel getPanelTabAccount() {
		return panelTabAccount;
	}

	public void setPanelTabAccount(JPanel panelTabAccount) {
		this.panelTabAccount = panelTabAccount;
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
	
	public FlightModel getListFlightWaiting() {
		return listFlightWaiting;
	}

	public void setListFlightWaiting(FlightModel listFlightWaiting) {
		this.listFlightWaiting = listFlightWaiting;
	}

	public CustomerModel getListCustomerWaiting() {
		return listCustomerWaiting;
	}

	public void setListCustomerWaiting(CustomerModel listCustomerWaiting) {
		this.listCustomerWaiting = listCustomerWaiting;
	}

	public void refreshTableEmployee() {
		ArrayList<Employee> employees = EmployeeDAO.getInstance().selectAll();
		loadDataTableEmployee(employees);
	}

	public void refreshTableFlight() {
		ArrayList<Flight> flights = FlightDAO.getInstance().selectFromToday();
		loadDataTableFlight(flights);
	}
	
	public void refreshTableTicket() {
		ArrayList<Ticket> tickets = TicketDAO.getInstance().selectAll();
		loadDataTableTicket(tickets);
	}
	
	public void refreshTableWaiting() {
		loadDataTableWaiting(listTicketWaiting.getTickets());
	}
	
	public void reverseLocation() {
		String departure = departureComboBox.getSelectedItem() +"";
		String destination = destinationComboBox.getSelectedItem() +"";
		departureComboBox.setSelectedItem(destination);
		destinationComboBox.setSelectedItem(departure);
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
	
	public void lockEmployee() {
		int rowIndex = this.getTableEmployee().getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.getTableEmployee().getModel();
		int idSelect = Integer.valueOf(tableModel.getValueAt(rowIndex, 0)+"");
		ArrayList<Employee> employees = EmployeeDAO.getInstance().selectAll();
		for(int i=0;i<employees.size();i++) {
			if(employees.get(i).getEmployeeId()==idSelect) {
				employees.get(i).setIsActive(0);
				EmployeeDAO.getInstance().update(employees.get(i));
				break;
			}	
		}
		loadDataTableEmployee(employees);
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
		int rowIndex = tableFlight.getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) tableFlight.getModel();
		String flightId = tableModel.getValueAt(rowIndex, 0)+"";
		Flight flight = FlightDAO.getInstance().selectById(flightId);
		flight.setIsActive(0);
		FlightDAO.getInstance().update(flight);
	}
	
	public void handlePayment() {
		
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
	
	public void loadDataTableWaiting(ArrayList<Ticket> tickets) {
		DefaultTableModel tableModel = (DefaultTableModel) tableWaiting.getModel();
		tableModel.getDataVector().removeAllElements();
		if(tickets.isEmpty())
			return;
		int stt =1;
		for(int i = tickets.size()-1;i>=0;i--) {
			tableModel.addRow(new Object[] {
					stt,
					tickets.get(i).getFlight().getFlightId(),
					tickets.get(i).getPassengerName(),
					tickets.get(i).getCustomer().getPhone(),
					tickets.get(i).getEmployee().getEmployeeName(),
					tickets.get(i).getTicketclass().getTicketClassType(),
					tickets.get(i).getFlight().getTakeOffTime(),
					tickets.get(i).getFlight().getFlightDate()
			});
			stt++;
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
			String flightId = row.getCell(0).getStringCellValue();
			Aircraft aircraft = AircraftDAO.getInstance().selectById(row.getCell(1).getStringCellValue());
			Airport departureAirport = AirportDAO.getInstance().selectById(row.getCell(2).getStringCellValue());
			Airport destinationAirport = AirportDAO.getInstance().selectById(row.getCell(3).getStringCellValue());
			java.util.Date flightDate = row.getCell(4).getDateCellValue();
			String takeOfTime = formatter.formatCellValue(row.getCell(5));
			String landingTime = formatter.formatCellValue(row.getCell(6));
			int numberBusinessSeats = aircraft.getBusinessClassSeats();
			int numberEconomySeats = aircraft.getEconomyClassSeats();
			String price = formatter.formatCellValue(row.getCell(7));
			Flight flight = new Flight(flightId, aircraft, departureAirport, destinationAirport, takeOfTime
					, landingTime, flightDate, numberEconomySeats, numberBusinessSeats, "Waiting", price, 1, null);
			FlightDAO.getInstance().add(flight);
		}
		refreshTableFlight();
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
		ArrayList<Employee> employees = EmployeeDAO.getInstance().selectAll();
		ArrayList<Employee> listResultSearch = new ArrayList<Employee>();
		for(Employee e: employees) {
			String name = e.getEmployeeName().toLowerCase();
			String phone = e.getPhone();
			if(name.contains(search) || phone.contains(search)) { 
				listResultSearch.add(e);
			}
		}
		if(!listResultSearch.isEmpty())
			loadDataTableEmployee(listResultSearch);
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
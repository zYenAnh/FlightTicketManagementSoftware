package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controller.CustomKeyListener;
import controller.InployeeInformationEntryFormController;
import dataAccessObject.AccountDAO;
import dataAccessObject.EmployeeDAO;
import entities.Account;
import entities.Employee;
import model.Province;

public class EmployeeInformationEntryForm extends JFrame {

	private HomeView homeView;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField dateofbirth;
	private JTextField citizenidentifyTextField;
	private JTextField phoneTextField;
	private ActionListener empIEFController;
	private JComboBox genderComboBox;
	private JComboBox roleComboBox;
	private JTextField address;
	private JDateChooser dateChooser;
	
	public int rowSelectedIndex;
	
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_14_Thin = new Font("Poppins", Font.PLAIN, 14);
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	
	/**
	 * Create the frame.
	 */
	public EmployeeInformationEntryForm(HomeView homeView) {
		empIEFController = new InployeeInformationEntryFormController(this);
		this.homeView = homeView;
		rowSelectedIndex = homeView.getTableEmployee().getSelectedRow();
		setSize(450, 550);
		setLocationRelativeTo(null);	
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBounds(32, 60, 379, 369);
		inputPanel.setLayout(new GridLayout(7,2,0,20));
		
		contentPane.add(inputPanel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(font_14_Thin);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.addKeyListener(new CustomKeyListener(nameTextField,50));
		nameTextField.setFont(font_JetBrains);
		nameTextField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel roleLable = new JLabel("Role");
		roleLable.setFont(font_14_Thin);
		roleLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(roleLable);
		
		roleComboBox = new JComboBox();
		roleComboBox.setFont(font_JetBrains);
		roleComboBox.addItem("Management Staff");
		roleComboBox.addItem("Ticket Seller");
		inputPanel.add(roleComboBox);
		
		JLabel genderLable = new JLabel("Gender");
		genderLable.setFont(font_14_Thin);
		genderLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(genderLable);
		
		genderComboBox = new JComboBox();
		genderComboBox.setFont(font_JetBrains);
		genderComboBox.addItem("Male");
		genderComboBox.addItem("Female");
		inputPanel.add(genderComboBox);
		
		JLabel dateOfBirthLable = new JLabel("Date Of Birth");
		dateOfBirthLable.setFont(font_14_Thin);
		dateOfBirthLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(dateOfBirthLable);
		
		dateChooser = new JDateChooser();
		inputPanel.add(dateChooser);
				
		JLabel addressLable = new JLabel("Address");
		addressLable.setFont(font_14_Thin);
		addressLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(addressLable);
					
		address = new JTextField();
		address.setFont(font_JetBrains);
		inputPanel.add(address);
		
		JLabel citizenIdentifyLable = new JLabel("CitizenIdentify");
		citizenIdentifyLable.setFont(font_14_Thin);
		citizenIdentifyLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(citizenIdentifyLable);
		
		citizenidentifyTextField = new JTextField();
		citizenidentifyTextField.addKeyListener(new CustomKeyListener(citizenidentifyTextField,50));
		citizenidentifyTextField.setFont(font_JetBrains);
		citizenidentifyTextField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(citizenidentifyTextField);
		citizenidentifyTextField.setColumns(10);
		
		JLabel phoneLable = new JLabel("Phone");
		phoneLable.setFont(font_14_Thin);
		phoneLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(phoneLable);
		
		phoneTextField = new JTextField();
		phoneTextField.addKeyListener(new CustomKeyListener(phoneTextField, 10));
		phoneTextField.setFont(font_JetBrains);
		phoneTextField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(phoneTextField);
		phoneTextField.setColumns(10);
		
		JLabel Tiltle = new JLabel("Staff Infomation");
		Tiltle.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 30));
		Tiltle.setHorizontalAlignment(SwingConstants.CENTER);
		Tiltle.setBounds(72, 11, 304, 38);
		contentPane.add(Tiltle);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(72, 451, 304, 51);
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
		if(this.homeView.selectedKey=="Modify")
			loadInfoEmployeeToInputCell();
	}
	
	public void closeForm() {
		this.dispose();
	}
	
	public void updateEmployee(Employee e) {
		int rowIndex = this.homeView.getTableEmployee().getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.homeView.getTableEmployee().getModel();
		int employeeId = Integer.valueOf(tableModel.getValueAt(rowIndex, 0)+"");
		e.setEmployeeId(employeeId);
		EmployeeDAO.getInstance().update(e);
		ArrayList<Employee> employees = EmployeeDAO.getInstance().selectAll();
		this.homeView.loadDataTableEmployee(employees);
	}
	
	public int insertEmployee(Employee e) {
		int checkAddEmp =0;
		checkAddEmp = EmployeeDAO.getInstance().add(e);
		if(checkAddEmp!=0) {
			ArrayList<Employee> employees = EmployeeDAO.getInstance().selectAll();
			this.homeView.loadDataTableEmployee(employees);
			return checkAddEmp;
		} else {
				JOptionPane.showMessageDialog(null,"Employee already exists, please re-enter");
		}
		return checkAddEmp;
	}
	
	public String getSelectedKey() {
		return this.homeView.selectedKey;
	}
	
	public Employee createEmployeeFromInputCell() {
		String name = this.nameTextField.getText();
		String address = this.address.getText();
		String citizenidentify = this.citizenidentifyTextField.getText();
		java.util.Date dateSelected = this.dateChooser.getDate();
		String phone = this.phoneTextField.getText();
		String gender = this.genderComboBox.getSelectedItem()+"";
		String role = this.roleComboBox.getSelectedItem()+"";
		return new Employee(name, citizenidentify, dateSelected, gender, address, phone, role, 1, null, null, null);
	}
	
	public void loadInfoEmployeeToInputCell() {
		int rowIndex = this.homeView.getTableEmployee().getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.homeView.getTableEmployee().getModel();
		int employeeId = Integer.valueOf(tableModel.getValueAt(rowIndex, 0)+"");
		Employee employee = EmployeeDAO.getInstance().selectById(employeeId);
		this.nameTextField.setText(employee.getEmployeeName());
		this.roleComboBox.setSelectedItem(tableModel.getValueAt(rowIndex, 2));
		this.genderComboBox.setSelectedItem(employee.getGender());
		this.dateChooser.setDate(employee.getDateOfBirth());
		this.phoneTextField.setText(employee.getPhone());
		this.address.setText(employee.getAddress());
		this.citizenidentifyTextField.setText(employee.getCitizenIdentify());
	}
}

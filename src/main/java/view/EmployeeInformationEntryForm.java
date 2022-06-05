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

import org.jdatepicker.DateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import org.jdatepicker.impl.UtilDateModel;

import controller.InployeeInformationEntryFormController;
import dataAccessObject.AccountDAO;
import dataAccessObject.EmployeeDAO;
import entities.Account;
import entities.Employee;
import entities.Province;

public class EmployeeInformationEntryForm extends JFrame {

	private HomeView homeView;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField dateofbirth;
	private JTextField citizenidentifyTextField;
	private JTextField phoneTextField;
	private ActionListener empIEFController;
	private JDatePickerImpl dateDeparturePicker;
	private JComboBox genderComboBox;
	private JComboBox roleComboBox;
	private JComboBox address;
	
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
		dateDeparturePicker.getComponent(0).setPreferredSize(new Dimension(80,34)); //JFormattedTextField
		dateDeparturePicker.getComponent(1).setPreferredSize(new Dimension(40,20));
		
		dateDeparturePicker.getJFormattedTextField().setHorizontalAlignment(SwingConstants.LEFT);
		
		inputPanel.add(dateDeparturePicker);
				
		JLabel addressLable = new JLabel("Address");
		addressLable.setFont(font_14_Thin);
		addressLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(addressLable);
					
		address = new JComboBox();
		address.setFont(font_JetBrains);
		ArrayList<Province> provinces = Province.getDSTinh();
		for(Province p: provinces) {
			address.addItem(p.getTenTinhString());
		}
		
		inputPanel.add(address);
		
		JLabel citizenIdentifyLable = new JLabel("CitizenIdentify");
		citizenIdentifyLable.setFont(font_14_Thin);
		citizenIdentifyLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(citizenIdentifyLable);
		
		citizenidentifyTextField = new JTextField();
		citizenidentifyTextField.setFont(font_JetBrains);
		citizenidentifyTextField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		inputPanel.add(citizenidentifyTextField);
		citizenidentifyTextField.setColumns(10);
		
		JLabel phoneLable = new JLabel("Phone");
		phoneLable.setFont(font_14_Thin);
		phoneLable.setHorizontalAlignment(SwingConstants.CENTER);
		inputPanel.add(phoneLable);
		
		phoneTextField = new JTextField();
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
			loadEmpToInputCell();
	}
	
	public void closeForm() {
		this.setVisible(false);
	}
	
	public void updateEmp(Employee e, int rowIndex) {
		EmployeeDAO.getInstance().update(e);
		DefaultTableModel tableModel = (DefaultTableModel) this.homeView.getTableEmployee().getModel();
		ArrayList<Employee> employees = this.homeView.getEmployeeModel().getEmployees();
		for(int i=0;i<employees.size();i++) {
			if(e.getEmployeeId().equals(employees.get(i).getEmployeeId())) {
				this.homeView.getEmployeeModel().getEmployees().set(i, e);
				break;
			}
		}
		tableModel.setValueAt(e.getEmployeeName(), rowIndex, 1);
		tableModel.setValueAt(e.getRole(), rowIndex, 2);
		tableModel.setValueAt(e.getGender(), rowIndex, 3);
		tableModel.setValueAt(e.getDateOfBirth(), rowIndex, 4);
		tableModel.setValueAt(e.getPhone(), rowIndex, 5);
		tableModel.setValueAt(e.getAddress(), rowIndex, 6);
		tableModel.setValueAt(e.getCitizenIdentify(), rowIndex, 7);
	}
	
	public int addEmp(Employee e) {
		int checkAddEmp =0;
		checkAddEmp = EmployeeDAO.getInstance().add(e);
		if(checkAddEmp!=0) {
			this.homeView.getEmployeeModel().insert(e);
			this.homeView.reloadTableEmployee();
			return checkAddEmp;
		} else {
				JOptionPane.showMessageDialog(null,"Employee already exists, please re-enter");
		}
		return checkAddEmp;
	}
	
	public String getSelectedKey() {
		return this.homeView.selectedKey;
	}
	
	public Employee getDataFromEmployeeInput() {
		DefaultTableModel tableModel = (DefaultTableModel) this.homeView.getTableEmployee().getModel();
		int rowIndex = this.homeView.getTableEmployee().getSelectedRow();
		Employee result = new Employee();
		if(rowIndex!=-1)
			result.setEmployeeId(Integer.valueOf(tableModel.getValueAt(rowIndex, 0)+""));
		result.setEmployeeName(this.nameTextField.getText());
		result.setAddress(this.address.getSelectedItem()+"");
		result.setCitizenIdentify(this.citizenidentifyTextField.getText());
		Date dateSelected = (Date) this.dateDeparturePicker.getModel().getValue();
		result.setDateOfBirth(dateSelected);
		result.setPhone(this.phoneTextField.getText());
		result.setGender(this.genderComboBox.getSelectedItem()+"");
		result.setRole(this.roleComboBox.getSelectedItem()+"");
		return result;
	}
	
	public void loadEmpToInputCell() {
		int rowIndex = this.homeView.getTableEmployee().getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) this.homeView.getTableEmployee().getModel();
		this.nameTextField.setText(tableModel.getValueAt(rowIndex, 1)+"");
		this.roleComboBox.setSelectedItem(tableModel.getValueAt(rowIndex, 2));
		this.genderComboBox.setSelectedItem(tableModel.getValueAt(rowIndex, 3));
			
		Date date = (Date) tableModel.getValueAt(rowIndex, 4);
		this.phoneTextField.setText(tableModel.getValueAt(rowIndex, 5)+"");
		this.address.setSelectedItem(tableModel.getValueAt(rowIndex, 6));
		this.citizenidentifyTextField.setText(tableModel.getValueAt(rowIndex, 7)+"");
	}
}

package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import dataAccessObject.AccountDAO;
import entities.Account;
import entities.Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FromCreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTxtF;
	private JPasswordField passwordTxtF;
	private JPasswordField rePasswordTxtF;
	private JComboBox authorCbb;
	private JTable getTable;
	private HomeView homeView;
	

	public FromCreateAccount(JTable table,HomeView homeView) {
		this.getTable = table;
		this.homeView = homeView;
		setBounds(100, 100, 634, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Ticket");
		lblNewLabel.setBounds(5, 5, 602, 46);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel(new GridLayout(4,2,10,20));
		panel.setBounds(93, 61, 436, 185);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		usernameTxtF = new JTextField();
		panel.add(usernameTxtF);
		usernameTxtF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		passwordTxtF = new JPasswordField();
		panel.add(passwordTxtF);
		
		JLabel lblNewLabel_2_1 = new JLabel("Re-enter password:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2_1);
		
		rePasswordTxtF = new JPasswordField();
		panel.add(rePasswordTxtF);
		
		JLabel lblNewLabel_3 = new JLabel("Authorities:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		authorCbb = new JComboBox();
		authorCbb.addItem("Management Staff");
		authorCbb.addItem("Ticket Seller");
		authorCbb.setSelectedIndex(-1);
		panel.add(authorCbb);
		FromCreateAccount form = this;
		
		JButton saveBtn = new JButton("Save");
		saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(usernameTxtF.getText().equals("") || passwordTxtF.getText().equals("") || authorCbb.getSelectedIndex()==-1) {
					JOptionPane.showMessageDialog(form, "Please enter full information!");
				} else {
					if(passwordTxtF.getText().equals(rePasswordTxtF.getText())) {
						int choose = JOptionPane.showConfirmDialog(form, "Are you sure create account?");
						if(choose ==0) {
							createAccount(getInfoAccountFromCell());
							JOptionPane.showMessageDialog(form, "Create Account Success");
							closeForm();
						}
					} else {
						JOptionPane.showMessageDialog(form, "Please re-verify your password!");
					}					
				}
			}
		});
		saveBtn.setBounds(261, 268, 121, 32);
		contentPane.add(saveBtn);
	}
	
	public void closeForm() {
		this.dispose();
	}
	
	public void createAccount(Account account) {
		AccountDAO.getInstance().add(account);
	}
	
	public Account getInfoAccountFromCell() {
		int rowSelect = getTable.getSelectedRow();
		DefaultTableModel tableModel = (DefaultTableModel) getTable.getModel();
		Employee employee = this.homeView.getEmployeeModel().searchEmployeeById(Integer.valueOf((tableModel.getValueAt(rowSelect, 0)+"")));
		String username = usernameTxtF.getText();
		String password = passwordTxtF.getText();
		String role = authorCbb.getSelectedItem()+"";
		return new Account(username, employee, password, role, 1);
	}
}

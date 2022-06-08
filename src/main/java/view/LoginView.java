package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import javassist.expr.Instanceof;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import controller.LoginController;
import dataAccessObject.AccountDAO;
import entities.Account;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private ActionListener acLoginController;
	private JLabel messageLogin;
	
	
	Font font_JetBrains = new Font("JetBrains Mono", Font.BOLD, 12);
	Font font_12 = new Font("Poppins", Font.BOLD, 12);
	Font font_12_Thin = new Font("Poppins", Font.PLAIN, 12);
	Font font_16_Thin = new Font("Poppins", Font.PLAIN, 16);
	Font font_20_Thin = new Font("Poppins", Font.PLAIN, 20);
	Font font_32_Thin = new Font("Poppins", Font.PLAIN, 32);
	public JButton loginBtn;

	/**
	 * Create the frame.
	 */
	public LoginView() {
		acLoginController = new LoginController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,500);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel centerJPanel = new JPanel();
		centerJPanel.setBounds(0, 0, 699, 472);
		getContentPane().add(centerJPanel);
		centerJPanel.setLayout(null);
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(font_JetBrains);
		usernameTextField.setMargin(new Insets(0,12,0,0));
		usernameTextField.setForeground(Color.BLACK);
		usernameTextField.setBounds(157, 200, 357, 38);
		centerJPanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(font_JetBrains);
		passwordTextField.setMargin(new Insets(0,12,0,0));
		passwordTextField.setToolTipText("");
		passwordTextField.setBounds(157, 284, 357, 38);
		centerJPanel.add(passwordTextField);
		        
        loginBtn = new JButton("LOGIN");
        loginBtn.setFont(font_20_Thin);
        loginBtn.setBounds(214, 361, 263, 49);
        centerJPanel.add(loginBtn);
        loginBtn.addActionListener(acLoginController);
          
        JLabel titleLable = new JLabel("AIRCRAFT TICKET MANAGEMENT SYSTEM");
        titleLable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        titleLable.setFont(new Font("Poppins", Font.BOLD | Font.ITALIC, 32));
        titleLable.setBounds(0, 23, 689, 63);
        centerJPanel.add(titleLable);
        titleLable.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel usernameLable = new JLabel("Username");
        usernameLable.setFont(font_16_Thin);
        usernameLable.setBounds(157, 175, 96, 14);
        centerJPanel.add(usernameLable);
        
        JLabel passwordLable = new JLabel("Password");
        passwordLable.setFont(font_16_Thin);
        passwordLable.setBounds(157, 259, 96, 14);
        centerJPanel.add(passwordLable);
        
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setFont(new Font("Poppins", Font.PLAIN, 30));
        loginLabel.setBounds(140, 108, 391, 38);
        centerJPanel.add(loginLabel);
        
        messageLogin = new JLabel("");
        messageLogin.setHorizontalAlignment(SwingConstants.RIGHT);
        messageLogin.setForeground(Color.RED);
        messageLogin.setFont(font_JetBrains);
        messageLogin.setBounds(157, 336, 357, 14);
        centerJPanel.add(messageLogin);
	}
	
	public void handleLogin() 
	{
		String username = this.usernameTextField.getText();
		String password = this.passwordTextField.getText();
		if(username.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "You have not entered your username or password! Please re-enter!");
		} else {
			String condition = "Username = " + "'" +username+ "'" + " AND Password = " +"'" + password+"'";
			List<Account> accounts = AccountDAO.getInstance().selectByCondition(condition);
			if(!accounts.isEmpty()) {
				if(accounts.get(0).getRole().equals("ADMIN")) {
					try {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						new HomeView();
						this.setVisible(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (accounts.get(0).getRole().equals("Management Staff")) {
					try {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						new HomeView();
						this.setVisible(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					try {
						UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
						new HomeView();
						this.setVisible(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			} else {
				this.messageLogin.setText("Incorrect account or password! Please re-enter!");
			}
		}
		
	}
}





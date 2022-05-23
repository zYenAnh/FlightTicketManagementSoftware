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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javassist.expr.Instanceof;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class LoginView extends JFrame {

	private JPanel contentPane;
	
	Font font_20 = new Font("Poppins", Font.BOLD, 18);
	Font font_16 = new Font("Poppins", Font.BOLD, 16);
	Font font_12 = new Font("Poppins", Font.BOLD, 12);
	Font font_14 = new Font("Poppins", Font.BOLD, 14);
	Font font_12_Thin = new Font("Poppins", Font.PLAIN, 12);
	Font font_16_Thin = new Font("Poppins", Font.PLAIN, 16);
	Font font_20_Thin = new Font("Poppins", Font.PLAIN, 20);
	Font font_32_Thin = new Font("Poppins", Font.PLAIN, 32);
	Font font_10 = new Font("Poppins", Font.BOLD, 10);
	
	JPasswordField inputPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
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
		
		JTextField inputUserName = new JTextField();
		inputUserName.setFont(font_12_Thin);
		inputUserName.setMargin(new Insets(0,12,0,0));
		inputUserName.setForeground(Color.BLACK);
		inputUserName.setBounds(157, 200, 357, 38);
		centerJPanel.add(inputUserName);
		inputUserName.setColumns(10);
		
		inputPassword = new JPasswordField();
		inputPassword.setFont(font_12_Thin);
		inputPassword.setMargin(new Insets(0,12,0,0));
		inputPassword.setToolTipText("");
		inputPassword.setBounds(157, 284, 357, 38);
		centerJPanel.add(inputPassword);
		        
        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setFont(font_20_Thin);
        loginBtn.setBounds(214, 361, 263, 49);
        centerJPanel.add(loginBtn);
          
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
        
        JLabel messageLogin = new JLabel("");
        messageLogin.setBounds(465, 336, 49, 14);
        centerJPanel.add(messageLogin);
	}
}



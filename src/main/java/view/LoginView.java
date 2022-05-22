package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
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
import java.awt.Color;

public class LoginView extends JFrame {

	private JPanel contentPane;

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
		centerJPanel.setBounds(0, 0, 700, 472);
		getContentPane().add(centerJPanel);
		centerJPanel.setLayout(null);
		
		//Create Icon Title
		JLabel lblIconTitle = new JLabel("");
		lblIconTitle.setBounds(215, 6, 269, 194);
		centerJPanel.add(lblIconTitle);
		ImageIcon iconTitle = new ImageIcon("/Users/baoan/Documents/App/src/Icon/TitlePlane Icon.png");
		Image imgTitle = iconTitle.getImage();
        Image imgTitleScale = imgTitle.getScaledInstance(lblIconTitle.getWidth(), lblIconTitle.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconTitle = new ImageIcon(imgTitleScale);
        lblIconTitle.setIcon(scaledIconTitle);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(280, 150, 150, 38);
		centerJPanel.add(lblLogin);
		
		JTextField inputUserName = new JTextField();
		inputUserName.setForeground(Color.BLACK);
		inputUserName.setText("E-Mail");
		inputUserName.setBounds(245, 200, 269, 38);
		centerJPanel.add(inputUserName);
		inputUserName.setColumns(10);
		
		JPasswordField inputPassword = new JPasswordField();
		inputPassword.setToolTipText("");
		inputPassword.setBounds(245, 275, 269, 38);
		centerJPanel.add(inputPassword);
		
		JLabel iconUserName = new JLabel("");
		iconUserName.setBounds(161, 191, 73, 60);
		centerJPanel.add(iconUserName);
		

		ImageIcon iconUser = new ImageIcon("/Users/baoan/Documents/App/src/Icon/User Icon.png");
		Image imgUser = iconUser.getImage();
        Image imgUserScale = imgUser.getScaledInstance(iconUserName.getWidth(), iconUserName.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconUser = new ImageIcon(imgUserScale);
        iconUserName.setIcon(scaledIconUser);
		
		JLabel iconPassword = new JLabel("");
		iconPassword.setBounds(168, 271, 61, 49);
		centerJPanel.add(iconPassword);
		ImageIcon iconPass = new ImageIcon("/Users/baoan/Documents/App/src/Icon/Password Icon.png");
		Image imgPass = iconPass.getImage();
        Image imgPassScale = imgPass.getScaledInstance(iconPassword.getWidth(), iconPassword.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconPass = new ImageIcon(imgPassScale);
        iconPassword.setIcon(scaledIconPass);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(272, 343, 171, 49);
        centerJPanel.add(btnLogin);
        
        JLabel lblTitle = new JLabel("AIRCRAFT TICKET MANAGEMENT");
        lblTitle.setBounds(44, 6, 611, 42);
        centerJPanel.add(lblTitle);
        lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 35));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
	}
		
}



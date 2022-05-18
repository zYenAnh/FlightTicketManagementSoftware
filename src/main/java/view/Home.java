package view;
// test
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField searchTF;
	private JTable tableTicket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		Font font_LucidaFont_16 = new Font("Lucida Grande", Font.BOLD, 16);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBounds(0,0,300,720);
		contentPane.add(navigationPanel);
		navigationPanel.setLayout(null);
		
		JLabel titleJLabel = new JLabel("AIRCRAP TICKET MANAGEMENT");
		titleJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleJLabel.setFont(font_LucidaFont_16);
		titleJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleJLabel.setBounds(0,0,300,80);
		titleJLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		navigationPanel.add(titleJLabel);
		
	   //Create jLabel TICKET MANAGEMENT
		JLabel ticketJLabel = new JLabel("       TICKET MANAGEMENT");
		ticketJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ticketJLabel.setIcon(null);
		
		ticketJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		ticketJLabel.setFont(font_LucidaFont_16);
		ticketJLabel.setBounds(0,80,300,80);
		ticketJLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		navigationPanel.add(ticketJLabel);
		
		
		ImageIcon iconTicket = new ImageIcon("..\\AirTicketManagementSoftware\\src\\main\\resources\\Icon\\ticket.png");
		JLabel iconTicketJLabel = new JLabel(iconTicket);
		iconTicketJLabel.setBounds(20, 25, 36, 32);
		ticketJLabel.add(iconTicketJLabel);
		Image imgTicket = iconTicket.getImage();
        Image imgTicketScale = imgTicket.getScaledInstance(iconTicketJLabel.getWidth(), iconTicketJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconTicket = new ImageIcon(imgTicketScale);
        iconTicketJLabel.setIcon(scaledIconTicket);
		
         //Create jLabel FLIGHT MANAGEMENT
        JLabel flightMNMJLabel = new JLabel("       FLIGHT MANAGEMENT");
        flightMNMJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        flightMNMJLabel.setIcon(null);
		
        flightMNMJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        flightMNMJLabel.setFont(font_LucidaFont_16);
        flightMNMJLabel.setBounds(0,160,300,80);
        flightMNMJLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		navigationPanel.add(flightMNMJLabel);
		
		JLabel iconFlightMNMJLabel = new JLabel("");
		iconFlightMNMJLabel.setBounds(20, 25, 36, 32);
		flightMNMJLabel.add(iconFlightMNMJLabel);
		ImageIcon iconFlight = new ImageIcon("..\\AirTicketManagementSoftware\\src\\main\\resources\\Icon\\plane.png");
		Image imgFlight = iconFlight.getImage();
        Image imgFlightScale = imgFlight.getScaledInstance(iconFlightMNMJLabel.getWidth(), iconFlightMNMJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconFlight = new ImageIcon(imgFlightScale);
        iconFlightMNMJLabel.setIcon(scaledIconFlight);
        
        //Create jLabel EMPLOYEE MANAGEMENT
        JLabel employeeMNMJLabel = new JLabel("             EMPLOYEE MANAGEMENT");
        employeeMNMJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        employeeMNMJLabel.setIcon(null);
		
        employeeMNMJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        employeeMNMJLabel.setFont(font_LucidaFont_16);
        employeeMNMJLabel.setBounds(0,240,300,80);
        employeeMNMJLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		navigationPanel.add(employeeMNMJLabel);
		
		JLabel iconEmployeeMNMJLabel = new JLabel("");
		iconEmployeeMNMJLabel.setBounds(20, 25, 36, 32);
		employeeMNMJLabel.add(iconEmployeeMNMJLabel);
		ImageIcon iconEmployee = new ImageIcon("..\\AirTicketManagementSoftware\\src\\main\\resources\\Icon\\nameIcon.png");
		Image imgEmployee = iconEmployee.getImage();
        Image imgEmployeeScale = imgEmployee.getScaledInstance(iconEmployeeMNMJLabel.getWidth(), iconEmployeeMNMJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconEmployee = new ImageIcon(imgEmployeeScale);
        iconEmployeeMNMJLabel.setIcon(scaledIconEmployee);
        
        //Create jLabel INVOICE MANAGEMENT
        JLabel invoiceMNMJLabel = new JLabel("         INVOICE MANAGEMENT");
        invoiceMNMJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        invoiceMNMJLabel.setIcon(null);
		
        invoiceMNMJLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        invoiceMNMJLabel.setFont(font_LucidaFont_16);
        invoiceMNMJLabel.setBounds(0,320,300,80);
        invoiceMNMJLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		navigationPanel.add(invoiceMNMJLabel);
		
		JLabel iconInvoiceMNMJLabel = new JLabel("");
		iconInvoiceMNMJLabel.setBounds(20, 25, 36, 32);
		invoiceMNMJLabel.add(iconInvoiceMNMJLabel);
		ImageIcon iconInvoice = new ImageIcon("..\\AirTicketManagementSoftware\\src\\main\\resources\\Icon\\invoiceIcon.png");
		Image imgInvoice = iconInvoice.getImage();
        Image imgInvoiceScale = imgInvoice.getScaledInstance(iconInvoiceMNMJLabel.getWidth(), iconInvoiceMNMJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconInvoice = new ImageIcon(imgInvoiceScale);
        iconInvoiceMNMJLabel.setIcon(scaledIconInvoice);

		//Create JLabel STATISTIC
		JLabel statisticJLabel = new JLabel("                STATISTIC");
        statisticJLabel.setHorizontalAlignment(SwingConstants.LEADING);
        statisticJLabel.setIcon(null);

		statisticJLabel.setHorizontalTextPosition(SwingConstants.LEADING);
        statisticJLabel.setFont(font_LucidaFont_16);
        statisticJLabel.setBounds(0,400,300,80);
        statisticJLabel.setBorder(BorderFactory.createLineBorder(Color.gray));
		navigationPanel.add(statisticJLabel);

		JLabel iconStatisticJLabel = new JLabel("");
		iconStatisticJLabel.setBounds(20, 25, 36, 32);
		statisticJLabel.add(iconStatisticJLabel);
		ImageIcon iconStatistic = new ImageIcon("..\\AirTicketManagementSoftware\\src\\main\\resources\\Icon\\statisticIcon.png");
		Image imgStatistic = iconStatistic.getImage();
        Image imgStatisticScale = imgStatistic.getScaledInstance(iconStatisticJLabel.getWidth(), iconStatisticJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconStatistic = new ImageIcon(imgStatisticScale);
        iconStatisticJLabel.setIcon(scaledIconStatistic);


        
		JPanel toolPanel = new JPanel();
		toolPanel.setBounds(300, 0, 980, 80);
		contentPane.add(toolPanel);
		toolPanel.setLayout(null);
		
		JLabel iconSearchJLabel = new JLabel("");
		iconSearchJLabel.setBounds(912, 16, 37, 31);
		toolPanel.add(iconSearchJLabel);
		ImageIcon iconSearch = new ImageIcon("..\\AirTicketManagementSoftware\\src\\main\\resources\\Icon\\searchIcon.png");
		Image imgSearch = iconSearch.getImage();
        Image imgSearchScale = imgSearch.getScaledInstance(iconSearchJLabel.getWidth(), iconSearchJLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIconSearch = new ImageIcon(imgSearchScale);
        iconSearchJLabel.setIcon(scaledIconSearch);
		
		
		searchTF = new JTextField();
		searchTF.setBackground(Color.LIGHT_GRAY);
		searchTF.setBounds(254, 6, 705, 52);
		toolPanel.add(searchTF);
		searchTF.setColumns(10);
		
		// Create button ADD
		JButton btnAdd = new JButton("");
		btnAdd.setBounds(18, 1, 64, 57);
		toolPanel.add(btnAdd);
		ImageIcon iconAdd = new ImageIcon("..\\AirTicketManagementSoftware\\src\\main\\resources\\Icon\\addIcon.png");
		Image imgAdd = iconAdd.getImage();
        Image imgAddScale = imgAdd.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon scaledIconAdd = new ImageIcon(imgAddScale);
        btnAdd.setIcon(scaledIconAdd);
		
		// Create button Delete
		JButton btnDelete = new JButton("");
		btnDelete.setBounds(94, 1, 64, 57);
		toolPanel.add(btnDelete);
		ImageIcon iconDelete = new ImageIcon("..\\AirTicketManagementSoftware\\src\\main\\resources\\Icon\\deleteIcon.png");
		Image imgDelete = iconDelete.getImage();
        Image imgDeleteScale = imgDelete.getScaledInstance(46, 38, Image.SCALE_SMOOTH);
        ImageIcon scaledIconDelete = new ImageIcon(imgDeleteScale);
        btnDelete.setIcon(scaledIconDelete);
		
        // Create button Modify
		JButton btnModify = new JButton("");
		btnModify.setBounds(170, 1, 64, 57);
		toolPanel.add(btnModify);
		ImageIcon iconModify = new ImageIcon("..\\AirTicketManagementSoftware\\src\\main\\resources\\Icon\\settingIcon.png");
		Image imgModify = iconModify.getImage();
        Image imgModifyScale = imgModify.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
        ImageIcon scaledIconModify = new ImageIcon(imgModifyScale);
        btnModify.setIcon(scaledIconModify);
		
		JLabel lblAdd = new JLabel("ADD");
		lblAdd.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBounds(18, 58, 61, 16);
		toolPanel.add(lblAdd);
		
		JLabel lblDelete = new JLabel("DELETE");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblDelete.setBounds(94, 58, 61, 16);
		toolPanel.add(lblDelete);
		
		JLabel lblModify = new JLabel("MODIFY");
		lblModify.setHorizontalAlignment(SwingConstants.CENTER);
		lblModify.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblModify.setBounds(173, 58, 61, 16);
		toolPanel.add(lblModify);
		
		JPanel ticketPanel = new JPanel();
		ticketPanel.setBounds(300, 80, 980, 640);
		contentPane.add(ticketPanel);
		ticketPanel.setLayout(null);
		
		// Create Table
		tableTicket = new JTable();
		tableTicket.setBackground(Color.LIGHT_GRAY);
		tableTicket.setBounds(23, 0, 933, 597);
		tableTicket.setModel(new DefaultTableModel(
				new Object [][] {},
				new String[] { 
						"Ticket ID", "Flight ", "Customer ID", "Ticket Class ID", "Employee ID", "Ticket Type", "Passenger Name", "Boarding Time", "Flight Date"
				}));
		JScrollPane tableTicketScrP = new JScrollPane(tableTicket);
		tableTicketScrP.setBounds(23, 0, 933, 597);
		JTableHeader tableTicketHeader = tableTicket.getTableHeader();
		tableTicketHeader.setFont(font_LucidaFont_16);
		ticketPanel.add(tableTicketScrP);
	}
	
}

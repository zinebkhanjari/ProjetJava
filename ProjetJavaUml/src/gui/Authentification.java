package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.ConnectionDataBase;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField emailField;
	private Connection conx;
	String email;
	String password;
	String email1;
	String pass1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
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
	public Authentification() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,774,651);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(156, 212, 48, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPasseword = new JLabel("passeword:");
		lblPasseword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPasseword.setBounds(150, 293, 86, 23);
		contentPane.add(lblPasseword);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\Capture.PNG"));
		lblNewLabel.setBounds(349, 35, 100, 114);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.CYAN);
		passwordField.setBounds(312, 294, 181, 22);
		contentPane.add(passwordField);
		try {
			conx=ConnectionDataBase.connectionBd();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JButton btnSeConnecter = new JButton("Se connecter");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 email=emailField.getText().toString();
				password=passwordField.getText().toString();
				ResultSet result=null;
				PreparedStatement myStmt = null;
				boolean connecté=false;
				
				try {
					myStmt = conx.prepareStatement("select emailAd,password from adherent ");
					
					result=myStmt.executeQuery();}
				catch(Exception e1) {
					
				}
				if(email.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "entrer vos cordonées");
				}
				else
				{

					try {
						while(result.next()) {
					    email1=result.getString("emailAd");
						 pass1=result.getString("password");
						}}
						 catch (HeadlessException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						if(email1.equals(email) && pass1.equals(password)) {
							AdherentMenu adWindow=new AdherentMenu();
							adWindow.setVisible(true);
							connecté=true;
							 
						}
					  else  if(email.equals("adminItwave@gmail.com") && password.equals("adminadmin"))
							{
								MainMenu menu=new MainMenu();
								menu.setVisible(true);
								connecté=true;
							
								
								}
	

						if (!connecté) {
							JOptionPane.showMessageDialog(null, "connection échoué");
							emailField.setText("");
							passwordField.setText("");
							
						}}

				
			
			}});
		btnSeConnecter.setBackground(Color.WHITE);
		btnSeConnecter.setBounds(358, 434, 116, 32);
		contentPane.add(btnSeConnecter);
		
		emailField = new JTextField();
		emailField.setBackground(Color.CYAN);
		emailField.setBounds(312, 209, 181, 23);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("mot de passe oubli\u00E9?");
		lblMotDePasse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "merci d'envoyer vos cordonnées à l'adresse email 	adminItwave@gmail.com afin de recuperer votre compte");
			}
		});
		lblMotDePasse.setForeground(Color.RED);
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMotDePasse.setBounds(371, 325, 124, 14);
		contentPane.add(lblMotDePasse);
	}
}

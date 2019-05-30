package gui;

import java.awt.BorderLayout;

import Dao.ConnectionDataBase;
import net.proteanit.sql.DbUtils;

import java.awt.EventQueue;
//import users.Adherent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionAdherent extends JFrame {

	private JPanel contentPane;
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField emailField;
	private JTextField telField;
	private JTextField niveauField;
	private String nomAd;
	private String prenomAd;
	private String emailAd;
	private String telAd;
	private String niveauAd;
	private String password;
     Connection conx;
	private JTextField passwordField;
	private JTable table;
	void close() {
		dispose();
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionAdherent frame = new GestionAdherent();
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
	public GestionAdherent() {
		setTitle("Gestion Adherent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,774,651);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\aaaaa.PNG"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(Color.BLACK);
		try {
			conx=ConnectionDataBase.connectionBd();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomAd=nomField.getText();
				prenomAd=prenomField.getText();
				emailAd=emailField.getText();
				telAd=telField.getText();
				niveauAd=niveauField.getText();
				password=passwordField.getText();
		
				if(nomAd.contentEquals("") || prenomAd.contentEquals("") || emailAd.contentEquals("") || telAd.contentEquals("") || niveauAd.contentEquals("")  ) {
					JOptionPane.showMessageDialog(null, "entrer toutes les informations s'il vous plait");
				}
				else {
				PreparedStatement myStmt = null;

				try {
					// prepare statement
					myStmt = conx.prepareStatement("insert into adherent"
							+ " (nomAd,prenomAd,emailAd,telAd,niveauAd,password)"
							+ " values (?, ?, ?, ?,?, ?)");
					
					// set params
					myStmt.setString(1,nomAd);
					myStmt.setString(2,prenomAd);
					myStmt.setString(3,emailAd);
					myStmt.setString(4,telAd);
					myStmt.setString(5,niveauAd);
					myStmt.setString(6,password);
				
					
					// execute SQL
					myStmt.executeUpdate();		
					JOptionPane.showMessageDialog(null, "ajout réussit");
					nomField.setText("");
				    prenomField.setText("");
					emailField.setText("");
					telField.setText("");
					niveauField.setText("");
					passwordField.setText("");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					try {
						myStmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}}
		});
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(87, 502, 89, 59);
		contentPane.add(btnNewButton);
		
		JButton btnModifier = new JButton("");
		btnModifier.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\bbbbb.PNG"));
		btnModifier.setBackground(new Color(255, 255, 255));
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModifier.setForeground(Color.BLACK);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailAd=emailField.getText();	
				PreparedStatement myStmt=null;
				try {
					myStmt=conx.prepareStatement("delete from adherent where emailAd=?");
					myStmt.setString(1,emailAd);
			
					myStmt.executeUpdate();		
					JOptionPane.showMessageDialog(null, "Suppression réussite");
					nomField.setText("");
				    prenomField.setText("");
					emailField.setText("");
					telField.setText("");
					niveauField.setText("");
					passwordField.setText("");
					actualiserTable();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					try {
						myStmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();

					// TODO: handle exception
				}
				
				}
			}
		});
		btnModifier.setBounds(437, 502, 89, 59);
		contentPane.add(btnModifier);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\Capture.PNG"));
		label.setBounds(345, 11, 110, 106);
		contentPane.add(label);
		
		nomField = new JTextField();
		/*nomField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			String 	sql="select nomAd from adherent where emailAd= ? ";
			PreparedStatement stmt=null;
			ResultSet result=null;
			try {
				stmt=conx.prepareStatement(sql);
				stmt.setString(1,emailField.getText());
				
					
					
					
				
				result=stmt.executeQuery();
				if(result.next()) {
				String nom=result.getString("nomAd");
				nomField.setText(nom);}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});*/
		nomField.setBackground(Color.CYAN);
		nomField.setBounds(79, 196, 196, 20);
		contentPane.add(nomField);
		nomField.setColumns(10);
		
		prenomField = new JTextField();
		prenomField.setBackground(Color.CYAN);
		prenomField.setBounds(79, 237, 196, 20);
		contentPane.add(prenomField);
		prenomField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBackground(Color.CYAN);
		emailField.setBounds(79, 148, 196, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		telField = new JTextField();
		telField.setBackground(Color.CYAN);
		telField.setBounds(79, 285, 196, 20);
		contentPane.add(telField);
		telField.setColumns(10);
		
		niveauField = new JTextField();
		niveauField.setBackground(Color.CYAN);
		niveauField.setBounds(79, 329, 196, 20);
		contentPane.add(niveauField);
		niveauField.setColumns(10);
		
		JLabel lblNom = new JLabel("nom:");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNom.setBounds(10, 196, 92, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrnom = new JLabel("pr\u00E9nom:");
		lblPrnom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrnom.setBounds(10, 237, 92, 14);
		contentPane.add(lblPrnom);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(87, 265, 89, -20);
		contentPane.add(lblEmail);
		
		JLabel lblEmail_1 = new JLabel("email:");
		lblEmail_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail_1.setBounds(10, 148, 92, 14);
		contentPane.add(lblEmail_1);
		
		JLabel lblTlphone = new JLabel("t\u00E9l\u00E9phone:");
		lblTlphone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTlphone.setBounds(10, 285, 92, 14);
		contentPane.add(lblTlphone);
		
		JLabel lblNiveau = new JLabel("niveau:");
		lblNiveau.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNiveau.setBounds(10, 329, 92, 14);
		contentPane.add(lblNiveau);
		
		JButton btnModifier_1 = new JButton("");
		btnModifier_1.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\Capture.PNGjjjj.PNG"));
		btnModifier_1.setBackground(Color.WHITE);
		btnModifier_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomAd=nomField.getText();
				prenomAd=prenomField.getText();
				emailAd=emailField.getText();
				telAd=telField.getText();
				niveauAd=niveauField.getText();
				password=passwordField.getText();
				
				 PreparedStatement stmt=null;
				 
				 try {
					 stmt=conx.prepareStatement("update adherent"
				         +" set nomAd=? , prenomAd=? , telAd=? , niveauAd=? ,password=? "
							+ "where emailAd=? ");
					 stmt.setString(1, nomAd);
					 stmt.setString(2, prenomAd);
					 
					 stmt.setString(3, telAd);
					 stmt.setString(4, niveauAd);
					 stmt.setString(5, emailAd);
					 stmt.setString(6, password);

					 stmt.executeUpdate();
					 JOptionPane.showMessageDialog(null, "modification réussite");
					 nomField.setText("");
					    prenomField.setText("");
						emailField.setText("");
						telField.setText("");
						niveauField.setText("");
						passwordField.setText("");
					 }
						catch(Exception r){
							
						}
				
				 
				 finally {
						try {
							stmt.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
								
						}
					}
				
				
				 actualiserTable();
					

			}
		});
		btnModifier_1.setForeground(Color.BLACK);
		btnModifier_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModifier_1.setBounds(268, 502, 89, 59);
		contentPane.add(btnModifier_1);
		
		JList list = new JList();
		list.setBounds(101, 572, 1, 1);
		contentPane.add(list);
		
		JLabel lblAjouter = new JLabel("Ajouter");
		lblAjouter.setBounds(117, 573, 48, 14);
		contentPane.add(lblAjouter);
		
		JLabel lblModifier = new JLabel("modifier");
		lblModifier.setBounds(292, 573, 48, 14);
		contentPane.add(lblModifier);
		
		JLabel lblSupprimer = new JLabel("Supprimer");
		lblSupprimer.setBounds(461, 573, 65, 14);
		contentPane.add(lblSupprimer);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBackground(Color.CYAN);
		passwordField.setBounds(79, 370, 196, 20);
		contentPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(10, 370, 92, 14);
		contentPane.add(lblPassword);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(285, 128, 476, 262);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			int row=table.getSelectedRow();
			String nom=table.getModel().getValueAt(row,0).toString();
			String prenom=table.getModel().getValueAt(row,1).toString();
			String email=table.getModel().getValueAt(row,2).toString();
			String tel=table.getModel().getValueAt(row,3).toString();
			String niveau=table.getModel().getValueAt(row,4).toString();
			String password=table.getModel().getValueAt(row,5).toString();
			nomField.setText(nom);
			prenomField.setText(prenom);
			emailField.setText(email);
			telField.setText(tel);
			niveauField.setText(niveau);
			passwordField.setText(password);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnActualiser = new JButton("");
		btnActualiser.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\Capture.PNGqqqqqqq.PNG"));
		btnActualiser.setBackground(Color.WHITE);
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 actualiserTable();
			}
		});
		btnActualiser.setBounds(700, 70, 48, 47);
		contentPane.add(btnActualiser);
		
		JButton btnRetour = new JButton("");
		btnRetour.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\backkk.PNG"));
		btnRetour.setBackground(Color.WHITE);
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				MainMenu back=new MainMenu();
				back.setVisible(true);
				
				close();
				
			}
		});
		btnRetour.setBounds(10, 70, 48, 47);
		contentPane.add(btnRetour);
		
		JButton btnSupprimer = new JButton("Supprimer");
	
	

		
	}


	public void actualiserTable() {
	String sql="select nomAd,prenomAd,emailAd,telAd,niveauAd,password from adherent";
	try {
		PreparedStatement stmt=conx.prepareStatement(sql);
		ResultSet result=stmt.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(result));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}

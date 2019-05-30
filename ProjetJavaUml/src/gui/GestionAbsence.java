package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.sql.Connection;
import java.sql.*;
import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;

import Dao.ConnectionDataBase;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionAbsence extends JFrame {

	private JPanel contentPane;
	private Connection conx;
	JComboBox nomBox ;
	JComboBox comboBox ;
	private JTable table;
	JDateChooser dateChooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionAbsence frame = new GestionAbsence();
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
	public GestionAbsence() {
		setTitle("Gestion d'absence ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,774,651);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(363, 142, 395, 352);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				String nom=table.getModel().getValueAt(row,1).toString();
				String date=table.getModel().getValueAt(row,2).toString();
				String raison=table.getModel().getValueAt(row,3).toString();
				
				nomBox.setSelectedItem(nom);
				comboBox.setSelectedItem(raison);
				dateChooser.setDateFormatString(date);
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
				{},
				{},
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		try {
			conx=ConnectionDataBase.connectionBd();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\Capture.PNG"));
		label.setBounds(300, 11, 134, 100);
		contentPane.add(label);
		
		JLabel lblNom = new JLabel("nom:");
		lblNom.setBounds(10, 181, 73, 14);
		
		contentPane.add(lblNom);
		
		nomBox = new JComboBox();
		nomBox.setBackground(Color.CYAN);
		nomBox.setBounds(93, 177, 141, 22);
		contentPane.add(nomBox);
		fillBox();
		JLabel lblDate = new JLabel("date:");
		lblDate.setBounds(10, 253, 48, 14);
		contentPane.add(lblDate);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"maladie", "retard", "exams", "voyage", "non justifi\u00E9", "autres"}));
		comboBox.setBackground(Color.CYAN);
		comboBox.setBounds(93, 305, 141, 22);
		contentPane.add(comboBox);
		
		JLabel lblJustification = new JLabel("justification:");
		lblJustification.setBounds(10, 309, 73, 14);
		contentPane.add(lblJustification);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(93, 247, 141, 20);
		contentPane.add(dateChooser);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom=nomBox.getSelectedItem().toString();
				String date=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
				String raison=comboBox.getSelectedItem().toString();
				PreparedStatement stmt=null;
				try {
					stmt=(PreparedStatement) conx.prepareStatement("insert into absence(nomAd,dateAb,raison) values(?,?,?)");
					stmt.setString(1, nom);
					stmt.setString(2, date);
					stmt.setString(3, raison);
					stmt.executeUpdate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally
				{
					try {
						stmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, "Ajout réussit");
				
				updateTable();
			}
		});
		button.setBackground(Color.WHITE);
		button.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\addd.PNG"));
		button.setBounds(66, 400, 48, 41);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				if(row==-1) {
					JOptionPane.showMessageDialog(null, "selectionner une ligne  ");
					
				}else 
				{
				
				java.sql.PreparedStatement stmt=null;
			    
				try {
					String id=table.getValueAt(row, 0).toString();
					stmt=conx.prepareStatement("delete from absence where idAb= ?");
					
					stmt.setString(1,id);
					stmt.executeUpdate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					try {
						stmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
				JOptionPane.showMessageDialog(null,"supression réussite");
				updateTable();
				
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\supp.PNG"));
		button_1.setBounds(186, 400, 48, 41);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\Capture.PNGqqqqqqq.PNG"));
		button_2.setBounds(700, 101, 48, 35);
		contentPane.add(button_2);
		
		JLabel lblAjouter = new JLabel("ajouter");
		lblAjouter.setBounds(76, 452, 48, 14);
		contentPane.add(lblAjouter);
		
		JLabel lblSupprimer = new JLabel("supprimer");
		lblSupprimer.setBounds(196, 452, 73, 14);
		contentPane.add(lblSupprimer);
		
		JLabel lblTableDabsence = new JLabel("table d'absence");
		lblTableDabsence.setBounds(467, 117, 134, 14);
		contentPane.add(lblTableDabsence);
	}
	public void fillBox() {
		java.sql.PreparedStatement stmt=null;
		ResultSet result=null;
		try {
			stmt=conx.prepareStatement("select nomAd,prenomAd from adherent");
			result=stmt.executeQuery();
			while(result.next()) {
				String nom=result.getString("nomAd");
				String prenom=result.getString("prenomAd");
				nomBox.addItem(nom+" "+prenom);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void updateTable() {
	    java.sql.PreparedStatement stmt=null;
	    ResultSet result=null;
		try {
			stmt=conx.prepareStatement("select * from absence");
			result=stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(result));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

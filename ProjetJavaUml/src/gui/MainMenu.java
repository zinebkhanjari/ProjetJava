package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;
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
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,774,651);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionAdherent ges=new GestionAdherent();
				ges.setVisible(true);
				close();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\ssssss.PNG"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 269, 149, 149);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\cccc.PNG"));
		btnNewButton_2.setBounds(262, 269, 168, 149);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\areal.PNG"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionAbsence ga=new GestionAbsence();
				ga.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(514, 269, 168, 146);
		contentPane.add(btnNewButton_4);
		
		JLabel lblGestionAdherents = new JLabel("gestion adherents");
		lblGestionAdherents.setBounds(52, 438, 123, 14);
		contentPane.add(lblGestionAdherents);
		
		JLabel lblCalendrierDesEvenements = new JLabel("calendrier des evenements ");
		lblCalendrierDesEvenements.setBounds(275, 438, 134, 14);
		contentPane.add(lblCalendrierDesEvenements);
		
		JLabel lblGestionDabsence = new JLabel("Gestion d'absence");
		lblGestionDabsence.setBounds(534, 438, 105, 14);
		contentPane.add(lblGestionDabsence);
	}
}

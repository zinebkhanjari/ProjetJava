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
		btnNewButton.setBounds(35, 324, 149, 149);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionEvent ge=new GestionEvent();
				ge.setVisible(true );
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\cccc.PNG"));
		btnNewButton_2.setBounds(290, 324, 168, 149);
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
		btnNewButton_4.setBounds(550, 335, 168, 146);
		contentPane.add(btnNewButton_4);
		
		JLabel lblGestionAdherents = new JLabel("gestion adherents");
		lblGestionAdherents.setBounds(52, 564, 123, 14);
		contentPane.add(lblGestionAdherents);
		
		JLabel lblCalendrierDesEvenements = new JLabel("calendrier des evenements ");
		lblCalendrierDesEvenements.setBounds(320, 564, 134, 14);
		contentPane.add(lblCalendrierDesEvenements);
		
		JLabel lblGestionDabsence = new JLabel("Gestion d'absence");
		lblGestionDabsence.setBounds(594, 564, 105, 14);
		contentPane.add(lblGestionDabsence);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\lplpppe.PNG"));
		label.setBounds(256, -23, 286, 252);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\2560x1440-turquoise-blue-solid-color-background.jpg"));
		label_1.setBounds(492, 259, 6, 305);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\2560x1440-turquoise-blue-solid-color-background.jpg"));
		label_2.setBounds(238, 264, 6, 300);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\2560x1440-turquoise-blue-solid-color-background.jpg"));
		label_3.setBounds(-10, 251, 768, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\2560x1440-turquoise-blue-solid-color-background.jpg"));
		label_4.setBounds(-10, 557, 768, 21);
		contentPane.add(label_4);
	}
}

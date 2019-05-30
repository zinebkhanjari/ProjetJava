package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class AdherentMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdherentMenu frame = new AdherentMenu();
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
	public AdherentMenu() {
		setTitle("menu Adherent ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,774,651);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInformationPersonnels = new JButton("");
		btnInformationPersonnels.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\setting.PNG"));
		btnInformationPersonnels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile pr=new Profile();
				pr.setVisible(true);
			}
		});
		btnInformationPersonnels.setBounds(64, 334, 137, 135);
		contentPane.add(btnInformationPersonnels);
		
		JLabel lblProfil = new JLabel("parametres personnels");
		lblProfil.setBounds(83, 498, 123, 14);
		contentPane.add(lblProfil);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\areal.PNG"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile1 pr=new Profile1();
				pr.setVisible(true);
			}
		});
		button.setBounds(601, 334, 147, 135);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\cccc.PNG"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(338, 345, 138, 124);
		contentPane.add(button_1);
		
		JLabel lblConsulterMonAbsence = new JLabel("consulter mon absence ");
		lblConsulterMonAbsence.setBounds(630, 501, 147, 8);
		contentPane.add(lblConsulterMonAbsence);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\Capture.PNG"));
		label.setBounds(338, 60, 109, 113);
		contentPane.add(label);
		
		JLabel lblBonjourCherAdherent = new JLabel("bonjour cher Adherent ");
		lblBonjourCherAdherent.setForeground(Color.DARK_GRAY);
		lblBonjourCherAdherent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBonjourCherAdherent.setBounds(321, 194, 179, 14);
		contentPane.add(lblBonjourCherAdherent);
		
		JLabel lblConsulterLesEvenements = new JLabel("consulter les evenements ");
		lblConsulterLesEvenements.setBounds(339, 498, 147, 14);
		contentPane.add(lblConsulterLesEvenements);
	}
}

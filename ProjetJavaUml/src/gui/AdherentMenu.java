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
	public void close() {
		dispose();
	}
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
				close();
			}
		});
		btnInformationPersonnels.setBounds(64, 334, 137, 135);
		contentPane.add(btnInformationPersonnels);
		
		JLabel lblProfil = new JLabel("parametres personnels");
		lblProfil.setBounds(43, 551, 207, 26);
		contentPane.add(lblProfil);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\areal.PNG"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Verifi pr=new Verifi();
				pr.setVisible(true);
				dispose();
			}
		});
		button.setBounds(573, 334, 147, 135);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\cccc.PNG"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultEvent ge=new ConsultEvent();
				ge.setVisible(true);
				close();
			}
		});
		button_1.setBounds(316, 345, 138, 124);
		contentPane.add(button_1);
		
		JLabel lblConsulterMonAbsence = new JLabel("consulter mon absence ");
		lblConsulterMonAbsence.setBounds(589, 554, 147, 23);
		contentPane.add(lblConsulterMonAbsence);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\Capture.PNG"));
		label.setBounds(327, 60, 109, 113);
		contentPane.add(label);
		
		JLabel lblBonjourCherAdherent = new JLabel("bonjour cher Adherent ");
		lblBonjourCherAdherent.setForeground(Color.DARK_GRAY);
		lblBonjourCherAdherent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBonjourCherAdherent.setBounds(316, 194, 184, 26);
		contentPane.add(lblBonjourCherAdherent);
		
		JLabel lblConsulterLesEvenements = new JLabel("consulter les evenements ");
		lblConsulterLesEvenements.setBounds(326, 551, 240, 26);
		contentPane.add(lblConsulterLesEvenements);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\2560x1440-turquoise-blue-solid-color-background.jpg"));
		label_1.setBounds(0, 240, 758, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\2560x1440-turquoise-blue-solid-color-background.jpg"));
		label_2.setBounds(250, 240, 14, 325);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\2560x1440-turquoise-blue-solid-color-background.jpg"));
		label_3.setBounds(510, 240, 14, 320);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\USER\\Desktop\\projetJava\\2560x1440-turquoise-blue-solid-color-background.jpg"));
		label_4.setBounds(0, 551, 758, 26);
		contentPane.add(label_4);
	}
}

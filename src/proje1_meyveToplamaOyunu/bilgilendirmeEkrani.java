package proje1_meyveToplamaOyunu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class bilgilendirmeEkrani extends JFrame{
	
	public static void bilgilendirmeEkrani(){
		JFrame frame;
		JPanel contentPane;
		JButton btnGeri;
		JLabel lblBilgilendirmeYazisi1;
		JLabel lblBilgilendirmeYazisi2;
		JLabel lblBilgilendirmeYazisi3;
		JLabel lblArkaplan;
		
		ImageIcon imgFotograf = new ImageIcon("arkaplan.png");
		
		frame = new JFrame("Bilgilendirme");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		btnGeri = new JButton("Geri");
		btnGeri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				anasayfaEkrani AnasayfaEkrani = new anasayfaEkrani();
				AnasayfaEkrani.anasayfaEkrani();
				
			}
		});
		btnGeri.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGeri.setBounds(10, 11, 89, 23);
		contentPane.add(btnGeri);
		frame.add(contentPane);
		
		lblBilgilendirmeYazisi1 = new JLabel("");
		lblBilgilendirmeYazisi1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblBilgilendirmeYazisi1.setBounds(227, 200, 355, 40);
		lblBilgilendirmeYazisi1.setText("Herbir meyve yakalandýðýnda 1 puan artar.");
		contentPane.add(lblBilgilendirmeYazisi1);
		frame.add(contentPane);
		
		lblBilgilendirmeYazisi2 = new JLabel("");
		lblBilgilendirmeYazisi2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblBilgilendirmeYazisi2.setBounds(227, 250, 355, 40);
		lblBilgilendirmeYazisi2.setText("Herbir meyve yere düþtüðünde 1 can eksilir.");
		contentPane.add(lblBilgilendirmeYazisi2);
		frame.add(contentPane);
		
		lblBilgilendirmeYazisi3 = new JLabel("");
		lblBilgilendirmeYazisi3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblBilgilendirmeYazisi3.setBounds(227, 300, 355, 40);
		lblBilgilendirmeYazisi3.setText("Can 0 olduðunda oyun biter.");
		contentPane.add(lblBilgilendirmeYazisi3);
		frame.add(contentPane);
		
		lblArkaplan = new JLabel("", imgFotograf, JLabel.CENTER);
	    lblArkaplan.setBounds(0, 0, 800, 600);
		contentPane.add(lblArkaplan);
		frame.add(contentPane);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bilgilendirmeEkrani();

	}

}

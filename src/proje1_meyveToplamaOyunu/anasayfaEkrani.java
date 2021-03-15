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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class anasayfaEkrani extends JFrame{
	
	/*public static void muzikEkle(){
	try {
		AudioInputStream stream = AudioSystem.getAudioInputStream(new File("arkaplanMuzigi.wav"));
		try {
				Clip clip = AudioSystem.getClip();
				clip.open(stream);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			System.out.println("LineUnavailableException Hatasý...");
			e.printStackTrace();
		}
	} catch (UnsupportedAudioFileException | IOException e) {
		// TODO Auto-generated catch block
		System.out.println("UnsupportedAudioFileException veya IOException Hatasý...");
		e.printStackTrace();
	}
}*/
	
	public static void anasayfaEkrani(){
		JFrame frame;
		JPanel contentPane;
		JButton btnYeniOyun;
		JButton btnDevamEt;
		JButton btnYuksekSkorlar;
		JButton btnSecenekler;
		JButton btnBilgilendirme;
		JButton btnCikis;
		JLabel lblArkaplan;
		
		ImageIcon imgFotograf = new ImageIcon("arkaplan.png");
		
		frame = new JFrame("Meyve Toplama Oyunu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		btnYeniOyun = new JButton("Yeni Oyun");
		btnYeniOyun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				karakterSecimiEkrani KarakterSecimi = new karakterSecimiEkrani("Karakter Seçimi");
				KarakterSecimi.karakterSecimi();
			}
		});
		btnYeniOyun.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnYeniOyun.setBounds(286, 200, 175, 30);
		contentPane.add(btnYeniOyun);
	    frame.add(contentPane);
	    
		btnYuksekSkorlar = new JButton("Yüksek Skorlar");
		btnYuksekSkorlar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				yuksekSkorlarEkrani YuksekSkorlarEkrani = new yuksekSkorlarEkrani();
				YuksekSkorlarEkrani.yuksekSkorlarEkrani();
			}
		});
		btnYuksekSkorlar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnYuksekSkorlar.setBounds(286, 240, 175, 30);
		contentPane.add(btnYuksekSkorlar);
	    frame.add(contentPane);
	    
		btnBilgilendirme = new JButton("Bilgilendirme");
		btnBilgilendirme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				bilgilendirmeEkrani BilgilendirmeEkrani = new bilgilendirmeEkrani();
				BilgilendirmeEkrani.bilgilendirmeEkrani();
			}
		});
		btnBilgilendirme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBilgilendirme.setBounds(286, 280, 175, 30);
		contentPane.add(btnBilgilendirme);
	    frame.add(contentPane);
	    
		btnCikis = new JButton("Çýkýþ");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCikis.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCikis.setBounds(286, 320, 175, 30);
		contentPane.add(btnCikis);
	    frame.add(contentPane);
		
	    lblArkaplan = new JLabel("", imgFotograf, JLabel.CENTER);
	    lblArkaplan.setBounds(0, 0, 800, 600);
		contentPane.add(lblArkaplan);
		frame.add(contentPane);
	}
	
	public static void main(String[] args) {
		anasayfaEkrani();
		//muzikEkle();
	}

}

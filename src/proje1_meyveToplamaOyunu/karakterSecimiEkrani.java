package proje1_meyveToplamaOyunu;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class karakterSecimiEkrani extends JFrame{
	
	public karakterSecimiEkrani(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public static void karakterSecimi(){
		JFrame frame;
		JPanel contentPane;
		JButton btnGeri;
		JButton btnMario;
		JButton btnPrenses;
		JLabel lblArkaplan;
		Icon iconMario;
		Icon iconPrenses;
		
		ImageIcon imgFotograf = new ImageIcon("arkaplan.png");
		
		frame = new JFrame("Karakter Seçimi");
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
		
		iconMario = new ImageIcon("mario.png");
		btnMario = new JButton(iconMario);
		btnMario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				karakterSecimiEkrani KarakterSecimi = new karakterSecimiEkrani("Meyve Toplama Oyunu");
				
				frame.setVisible(false);
				KarakterSecimi.setResizable(false);	//yeniden boyutlandırılamayacak.
				KarakterSecimi.setFocusable(false);	//işlemler JPanel üzerinde olacak, JFrame'e odaklanmayacak.
				KarakterSecimi.setSize(800, 600);
				KarakterSecimi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//sağ üstteki x'ye basınca kapanacak.
				
				marioOyunEkrani MarioOyunEkrani = new marioOyunEkrani();
				
				MarioOyunEkrani.setLayout(null);
				MarioOyunEkrani.requestFocus();	//JPanel'in klavye işlemlerini anlayacak.
				MarioOyunEkrani.addKeyListener(MarioOyunEkrani);
				MarioOyunEkrani.setFocusable(true);	//işlemler JPanel üzerinde olacak. Odak JPanelde.
				MarioOyunEkrani.setFocusTraversalKeysEnabled(false);	//klavye işlemleri anlaşılacak.
				
				KarakterSecimi.add(MarioOyunEkrani);	//JPanel, JFrame'e eklendi.
				KarakterSecimi.setVisible(true);	//JFrame, JPanel eklendiğinde direkt oluşacak.

			}
		});
		btnMario.setBounds(209, 135, 180, 280);
		contentPane.add(btnMario);
		frame.add(contentPane);
		
		iconPrenses = new ImageIcon("prenses.png");
		btnPrenses = new JButton(iconPrenses);
		btnPrenses.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				karakterSecimiEkrani KarakterSecimi = new karakterSecimiEkrani("Meyve Toplama Oyunu");
				
				frame.setVisible(false);
				KarakterSecimi.setResizable(false);	//yeniden boyutlandırılamayacak.
				KarakterSecimi.setFocusable(false);	//işlemler JPanel üzerinde olacak, JFrame'e odaklanmayacak.
				KarakterSecimi.setSize(800, 600);
				KarakterSecimi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//sağ üstteki x'ye basınca kapanacak.
				
				prensesOyunEkrani PrensesOyunEkrani = new prensesOyunEkrani();
				
				PrensesOyunEkrani.setLayout(null);
				PrensesOyunEkrani.requestFocus();	//JPanel'in klavye işlemlerini anlayacak.
				PrensesOyunEkrani.addKeyListener(PrensesOyunEkrani);
				PrensesOyunEkrani.setFocusable(true);	//işlemler JPanel üzerinde olacak. Odak JPanelde.
				PrensesOyunEkrani.setFocusTraversalKeysEnabled(false);	//klavye işlemleri anlaşılacak.
				
				KarakterSecimi.add(PrensesOyunEkrani);	//JPanel, JFrame'e eklendi.
				KarakterSecimi.setVisible(true);	//JFrame, JPanel eklendiğinde direkt oluşacak.

			}
		});
		btnPrenses.setBounds(399, 135, 160, 280);
		contentPane.add(btnPrenses);
		frame.add(contentPane);
		
		lblArkaplan = new JLabel("", imgFotograf, JLabel.CENTER);
	    lblArkaplan.setBounds(0, 0, 800, 600);
		contentPane.add(lblArkaplan);
		frame.add(contentPane);
	}

	public static void main(String[] args) {
		karakterSecimi();
	}

}

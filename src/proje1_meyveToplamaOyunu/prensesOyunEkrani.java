package proje1_meyveToplamaOyunu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class prensesOyunEkrani extends JPanel implements KeyListener,ActionListener{
	
	Timer timer = new Timer(5, this);
	
	private ArrayList<portakal> Portakallar = new ArrayList<portakal>();
	private int portakalilerliyorX = 0;
	private int portakalilerliyorY = 1;
	
	public double gecenSure = 0;
	public int puan = 0;
	public int can = 3;
	
	private BufferedImage image;
	private int prensesX = 0;	//mario'nun baþlangýçtaki X deðeri 0.
	private int prensesY = 430;
	private int prensesilerliyorX = 20;
	
	private JLabel lblPuan;
	private JLabel lblCan;
	
	private JButton btnKaydetveYenidenOyna;
	private JButton btnAnasayfayaDon;
	private JLabel lblKullaniciAdiGiris;
	private JLabel lblKaybettiniz;
	private JLabel lblKazandiniz;
	private JLabel lblPuann;
	private JLabel lblPuannn;
	private JLabel lblGecenSure;
	private JLabel lblGecenSuree;
	private JTextField txtKullaniciAdiGiris;
	
	kullaniciislemleri islem = new kullaniciislemleri();
	
	public void portakalEkle(){
		Portakallar.add(new portakal((int)(Math.random() * 790), 20));
	}
	public void portakalEkle2(){
		for(int i = 0 ; i <= 1 ; i++){
			Portakallar.add(i, new portakal((int)(Math.random() * 790), 20));
		}
	}
	public void portakalEkle3(){
		for(int i = 0 ; i <= 2 ; i++){
			Portakallar.add(i, new portakal((int)(Math.random() * 790), 20));
		}
	}
	public void portakalEkle4(){
		for(int i = 0 ; i <= 3 ; i++){
			Portakallar.add(i, new portakal((int)(Math.random() * 790), 20));
		}
	}
	public void portakalEkle5(){
		for(int i = 0 ; i <= 4 ; i++){
			Portakallar.add(i, new portakal((int)(Math.random() * 790), 20));
		}
	}
	
	public void oyunBitti(){
		lblPuann = new JLabel("Puan : ");
		lblPuann.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuann.setBounds(230, 150, 150, 30);
		add(lblPuann);
		
		lblPuannn = new JLabel("" + puan);
		lblPuannn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuannn.setBounds(330, 150, 150, 30);
		add(lblPuannn);
		
		lblGecenSure = new JLabel("Geçen Süre : ");
		lblGecenSure.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGecenSure.setBounds(230, 200, 150, 30);
		add(lblGecenSure);
		
		lblGecenSuree = new JLabel("" + (gecenSure / 1000.0) + " saniye");
		lblGecenSuree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGecenSuree.setBounds(330, 200, 150, 30);
		add(lblGecenSuree);
		
		lblKullaniciAdiGiris = new JLabel("Kullanýcý Adý : ");
		lblKullaniciAdiGiris.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKullaniciAdiGiris.setBounds(230, 250, 150, 30);
		add(lblKullaniciAdiGiris);
		
		txtKullaniciAdiGiris = new JTextField("");
		txtKullaniciAdiGiris.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtKullaniciAdiGiris.setBounds(330, 250, 150, 30);
		add(txtKullaniciAdiGiris);
		
		btnKaydetveYenidenOyna = new JButton("Kaydet ve Yeniden Oyna");
		btnKaydetveYenidenOyna.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
					String userName = txtKullaniciAdiGiris.getText();
					String score = lblPuannn.getText();
					String time = lblGecenSuree.getText();
					
					islem.kullaniciEkle(userName, score, time);
					
					karakterSecimiEkrani KarakterSecimi = new karakterSecimiEkrani("Karakter Seçimi");
					KarakterSecimi.karakterSecimi();
					
					System.out.println("Kullanýcý Eklendi.");
				}
				catch(Exception ex){
					System.out.println("Baðlantý Baþarýsýz...");
					ex.printStackTrace();
				}
			}
		});
		btnKaydetveYenidenOyna.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnKaydetveYenidenOyna.setBounds(150, 300, 220, 30);
		add(btnKaydetveYenidenOyna);
		
		btnAnasayfayaDon = new JButton("Anasayfaya Dön");
		btnAnasayfayaDon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				anasayfaEkrani AnasayfaEkrani = new anasayfaEkrani();
				AnasayfaEkrani.anasayfaEkrani();
			}
		});
		btnAnasayfayaDon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAnasayfayaDon.setBounds(400, 300, 200, 30);
		add(btnAnasayfayaDon);
	}
	
	public boolean kazananiKontrolEt(){
		for(portakal Portakal : Portakallar){
			if(new Rectangle(Portakal.getX(), Portakal.getY(), 20, 20). intersects
					(new Rectangle(prensesX, prensesY, image.getWidth() / 2, image.getHeight() / 2))){
				puan++;
				lblPuan.setText("Puan : " + puan);
				lblCan.setText("Can : " + can);
				Portakallar.remove(Portakal);
				
				if(puan >= 0 && puan <= 2){
					portakalEkle();
				}
				else if(puan >= 3 && puan <= 5){
					portakalEkle2();
				}
				else if(puan >= 6 && puan <= 8){
					portakalEkle3();
				}
				else if(puan >= 9 && puan <= 11){
					portakalEkle4();
				}
				else if(puan >= 12 && puan <= 13){
					portakalEkle5();
				}
				else if(puan >= 14 && puan <= 16){
					portakalEkle3();
				}
				else if(puan >= 17 && puan <= 49){
					portakalEkle2();
				}
				else if(puan == 50){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean kaybedeniKontrolEt(){
		for(portakal Portakal : Portakallar){
			if(Portakal.getY() > 600){
				if(can > 1){
					can--;
					lblPuan.setText("Puan : " + puan);
					lblCan.setText("Can : " + can);
					Portakallar.remove(Portakal);
					portakalEkle();
				}
				else if(can == 1){
					can--;
					lblPuan.setText("Puan : " + puan);
					lblCan.setText("Can : " + can);
					return true;
				}
			}
		}
		return false;
	}
	
	public prensesOyunEkrani(){
		try {
			image = ImageIO.read(new FileImageInputStream(new File("prenses.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException Hatasý...");
		}
		setBackground(Color.WHITE);
		timer.start();
		
		Portakallar.add(new portakal((int)(Math.random() * 790), 20));
		
		lblPuan = new JLabel("Puan : " + puan);
		lblPuan.setBounds(325, 5, 150, 10);
		add(lblPuan);
		
		lblCan = new JLabel("Can : " + can);
		lblCan.setBounds(425, 5, 150, 10);
		add(lblCan);
		
		kazananiKontrolEt();
		kaybedeniKontrolEt();
	}
	
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		gecenSure += 5;
		
		g.drawImage(image, prensesX, prensesY, image.getWidth() / 2, image.getHeight() / 2, this);
			//490 : en alttan baþlamasý için
			//image.getWidth() / 10, image.getHeight() / 10 : fotoðrafýn boyutunu küçültmek için
			//this : JPanel üzerinde oluþmasý için
		
		g.setColor(Color.ORANGE);
		
		for(portakal Portakal : Portakallar){
			g.fillOval(Portakal.getX(), Portakal.getY(), 20, 20);
		}
		
		if(kazananiKontrolEt()){
			timer.stop();
			
			lblKazandiniz = new JLabel("KAZANDINIZ");
			lblKazandiniz.setForeground(Color.RED);
			lblKazandiniz.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblKazandiniz.setBounds(325, 100, 150, 30);
			add(lblKazandiniz);
			
			oyunBitti();
		}
		
		else if(kaybedeniKontrolEt()){
			timer.stop();
			
			lblKaybettiniz = new JLabel("KAYBETTÝNÝZ");
			lblKaybettiniz.setForeground(Color.RED);
			lblKaybettiniz.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblKaybettiniz.setBounds(325, 100, 150, 30);
			add(lblKaybettiniz);
			
			oyunBitti();
			
			//System.exit(0);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(portakal Portakal : Portakallar){
			Portakal.setY(Portakal.getY() + portakalilerliyorY);
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		/*sola basýldýðýnda sola basýlmýþ þeklinde, saða basýldýðýnda saða basýlmýþ þeklinde 
		  deðer dönecek.*/
		if(c == KeyEvent.VK_LEFT){
			if(prensesX <= 0){
				prensesX = 0;
			}
			else{
				prensesX -= prensesilerliyorX;
			}
		}
		else if(c == KeyEvent.VK_RIGHT){
			if(prensesX >= 720){
				prensesX = 720;
			}
			else{
				prensesX += prensesilerliyorX;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

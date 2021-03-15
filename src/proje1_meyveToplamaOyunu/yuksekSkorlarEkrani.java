package proje1_meyveToplamaOyunu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class yuksekSkorlarEkrani extends JFrame{
	
	static DefaultTableModel model;
	static kullaniciislemleri islemler = new kullaniciislemleri();
	
	public static void yuksekSkorlariGoruntule(){
		model.setRowCount(0);
		ArrayList<kullanici> kullanicilar = new ArrayList<kullanici>();
		
		kullanicilar = islemler.kullanicilariGetir();
		
		if(kullanicilar != null){
			for(kullanici Kullanici : kullanicilar){
				Object[] eklenecek = {Kullanici.getId(),Kullanici.getUserName(),Kullanici.getScore(),
						Kullanici.getTime() + " sn"};
				model.addRow(eklenecek);
			}
		}
	}
	
	public static void yuksekSkorlarEkrani(){
		JFrame frame;
		JPanel contentPane;
		JButton btnGeri;
		JLabel lblArkaplan;
		JTable tblYuksekSkorlar;
		
		ImageIcon imgFotograf = new ImageIcon("arkaplan.png");
		
		frame = new JFrame("Yüksek Skorlar");
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 764, 505);
		contentPane.add(scrollPane);
		
		tblYuksekSkorlar = new JTable();
		scrollPane.setViewportView(tblYuksekSkorlar);
		tblYuksekSkorlar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Kullanýcý Adý", "Puan", "Süre"
			}
		));
		
		lblArkaplan = new JLabel("", imgFotograf, JLabel.CENTER);
	    lblArkaplan.setBounds(0, 0, 800, 600);
		contentPane.add(lblArkaplan);
		frame.add(contentPane);
		
		model = (DefaultTableModel) tblYuksekSkorlar.getModel();
		yuksekSkorlariGoruntule();
	}

	public static void main(String[] args) {
		yuksekSkorlarEkrani();
	}

}

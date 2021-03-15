package proje1_meyveToplamaOyunu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class kullaniciislemleri {

	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	
	public ArrayList<kullanici> kullanicilariGetir(){
		ArrayList<kullanici> cikti = new ArrayList<kullanici>();
		
		try {
			statement = con.createStatement();
			
			String sorgu = "Select * From oyuncular ORDER BY score DESC";
			
			ResultSet rs = statement.executeQuery(sorgu);
			
			while(rs.next()){
				int id = rs.getInt("id");
				String userName = rs.getString("userName");
				String score = rs.getString("score");;
				String time = rs.getString("time");
				
				cikti.add(new kullanici(id, userName, score, time));
			}
			return cikti;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void kullaniciEkle(String userName, String score, String time){
		String sorgu = "Insert Into oyuncular (userName, score, time) VALUES (?, ?, ?)";
		try {
			preparedStatement = con.prepareStatement(sorgu);
			
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, score);
			preparedStatement.setString(3, time);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public kullaniciislemleri(){
		String url = "jdbc:mysql://" + database.host + ":" + database.port + "/" + database.db;
		//jdbc:mysql://localhost:3306/deneme
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
				//baðlantý için gerekli olan Driver baþlatýlmalý yoksa hata verebilir.
		}
		catch(ClassNotFoundException e){
			System.out.println("Driver Bulunamadý...");
				//veri tabaný eklenmemiþ olursa bu hatayý verir.
		}
		try {
			con = DriverManager.getConnection(url, "root", "");
			System.out.println("Baðlantý Baþarýlý...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Baðlantý Baþarýsýz...");
			e.printStackTrace();
		}
	}
}

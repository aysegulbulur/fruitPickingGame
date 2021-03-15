package proje1_meyveToplamaOyunu;

import java.util.Comparator;

public class kullanici{
	
	private int id;
	private String userName;
	private String score;
	private String time;
	public kullanici(int id, String userName, String score, String time) {
		super();
		this.id = id;
		this.userName = userName;
		this.score = score;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}

package com.ust.ioc;

public class Login {
	
	private String userName;
	private String password;
	DBConnection db;
	
	public DBConnection getDb() {
		return db;
	}
	public void setDb(DBConnection db) {
		this.db = db;
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String validate()
	{
		//obtain connection to database and writes sql to verify username and password exist in database
		//db = new DBConnection();
		Connection con =db.getConnection();
		return "Login validated";
	}
	
	

}

package com.internousdev.ecsite.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConector {
	private static String drierName="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost/ecsitea";

	private static String user="root";
	private static String password="mysql";
//	Mysqlに入るための情報

	public Connection getConnection(){
		Connection con=null;

		try{
			Class.forName(drierName);
			con=(Connection) DriverManager.getConnection(url,user,password);
//			Mysqlに送る箱
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}

}

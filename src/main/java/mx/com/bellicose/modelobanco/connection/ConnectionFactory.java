package mx.com.bellicose.modelobanco.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory instance = new ConnectionFactory();
	private String url;
	private String usr;
	private String pass;
	private String driver;
	private Connection conn;
	
	private ConnectionFactory(){
		url = "jdbc:mysql://localhost:3307/systembank";
		usr = "root";
		pass = "";
		driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConection(){
		try {
			conn = DriverManager.getConnection(url, usr, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static ConnectionFactory getInstance(){
		return instance;
	}
	public void close(){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

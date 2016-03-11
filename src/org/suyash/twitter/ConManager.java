package org.suyash.twitter;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConManager {
	
			private static ConManager instance = null;
			
			private final String USERNAME = 	"root";
			private final String PASSWORD = 	"root";
			private final String CONN_STRING = "jdbc:mysql://localhost/twitter";
			
			private Connection conn = null;
			
			private ConManager(){
			}
			
			public static ConManager getInstance(){
				if(instance == null){
					instance = new ConManager();
				}
				return instance;
			}
			private boolean openConnection(){
				try {
					conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
			public Connection getConnection(){
					if(conn == null){
						if(openConnection()){
								System.out.println("Connection Opened");
								return conn;
						}else{
							return null;
						}
					}
					return conn;
			}
			public void close(){
				System.out.println("Closing Connection");
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = null;
			}
}
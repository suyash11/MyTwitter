package org.suyash.twitter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DManager {
	
	private static Connection conn = ConManager.getInstance().getConnection();
	public static void Insert(GetsSets set) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		
		String sql	=	"INSERT INTO USER (username,email,pw) VALUES(?,?,?)";
	
		if(conn != null)
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, set.getUsername());
			pstmt.setString(2, set.getEmail());
			pstmt.setString(3, set.getPw());
			pstmt.executeUpdate();
			ConManager.getInstance().close();		
		}
	}
	
	public static int checkUser(GetsSets get) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		
		String sql	=	"SELECT COUNT(*) FROM USER WHERE email=? AND pw=?";

		int count = 0;
		
		if(conn != null)
		{
			PreparedStatement pstmt	=	conn.prepareStatement(sql);
			pstmt.setString(1, get.getEmail());
			pstmt.setString(2, get.getPw());
			ResultSet rs	=	pstmt.executeQuery();
			
			while(rs.next()){
				count	=	rs.getInt(1);
			}
			ConManager.getInstance().close();
		}
		return count;	
	}

}

package com.connect;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DatabaseConnection {
	
	Connection con = null;
	ResultSet rs;
    Statement stmt = null;
    PreparedStatement pstmt=null;
	
	DatabaseConnection(){		
		try {			
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-02.cleardb.net:3306/ad_435f7c812725dd1","b801b961c05b44","d99657c2");
				stmt = con.createStatement();
				if(!con.isClosed())
					System.out.println("Successfully Connected!!!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public ResultSet selectDb(String query) {
		
		System.out.println("In select db..");
		
		try {
			pstmt=con.prepareStatement(query);
			
			rs=pstmt.executeQuery(query);
			
			rs.close();
			pstmt.close();
			
			return rs;
		}
		catch(Exception e){
			rs=null;
			e.printStackTrace();
			return rs;
		}
		//return null;
	}
	
	public int update(String query) {
		System.out.println("In insert...");
		int res=0;
		
		try{
			pstmt=con.prepareStatement(query);
			
			pstmt.executeUpdate();
			
			return res;
		}
		catch(Exception e) {
			e.printStackTrace();
			return res;
		}
	}
	
	
	public int count(String query) {

		System.out.println("Db call called... ");
	
		try {
	
			pstmt = con.prepareStatement(query);
			
			// Execute query; retrieve name and assign it to Java variable.
			//ResultSet rs;
			
			rs = pstmt.executeQuery();
	
			int total=0;
			
			while(rs.next())
			{
			  total=rs.getInt("CNT");
			  
			  System.out.println("Total is: " + total);
			}
	
			// Close result set and statement objects.
			rs.close();
			pstmt.close();
			
			return total;
	
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}